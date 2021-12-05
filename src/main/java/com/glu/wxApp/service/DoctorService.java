package com.glu.wxApp.service;

import com.glu.wxApp.domain.Doctor;
import com.glu.wxApp.mapper.DoctorMapper;
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

public class DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addDoctor(String doctorInfo){
        Doctor doctor = parseFunction.parseToDoctor(doctorInfo, true);
        doctorMapper.addDoctor(doctor);
    }

    public List<Doctor> findDoctor(String doctorInfo){
        Doctor doctor = parseFunction.parseToDoctor(doctorInfo, false);
        return doctorMapper.findDoctor(doctor);
    }

    public void updateDoctor(String doctorInfo){
        JSONObject doctorInfoJ = JSON.parseObject(doctorInfo);

        Doctor doctorOld = parseFunction.parseToDoctor(String.valueOf(doctorInfoJ.get("old")), false);
        Doctor doctorNew = parseFunction.parseToDoctor(String.valueOf(doctorInfoJ.get("new")), true);
        doctorMapper.updateDoctor(doctorOld, doctorNew);
    }

    public void deleteDoctor(String doctorInfo){
        Doctor doctor = parseFunction.parseToDoctor(doctorInfo, false);
        doctorMapper.deleteDoctor(doctor);
    }
}
