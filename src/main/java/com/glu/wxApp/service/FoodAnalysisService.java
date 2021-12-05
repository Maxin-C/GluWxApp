package com.glu.wxApp.service;

import com.glu.wxApp.domain.FoodAnalysis;
import com.glu.wxApp.mapper.FoodAnalysisMapper;
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

public class FoodAnalysisService {

    @Autowired
    private FoodAnalysisMapper foodAnalysisMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addFoodAnalysis(String foodAnalysisInfo) throws ParseException {
        FoodAnalysis foodAnalysis = parseFunction.parseToFoodAnalysis(foodAnalysisInfo, true);
        foodAnalysisMapper.addFoodAnalysis(foodAnalysis);
    }

    public List<FoodAnalysis> findFoodAnalysis(String foodAnalysisInfo) throws ParseException {
        FoodAnalysis foodAnalysis = parseFunction.parseToFoodAnalysis(foodAnalysisInfo, false);
        return foodAnalysisMapper.findFoodAnalysis(foodAnalysis);
    }

    public void updateFoodAnalysis(String foodAnalysisInfo) throws ParseException {
        JSONObject foodAnalysisInfoJ = JSON.parseObject(foodAnalysisInfo);

        FoodAnalysis foodAnalysisOld = parseFunction.parseToFoodAnalysis(String.valueOf(foodAnalysisInfoJ.get("old")), false);
        FoodAnalysis foodAnalysisNew = parseFunction.parseToFoodAnalysis(String.valueOf(foodAnalysisInfoJ.get("new")), true);
        foodAnalysisMapper.updateFoodAnalysis(foodAnalysisOld, foodAnalysisNew);
    }

    public void deleteFoodAnalysis(String foodAnalysisInfo) throws ParseException {
        FoodAnalysis foodAnalysis = parseFunction.parseToFoodAnalysis(foodAnalysisInfo, false);
        foodAnalysisMapper.deleteFoodAnalysis(foodAnalysis);
    }
}
