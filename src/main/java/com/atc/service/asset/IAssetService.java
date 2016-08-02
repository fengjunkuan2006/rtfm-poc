package com.atc.service.asset;

import com.atc.domains.asset.entity.Asset;

import java.util.List;

/**
 * Created by Neil.Fang on 7/25/2016.
 */
public interface IAssetService {
    /**
     * Add Asset
     *
     * @param asset
     * @return
     */
    int addAsset(Asset asset);

    /**
     * Get Assetr List
     *
     * @param assets
     * @return List<Asset>
     */
    List<Asset> findAssets(Asset assets);

    /**
     * Get Asset By AssetId
     *
     * @param id Asset  keyId
     * @return Asset
     */
    Asset get(Integer id);

    /**
     * Update Asset By AssetId
     *
     * @param id  Asset  keyId
     * @param assets
     */
    void update(Asset assets);
}
