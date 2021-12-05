package com.glu.wxApp.service;

import com.glu.wxApp.domain.GluPlan;
import com.glu.wxApp.mapper.GluPlanMapper;
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

public class GluPlanService {

    @Autowired
    private GluPlanMapper gluPlanMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addGluPlan(String gluPlanInfo){
        GluPlan gluPlan = parseFunction.parseToGluPlan(gluPlanInfo, true);
        gluPlanMapper.addGluPlan(gluPlan);
    }

    public List<GluPlan> findGluPlan(String gluPlanInfo){
        GluPlan gluPlan = parseFunction.parseToGluPlan(gluPlanInfo, false);
        return gluPlanMapper.findGluPlan(gluPlan);
    }

    public void updateGluPlan(String gluPlanInfo){
        JSONObject gluPlanInfoJ = JSON.parseObject(gluPlanInfo);

        GluPlan gluPlanOld = parseFunction.parseToGluPlan(String.valueOf(gluPlanInfoJ.get("old")), false);
        GluPlan gluPlanNew = parseFunction.parseToGluPlan(String.valueOf(gluPlanInfoJ.get("new")), true);
        gluPlanMapper.updateGluPlan(gluPlanOld, gluPlanNew);
    }

    public void deleteGluPlan(String gluPlanInfo){
        GluPlan gluPlan = parseFunction.parseToGluPlan(gluPlanInfo, false);
        gluPlanMapper.deleteGluPlan(gluPlan);
    }
}
