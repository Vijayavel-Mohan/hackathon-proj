package com.example.repoistory;

import com.example.entity.ColumnDefn;
import com.example.entity.CustomObjectDefn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface ColumnDefnRepository  {

    void add(Map<String,Object> data) throws Exception;

    void createTableDefn(Map<String, Object> dataMap) throws Exception;

}
