package com.example.service;

import com.example.Database;
import com.example.entity.ColumnDefn;
import com.example.entity.CustomObjectDefn;
import com.example.repoistory.ColumnDefnRepository;
import com.example.repoistory.CustomObjectDefnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.constants.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomObjService implements CustomObjectDefnRepository {

    @Autowired
    Database db;

    public void add(Map<String,Object> data) throws Exception {
        data.put("col_id", UUID.randomUUID().toString());
        String customObjSql = CommonUtils.prepareCustObjData(data, custObjDefn, INSERT_CUSTOM_OBJ_DEFN);
        db.insertObj(customObjSql);
    }

    @Override
    public List<Map<String, Object>> getCustomObjRecords(String site_id, String custom_name) {
        String sql = "Select * from custom_objects left join col_defn on custom_objects.col_id = col_defn.col_id" +
                " where custom_objects.site_id="+site_id+" and custom_objects.name='"+custom_name+"'";
        return db.getRecords(sql);
    }


}
