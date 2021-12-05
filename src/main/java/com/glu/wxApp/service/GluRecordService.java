package com.glu.wxApp.service;

import com.glu.wxApp.domain.GluRecord;
import com.glu.wxApp.mapper.GluRecordMapper;
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

public class GluRecordService {

    @Autowired
    private GluRecordMapper gluRecordMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addGluRecord(String gluRecordInfo) throws ParseException {
        GluRecord gluRecord = parseFunction.parseToGluRecord(gluRecordInfo, true);
        gluRecordMapper.addGluRecord(gluRecord);
    }

    public List<GluRecord> findGluRecord(String gluRecordInfo) throws ParseException {
        GluRecord gluRecord = parseFunction.parseToGluRecord(gluRecordInfo, false);
        return gluRecordMapper.findGluRecord(gluRecord);
    }

    public void updateGluRecord(String gluRecordInfo) throws ParseException {
        JSONObject gluRecordInfoJ = JSON.parseObject(gluRecordInfo);

        GluRecord gluRecordOld = parseFunction.parseToGluRecord(String.valueOf(gluRecordInfoJ.get("old")), false);
        GluRecord gluRecordNew = parseFunction.parseToGluRecord(String.valueOf(gluRecordInfoJ.get("new")), true);
        gluRecordMapper.updateGluRecord(gluRecordOld, gluRecordNew);
    }

    public void deleteGluRecord(String gluRecordInfo) throws ParseException {
        GluRecord gluRecord = parseFunction.parseToGluRecord(gluRecordInfo, false);
        gluRecordMapper.deleteGluRecord(gluRecord);
    }
}
