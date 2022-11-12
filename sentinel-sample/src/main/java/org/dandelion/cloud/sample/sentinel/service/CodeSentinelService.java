package org.dandelion.cloud.sample.sentinel.service;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.dandelion.cloud.sample.sentinel.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author L
 * @version 1.0
 * @date 2022-10-19 17:20
 */
@Service
public class CodeSentinelService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    private final static String USER = "USER";

    public List<User> getUser(String id) {

        Entry entry = null;

        try {
            // 获取 Entry 访问令牌
            entry = SphU.entry(USER);


            // 热点规则限流
//            entry = SphU.entry(USER, EntryType.IN, 1, id);

            // 执行业务逻辑
            String sql = "SELECT * FROM user WHERE id='" + id + "'";

            return jdbcTemplate.query(sql, (rs, rowNum) -> {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                return user;
            });

        } catch (BlockException e) {
            // 抛出异常，被限流
            // 执行降级或其他业务处理
            System.out.println("被限流 ! ! !");
            throw new RuntimeException("被限流 ! ! !");
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }


    }
}
