package com.project.expenses.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

@Controller
public class WelcomeController {

    private final static Logger LOGGER = Logger.getLogger(WelcomeController.class.getName());
    // inject via application.properties
    //@Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/welcome")
    public ModelAndView firstPage() {
        LOGGER.info("Accessed Welcome controller");
        return new ModelAndView("welcome");
    }

}