package org.dandelion.cloud.sample.sentinel;

import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class SentinelSampleApplication {

    public static void main(String[] args) {
//        initFlowRule();
//        initFlow4Nacos();
        SpringApplication.run(SentinelSampleApplication.class, args);
    }

    /**
     * 编码配置
     * 使用 Nacos 作为配置中心，来持久化 Sentinel 的规则
     *
     * Nacos ===> Sentinel    √
     * Sentinel ===> Nacos    ×
     * 不能双向推送
     * 需要手动改 Dashboard 规则
     *
     * @author L
     */
    public static void initFlow4Nacos() {
        String remoteAddress = "localhost:8848";
        String groupId = "DEFAULT_GROUP";
        String dataId = "springcloud-sentinel";
        Converter<String, List<FlowRule>> parser = source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
        });
        ReadableDataSource<String, List<FlowRule>> nacosDataSource = new NacosDataSource<>(remoteAddress, groupId, dataId, parser);
        FlowRuleManager.register2Property(nacosDataSource.getProperty());
    }

    /**
     * 定义限流规则，测试时可以使用，生产建议使用 datasource 配置中心
     *
     * @author L
     */
    private static void initFlowRule() {

        // 流控策略
        List<FlowRule> flowRuleList = new ArrayList<>();
        // 限流规则类
        FlowRule flowRule = new FlowRule();
        // 按照资源名称限流
        flowRule.setResource("USER");
        // 流量控制的阈值类型(0:线程数，1:QPS)
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 流量控制阈值计数
        flowRule.setCount(1);
        flowRuleList.add(flowRule);
        // 加载限流规则
        FlowRuleManager.loadRules(flowRuleList);

        // *******************************************************

        // 降级策略
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource("USER");
        DegradeRuleManager.loadRules(Collections.singletonList(degradeRule));

        // *******************************************************

        // 热点参数
        ParamFlowRule paramFlowRule = new ParamFlowRule();
        paramFlowRule.setResource("USER");
        ParamFlowRuleManager.loadRules(Collections.singletonList(paramFlowRule));

    }

}
