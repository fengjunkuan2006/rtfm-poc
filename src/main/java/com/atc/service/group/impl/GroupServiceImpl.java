package com.atc.service.group.impl;

import com.atc.domains.group.IGroupDAO;
import com.atc.domains.group.entity.Group;
import com.atc.service.group.IGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Neil.Fang on 7/25/2016.
 */
@Service
public class GroupServiceImpl implements IGroupService {
    private final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);

    @Autowired
    IGroupDAO groupDAO;

    public List<Group> getGroupList(String org) {
        List<Group> result = null;

        try {
            result = groupDAO.selectGroup(org);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return result;
    }
}
