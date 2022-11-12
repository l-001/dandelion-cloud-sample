package org.dandelion.cloud.sample.fegin.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO
 *
 * @author L
 * @version 1.0
 * @date 2022-10-21 10:21
 */
@FeignClient(name = "springcloud-eureka-client")
public interface FeginService {

    @GetMapping("/eureka/client/get/{id}")
    String get(@PathVariable("id") String id);

}
