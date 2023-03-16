package org.omaha.cloud.controller;

import org.omaha.cloud.entity.User;
import org.omaha.cloud.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonHystrixController {

    @Autowired
    private RibbonHystrixService ribbonHystrixService;


    @GetMapping("/ribbon/{id}")
    public User findById(@PathVariable Long id) {
        return this.ribbonHystrixService.findById(id);
    }
}
