package com.glu.wxApp.controller;

import com.glu.wxApp.domain.FoodDetail;
import com.glu.wxApp.service.FoodDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("foodDetail")

public class FoodDetailController {

    @Autowired
    private FoodDetailService foodDetailService;

    @RequestMapping("add")
    public void addFoodDetail(@RequestBody String foodDetailInfo){
        foodDetailService.addFoodDetail(foodDetailInfo);}

    @RequestMapping("find")
    public List<FoodDetail> findFoodDetail(@RequestBody String foodDetailInfo){return foodDetailService.findFoodDetail(foodDetailInfo);}

    @RequestMapping("update")
    public void updateFoodDetail(@RequestBody String foodDetailInfo){
        foodDetailService.updateFoodDetail(foodDetailInfo);}

    @RequestMapping("delete")
    public void deleteFoodDetail(@RequestBody String foodDetailInfo){
        foodDetailService.deleteFoodDetail(foodDetailInfo);}
}
