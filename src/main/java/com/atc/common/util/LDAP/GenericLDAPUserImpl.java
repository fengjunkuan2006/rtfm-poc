package com.atc.common.util.LDAP;

/**
 * Created by Vic.Feng on 29/12/2015.
 */

import javax.naming.directory.DirContext;
import javax.naming.ldap.LdapName;

public class GenericLDAPUserImpl implements LDAPUser {

    LdapName name = null;

    public GenericLDAPUserImpl() {
        super();
    }

    public GenericLDAPUserImpl(LdapName name) {
        this.name = name;
    }

    public String getDN(DirContext ctx) {
        return name.toString();
    }


    public LdapName getName() {
        return name;
    }
}