package com.atc.domains.home.impl;

import com.atc.common.util.DBException;
import com.atc.domains.home.IUserDAO;
import com.atc.domains.home.entity.Actor;
import org.hibernate.HibernateException;
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
public class UserDAOImpl implements IUserDAO {
    @Resource
    public SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public Actor selectUserByNameAndPassword(String username, String password, String organisation) {
        try {
            org.hibernate.Criteria criteria = getSession().createCriteria(Actor.class);
            criteria.add(Restrictions.eq("loginName", username));
            criteria.add(Restrictions.eq("password", password));
            criteria.add(Restrictions.eq("org", organisation));
            List users = criteria.list();
            if (users.size() > 0) {
                return (Actor) users.get(0);
            }
            return null;
        } catch (HibernateException e) {
            throw new DBException(e.getMessage());
        }
    }
}
