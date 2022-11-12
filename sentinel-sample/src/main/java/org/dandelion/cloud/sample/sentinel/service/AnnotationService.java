package org.dandelion.cloud.sample.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

/**
 * TODO SentinelResource 注解 降级测试
 *
 * @author L
 * @version 1.0
 * @date 2022-10-20 17:56
 */
@Service
public class AnnotationService {

    /**
     * SentinelResource 限流注解，方法级；该注解并不默认配置降级策略，需要手动在 Dashboard 中配置
     *
     * @return .
     * @author L
     */
    @SentinelResource(blockHandler = "blockHandler")
    public String annotation() {
        return "注解方式进行限流测试 -> 通过";
    }

    /**
     * 限流降级方法
     *
     * @param e .
     * @return .
     * @author L
     */
    public String blockHandler(BlockException e) {
        System.out.println(e.getRule());
        return "注解方式进行限流测试 -> 被限流";
    }
}
