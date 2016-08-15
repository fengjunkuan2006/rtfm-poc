package com.atc.domains.asset.impl;

import com.atc.common.model.asset.PagedListCondition;
import com.atc.common.model.asset.PagedListResult;
import com.atc.common.util.DBException;
import com.atc.domains.asset.IAssetDAO;
import com.atc.domains.asset.entity.Asset;
import javafx.application.Application;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Vic.Feng on 10/03/2016.
 */
@Service
public class AssetDAOImpl implements IAssetDAO {
    @Resource
    public SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public int insertAsset(Asset asset) {
        try {
            String sql = "INSERT INTO assets (org, key_id, asset_reference, description, group_id, account_id, location_id, manufacturer, serial_number) SELECT org, IFNULL(MAX(key_id), 0) + 1 AS keyId, '" + asset.getAssetReference() + "', '" + asset.getDescription() + "','" + asset.getGroupId() + "','" + asset.getAccountId() + "','" + asset.getLocationId() + "','" + asset.getManufacturer() + "','" + asset.getSerialNumber() + "' FROM assets WHERE org='" + asset.getOrg() + "'";
            SQLQuery query = getSession().createSQLQuery(sql);
            return query.executeUpdate();
        } catch (Exception e) {
            throw new DBException(e.getMessage());
        }
    }

    public PagedListResult findAssets(PagedListCondition condition) {
        org.hibernate.Criteria criteria = getSession().createCriteria(Asset.class);

        criteria.add(Restrictions.eq("org", condition.getOrg()));
        if (StringUtils.isNotEmpty(condition.getAssetReference())) {
            criteria.add(Restrictions.eq("assetReference", condition.getAssetReference().trim()));
        }
        if (StringUtils.isNotEmpty(condition.getDescription())) {
            criteria.add(Restrictions.eq("description", condition.getDescription().trim()));
        }
        if (StringUtils.isNotEmpty(condition.getManufacturer())) {
            criteria.add(Restrictions.eq("manufacturer", condition.getManufacturer().trim()));
        }
        if (StringUtils.isNotEmpty(condition.getSerialNumber())) {
            criteria.add(Restrictions.eq("serialNumber", condition.getSerialNumber().trim()));
        }
        if (StringUtils.isNotEmpty(condition.getServiceProvider())) {
            criteria.add(Restrictions.eq("serviceProvider", condition.getServiceProvider().trim()));
        }
        if (condition.getAccountId() != null && condition.getAccountId() != 0) {
            criteria.add(Restrictions.eq("accountId", condition.getAccountId()));
        }
        if (condition.getLocationId() != null && condition.getLocationId() != 0) {
            criteria.add(Restrictions.eq("locationId", condition.getLocationId()));
        }
        if (condition.getGroupId() != null && condition.getGroupId() != 0) {
            criteria.add(Restrictions.eq("groupId", condition.getGroupId()));
        }
        //Total record number
        Long totalCount = (Long)criteria.setProjection(Projections.rowCount()).uniqueResult();
        criteria.setProjection( null );

        criteria.setFirstResult(condition.getiDisplayStart());
        criteria.setMaxResults(condition.getiDisplayLength());

        try {
            PagedListResult result = new PagedListResult();
            result.setiTotalRecords(totalCount);
            result.setiTotalDisplayRecords(totalCount);
            result.setAaData(criteria.list());

            return result;
        } catch (HibernateException e) {
            throw new DBException(e.getMessage());
        }
    }

    /**
     * Get asset by id and org
     * @param id
     * @param org
     * @return
     */
    public Asset get(Integer id, String org) {
        try {
            Criteria criteria = getSession().createCriteria(Asset.class);
            criteria.add(Restrictions.eq("org", org));
            criteria.add(Restrictions.eq("keyId", id));
            return (Asset) criteria.list().get(0);
        } catch (HibernateException e) {
            throw new DBException(e.getMessage());
        }
    }

    /**
     * update asset
     * @param asset
     */
    public void update(Asset asset) {
        try {
            Session session = getSession();
            Transaction tx = session.beginTransaction();
            session.update(asset);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            throw new DBException(e.getMessage());
        }
    }
}
