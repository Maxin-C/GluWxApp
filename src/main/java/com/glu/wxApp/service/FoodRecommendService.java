package com.glu.wxApp.service;

import com.glu.wxApp.domain.FoodRecommend;
import com.glu.wxApp.mapper.FoodRecommendMapper;
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

public class FoodRecommendService {

    @Autowired
    private FoodRecommendMapper foodRecommendMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addFoodRecommend(String foodRecommendInfo){
        FoodRecommend foodRecommend = parseFunction.parseToFoodRecommend(foodRecommendInfo, true);
        foodRecommendMapper.addFoodRecommend(foodRecommend);
    }

    public List<FoodRecommend> findFoodRecommend(String foodRecommendInfo){
        FoodRecommend foodRecommend = parseFunction.parseToFoodRecommend(foodRecommendInfo, false);
        return foodRecommendMapper.findFoodRecommend(foodRecommend);
    }

    public void updateFoodRecommend(String foodRecommendInfo){
        JSONObject foodRecommendInfoJ = JSON.parseObject(foodRecommendInfo);

        FoodRecommend foodRecommendOld = parseFunction.parseToFoodRecommend(String.valueOf(foodRecommendInfoJ.get("old")), false);
        FoodRecommend foodRecommendNew = parseFunction.parseToFoodRecommend(String.valueOf(foodRecommendInfoJ.get("new")), true);
        foodRecommendMapper.updateFoodRecommend(foodRecommendOld, foodRecommendNew);
    }

    public void deleteFoodRecommend(String foodRecommendInfo){
        FoodRecommend foodRecommend = parseFunction.parseToFoodRecommend(foodRecommendInfo, false);
        foodRecommendMapper.deleteFoodRecommend(foodRecommend);
    }
}
