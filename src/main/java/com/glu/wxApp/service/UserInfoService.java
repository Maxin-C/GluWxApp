package com.glu.wxApp.service;

import com.glu.wxApp.domain.UserInfo;
import com.glu.wxApp.mapper.UserInfoMapper;
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

public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addUserInfo(String userInfoInfo) throws ParseException {
        UserInfo userInfo = parseFunction.parseToUserInfo(userInfoInfo, true);
        userInfoMapper.addUserInfo(userInfo);
    }

    public List<UserInfo> findUserInfo(String userInfoInfo) throws ParseException {
        UserInfo userInfo = parseFunction.parseToUserInfo(userInfoInfo, false);
        return userInfoMapper.findUserInfo(userInfo);
    }

    public void updateUserInfo(String userInfoInfo) throws ParseException {
        JSONObject userInfoInfoJ = JSON.parseObject(userInfoInfo);

        UserInfo userInfoOld = parseFunction.parseToUserInfo(String.valueOf(userInfoInfoJ.get("old")), false);
        UserInfo userInfoNew = parseFunction.parseToUserInfo(String.valueOf(userInfoInfoJ.get("new")), true);
        userInfoMapper.updateUserInfo(userInfoOld, userInfoNew);
    }

    public void deleteUserInfo(String userInfoInfo) throws ParseException {
        UserInfo userInfo = parseFunction.parseToUserInfo(userInfoInfo, false);
        userInfoMapper.deleteUserInfo(userInfo);
    }
}
