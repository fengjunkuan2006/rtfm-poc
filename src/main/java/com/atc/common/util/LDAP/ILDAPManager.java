package com.atc.common.util.LDAP;

/**
 * Created by Vic.Feng on 29/12/2015.
 */

import com.atc.common.util.exception.NamingException;

/**
 *  The ILDAPManager interface provides an API to an LDAP server.
 *
 * @author       Alan Ewald
 * @created      2/8/2010
 * @copyright    Copyright (c) 2010 American Tower Corporation, All Rights Reserved.
 */
public interface ILDAPManager {

    /**
     * Lookup a user in the LDAP server using the specified username.
     *
     * @param username
     * @return
     * @throws NamingException
     */
    public LDAPUser getUserByUsername(String username) throws NamingException;

    /**
     * Lookup a user in the LDAP server using the specified username and search DN.
     *
     * @param username
     * @param searchDN
     * @return
     * @throws NamingException
     */
    public LDAPUser getUserByUsername(String username, String searchDN) throws NamingException;

    /**
     * Create a new user.
     *
     * @param username
     * @param password
     * @return
     * @throws NamingException
     */
    public LDAPUser createUser(String username, String password) throws NamingException;

    /**
     * Check a user's password.
     *
     * @param user
     * @param password
     * @return
     * @throws NamingException
     */
    public boolean checkPassword(LDAPUser user, String password);

    /**
     * Change user's password.
     *
     * @param user
     * @param newPassword
     * @throws NamingException
     */
    public void changePassword(LDAPUser user, String newPassword) throws NamingException;

    /**
     * Change user's username.
     *
     * @param user
     * @param newUsername
     * @throws NamingException
     */
    public void changeUsername(LDAPUser user, String newUsername) throws NamingException;

    /**
     * Add an LDAP user to an existing group.
     *
     * @param user
     * @param group
     * @throws NamingException
     */
    public void addUserToGroup(LDAPUser user, String group) throws NamingException;

    /**
     * Check to see if an LDAP user is a member of an existing group.
     *
     * @param user
     * @param group
     * @return
     * @throws NamingException
     */
    public boolean userInGroup(LDAPUser user, String group) throws NamingException;

    /**
     * Remove an LDAP user from an existing group.
     *
     * @param user
     * @param group
     * @throws NamingException
     */
    public void removeUserFromGroup(LDAPUser user, String group) throws NamingException;

    /**
     * Delete a user.
     *
     * @param user
     * @throws NamingException
     */
    public void deleteUser(LDAPUser user) throws NamingException;

    /**
     * Lookup an attribute value for the specified user.
     *
     * @param user
     * @param attrName
     * @return
     * @throws NamingException
     */
    public String getAttributeValue(LDAPUser user, String attrName) throws NamingException;

    /**
     * Lookup an attribute value for the specified user using the generic API
     *
     * @param user
     * @param attrName
     * @param useGenericAPI
     * @return
     * @throws NamingException
     */
    public String getAttributeValue(LDAPUser user, String attrName, boolean useGenericAPI) throws NamingException;

    /**
     * Lookup a user based on their common name.
     *
     * @param commonName
     * @throws NamingException
     */
    public LDAPUser getUserByCommonName(String commonName) throws NamingException;

    /**
     * Lookup a user based on their GUID
     * @param ldapGuid
     * @return
     * @throws NamingException
     */
    public LDAPUser getUserByGUID(String ldapGuid) throws NamingException;

}