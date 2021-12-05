package com.glu.wxApp.controller;

import com.glu.wxApp.domain.FoodRecommend;
import com.glu.wxApp.service.FoodRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("foodRecommend")

public class FoodRecommendController {

    @Autowired
    private FoodRecommendService foodRecommendService;

    @RequestMapping("add")
    public void addFoodRecommend(@RequestBody String foodRecommendInfo){
        foodRecommendService.addFoodRecommend(foodRecommendInfo);}

    @RequestMapping("find")
    public List<FoodRecommend> findFoodRecommend(@RequestBody String foodRecommendInfo){return foodRecommendService.findFoodRecommend(foodRecommendInfo);}

    @RequestMapping("update")
    public void updateFoodRecommend(@RequestBody String foodRecommendInfo){
        foodRecommendService.updateFoodRecommend(foodRecommendInfo);}

    @RequestMapping("delete")
    public void deleteFoodRecommend(@RequestBody String foodRecommendInfo){
        foodRecommendService.deleteFoodRecommend(foodRecommendInfo);}
}
