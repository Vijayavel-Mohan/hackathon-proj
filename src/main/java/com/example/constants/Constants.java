package com.example.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants{
    public static final String INSERT_CUSTOM_OBJ_DEFN = "INSERT INTO public.custom_objects";

    public static final String INSERT_COL_DEFN = "INSERT INTO public.col_defn";

    public static final String VALUES = " values ";

    public static final String BRACKETS_OPEN = "(";

    public static final String BRACKETS_CLOSE= ")";

    public  static final String COMMA = ",";

    public  static final String SEMI_COLON = ";";

    public static final String CREATE_TABLE ="CREATE TABLE ";

    public static List<String> custObjDefn = Arrays.asList("site_id","name","api_path","col_id");

    public static List<String> colDefn = Arrays.asList("col_id","col_name","col_type","col_length","is_relation","relation_name");

    public static Map<String, Object> dataTypeMap = new HashMap<>();
    static {
        dataTypeMap.put("Text", "VARCHAR");
        dataTypeMap.put("Number","INT");
        dataTypeMap.put("obj","JSON");
    }


}
