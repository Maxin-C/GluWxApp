package com.glu.wxApp.service;

import com.glu.wxApp.domain.FoodRecord;
import com.glu.wxApp.mapper.FoodRecordMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@EnableTransactionManagement
@Transactional(rollbackFor = Exception.class)
@MapperScan(basePackages = "com.glu.wxApp", annotationClass = Repository.class)

public class FoodRecordService {

    @Autowired
    private FoodRecordMapper foodRecordMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addFoodRecord(String foodRecordInfo) throws ParseException {
        FoodRecord foodRecord = parseFunction.parseToFoodRecord(foodRecordInfo, true);
        foodRecordMapper.addFoodRecord(foodRecord);
    }

    public List<FoodRecord> findFoodRecord(String foodRecordInfo) throws ParseException {
        FoodRecord foodRecord = parseFunction.parseToFoodRecord(foodRecordInfo, false);
        return foodRecordMapper.findFoodRecord(foodRecord);
    }

    public void updateFoodRecord(String foodRecordInfo) throws ParseException {
        JSONObject foodRecordInfoJ = JSON.parseObject(foodRecordInfo);

        FoodRecord foodRecordOld = parseFunction.parseToFoodRecord(String.valueOf(foodRecordInfoJ.get("old")), false);
        FoodRecord foodRecordNew = parseFunction.parseToFoodRecord(String.valueOf(foodRecordInfoJ.get("new")), true);
        foodRecordMapper.updateFoodRecord(foodRecordOld, foodRecordNew);
    }

    public void deleteFoodRecord(String foodRecordInfo) throws ParseException {
        FoodRecord foodRecord = parseFunction.parseToFoodRecord(foodRecordInfo, false);
        foodRecordMapper.deleteFoodRecord(foodRecord);
    }
}
