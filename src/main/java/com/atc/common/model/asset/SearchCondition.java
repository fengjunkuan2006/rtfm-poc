package com.atc.common.model.asset;


/**
 * Created by Vic.Feng on 7/28/2016.
 */

public class SearchCondition {
    private String org;
    private String assetReference;
    private String description;
    private String manufacturer;
    private String serialNumber;
    private Integer locationId;
    private Integer accountId;
    private Integer groupId;
    private String serviceProvider;

    public String getOrg() {
        return org == null ? "" : org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getAssetReference() {
        return assetReference == null ? "" : assetReference;
    }

    public void setAssetReference(String assetReference) {
        this.assetReference = assetReference;
    }

    public String getDescription() {
        return description == null ? "" : description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer == null ? "" : manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSerialNumber() {
        return serialNumber == null ? "" : serialNumber;
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
        return serviceProvider == null ? "" : serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override
    public String toString() {
        return "assetReference=" + assetReference +
                "&description=" + description +
                "&manufacturer=" + manufacturer +
                "&serialNumber=" + serialNumber +
                "&locationId=" + locationId +
                "&accountId=" + accountId +
                "&groupId=" + groupId +
                "&serviceProvider=" + serviceProvider;
    }
}
