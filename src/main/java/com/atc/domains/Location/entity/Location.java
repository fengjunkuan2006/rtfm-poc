package com.atc.domains.location.entity;


import com.atc.common.model.BasePrimaryID;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Darren.zhang on 8/1/2016.
 */
@Entity
@IdClass(BasePrimaryID.class)
@Table(name = "treenodes")
public class Location implements Serializable {
    @Id
    @Column(name = "ORG")
    private String org;
    @Id
    @Column(name = "KEY_ID")
    private Integer keyId;
    @Column(name = "LABEL")
    private String name;
    @Column(name = "PARENTNODEID")
    private Integer parentNodeId;

    public Location() {
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(Integer parentNodeId) {
        this.parentNodeId = parentNodeId;
    }
}
