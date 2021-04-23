package com.example.controller;

import com.example.service.ColDefnService;
import com.example.service.CustomObjService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/api/customObject/")
public class CustomObjectController {

    @Autowired
    CustomObjService customObjService;

    @Autowired
    ColDefnService colDefObj;

    @PostMapping("insert")
    String createCustomObject(@RequestBody  Map<String,Object> dataMap){
       try {
           customObjService.add(dataMap);
           colDefObj.add(dataMap);
           colDefObj.createTableDefn(dataMap);
       }catch(Exception e){
            return HttpStatus.valueOf(500).toString();
       }
        return HttpStatus.valueOf(200).toString();
   }

    @GetMapping("/{site_id}/{custom_name}/getCustomObject")
    List<Map<String, Object>> createCustomObject(@PathVariable String site_id,@PathVariable String custom_name){
        try {
            List<Map<String, Object>> records = customObjService.getCustomObjRecords(site_id, custom_name);
              return records;
        }catch(Exception e){
            return new ArrayList<>();
        }
    }



}
