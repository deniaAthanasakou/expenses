package com.project.expenses;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.logging.Logger;

public final class Utils {

    private final static Logger LOGGER = Logger.getLogger(Utils.class.getName());

    public final static String getUserName() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String loggedInUsername = authentication.getName();
            return loggedInUsername;
        }catch(Exception e){
            LOGGER.info("Could not receive username. Exception message: " + e.getMessage());
            return null;
        }
    }
}
