package com.atc.domains.group;

import com.atc.domains.group.entity.Group;

import java.util.List;

/**
 * Created by Vic.Feng on 01/02/2016.
 */
public interface IGroupDAO {
    /**
     * Select group
     *
     * @param org
     * @return
     */
    public List<Group> selectGroup(String org);
}
