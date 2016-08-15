package com.atc.domains.home;

import com.atc.domains.home.entity.Actor;

/**
 * Created by Vic.Feng on 01/02/2016.
 */
public interface IUserDAO {
    Actor selectUserByNameAndPassword(String username, String password, String organisation);
}
