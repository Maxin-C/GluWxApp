package com.glu.wxApp.service;

import com.glu.wxApp.domain.SportItem;
import com.glu.wxApp.mapper.SportItemMapper;
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

public class SportItemService {

    @Autowired
    private SportItemMapper sportItemMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addSportItem(String sportItemInfo){
        SportItem sportItem = parseFunction.parseToSportItem(sportItemInfo, true);
        sportItemMapper.addSportItem(sportItem);
    }

    public List<SportItem> findSportItem(String sportItemInfo){
        SportItem sportItem = parseFunction.parseToSportItem(sportItemInfo, false);
        return sportItemMapper.findSportItem(sportItem);
    }

    public void updateSportItem(String sportItemInfo){
        JSONObject sportItemInfoJ = JSON.parseObject(sportItemInfo);

        SportItem sportItemOld = parseFunction.parseToSportItem(String.valueOf(sportItemInfoJ.get("old")), false);
        SportItem sportItemNew = parseFunction.parseToSportItem(String.valueOf(sportItemInfoJ.get("new")), true);
        sportItemMapper.updateSportItem(sportItemOld, sportItemNew);
    }

    public void deleteSportItem(String sportItemInfo){
        SportItem sportItem = parseFunction.parseToSportItem(sportItemInfo, false);
        sportItemMapper.deleteSportItem(sportItem);
    }
}
