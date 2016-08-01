package com.atc.common.util;

import com.atc.common.constant.SystemConstants;
import com.atc.domains.home.entity.Actor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Vic.Feng on 18/12/2015.
 */
public class SessionUtil {
    public static Actor getSessionUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            Object obj = session.getAttribute(SystemConstants.LOGGED_USER);
            if (obj != null) {
                try {
                    return (Actor) SerializeUtil.unserialize((byte[]) obj);
                } catch (Exception ex) {
                    return null;
                }
            }
        }

        return null;
    }
}
