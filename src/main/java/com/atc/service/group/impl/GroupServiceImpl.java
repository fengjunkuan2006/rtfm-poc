package com.atc.service.group.impl;

import com.atc.domains.group.entity.Group;
import com.atc.domains.group.IGroupDAO;
import com.atc.service.group.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Neil.Fang on 7/25/2016.
 */
@Service
public class GroupServiceImpl implements IGroupService {
    @Autowired
    IGroupDAO groupDAO;

    public List<Group> getGroupList() {
        return groupDAO.selectGroup();
    }
}
