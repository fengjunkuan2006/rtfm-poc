package com.atc.common.util;

import org.springframework.beans.propertyeditors.PropertiesEditor;

/**
 * Created by Vic.Feng on 22/12/2015.
 */
public class DoubleEditor extends PropertiesEditor {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.equals("")) {
            text = "0";
        }
        setValue(Double.parseDouble(text));
    }

    @Override
    public String getAsText() {
        return getValue().toString();
    }
}