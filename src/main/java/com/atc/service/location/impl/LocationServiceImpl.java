package com.atc.service.location.impl;

import com.atc.domains.location.ILocationDAO;
import com.atc.domains.location.entity.Location;
import com.atc.service.location.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Viki.Feng on 2016/8/1.
 */
@Service
public class LocationServiceImpl implements ILocationService {
    @Autowired
    ILocationDAO locationDAO;

    public List<Location> getLocations(String org) {
        return locationDAO.getLocations(org);
    }

    public List<Location> getLocationsById(Integer id, String org) {
        return locationDAO.getLocationsById(id, org);
    }
}
