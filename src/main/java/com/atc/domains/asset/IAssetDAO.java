package com.atc.domains.asset;

import com.atc.domains.asset.entity.Asset;

import java.util.List;

/**
 * Created by Viki.Feng on 01/02/2016.
 */
public interface IAssetDAO {
    /**
     * insertAsset
     * @param asset
     * @return
     */
    int insertAsset(Asset asset);

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
     * updateAsset
     * @param id
     * @param assets
     */
    void update(Integer id, Asset assets);
}
