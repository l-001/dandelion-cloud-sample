package org.dandelion.cloud.sample.gateway.dynamic;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * TODO 使用 Nacos 做动态路由
 *
 * @author L
 * @version 1.0
 * @date 2022-10-25 18:04
 */
public class NacosRouteRepository implements RouteDefinitionRepository {
    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return null;
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }
}
