package com.atc.service.asset;

import com.atc.common.model.asset.PagedListCondition;
import com.atc.common.model.asset.PagedListResult;
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
     * Update Asset By Id
     *
     * @param asset
     */
    void update(Asset asset);
}
