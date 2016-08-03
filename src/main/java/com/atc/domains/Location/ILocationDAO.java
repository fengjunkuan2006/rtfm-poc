package com.atc.domains.location;

import com.atc.domains.location.entity.Location;

import java.util.List;

/**
 * Created by Viki.Feng on 2016/8/1.
 */
public interface ILocationDAO {

    /**
     * Get List<Location>
     *
     * @param org ORG
     * @return List<Location>
     */
    List<Location> getLocations(String org);


    /**
     * Get List<Location> By LocationKeyId
     *
     * @param id LocationKeyId
     * @param org ORG
     * @return List<Location>
     */
    List<Location> getLocationsById(Integer id, String org);
}
