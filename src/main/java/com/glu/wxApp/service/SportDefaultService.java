package com.glu.wxApp.service;

import com.glu.wxApp.domain.SportDefault;
import com.glu.wxApp.mapper.SportDefaultMapper;
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

public class SportDefaultService {

    @Autowired
    private SportDefaultMapper sportDefaultMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addSportDefault(String sportDefaultInfo){
        SportDefault sportDefault = parseFunction.parseToSportDefault(sportDefaultInfo, true);
        sportDefaultMapper.addSportDefault(sportDefault);
    }

    public List<SportDefault> findSportDefault(String sportDefaultInfo){
        SportDefault sportDefault = parseFunction.parseToSportDefault(sportDefaultInfo, false);
        return sportDefaultMapper.findSportDefault(sportDefault);
    }

    public void updateSportDefault(String sportDefaultInfo){
        JSONObject sportDefaultInfoJ = JSON.parseObject(sportDefaultInfo);

        SportDefault sportDefaultOld = parseFunction.parseToSportDefault(String.valueOf(sportDefaultInfoJ.get("old")), false);
        SportDefault sportDefaultNew = parseFunction.parseToSportDefault(String.valueOf(sportDefaultInfoJ.get("new")), true);
        sportDefaultMapper.updateSportDefault(sportDefaultOld, sportDefaultNew);
    }

    public void deleteSportDefault(String sportDefaultInfo){
        SportDefault sportDefault = parseFunction.parseToSportDefault(sportDefaultInfo, false);
        sportDefaultMapper.deleteSportDefault(sportDefault);
    }
}
