package com.atc.service.location;

import com.atc.domains.location.entity.Location;

import java.util.List;

/**
 * Created by Viki.Feng on 2016/8/1.
 */
public interface ILocationService {

    /**
     * Get Location List
     *
     * @return List<Location>
     */
    List<Location> getLocations();


    /**
     * Get List<Location> By LocationKeyId
     *
     * @param id LocationLeyId
     * @param org ORG
     * @return List<Location>
     */
    List<Location> getLocationsById(Integer id, String org);
}
