package com.atc.common.util;

/**
 * Created by Vic.Feng on 10/03/2016.
 */
public class DBException extends RuntimeException {
    private static String typeFlag = "DB EXCEPTION: ";

    public DBException() {
        super();
    }

    public DBException(String msg) {
        super(typeFlag + msg);
    }

    public DBException(String msg, Throwable cause) {
        super(typeFlag + msg, cause);
    }

    public DBException(Throwable cause) {
        super(cause);
    }
}
