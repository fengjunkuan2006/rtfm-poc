package com.atc.common.util.LDAP;

/**
 * Created by Vic.Feng on 29/12/2015.
 */

import com.atc.common.util.SSHAUtil;
import com.atc.common.util.config.SystemConfiguration;
import com.atc.common.util.exception.NamingException;
import com.novell.ldap.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.naming.Context;
import javax.naming.directory.Attributes;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.naming.ldap.LdapName;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * The OracleLDAPManager class provides an interface to an LDAP server. It uses Oracle
 * extensions to the standard LDAP/JNDI API's.
 *
 * @author Alan Ewald
 * @created 1/5/2010
 * @copyright Copyright (c) 2010 American Tower Corporation, All Rights Reserved.
 */
@Service
public class OpenLDAPManager implements ILDAPManager {
    private final Logger logger = LoggerFactory.getLogger(OpenLDAPManager.class);

    private final int UF_ACCOUNTDISABLE = 0x0002;
    private final int UF_PASSWD_NOTREQD = 0x0020;
    private final int UF_PASSWD_CANT_CHANGE = 0x0040;
    private final int UF_NORMAL_ACCOUNT = 0x0200;
    private final int UF_DONT_EXPIRE_PASSWD = 0x10000;
    private final int UF_PASSWORD_EXPIRED = 0x800000;

    public OpenLDAPManager() {
        super();
    }

    protected LDAPConnection getConnection() throws NamingException {
        LDAPConnection conn = null;

        String allowUserCreate = SystemConfiguration.getValue(SystemConfiguration.LDAP_ALLOW_USER_CREATE);
        if (StringUtils.isEmpty(allowUserCreate) || !allowUserCreate.equals("true")) {
            conn = new LDAPConnection();
        } else {
            conn = new LDAPConnection(new LDAPJSSESecureSocketFactory());
        }

        try {
            conn.connect(SystemConfiguration.getValue(SystemConfiguration.LDAP_HOST),
                    SystemConfiguration.getValueAsInt(SystemConfiguration.LDAP_PORT));
            conn.bind(LDAPConnection.LDAP_V3,
                    SystemConfiguration.getValue(SystemConfiguration.LDAP_USER),
                    SystemConfiguration.getValue(SystemConfiguration.LDAP_PASSWORD).getBytes("UTF8"));
            return conn;
        } catch (LDAPException le) {
            throw new NamingException(le.getMessage(), le);
        } catch (UnsupportedEncodingException uee) {
            throw new NamingException(uee.getMessage(), uee);
        }
    }

    /**
     * @see ILDAPManager#getUserByUsername(String)
     */
    public LDAPUser getUserByUsername(String username) throws NamingException {

        LDAPConnection lc = getConnection();

        return getUser(lc, username);
    }

    /**
     * @see ILDAPManager#getUserByUsername(String, String)
     */
    public LDAPUser getUserByUsername(String username, String searchDN) throws NamingException {
        LDAPConnection lc = getConnection();

        return getUser(lc, username, searchDN);
    }

    /**
     * Retrieve an LDAP entry for the user with the specified username.
     *
     * @param lc
     * @param username
     * @return
     * @throws NamingException
     */
    private LDAPUser getUser(LDAPConnection lc, String username, String searchDN) throws NamingException {
        try {
            String searchFilter = SystemConfiguration.getValue(SystemConfiguration.LDAP_USERNAME_ATTRIBUTE) + "=" + username;

            LDAPSearchResults searchResults = lc.search(searchDN,
                    LDAPConnection.SCOPE_SUB,
                    searchFilter,
                    null,
                    false);

            if (searchResults.hasMore()) {
                LDAPEntry le = searchResults.next();
                lc.disconnect();
                return new OpenLDAPUserImpl(le);
            } else {
                lc.disconnect();
                throw new NamingException("User not found");
            }
        } catch (LDAPException le) {
            throw new NamingException(le.getMessage(), le);
        }
    }

    private LDAPUser getUser(LDAPConnection lc, String username) throws NamingException {
        return getUser(lc, username, SystemConfiguration.getValue(SystemConfiguration.LDAP_USER_DN));
    }

    /**
     * @see ILDAPManager#createUser(String, String)
     */
    public LDAPUser createUser(String username,
                               String password) throws NamingException {

        String allowUserCreate = SystemConfiguration.getValue(SystemConfiguration.LDAP_ALLOW_USER_CREATE);
        if (StringUtils.isEmpty(allowUserCreate) || !allowUserCreate.equals("true")) {
            throw new NamingException("User create is turned off in configuration");
        }

        LDAPConnection lc = getConnection();

        try {
            LDAPAttributeSet las = new LDAPAttributeSet();

            // Object class
            String[] objClasses = new String[]{"top", "person", "organizationalPerson", "user"};
            las.add(new LDAPAttribute("objectclass", objClasses));

            // CN
            las.add(new LDAPAttribute(SystemConfiguration.getValue(SystemConfiguration.LDAP_COMMON_NAME_ATTRIBUTE), username));

            // sAMAccountName
            las.add(new LDAPAttribute(SystemConfiguration.getValue(SystemConfiguration.LDAP_USERNAME_ATTRIBUTE), username));

            // userAccessControl
            las.add(new LDAPAttribute("userAccountControl", Integer.toString(UF_NORMAL_ACCOUNT + UF_PASSWD_NOTREQD + UF_PASSWORD_EXPIRED + UF_ACCOUNTDISABLE)));


            LDAPEntry newEntry = new LDAPEntry(buildUserDN(username), las);

            lc.add(newEntry);

            // Next set password and modify UserAccountControl
            //
            //
            ArrayList<LDAPModification> mods = new ArrayList<LDAPModification>();
            String quotedPassword = "\"" + password + "\"";
            byte[] unicodePassword = quotedPassword.getBytes("UTF-16LE");
            mods.add(new LDAPModification(LDAPModification.ADD,
                    new LDAPAttribute(SystemConfiguration.getValue(SystemConfiguration.LDAP_PASSWORD_ATTRIBUTE),
                            unicodePassword)));
            mods.add(new LDAPModification(LDAPModification.REPLACE,
                    new LDAPAttribute("userAccountControl", Integer.toString(UF_NORMAL_ACCOUNT))));
            lc.modify(buildUserDN(username), mods.toArray(new LDAPModification[0]));

            return getUser(lc, username);
        } catch (LDAPException le) {
            throw new NamingException(le.getMessage(), le);
        } catch (UnsupportedEncodingException uee) {
            throw new NamingException(uee.getMessage(), uee);
        }
    }

    /**
     * @see ILDAPManager#checkPassword(LDAPUser, String)
     */
    public boolean checkPassword(LDAPUser user,
                                 String password) {
        if(null != user && null != password && !password.equals("")) {
            try {
                LDAPConnection lc = getConnection();

                LDAPAttribute attr = new LDAPAttribute(SystemConfiguration.getValue(SystemConfiguration.LDAP_PASSWORD_ATTRIBUTE), password);

                return lc.compare(user.getDN(null), attr);
            } catch (Exception ex) {
                logger.error(ex.getMessage());
            }
        }
        return false;
    }

    /**
     * @see ILDAPManager#changePassword(LDAPUser, String)
     */
    public void changePassword(LDAPUser user,
                               String newPassword) throws NamingException {
        LDAPConnection lc = getConnection();

        try {
            String quotedPassword = "\"" + newPassword + "\"";
            byte[] unicodePassword = quotedPassword.getBytes("UTF-16LE");
            LDAPModification mod = new LDAPModification(LDAPModification.REPLACE,
                    new LDAPAttribute(SystemConfiguration.getValue(SystemConfiguration.LDAP_PASSWORD_ATTRIBUTE),
                            unicodePassword));
            lc.modify(user.getDN(null), mod);
        } catch (LDAPException le) {
            throw new NamingException(le.getMessage(), le);
        } catch (UnsupportedEncodingException uee) {
            throw new NamingException(uee.getMessage(), uee);
        }

    }

    /**
     * @see ILDAPManager#changeUsername(LDAPUser, String)
     */
    public void changeUsername(LDAPUser user, String newUsername) throws NamingException {
        LDAPConnection lc = getConnection();

        try {
            ArrayList<LDAPModification> mods = new ArrayList<LDAPModification>();
            mods.add(new LDAPModification(LDAPModification.REPLACE,
                    new LDAPAttribute(SystemConfiguration.getValue(SystemConfiguration.LDAP_USERNAME_ATTRIBUTE),
                            newUsername)));
            mods.add(new LDAPModification(LDAPModification.REPLACE,
                    new LDAPAttribute(SystemConfiguration.getValue(SystemConfiguration.LDAP_COMMON_NAME_ATTRIBUTE),
                            newUsername)));
            lc.modify(user.getDN(null), mods.toArray(new LDAPModification[0]));
        } catch (LDAPException le) {
            throw new NamingException(le.getMessage(), le);
        }
    }

    /**
     * @see ILDAPManager#addUserToGroup(LDAPUser, String)
     */
    public void addUserToGroup(LDAPUser user,
                               String group) throws NamingException {
        LDAPConnection lc = getConnection();

        try {
            LDAPModification mod = new LDAPModification(LDAPModification.ADD, new LDAPAttribute("member", user.getDN(null)));
            lc.modify(buildGroupDN(group), mod);
        } catch (LDAPException le) {
            throw new NamingException(le.getMessage(), le);
        }

    }

    /**
     * @see ILDAPManager#userInGroup(LDAPUser, String)
     */
    public boolean userInGroup(LDAPUser user,
                               String group) throws NamingException {
        LDAPConnection lc = getConnection();

        LDAPEntry le = getGroup(lc, group, SystemConfiguration.getValue(SystemConfiguration.LDAP_GROUP_DN));

        LDAPAttributeSet las = le.getAttributeSet();
        LDAPAttribute members = las.getAttribute("member");
        if (members != null) {
            String[] users = members.getStringValueArray();
            String userDN = user.getDN(null).toUpperCase();
            for (int i = 0; i < users.length; i++) {
                if (users[i].toUpperCase().equals(userDN)) {
                    return true;
                }
            }
        }

        return false;
    }

    private LDAPEntry getGroup(LDAPConnection lc, String group, String searchDN) throws NamingException {
        try {
            String searchFilter = "(" + SystemConfiguration.getValue(SystemConfiguration.LDAP_GROUPNAME_ATTRIBUTE) + "=" + group + ")";

            LDAPSearchResults searchResults = lc.search(searchDN,
                    LDAPConnection.SCOPE_SUB,
                    searchFilter,
                    null,
                    false);

            if (searchResults.hasMore()) {
                LDAPEntry le = searchResults.next();
                return le;
            } else {
                throw new NamingException("Group not found");
            }
        } catch (LDAPException le) {
            throw new NamingException(le.getMessage(), le);
        }
    }


    /**
     * @see ILDAPManager#removeUserFromGroup(LDAPUser, String)
     */
    public void removeUserFromGroup(LDAPUser user,
                                    String group) throws NamingException {
        LDAPConnection lc = getConnection();

        try {
            LDAPModification mod = new LDAPModification(LDAPModification.DELETE, new LDAPAttribute("member", user.getDN(null)));
            lc.modify(buildGroupDN(group), mod);
        } catch (LDAPException le) {
            throw new NamingException(le.getMessage(), le);
        }
    }


    /**
     * @see ILDAPManager#deleteUser(LDAPUser)
     */
    public void deleteUser(LDAPUser user) throws NamingException {
        if (user == null) {
            throw new NamingException("Invalid Argument");
        }

        try {
            LDAPConnection lc = getConnection();
            String dn = user.getDN(null);
            lc.delete(dn);
        } catch (LDAPException le) {
            throw new NamingException(le.getMessage(), le);
        }
    }

    /**
     * @see ILDAPManager#getAttributeValue(LDAPUser, String)
     */
    public String getAttributeValue(LDAPUser user, String attrName) throws NamingException {
        if ((user == null) || (attrName == null)) {
            throw new NamingException("Invalid Argument");
        }

        LDAPEntry le = ((OpenLDAPUserImpl) user).getUser();

        LDAPAttributeSet attributeSet = le.getAttributeSet();
        LDAPAttribute attr;
        for (Iterator i = attributeSet.iterator(); i.hasNext(); ) {
            attr = (LDAPAttribute) i.next();
            if (attr.getName().equals(attrName)) {
                return attr.getStringValue();
            }
        }

        return null;
    }

    /**
     * @see ILDAPManager#getUserByCommonName(String)
     */
    public LDAPUser getUserByCommonName(String commonName) throws NamingException {
        try {
            LDAPConnection lc = getConnection();
            String searchDN = SystemConfiguration.getValue(SystemConfiguration.LDAP_USER_DN);
            String searchFilter = "(" + SystemConfiguration.getValue(SystemConfiguration.LDAP_COMMON_NAME_ATTRIBUTE) + "=" + commonName + ")";

            LDAPSearchResults searchResults = lc.search(searchDN,
                    LDAPConnection.SCOPE_SUB,
                    searchFilter,
                    null,
                    false);

            if (searchResults.hasMore()) {
                LDAPEntry le = searchResults.next();
                return new OpenLDAPUserImpl(le);
            } else {
                throw new NamingException("User not found");
            }
        } catch (LDAPException le) {
            throw new NamingException(le.getMessage(), le);
        }
    }

    /**
     * Build the full DN for a user.
     *
     * @param username
     * @return
     */
    private String buildUserDN(String username) {
        StringBuffer dn = new StringBuffer();
        dn.append(SystemConfiguration.getValue(SystemConfiguration.LDAP_COMMON_NAME_ATTRIBUTE)).append("=").append(username).append(",");
        dn.append(SystemConfiguration.getValue(SystemConfiguration.LDAP_USER_DN));
        return dn.toString();
    }

    /**
     * Build the full DN for a group.
     *
     * @param group
     * @return
     */
    private String buildGroupDN(String group) {
        StringBuffer dn = new StringBuffer();
        dn.append(SystemConfiguration.getValue(SystemConfiguration.LDAP_GROUPNAME_ATTRIBUTE)).append("=").append(group).append(",");
        dn.append(SystemConfiguration.getValue(SystemConfiguration.LDAP_GROUP_DN));
        return dn.toString();
    }

    /**
     * @param GUID
     * @return
     * @throws NamingException
     */
    public LDAPUser getUserByGUID(String GUID) throws NamingException {
        // Convert the GUID to the form <GUID=abcd1234-abcd-1234-abcd5678efgh>
        Context ldapContext = getContext();
        try {
            String convertedGUID = "<GUID=" + GUID + ">";
            String returnedAtts[] = {"distinguishedName"};
            Attributes attrs = getContext().getAttributes(convertedGUID, returnedAtts);
            LdapName name =
                    new LdapName((String) attrs.get("distinguishedName").get());
            return new GenericLDAPUserImpl(name);

        } catch (Exception e) {
            throw new NamingException("Exception while trying to get user by GUID " +
                    GUID, e);
        } finally {
            try {
                ldapContext.close();
            } catch (javax.naming.NamingException e) {
                // TODO: log this exception...
            }
        }
    }

    /**
     * NOTE: This method does not really belong in this class. Please see <code>getUserByGUID</code> for details.
     *
     * @return Return an LDAPCOntext to use for searches.
     * @throws NamingException
     */
    protected LdapContext getContext() throws NamingException {
        LdapContext context = null;
        try {
            Hashtable env = new Hashtable();
            String adminName =
                    SystemConfiguration.getValue(SystemConfiguration.LDAP_USER);
            String adminPassword = SystemConfiguration.getValue(SystemConfiguration.LDAP_PASSWORD);
            String ldapURL = SystemConfiguration.getValue(SystemConfiguration.LDAP_PROVIDER_URL);

            env.put(Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.ldap.LdapCtxFactory");

            //set security credentials, note using simple cleartext authentication
            env.put(Context.SECURITY_AUTHENTICATION, "simple");
            env.put(Context.SECURITY_PRINCIPAL, adminName);
            env.put(Context.SECURITY_CREDENTIALS, adminPassword);

            env.put(Context.PROVIDER_URL, ldapURL);
            context = new InitialLdapContext(env, null);
            return context;
        } catch (Exception e) {
            throw new NamingException("Exception initializing LDAP connection ", e);
        }
    }

    public String getAttributeValue(LDAPUser user, String attrName,
                                    boolean useGenericAPI) throws NamingException {
        Attributes attrs;
        try {
            attrs =
                    getContext().getAttributes(((GenericLDAPUserImpl) user).getName(), new String[]{attrName});
            if (attrs.get(attrName) != null) {
                String value = (String) attrs.get(attrName).get();
                return value;
            }
            return "";
        } catch (Exception e) {
            throw new NamingException("Exception fetching attribute value for " + attrName, e);

        }
    }
}

