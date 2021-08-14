package com.stackroute.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


/**
 * RestController annotation is used to create Restful web services using Spring MVC
 */
@RestController

/**
 * RequestMapping annotation maps HTTP requests to handler methods
 */
@RequestMapping("/api/v1/")
public class ServiceController {

    /**
     * To get the property values
     */
    @Value("${app.validationConfirmationMessage}")
    private String validationConfirmationMessage;


    @GetMapping("data")
    public String getSensitiveData() {

        return validationConfirmationMessage;
    }

}
