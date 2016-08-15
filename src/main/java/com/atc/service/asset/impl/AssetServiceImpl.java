package com.atc.service.asset.impl;

import com.atc.common.model.asset.PagedListCondition;
import com.atc.common.model.asset.PagedListResult;
import com.atc.domains.asset.IAssetDAO;
import com.atc.domains.asset.entity.Asset;
import com.atc.service.asset.IAssetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Neil.Fang on 7/25/2016.
 */
@Service
public class AssetServiceImpl implements IAssetService {
    private final Logger logger = LoggerFactory.getLogger(AssetServiceImpl.class);

    @Autowired
    IAssetDAO assetDAO;

    public int addAsset(Asset asset) {
        int result = 0;
        try {
            result = assetDAO.insertAsset(asset);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return result;
    }

    public PagedListResult findAssets(PagedListCondition condition) {
        PagedListResult result = null;
        try {
            result = assetDAO.findAssets(condition);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return result;
    }

    public Asset get(Integer id, String org) {
        Asset result = null;
        try {
            result = assetDAO.get(id, org);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return result;
    }

    public void update(Asset asset) {
        try {
            assetDAO.update(asset);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
