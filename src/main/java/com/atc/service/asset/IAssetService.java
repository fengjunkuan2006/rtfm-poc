package com.atc.service.asset;

import com.atc.domains.asset.entity.Asset;

import java.util.List;

/**
 * Created by Neil.Fang on 7/25/2016.
 */
public interface IAssetService {
    /**
     * addAsset
     * @param asset
     * @return
     */
    int addAsset(Asset asset);

    /**
     * findAssets
     * @param assets
     * @return
     */
    List<Asset> findAssets(Asset assets);

    /**
     * getAsset
     * @param id
     * @return
     */
    Asset get(Integer id);

    /**
     * uodateAsset
     * @param id
     * @param assets
     */
    void update(Integer id, Asset assets);
}
