package com.glu.wxApp.service;

import com.glu.wxApp.domain.DoctorUser;
import com.glu.wxApp.mapper.DoctorUserMapper;
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

public class DoctorUserService {

    @Autowired
    private DoctorUserMapper doctorUserMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addDoctorUser(String doctorUserInfo){
        DoctorUser doctorUser = parseFunction.parseToDoctorUser(doctorUserInfo, true);
        doctorUserMapper.addDoctorUser(doctorUser);
    }

    public List<DoctorUser> findDoctorUser(String doctorUserInfo){
        DoctorUser doctorUser = parseFunction.parseToDoctorUser(doctorUserInfo, false);
        return doctorUserMapper.findDoctorUser(doctorUser);
    }

    public void updateDoctorUser(String doctorUserInfo){
        JSONObject doctorUserInfoJ = JSON.parseObject(doctorUserInfo);

        DoctorUser doctorUserOld = parseFunction.parseToDoctorUser(String.valueOf(doctorUserInfoJ.get("old")), false);
        DoctorUser doctorUserNew = parseFunction.parseToDoctorUser(String.valueOf(doctorUserInfoJ.get("new")), true);
        doctorUserMapper.updateDoctorUser(doctorUserOld, doctorUserNew);
    }

    public void deleteDoctorUser(String doctorUserInfo){
        DoctorUser doctorUser = parseFunction.parseToDoctorUser(doctorUserInfo, false);
        doctorUserMapper.deleteDoctorUser(doctorUser);
    }
}
