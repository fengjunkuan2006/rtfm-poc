package com.atc.domains.home.impl;

import com.atc.domains.home.ITaskDAO;
import com.atc.domains.home.entity.Task;
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
public class TaskDAOImpl implements ITaskDAO {
    @Resource
    public SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public List<Task> selectTasks() {
        org.hibernate.Criteria criteria = getSession().createCriteria(Task.class);
        //criteria.add(Restrictions.eq("taskId", 100L));
        List tasks = criteria.list();
        return tasks;
    }
}
