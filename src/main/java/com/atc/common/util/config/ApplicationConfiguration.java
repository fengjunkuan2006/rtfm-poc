package com.atc.common.util.config;/** * Created by Vic.Feng on 15/12/2015. */import com.atc.common.constant.SystemConstants;import com.atc.common.util.DateFormatHelper;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import java.util.Date;import java.util.Properties;import java.util.ResourceBundle;import java.util.StringTokenizer;/** * The ApplicationConfiguration class provides access to application level * configuration settings in the form of properties loaded from a property file. * * @author Ketan Dave * @created 4/16/2010 * @copyright Copyright (c) 2010 American Tower Corporation, All Rights Reserved. */public class ApplicationConfiguration {    public ApplicationConfiguration() {        super();    }    /**     * Application configuration constants     */    private static final Logger logger = LoggerFactory.getLogger(ApplicationConfiguration.class);    /**     * Application configuration value constants     */    // TODO: move these deployment configuration constants to the system configuration class?    //    public final static String DEPLOYMENT_MODE = "deployment.mode";    public final static String DEPLOYMENT_ENVIRONMENT = "deployment.env";    public final static String INTERNAL_DEPLOYMENT = "internal";    public final static String EXTERNAL_DEPLOYMENT = "external";    public final static String COMBINED_DEPLOYMENT = "combined";    public final static String WEBLOGIC_SERVER_NAME = "weblogic.Name";    // private fields    //    private static ResourceBundle bundle = null;    private static ResourceBundle getBundle() {        /*        if (bundle == null) {            String deploymentEnv = System.getProperty("atc.deployment.env");            String appName = CoreConfiguration.getValue(CoreConfiguration.APPLICATION_NAME);            logger.info("Selecting application configuration for application " + appName);            String configParentFolder = getConfigParentFolderName();            if (!StringUtils.isEmpty(appName) && !StringUtils.isEmpty(deploymentEnv)) {                logger.info("Selecting application configuration for application " + appName + " in " + deploymentEnv + " environment in domain " + configParentFolder);                try {                    InputStream is = new FileInputStream("/" + configParentFolder + "/" + appName + "/" + deploymentEnv + "/app_config.properties");                    bundle = new PropertyResourceBundle(is);                } catch (FileNotFoundException fnf) {                    logger.error("Application configuration file not found.");                    fnf.printStackTrace();                } catch (IOException ioe) {                    logger.error("Exception occurred during loading of application configuration file.");                    ioe.printStackTrace();                }            }        }        */        if (bundle == null) {            logger.info("Selecting default application configuration");            bundle = ResourceBundle.getBundle("sysconfig");        }        return bundle;    }    /**     * Retrieve the value stored for the specified setting.     *     * @param name The name of the configuration setting to retrieve     * @return The value of the configuration setting     */    public static String getValue(String name) {        if (name == null) {            return null;        }        // First look in the resource bundle for the setting        //        try {            String filePath = System.getProperty(SystemConstants.JVM_CONFIG_PATH);            if (filePath == null || filePath.isEmpty()) {                filePath = SystemConstants.FILE_PROPERTIES_SYSCONFIG;            }            Properties p = new Properties();            p.load(ApplicationConfiguration.class.getClassLoader().getResourceAsStream(filePath));            return p.getProperty(name);        } catch (Exception e) {            // Only java.util.MissingResourceException and java.lang.ClassCastException            // can be thrown by getString            e.printStackTrace(System.out);        }        return null;    }    /**     * Get a value as an int     *     * @param name The name of the configuration setting to retrieve     */    public static int getValueAsInt(String name) {        String value = getValue(name);        if (value != null) {            return Integer.parseInt(value);        } else {            return 0;        }    }    /**     * Get a value as a Boolean     *     * @param name     * @return     */    public static Boolean getValueAsBoolean(String name) {        String value = getValue(name);        if (value != null) {            return Boolean.parseBoolean(value);        } else {            return false;        }    }    public static Date getValueAsDate(String name) {        String value = getValue(name);        if (value != null) {            return DateFormatHelper.getDate(value);        }        return null;    }    public static String getServerName() {        return System.getProperty(WEBLOGIC_SERVER_NAME);    }    public static String getConfigParentFolderName() {        String domainHome = System.getProperty("domain.home");        StringTokenizer st1 = new StringTokenizer(domainHome, "/");        if (st1.countTokens() > 1) {            return st1.nextToken();        }        return domainHome;    }}