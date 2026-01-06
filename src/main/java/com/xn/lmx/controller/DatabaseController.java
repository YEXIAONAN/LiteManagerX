package com.xn.lmx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/get")
public class DatabaseController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 查询所有数据库
    @GetMapping("/databases")
    public List<String> getDatabses() {
        return jdbcTemplate.queryForList("SHOW DATABASES",String.class);
    }

    // 查询指定数据库的表结构
    @GetMapping("/{dbName}/info")
    public List<Map<String,Object>> getDatabaseInfo(@PathVariable String dbName) {
        String sql = "SELECT TABLE_NAME, COLUMN_NAME, COLUMN_TYPE, IS_NULLABLE, COLUMN_KEY " +
                "FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = ?";
        return jdbcTemplate.queryForList(sql,dbName);
    }

    // 查看指定表的数据
    @GetMapping("/{dbName}/data/{tableName}")
    public List<Map<String, Object>> getDatabaseData(@PathVariable String dbName,
                                                     @PathVariable String tableName) {
        jdbcTemplate.execute("USE " + dbName);  // 切换数据库
        String sql = "SELECT * FROM " + tableName;
        return jdbcTemplate.queryForList(sql);
    }
}
