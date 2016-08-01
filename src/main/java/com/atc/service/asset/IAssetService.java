package com.atc.service.asset;

import com.atc.domains.asset.entity.Asset;

import java.util.List;

/**
 * Created by Neil.Fang on 7/25/2016.
 */
public interface IAssetService {
    int addAsset(Asset asset);

    List<Asset> findAssets(Asset assets);

    Asset get(Integer id);

    void update(Integer id, Asset assets);
}
