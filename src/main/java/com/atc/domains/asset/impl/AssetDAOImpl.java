package com.atc.domains.asset.impl;

import com.atc.domains.asset.IAssetDAO;
import com.atc.domains.asset.entity.Asset;
import javafx.application.Application;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        String sql = "INSERT INTO assets (org, key_id, asset_reference, description, group_id, account_id, location_id, manufacturer, serial_number) SELECT 'AWSIE', IFNULL(MAX(key_id), 0) + 1 AS keyId, '" + asset.getAssetReference() + "', '" + asset.getDescription() + "','" + asset.getGroupId() + "','" + asset.getAccountId() + "','" + asset.getLocationId() + "','" + asset.getManufacturer() + "','" + asset.getSerialNumber() + "' FROM assets WHERE org='AWSIE'";
        SQLQuery query = getSession().createSQLQuery(sql);
        return query.executeUpdate();
    }

    public List<Asset> findAssets(Asset assets) {
        org.hibernate.Criteria criteria = getSession().createCriteria(Asset.class);

        if (!"".equals(assets.getAssetReference().trim())) {
            criteria.add(Restrictions.eq("assetReference", assets.getAssetReference().trim()));
        }
        if (!"".equals(assets.getDescription().trim())) {
            criteria.add(Restrictions.eq("description", assets.getDescription().trim()));
        }
        if (!"".equals(assets.getManufacturer().trim())) {
            criteria.add(Restrictions.eq("manufacturer", assets.getManufacturer().trim()));
        }
        if (!"".equals(assets.getSerialNumber().trim())) {
            criteria.add(Restrictions.eq("serialNumber", assets.getSerialNumber().trim()));
        }
        if (!"".equals(assets.getServiceProvider().trim())) {
            criteria.add(Restrictions.eq("serviceProvider", assets.getServiceProvider().trim()));
        }
        if (assets.getAccountId() != 0) {
            criteria.add(Restrictions.eq("accountId", assets.getAccountId()));
        }
        if (assets.getLocationId() != 0) {
            criteria.add(Restrictions.eq("locationId", assets.getLocationId()));
        }
        if (assets.getGroupId() != 0) {
            criteria.add(Restrictions.eq("groupId", assets.getGroupId()));
        }
        List<Asset> list = criteria.list();

        return list;
    }

    public Asset get(Integer id) {
        org.hibernate.Criteria criteria = getSession().createCriteria(Asset.class);
        criteria.add(Restrictions.eq("keyId", id));
        return (Asset) criteria.list().get(0);
    }

    public void update(Asset assets) {
        String sql = "UPDATE assets SET ASSET_REFERENCE='" + assets.getAssetReference() + "',DESCRIPTION='" + assets.getDescription() + "',ACCOUNT_ID='" + assets.getAccountId() + "',LOCATION_ID='" + assets.getLocationId() + "',MANUFACTURER='" + assets.getManufacturer() + "',SERIAL_NUMBER='" + assets.getSerialNumber() + "',GROUP_ID='" + assets.getGroupId() + "' WHERE KEY_ID='" + assets.getKeyId() + "'";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.executeUpdate();
    }
}
