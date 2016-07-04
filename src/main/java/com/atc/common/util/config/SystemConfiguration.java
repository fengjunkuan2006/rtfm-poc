package com.atc.common.util.config;

/**
 * Created by Vic.Feng on 29/12/2015.
 */

import com.atc.common.constant.SystemConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

/**
 * The SystemConfiguration class provides access to configuration
 * settings in the form of properties loaded from a property file.
 *
 * @author Alan Ewald
 * @created 1/5/2010
 * @copyright Copyright (c) 2010 American Tower Corporation, All Rights Reserved.
 */
public class SystemConfiguration {

    /**
     * System configuration constants
     */
    private static Logger logger = LoggerFactory.getLogger(SystemConfiguration.class);

    public final static String LDAP_PROVIDER_URL = "ldap.provider_url";
    public final static String LDAP_HOST = "ldap.host";
    public final static String LDAP_PORT = "ldap.port";
    public final static String LDAP_USER = "ldap.user";
    public final static String LDAP_PASSWORD = "ldap.password";
    public final static String LDAP_USER_DN = "ldap.user_base_dn";
    public final static String LDAP_USERNAME_ATTRIBUTE = "ldap.username_attribute";
    public final static String LDAP_PASSWORD_ATTRIBUTE = "ldap.password_attribute";
    public final static String LDAP_GROUP_DN = "ldap.group_base_dn";
    public final static String LDAP_GROUPNAME_ATTRIBUTE = "ldap.groupname_attribute";
    public final static String LDAP_SERVER_TYPE = "ldap.server_type";
    public final static String LDAP_ALLOW_USER_CREATE = "ldap.allow_user_create";
    public final static String LDAP_COMMON_NAME_ATTRIBUTE = "ldap.common_name_attribute";
    public final static String LDAP_FIRSTNAME_ATTRIBUTE = "ldap.firstname_attribute";
    public final static String LDAP_LASTNAME_ATTRIBUTE = "ldap.lastname_attribute";
    public final static String LDAP_EMAIL_ATTRIBUTE = "ldap.email_attribute";
    public final static String LDAP_PHONENUMBER_ATTRIBUTE = "ldap.phonenumber_attribute";

    public final static String JNDI_PROVIDER_URL = "jndi.provider_url";
    public final static String JNDI_USER = "jndi.user";
    public final static String JNDI_PASSWORD = "jndi.password";

    public final static String MAIL_SESSION_JNDI_NAME = "mail.session.jndi_name";
    public final static String MAIL_SEND_EXTERNAL_EMAIL = "mail.send_external_email";
    public final static String MAIL_STORE_PROTOCOL = "mail.store.protocol";
    public final static String MAIL_USER = "mail.user";
    public final static String MAIL_HOST = "mail.host";
    public final static String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";
    public final static String MAIL_FROM = "mail.from";
    public final static String deploymentEnv = System.getProperty("atc.deployment.env");

    // private fields
    //
    private static ResourceBundle bundle = null;

    private static ResourceBundle getBundle() {
        /*
        if (bundle == null) {
            String deploymentEnv = System.getProperty("atc.deployment.env");
            String appName = CoreConfiguration.getValue(CoreConfiguration.APPLICATION_NAME);
            logger.info("Selecting system configuration for application " + appName);
            String configParentFolder = getConfigParentFolderName();

            if (!StringUtils.isEmpty(appName) && !StringUtils.isEmpty(deploymentEnv)) {
                logger.info("Selecting system configuration for application " + appName + " in " + deploymentEnv + " environment in domain " + configParentFolder);
                try {
                    InputStream is = new FileInputStream("/" + configParentFolder + "/" + appName + "/" + deploymentEnv + "/sys_config.properties");
                    bundle = new PropertyResourceBundle(is);
                } catch (FileNotFoundException fnf) {
                    logger.error("System configuration file not found.");
                    fnf.printStackTrace();
                } catch (IOException ioe) {
                    logger.error("Exception occurred during loading of system configuration file.");
                    ioe.printStackTrace();
                }
            }

            // As a last chance, check for the configuration file in the classpath
            //
            if (bundle == null) {
                logger.info(SystemConfiguration.class, "Selecting default system configuration");
                bundle = ResourceBundle.getBundle("com.atc.config.sys_config");
            }
        }
        */

        if (bundle == null) {
            logger.info("Selecting default application configuration");
            bundle = ResourceBundle.getBundle("sysconfig");
        }
        return bundle;
    }

    /**
     * Retrieve the value stored for the specified setting.
     *
     * @param name The name of the configuration setting to retrieve
     * @return The value of the configuration setting
     */
    public static String getValue(String name) {
        if (name == null) {
            return null;
        }

        // First look in the resource bundle for the setting
        //
        try {
            String filePath = System.getProperty(SystemConstants.JVM_CONFIG_PATH);
            if (filePath == null || filePath.isEmpty()) {
                filePath = SystemConstants.FILE_PROPERTIES_SYSCONFIG;
            }

            Properties p = new Properties();
            p.load(ApplicationConfiguration.class.getClassLoader().getResourceAsStream(filePath));
            return p.getProperty(name);
        } catch (Exception e) {
            // Only java.util.MissingResourceException and java.lang.ClassCastException
            // can be thrown by getString
            e.printStackTrace(System.out);
        }

        return null;
    }

    /**
     * Get a value as an int
     *
     * @param name The name of the configuration setting to retrieve
     */
    public static int getValueAsInt(String name) {
        String value = getValue(name);

        if (value != null) {
            return Integer.parseInt(value);
        } else {
            return 0;
        }
    }

    public static Boolean getValueAsBoolean(String name) {
        String value = getValue(name);

        if (value != null) {
            return Boolean.parseBoolean(value);
        } else {
            return false;
        }
    }

    private static String getConfigParentFolderName() {
        String domainHome = System.getProperty("domain.home");
        StringTokenizer st1 = new StringTokenizer(domainHome, "/");
        if (st1.countTokens() > 1) {
            return st1.nextToken();
        }

        return domainHome;
    }
}