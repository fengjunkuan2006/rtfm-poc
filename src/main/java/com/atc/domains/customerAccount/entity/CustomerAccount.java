package com.atc.domains.customerAccount.entity;

import com.atc.common.model.BasePrimaryID;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Neil.Fang on 7/29/2016.
 */
@Entity
@IdClass(BasePrimaryID.class)
@Table(name = "customeraccounts")
public class CustomerAccount implements Serializable {
    @Id
    @Column(name = "ORG")
    private String org;
    @Id
    @Column(name = "KEY_ID")
    private int keyId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NUMBER")
    private String number;
    @Column(name = "LOCATIONROOT")
    private int location;
    @Column(name = "ACTIVE")
    private int active;

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
