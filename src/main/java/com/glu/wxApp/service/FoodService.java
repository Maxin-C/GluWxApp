package com.glu.wxApp.service;

import com.glu.wxApp.domain.Food;
import com.glu.wxApp.mapper.FoodMapper;
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

public class FoodService {

    @Autowired
    private FoodMapper foodMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addFood(String foodInfo){
        Food food = parseFunction.parseToFood(foodInfo, true);
        foodMapper.addFood(food);
    }

    public List<Food> findFood(String foodInfo){
        Food food = parseFunction.parseToFood(foodInfo, false);
        return foodMapper.findFood(food);
    }

    public void updateFood(String foodInfo){
        JSONObject foodInfoJ = JSON.parseObject(foodInfo);

        Food foodOld = parseFunction.parseToFood(String.valueOf(foodInfoJ.get("old")), false);
        Food foodNew = parseFunction.parseToFood(String.valueOf(foodInfoJ.get("new")), true);
        foodMapper.updateFood(foodOld, foodNew);
    }

    public void deleteFood(String foodInfo){
        Food food = parseFunction.parseToFood(foodInfo, false);
        foodMapper.deleteFood(food);
    }
}
