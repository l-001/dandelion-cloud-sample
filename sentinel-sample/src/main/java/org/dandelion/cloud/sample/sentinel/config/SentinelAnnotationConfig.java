package org.dandelion.cloud.sample.sentinel.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO SentinelResource 注解加载配置类
 *
 * @author L
 * @version 1.0
 * @date 2022-10-20 18:00
 */
@Configuration
public class SentinelAnnotationConfig {

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }
}
