package org.dandelion.cloud.sample.config.client.controller;

import org.dandelion.cloud.sample.config.client.entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * TODO
 *
 * @author L
 * @version 1.0
 * @date 2022-10-06 14:51
 */
@RestController
public class ClientController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("getUser")
    public List<User> getUser() {

        String sql = "SELECT * FROM user";

        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                return user;
            }
        });
    }
}
