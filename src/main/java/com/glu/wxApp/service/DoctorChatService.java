package com.glu.wxApp.service;

import com.glu.wxApp.domain.DoctorChat;
import com.glu.wxApp.mapper.DoctorChatMapper;
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

public class DoctorChatService {

    @Autowired
    private DoctorChatMapper doctorChatMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addDoctorChat(String doctorChatInfo) throws ParseException {
        DoctorChat doctorChat = parseFunction.parseToDoctorChat(doctorChatInfo, true);
        doctorChatMapper.addDoctorChat(doctorChat);
    }

    public List<DoctorChat> findDoctorChat(String doctorChatInfo) throws ParseException {
        DoctorChat doctorChat = parseFunction.parseToDoctorChat(doctorChatInfo, false);
        return doctorChatMapper.findDoctorChat(doctorChat);
    }

    public void updateDoctorChat(String doctorChatInfo) throws ParseException {
        JSONObject doctorChatInfoJ = JSON.parseObject(doctorChatInfo);

        DoctorChat doctorChatOld = parseFunction.parseToDoctorChat(String.valueOf(doctorChatInfoJ.get("old")), false);
        DoctorChat doctorChatNew = parseFunction.parseToDoctorChat(String.valueOf(doctorChatInfoJ.get("new")), true);
        doctorChatMapper.updateDoctorChat(doctorChatOld, doctorChatNew);
    }

    public void deleteDoctorChat(String doctorChatInfo) throws ParseException {
        DoctorChat doctorChat = parseFunction.parseToDoctorChat(doctorChatInfo, false);
        doctorChatMapper.deleteDoctorChat(doctorChat);
    }
}
