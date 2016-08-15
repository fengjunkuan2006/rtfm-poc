package com.atc.common.model.asset;

import com.atc.domains.asset.entity.Asset;

import java.util.List;

/**
 * Created by Vic.Feng on 2016/8/4.
 */
public class PagedListResult {
    private String sEcho;
    private Long iTotalRecords;
    private Long iTotalDisplayRecords;
    private List<Asset> aaData;

    public String getsEcho() {
        return sEcho;
    }

    public void setsEcho(String sEcho) {
        this.sEcho = sEcho;
    }

    public Long getiTotalRecords() {
        return iTotalRecords;
    }

    public void setiTotalRecords(Long iTotalRecords) {
        this.iTotalRecords = iTotalRecords;
    }

    public Long getiTotalDisplayRecords() {
        return iTotalDisplayRecords;
    }

    public void setiTotalDisplayRecords(Long iTotalDisplayRecords) {
        this.iTotalDisplayRecords = iTotalDisplayRecords;
    }

    public List<Asset> getAaData() {
        return aaData;
    }

    public void setAaData(List<Asset> aaData) {
        this.aaData = aaData;
    }
}
