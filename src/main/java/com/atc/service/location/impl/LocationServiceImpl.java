package com.atc.service.location.impl;

import com.atc.domains.location.ILocationDAO;
import com.atc.domains.location.entity.Location;
import com.atc.service.location.ILocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Vic.Feng on 2016/8/1.
 */
@Service
public class LocationServiceImpl implements ILocationService {
    private final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    ILocationDAO locationDAO;

    public List<Location> getLocations(String org) {
        List<Location> result = null;

        try {
            result = locationDAO.getLocations(org);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return result;
    }

    public List<Location> getLocationsById(Integer id, String org) {
        List<Location> result = null;

        try {
            result = locationDAO.getLocationsById(id, org);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return result;
    }
}
