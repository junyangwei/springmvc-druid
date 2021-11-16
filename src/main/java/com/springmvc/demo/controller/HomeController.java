package com.springmvc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author junyangwei
 * @date 2021-11-16
 */
@RestController
public class HomeController {
    @GetMapping("/api")
    public String home() {
        return "Hello, this is a SpringMVC demo with druid!";
    }
}
