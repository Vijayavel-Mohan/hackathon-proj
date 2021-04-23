package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class Database{

    @Autowired
    JdbcTemplate jdbc;


    public void insertObj(String sql) throws  Exception{
        jdbc.execute(sql);
    }


    public void insertObj(String... sql) throws  Exception{
        jdbc.batchUpdate(sql);
    }


    public List<Map<String, Object>> getRecords(String sql) {
        try {
            List<Map<String, Object>> records = jdbc.queryForList(sql);
            return records;
        }catch(Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}