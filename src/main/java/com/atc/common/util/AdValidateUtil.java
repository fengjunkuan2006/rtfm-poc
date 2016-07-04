package com.atc.common.util;

import com.atc.common.constant.home.UserResultCode;
import com.atc.common.model.CommonResultModel;
import org.apache.commons.lang3.StringUtils;

import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

/**
 * Created by Dave.zhou on 2015/12/18.
 */
public class AdValidateUtil {
    /**
     *
     *
     * @param url url
     * @param username username
     * @param password password
     * @return result(0:success, 2:error, 11:fail)
     */
    public static CommonResultModel adVaildate(String url, String username, String password, String postfix, String securityProtocol) {
        CommonResultModel result = new CommonResultModel();
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            result.setCode(UserResultCode.USERNAME_OR_PASSWORD_INVALID);
            result.setMessage("Username or password is empty");
            return result;
        }

        username += username.contains("@")?"":postfix;

        Hashtable<String, String> env = new Hashtable<String, String>();
        DirContext ctx;

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_PRINCIPAL, username);
        env.put(Context.SECURITY_CREDENTIALS, password);
        if(StringUtils.isNotEmpty(securityProtocol)) {
            env.put(Context.SECURITY_PROTOCOL, "ssl");
        }
        try {
            ctx = new InitialDirContext(env);// validate
            ctx.close();
            result.setCode(UserResultCode.SUCCESS);
        } catch (javax.naming.AuthenticationException e) {
            result.setCode(UserResultCode.USERNAME_OR_PASSWORD_INVALID);
            result.setMessage(e.getMessage());
        } catch (Exception e) {
            result.setCode(UserResultCode.ERROR);
            result.setMessage(e.getMessage());
        }

        return result;
    }

    /**
     * @param username username
     * @param password password
     * @return
     */
    public static CommonResultModel adVaildate(String username, String password) {
        return adVaildate(PropertiesUtil.getSysValue("ldap.provider_url"), username, password, PropertiesUtil.getSysValue("ldap.postfix"), PropertiesUtil.getSysValue("ldap.security_protocol"));
    }
}
