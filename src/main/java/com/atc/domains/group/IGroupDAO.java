package com.atc.domains.group;

import com.atc.domains.group.entity.Group;

import java.util.List;

/**
 * Created by Viki.Feng on 01/02/2016.
 */
public interface IGroupDAO {
    public List<Group> selectGroup();
}
