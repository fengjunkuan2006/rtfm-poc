package com.atc.common.util.exception;/** * Created by Vic.Feng on 16/12/2015. */public class DBException extends ATCException {    public DBException() {        super();    }    public DBException(String string) {        super(string);    }    public DBException(String string, Exception throwable) {        super(string, throwable);    }}