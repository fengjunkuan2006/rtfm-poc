package com.atc.domains.group.impl;

import com.atc.domains.group.entity.Group;
import com.atc.domains.group.IGroupDAO;
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
public class GroupDAOImpl implements IGroupDAO {
    @Resource
    public SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public List<Group> selectGroup(String org) {
        org.hibernate.Criteria criteria = getSession().createCriteria(Group.class);
        criteria.add(Restrictions.eq("org", org));

        List groups = criteria.list();
        return groups;
    }
}

