package com.atc.domains.group.entity;

import com.atc.common.model.BasePrimaryID;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Neil.Fang on 7/25/2016.
 */
@Entity
@IdClass(BasePrimaryID.class)
@Table(name = "assetgroups")
public class Group implements Serializable {
    @Id
    @Column(name="ORG")
    private String org;
    @Id
    @Column(name="KEY_ID")
    private int keyId;
    @Column(name="NAME")
    private String name;
    @Column(name="VERSION")
    private int version;

    public int getKeyId() {
        return keyId;
    }

    public void setKeyId(int keyId) {
        this.keyId = keyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
}

