package com.glu.wxApp.service;

import com.glu.wxApp.domain.FoodDetail;
import com.glu.wxApp.mapper.FoodDetailMapper;
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

public class FoodDetailService {

    @Autowired
    private FoodDetailMapper foodDetailMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addFoodDetail(String foodDetailInfo){
        FoodDetail foodDetail = parseFunction.parseToFoodDetail(foodDetailInfo, true);
        foodDetailMapper.addFoodDetail(foodDetail);
    }

    public List<FoodDetail> findFoodDetail(String foodDetailInfo){
        FoodDetail foodDetail = parseFunction.parseToFoodDetail(foodDetailInfo, false);
        return foodDetailMapper.findFoodDetail(foodDetail);
    }

    public void updateFoodDetail(String foodDetailInfo){
        JSONObject foodDetailInfoJ = JSON.parseObject(foodDetailInfo);

        FoodDetail foodDetailOld = parseFunction.parseToFoodDetail(String.valueOf(foodDetailInfoJ.get("old")), false);
        FoodDetail foodDetailNew = parseFunction.parseToFoodDetail(String.valueOf(foodDetailInfoJ.get("new")), true);
        foodDetailMapper.updateFoodDetail(foodDetailOld, foodDetailNew);
    }

    public void deleteFoodDetail(String foodDetailInfo){
        FoodDetail foodDetail = parseFunction.parseToFoodDetail(foodDetailInfo, false);
        foodDetailMapper.deleteFoodDetail(foodDetail);
    }
}
