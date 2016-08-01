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
     * @param assets
     * @return List<Asset>
     */
    List<Asset> findAssets(Asset assets);

    /**
     * Get Asset By AssetId
     *
     * @param id Asset keyId
     * @return Asset
     */
    Asset get(Integer id);

    /**
     * Update Asset By keyId
     *
     * @param id Asset KetId
     * @param assets
     */
    void update(Integer id, Asset assets);
}
