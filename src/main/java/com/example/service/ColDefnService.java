package com.example.service;

import com.example.Database;
import com.example.entity.CustomObjectDefn;
import com.example.repoistory.ColumnDefnRepository;
import com.example.repoistory.CustomObjectDefnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.constants.Constants.*;
import static com.example.constants.Constants.SEMI_COLON;

@Service
public class ColDefnService  implements ColumnDefnRepository {

        @Autowired
        Database db;

        public void add(Map<String,Object> data) throws Exception {
            List<Map<String, Object>> colData = (List<Map<String, Object>>) data.get("cols");
            String relatedId = data.get("col_id").toString();
            List<String> colsSql = new ArrayList<>();
            for(Map<String,Object> map : colData) {
                map.put("col_id",relatedId);
                colsSql.add(CommonUtils.prepareCustObjData(map, colDefn, INSERT_COL_DEFN));
            }
            String[] itemsArray = new String[colsSql.size()];
            itemsArray = colsSql.toArray(itemsArray);
            db.insertObj(itemsArray);
        }

    @Override
    public void createTableDefn(Map<String, Object> dataMap) throws Exception {
        String defnName = dataMap.get("name").toString();
        String defaultKey = "id INT AUTO_INCREMENT PRIMARY KEY";
        List<Map<String, Object>> colData = (List<Map<String, Object>>) dataMap.get("cols");
        String  insert = colData
                .stream()
                .map(data -> {
                    String type = data.get("col_type").toString();
                    String leng = data.get("col_length") == null ? "" : data.get("col_length").toString();
                    return data.get("col_name").toString()
                            +" "
                            +dataTypeMap.get(type).toString()
                            + (type.equalsIgnoreCase("text") ? BRACKETS_OPEN+leng+BRACKETS_CLOSE:"");
                })
                .collect(Collectors.joining(COMMA));

        String createSql = new StringBuilder(CREATE_TABLE)
                           .append(defnName).append(" ").append(BRACKETS_OPEN)
                .append(defaultKey).append(COMMA).append(insert)
                .append(BRACKETS_CLOSE).append(SEMI_COLON).toString();
        db.insertObj(createSql);

    }


}
