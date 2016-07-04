package com.atc.common.util;

import com.atc.common.constant.SystemConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by Kris.Wang on 3/30/2016.
 */
public class PropertiesUtil {
    private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties getProperties(String name) {
        if (name != null && !name.isEmpty()) {
            try {
                Properties p = new Properties();
                p.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(name));
                return p;
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

        return null;
    }

    public static String getValue(String propertiesName, String key) {
        Properties p = getProperties(propertiesName);

        if (p != null) {
            try {
                return p.getProperty(key);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

        return null;
    }

    public static String getSysValue(String key) {
        String filePath = System.getProperty(SystemConstants.JVM_CONFIG_PATH);
        if (filePath == null || filePath.isEmpty()) {
            filePath = SystemConstants.FILE_PROPERTIES_SYSCONFIG;
        }

        return getValue(filePath, key);
    }

    public static String getAppValue(String key) {
        return getValue(SystemConstants.FILE_PROPERTIES_APPCONFIG, key);
    }
}