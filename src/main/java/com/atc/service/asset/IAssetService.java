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
     * @param asset
     * @return List<Asset>
     */
    List<Asset> findAssets(Asset asset);

    /**
     * Get Asset By AssetId
     *
     * @param id
     * @param org
     * @return
     */
    Asset get(Integer id, String org);

    /**
     * Update Asset By Id
     *
     * @param asset
     */
    void update(Asset asset);
}
