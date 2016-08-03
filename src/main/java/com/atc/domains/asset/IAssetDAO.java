package com.atc.domains.asset;

import com.atc.domains.asset.entity.Asset;

import java.util.List;

/**
 * Created by Viki.Feng on 01/02/2016.
 */
public interface IAssetDAO {

    int insertAsset(Asset asset);

    /**
     * Find Asset List
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
     * Update Asset By keyId
     *
     * @param asset
     */
    void update(Asset asset);
}
