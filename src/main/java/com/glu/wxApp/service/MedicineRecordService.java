package com.glu.wxApp.service;

import com.glu.wxApp.domain.MedicineRecord;
import com.glu.wxApp.mapper.MedicineRecordMapper;
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

public class MedicineRecordService {

    @Autowired
    private MedicineRecordMapper medicineRecordMapper;

    private final ParseFunction parseFunction = new ParseFunction();

    public void addMedicineRecord(String medicineRecordInfo) throws ParseException {
        MedicineRecord medicineRecord = parseFunction.parseToMedicineRecord(medicineRecordInfo, true);
        medicineRecordMapper.addMedicineRecord(medicineRecord);
    }

    public List<MedicineRecord> findMedicineRecord(String medicineRecordInfo) throws ParseException {
        MedicineRecord medicineRecord = parseFunction.parseToMedicineRecord(medicineRecordInfo, false);
        return medicineRecordMapper.findMedicineRecord(medicineRecord);
    }

    public void updateMedicineRecord(String medicineRecordInfo) throws ParseException {
        JSONObject medicineRecordInfoJ = JSON.parseObject(medicineRecordInfo);

        MedicineRecord medicineRecordOld = parseFunction.parseToMedicineRecord(String.valueOf(medicineRecordInfoJ.get("old")), false);
        MedicineRecord medicineRecordNew = parseFunction.parseToMedicineRecord(String.valueOf(medicineRecordInfoJ.get("new")), true);
        medicineRecordMapper.updateMedicineRecord(medicineRecordOld, medicineRecordNew);
    }

    public void deleteMedicineRecord(String medicineRecordInfo) throws ParseException {
        MedicineRecord medicineRecord = parseFunction.parseToMedicineRecord(medicineRecordInfo, false);
        medicineRecordMapper.deleteMedicineRecord(medicineRecord);
    }
}
