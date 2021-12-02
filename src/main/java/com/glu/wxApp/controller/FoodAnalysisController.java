package com.glu.wxApp.controller;

import com.glu.wxApp.domain.FoodAnalysis;
import com.glu.wxApp.service.FoodAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("foodAnalysis")

public class FoodAnalysisController {

    @Autowired
    private FoodAnalysisService foodAnalysisService;

    @RequestMapping("add")
    public void addFoodAnalysis(@RequestBody String foodAnalysisInfo) throws ParseException {
        foodAnalysisService.addFoodAnalysis(foodAnalysisInfo);}

    @RequestMapping("find")
    public List<FoodAnalysis> findFoodAnalysis(@RequestBody String foodAnalysisInfo) throws ParseException {return foodAnalysisService.findFoodAnalysis(foodAnalysisInfo);}

    @RequestMapping("update")
    public void updateFoodAnalysis(@RequestBody String foodAnalysisInfo) throws ParseException {
        foodAnalysisService.updateFoodAnalysis(foodAnalysisInfo);}

    @RequestMapping("delete")
    public void deleteFoodAnalysis(@RequestBody String foodAnalysisInfo) throws ParseException {
        foodAnalysisService.deleteFoodAnalysis(foodAnalysisInfo);}
}
