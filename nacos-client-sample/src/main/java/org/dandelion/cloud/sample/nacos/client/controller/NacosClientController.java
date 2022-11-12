package org.dandelion.cloud.sample.nacos.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author L
 * @version 1.0
 * @date 2022-10-11 11:27
 */
@RestController
@RequestMapping("/nacos/client")
public class NacosClientController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") String id) {
        return "client ->> " + id;
    }

}
