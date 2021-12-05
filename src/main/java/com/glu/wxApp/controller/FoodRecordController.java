package com.glu.wxApp.controller;

import com.glu.wxApp.domain.FoodRecord;
import com.glu.wxApp.service.FoodRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("foodRecord")

public class FoodRecordController {

    @Autowired
    private FoodRecordService foodRecordService;

    @RequestMapping("add")
    public void addFoodRecord(@RequestBody String foodRecordInfo) throws ParseException {
        foodRecordService.addFoodRecord(foodRecordInfo);}

    @RequestMapping("find")
    public List<FoodRecord> findFoodRecord(@RequestBody String foodRecordInfo) throws ParseException {return foodRecordService.findFoodRecord(foodRecordInfo);}

    @RequestMapping("update")
    public void updateFoodRecord(@RequestBody String foodRecordInfo) throws ParseException {
        foodRecordService.updateFoodRecord(foodRecordInfo);}

    @RequestMapping("delete")
    public void deleteFoodRecord(@RequestBody String foodRecordInfo) throws ParseException {
        foodRecordService.deleteFoodRecord(foodRecordInfo);}
}
