package com.atc.common.util.exception;

/**
 * Created by Vic.Feng on 29/12/2015.
 */
public class NamingException extends ATCException {
    public NamingException() {
        super();
    }

    public NamingException(String string) {
        super(string);
    }

    public NamingException(String string, Exception throwable) {
        super(string, throwable);
    }
}

