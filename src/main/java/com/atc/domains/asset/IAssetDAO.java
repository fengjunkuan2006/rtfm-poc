package com.atc.domains.asset;

import com.atc.common.model.asset.PagedListCondition;
import com.atc.common.model.asset.PagedListResult;
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
     * @param condition
     * @return PagedListResult
     */
    PagedListResult findAssets(PagedListCondition condition);

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
