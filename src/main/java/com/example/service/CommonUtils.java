package com.example.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.constants.Constants.*;

public class CommonUtils{

    public static String prepareCustObjData(Map<String, Object> data, List<String> cols, String tableName) {
        String  insert = data.entrySet()
                .stream()
                .filter(entry -> cols.contains(entry.getKey()))
                .map(key -> key.getKey().toUpperCase())
                .collect(Collectors.joining(COMMA));
        String  value = data.entrySet()
                .stream()
                .filter(entry -> cols.contains(entry.getKey()))
                .map(key -> "\'"+key.getValue().toString()+"\'")
                .collect(Collectors.joining(COMMA));
        return new StringBuilder(tableName)
                .append(BRACKETS_OPEN)
                .append(insert)
                .append(BRACKETS_CLOSE)
                .append(VALUES)
                .append(BRACKETS_OPEN)
                .append(value)
                .append(BRACKETS_CLOSE)
                .append(SEMI_COLON)
                .toString();
    }
}