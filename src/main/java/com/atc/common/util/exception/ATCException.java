package com.atc.common.util.exception;/** * Created by Vic.Feng on 15/12/2015. */public class ATCException extends Exception {    public ATCException(String string, Exception throwable) {        super(string, throwable);    }    public ATCException(String string) {        super(string);    }    public ATCException() {        super();    }}