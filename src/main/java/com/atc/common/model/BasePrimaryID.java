package com.atc.common.model;

import java.io.Serializable;

/**
 * Created by Neil.Fang on 7/29/2016.
 */
public class BasePrimaryID implements Serializable {
    private String org;
    private Integer keyId;

    public BasePrimaryID(Integer keyId, String org) {
        this.keyId = keyId;
        this.org = org;
    }

    public BasePrimaryID() {
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
}
