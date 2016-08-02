package com.atc.domains.asset.entity;


import com.atc.common.model.BasePrimaryID;
import com.atc.domains.customerAccount.entity.CustomerAccount;
import com.atc.domains.location.entity.Location;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Darren.zhang on 7/28/2016.
 */
@Entity
@IdClass(BasePrimaryID.class)
@Table(name = "assets")
public class Asset implements Serializable {
    @Id
    @Column(name = "ORG")
    private String org;
    @Id
    @Column(name = "KEY_ID")
    private Integer keyId;
    @Column(name = "ASSET_REFERENCE")
    private String assetReference;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "MANUFACTURER")
    private String manufacturer;
    @Column(name = "SERIAL_NUMBER")
    private String serialNumber;
    @Column(name = "LOCATION_ID")
    private Integer locationId;
    @Column(name = "ACCOUNT_ID")
    private Integer accountId;
    @Column(name = "GROUP_ID")
    private Integer groupId;
    @Column(name = "SERVICE_PROVIDER")
    private String serviceProvider;

    public Asset() {
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

    public String getAssetReference() {
        return assetReference;
    }

    public void setAssetReference(String assetReference) {
        this.assetReference = assetReference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override
    public String toString() {
        return "Assets{" +
                "org='" + org + '\'' +
                ", keyId=" + keyId +
                ", assetReference='" + assetReference + '\'' +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", locationId=" + locationId +
                ", accountId=" + accountId +
                ", groupId=" + groupId +
                ", serviceProvider='" + serviceProvider + '\'' +
                '}';
    }
}
