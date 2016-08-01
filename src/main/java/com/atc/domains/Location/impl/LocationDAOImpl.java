package com.atc.domains.location.impl;

import com.atc.domains.location.ILocationDAO;
import com.atc.domains.location.entity.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Viki.Feng on 2016/8/1.
 */
@Service
public class LocationDAOImpl implements ILocationDAO {
    @Resource
    public SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public List<Location> getLocations() {
        org.hibernate.Criteria criteria = getSession().createCriteria(Location.class);
        List<Location> list = criteria.list();
        return list;
    }
}
