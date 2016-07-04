package com.atc.common.util.LDAP;

/**
 * Created by Vic.Feng on 29/12/2015.
 */
import javax.naming.directory.DirContext;

/**
 *  Interface representing a user object in the LDAP.
 *
 * @author       Alan Ewald
 * @created      1/6/2010
 * @copyright    Copyright (c) 2010 American Tower Corporation, All Rights Reserved.
 */
public interface LDAPUser {

    public String getDN(DirContext ctx);
}

