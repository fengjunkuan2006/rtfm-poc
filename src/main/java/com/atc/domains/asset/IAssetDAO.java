package com.atc.domains.asset;

import com.atc.domains.asset.entity.Asset;

import java.util.List;

/**
 * Created by Viki.Feng on 01/02/2016.
 */
public interface IAssetDAO {
    int insertAsset(Asset asset);

    List<Asset> findAssets(Asset assets);

    Asset get(Integer id);

    void update(Integer id, Asset assets);
}
