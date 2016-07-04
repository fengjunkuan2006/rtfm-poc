package com.atc.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kris.Wang on 1/6/2016.
 */
public class DateUtil {
    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /*Time format converter*/
    public static Timestamp Date2Timestamp(Date date){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str = sdf.format(date);
            return Timestamp.valueOf(str);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }
}
