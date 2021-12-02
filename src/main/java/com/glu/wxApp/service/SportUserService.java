package com.glu.wxApp.service;

import com.glu.wxApp.domain.SportUser;
import com.glu.wxApp.mapper.SportUserMapper;
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

public class SportUserService {

    @Autowired
    private SportUserMapper sportUserMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addSportUser(String sportUserInfo){
        SportUser sportUser = parseFunction.parseToSportUser(sportUserInfo, true);
        sportUserMapper.addSportUser(sportUser);
    }

    public List<SportUser> findSportUser(String sportUserInfo){
        SportUser sportUser = parseFunction.parseToSportUser(sportUserInfo, false);
        return sportUserMapper.findSportUser(sportUser);
    }

    public void updateSportUser(String sportUserInfo){
        JSONObject sportUserInfoJ = JSON.parseObject(sportUserInfo);

        SportUser sportUserOld = parseFunction.parseToSportUser(String.valueOf(sportUserInfoJ.get("old")), false);
        SportUser sportUserNew = parseFunction.parseToSportUser(String.valueOf(sportUserInfoJ.get("new")), true);
        sportUserMapper.updateSportUser(sportUserOld, sportUserNew);
    }

    public void deleteSportUser(String sportUserInfo){
        SportUser sportUser = parseFunction.parseToSportUser(sportUserInfo, false);
        sportUserMapper.deleteSportUser(sportUser);
    }
}
