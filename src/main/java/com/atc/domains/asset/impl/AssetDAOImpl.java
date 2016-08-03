package com.atc.domains.asset.impl;

import com.atc.domains.asset.IAssetDAO;
import com.atc.domains.asset.entity.Asset;
import javafx.application.Application;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Viki.Feng on 10/03/2016.
 */
@Service
public class AssetDAOImpl implements IAssetDAO {
    @Resource
    public SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public int insertAsset(Asset asset) {
        String sql = "INSERT INTO assets (org, key_id, asset_reference, description, group_id, account_id, location_id, manufacturer, serial_number) SELECT org, IFNULL(MAX(key_id), 0) + 1 AS keyId, '" + asset.getAssetReference() + "', '" + asset.getDescription() + "','" + asset.getGroupId() + "','" + asset.getAccountId() + "','" + asset.getLocationId() + "','" + asset.getManufacturer() + "','" + asset.getSerialNumber() + "' FROM assets WHERE org='" + asset.getOrg() + "'";
        SQLQuery query = getSession().createSQLQuery(sql);
        return query.executeUpdate();
    }

    public List<Asset> findAssets(Asset asset) {
        org.hibernate.Criteria criteria = getSession().createCriteria(Asset.class);

        criteria.add(Restrictions.eq("org", asset.getOrg()));
        if (!"".equals(asset.getAssetReference().trim())) {
            criteria.add(Restrictions.eq("assetReference", asset.getAssetReference().trim()));
        }
        if (!"".equals(asset.getDescription().trim())) {
            criteria.add(Restrictions.eq("description", asset.getDescription().trim()));
        }
        if (!"".equals(asset.getManufacturer().trim())) {
            criteria.add(Restrictions.eq("manufacturer", asset.getManufacturer().trim()));
        }
        if (!"".equals(asset.getSerialNumber().trim())) {
            criteria.add(Restrictions.eq("serialNumber", asset.getSerialNumber().trim()));
        }
        if (!"".equals(asset.getServiceProvider().trim())) {
            criteria.add(Restrictions.eq("serviceProvider", asset.getServiceProvider().trim()));
        }
        if (asset.getAccountId() != 0) {
            criteria.add(Restrictions.eq("accountId", asset.getAccountId()));
        }
        if (asset.getLocationId() != 0) {
            criteria.add(Restrictions.eq("locationId", asset.getLocationId()));
        }
        if (asset.getGroupId() != 0) {
            criteria.add(Restrictions.eq("groupId", asset.getGroupId()));
        }
        List<Asset> list = criteria.list();

        return list;
    }

    public Asset get(Integer id, String org) {
        org.hibernate.Criteria criteria = getSession().createCriteria(Asset.class);
        criteria.add(Restrictions.eq("org", org));
        criteria.add(Restrictions.eq("keyId", id));
        return (Asset) criteria.list().get(0);
    }

    public void update(Asset asset) {
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        session.update(asset);
        tx.commit();
        session.close();
    }
}
