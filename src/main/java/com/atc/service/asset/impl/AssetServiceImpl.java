package com.atc.service.asset.impl;

import com.atc.domains.asset.IAssetDAO;
import com.atc.domains.asset.entity.Asset;
import com.atc.service.asset.IAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Neil.Fang on 7/25/2016.
 */
@Service
public class AssetServiceImpl implements IAssetService {
    @Autowired
    IAssetDAO assetDAO;

    public int addAsset(Asset asset) {
        int result = 0;

        try {
            result = assetDAO.insertAsset(asset);
        } catch (Exception e) {
        }
        return result;
    }

    public List<Asset> findAssets(Asset asset) {
        return assetDAO.findAssets(asset);
    }

    public Asset get(Integer id, String org) {
        return assetDAO.get(id, org);
    }

    public void update(Asset asset) {
        assetDAO.update(asset);
    }
}
