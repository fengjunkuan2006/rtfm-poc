package com.atc.domains.location;

import com.atc.domains.location.entity.Location;

import java.util.List;

/**
 * Created by Viki.Feng on 2016/8/1.
 */
public interface ILocationDAO {
    List<Location> getLocations();

    List<Location> getLocationsById(Integer id, String org);
}
