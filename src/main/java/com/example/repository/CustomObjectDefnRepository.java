package com.example.repoistory;

import com.example.entity.CustomObjectDefn;

import java.util.List;
import java.util.Map;

public interface CustomObjectDefnRepository {

    void add(Map<String,Object> data) throws Exception;

    List<Map<String,Object>> getCustomObjRecords(String site_id, String custom_name);
}
