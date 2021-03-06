package com.atc.domains.customerAccount.impl;

import com.atc.common.util.DBException;
import com.atc.domains.customerAccount.ICustomerAccountDAO;
import com.atc.domains.customerAccount.entity.CustomerAccount;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Vic.Feng on 10/03/2016.
 */
@Service
public class CustomerAccountDAOImpl implements ICustomerAccountDAO {
    @Resource
    public SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public int insertAccount(CustomerAccount customerAccount) {
        try {
            String sql = "INSERT INTO customeraccounts (ORG, KEY_ID, NAME, NUMBER, LOCATIONROOT, ACTIVE, SAL_ID) SELECT org, IFNULL(MAX(key_id), 0) + 1 AS keyId, '" + customerAccount.getName() + "', '" + customerAccount.getNumber() + "','" + customerAccount.getLocation() + "','" + customerAccount.getActive() + "',0 FROM customeraccounts WHERE org='" + customerAccount.getOrg() + "'";
            SQLQuery query = getSession().createSQLQuery(sql);
            return query.executeUpdate();
        } catch (Exception e) {
            throw new DBException(e.getMessage());
        }
    }

    public List<CustomerAccount> getAccounts(String org) {
        try {
            org.hibernate.Criteria criteria = getSession().createCriteria(CustomerAccount.class);
            criteria.add(Restrictions.eq("org", org));

            List<CustomerAccount> list = criteria.list();
            return list;
        } catch (HibernateException e) {
            throw new DBException(e.getMessage());
        }
    }
}
