package com.glu.wxApp.controller;

import com.glu.wxApp.domain.MedicineRecord;
import com.glu.wxApp.service.MedicineRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("medicineRecord")

public class MedicineRecordController {

    @Autowired
    private MedicineRecordService medicineRecordService;

    @RequestMapping("add")
    public void addMedicineRecord(@RequestBody String medicineRecordInfo) throws ParseException {
        medicineRecordService.addMedicineRecord(medicineRecordInfo);}

    @RequestMapping("find")
    public List<MedicineRecord> findMedicineRecord(@RequestBody String medicineRecordInfo) throws ParseException {return medicineRecordService.findMedicineRecord(medicineRecordInfo);}

    @RequestMapping("update")
    public void updateMedicineRecord(@RequestBody String medicineRecordInfo) throws ParseException {
        medicineRecordService.updateMedicineRecord(medicineRecordInfo);}

    @RequestMapping("delete")
    public void deleteMedicineRecord(@RequestBody String medicineRecordInfo) throws ParseException {
        medicineRecordService.deleteMedicineRecord(medicineRecordInfo);}
}
