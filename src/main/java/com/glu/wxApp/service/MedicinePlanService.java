package com.glu.wxApp.service;

import com.glu.wxApp.domain.MedicinePlan;
import com.glu.wxApp.mapper.MedicinePlanMapper;
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

public class MedicinePlanService {

    @Autowired
    private MedicinePlanMapper medicinePlanMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addMedicinePlan(String medicinePlanInfo){
        MedicinePlan medicinePlan = parseFunction.parseToMedicinePlan(medicinePlanInfo, true);
        medicinePlanMapper.addMedicinePlan(medicinePlan);
    }

    public List<MedicinePlan> findMedicinePlan(String medicinePlanInfo){
        MedicinePlan medicinePlan = parseFunction.parseToMedicinePlan(medicinePlanInfo, false);
        return medicinePlanMapper.findMedicinePlan(medicinePlan);
    }

    public void updateMedicinePlan(String medicinePlanInfo){
        JSONObject medicinePlanInfoJ = JSON.parseObject(medicinePlanInfo);

        MedicinePlan medicinePlanOld = parseFunction.parseToMedicinePlan(String.valueOf(medicinePlanInfoJ.get("old")), false);
        MedicinePlan medicinePlanNew = parseFunction.parseToMedicinePlan(String.valueOf(medicinePlanInfoJ.get("new")), true);
        medicinePlanMapper.updateMedicinePlan(medicinePlanOld, medicinePlanNew);
    }

    public void deleteMedicinePlan(String medicinePlanInfo){
        MedicinePlan medicinePlan = parseFunction.parseToMedicinePlan(medicinePlanInfo, false);
        medicinePlanMapper.deleteMedicinePlan(medicinePlan);
    }
}
