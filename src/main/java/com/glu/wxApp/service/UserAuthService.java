package com.glu.wxApp.service;

import com.glu.wxApp.domain.UserAuth;
import com.glu.wxApp.mapper.UserAuthMapper;
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

public class UserAuthService {

    @Autowired
    private UserAuthMapper userAuthMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addUserAuth(String userAuthInfo) throws ParseException {
        UserAuth userAuth = parseFunction.parseToUserAuth(userAuthInfo, true);
        userAuthMapper.addUserAuth(userAuth);
    }

    public List<UserAuth> findUserAuth(String userAuthInfo) throws ParseException {
        UserAuth userAuth = parseFunction.parseToUserAuth(userAuthInfo, false);
        return userAuthMapper.findUserAuth(userAuth);
    }

    public void updateUserAuth(String userAuthInfo) throws ParseException {
        JSONObject userAuthInfoJ = JSON.parseObject(userAuthInfo);

        UserAuth userAuthOld = parseFunction.parseToUserAuth(String.valueOf(userAuthInfoJ.get("old")), false);
        UserAuth userAuthNew = parseFunction.parseToUserAuth(String.valueOf(userAuthInfoJ.get("new")), true);
        userAuthMapper.updateUserAuth(userAuthOld, userAuthNew);
    }

    public void deleteUserAuth(String userAuthInfo) throws ParseException {
        UserAuth userAuth = parseFunction.parseToUserAuth(userAuthInfo, false);
        userAuthMapper.deleteUserAuth(userAuth);
    }
}
