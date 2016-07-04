package com.atc.domains.home;

import com.atc.domains.home.entity.User;

/**
 * Created by Viki.Feng on 01/02/2016.
 */
public interface IUserDAO {
    User selectUserByNameAndPassword(String username, String password, String organisation);
}
