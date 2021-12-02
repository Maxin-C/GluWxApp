package com.glu.wxApp.controller;

import com.glu.wxApp.domain.GluRecord;
import com.glu.wxApp.service.GluRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("gluRecord")

public class GluRecordController {

    @Autowired
    private GluRecordService gluRecordService;

    @RequestMapping("add")
    public void addGluRecord(@RequestBody String gluRecordInfo) throws ParseException {gluRecordService.addGluRecord(gluRecordInfo);}

    @RequestMapping("find")
    public List<GluRecord> findGluRecord(@RequestBody String gluRecordInfo) throws ParseException {return gluRecordService.findGluRecord(gluRecordInfo);}

    @RequestMapping("update")
    public void updateGluRecord(@RequestBody String gluRecordInfo) throws ParseException {gluRecordService.updateGluRecord(gluRecordInfo);}

    @RequestMapping("delete")
    public void deleteGluRecord(@RequestBody String gluRecordInfo) throws ParseException {gluRecordService.deleteGluRecord(gluRecordInfo);}
}
