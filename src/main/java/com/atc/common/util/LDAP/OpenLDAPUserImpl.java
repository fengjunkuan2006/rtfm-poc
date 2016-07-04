package com.atc.common.util.LDAP;

/**
 * Created by Vic.Feng on 29/12/2015.
 */

import com.novell.ldap.LDAPEntry;

import javax.naming.directory.DirContext;

public class OpenLDAPUserImpl implements LDAPUser {
    private LDAPEntry user;

    protected OpenLDAPUserImpl(LDAPEntry u) {
        this.user = u;
    }

    protected LDAPEntry getUser() {
        return this.user;
    }

    public String getDN(DirContext ctx) {
        if (user == null) {
            return null;
        }
        return user.getDN();
    }
}