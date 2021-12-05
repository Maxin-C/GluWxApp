package com.glu.wxApp.controller;

import com.glu.wxApp.domain.Food;
import com.glu.wxApp.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("food")

public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping("add")
    public void addFood(@RequestBody String foodInfo){
        foodService.addFood(foodInfo);}

    @RequestMapping("find")
    public List<Food> findFood(@RequestBody String foodInfo){return foodService.findFood(foodInfo);}

    @RequestMapping("update")
    public void updateFood(@RequestBody String foodInfo){
        foodService.updateFood(foodInfo);}

    @RequestMapping("delete")
    public void deleteFood(@RequestBody String foodInfo){
        foodService.deleteFood(foodInfo);}
}
