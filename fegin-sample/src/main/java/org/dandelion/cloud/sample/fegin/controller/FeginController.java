package org.dandelion.cloud.sample.fegin.controller;

import org.dandelion.cloud.sample.fegin.service.FeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author L
 * @version 1.0
 * @date 2022-10-21 10:23
 */
@RestController
@RequestMapping("/fegin")
public class FeginController {

    @Autowired
    private FeginService feginService;

    @GetMapping("/get/{id}")
    public String fegin(@PathVariable("id") String id){
        return "fegin ->> "+feginService.get(id);
    }
}
