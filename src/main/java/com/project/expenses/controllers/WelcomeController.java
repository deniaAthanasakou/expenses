package com.project.expenses.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.logging.Logger;

@Controller
@ConfigurationProperties(prefix="welcome")
public class WelcomeController {

    private final static Logger LOGGER = Logger.getLogger(WelcomeController.class.getName());

    // inject via application.properties
   // @Value("${welcome.message}")
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "/welcome";
    }

}