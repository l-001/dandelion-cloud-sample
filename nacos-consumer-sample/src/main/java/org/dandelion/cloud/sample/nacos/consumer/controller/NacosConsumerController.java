package org.dandelion.cloud.sample.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * TODO
 *
 * @author L
 * @version 1.0
 * @date 2022-10-11 11:27
 */
@RestController
@RequestMapping("/nacos/consumer")
public class NacosConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 添加 @LoadBalanced 无法访问
     *
     * @param id .
     * @return string
     * @author L
     */
    @GetMapping("/ip/{id}")
    public String ip(@PathVariable("id") String id) {
        return "consumer ->> " + restTemplate.getForObject("http://localhost:8082/nacos/client/get/" + id, String.class);
    }

    /**
     * 不添加 @LoadBalanced 无法访问
     *
     * @param id .
     * @return string
     * @author L
     */
    @GetMapping("/name/{id}")
    public String name(@PathVariable("id") String id) {
        return "consumer ->> " + restTemplate.getForObject("http://springcloud-nacos-client/nacos/client/get/" + id, String.class);
    }
}
