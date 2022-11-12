package org.dandelion.cloud.sample.sentinel.controller;

import org.dandelion.cloud.sample.sentinel.entity.User;
import org.dandelion.cloud.sample.sentinel.service.CodeSentinelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO 编码方式测试 sentinel 限流
 *
 * @author L
 * @version 1.0
 * @date 2022-10-06 14:51
 */
@RestController
public class CodeSentinelController {

    @Autowired
    private CodeSentinelService codeSentinelService;

    @GetMapping("/getUser/{id}")
    public List<User> getUser(@PathVariable("id") String id) {
        return codeSentinelService.getUser(id);
    }
}
