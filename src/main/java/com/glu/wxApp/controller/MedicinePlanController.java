package com.glu.wxApp.controller;

import com.glu.wxApp.domain.MedicinePlan;
import com.glu.wxApp.service.MedicinePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("medicinePlan")

public class MedicinePlanController {

    @Autowired
    private MedicinePlanService medicinePlanService;

    @RequestMapping("add")
    public void addMedicinePlan(@RequestBody String medicinePlanInfo){
        medicinePlanService.addMedicinePlan(medicinePlanInfo);}

    @RequestMapping("find")
    public List<MedicinePlan> findMedicinePlan(@RequestBody String medicinePlanInfo){return medicinePlanService.findMedicinePlan(medicinePlanInfo);}

    @RequestMapping("update")
    public void updateMedicinePlan(@RequestBody String medicinePlanInfo){
        medicinePlanService.updateMedicinePlan(medicinePlanInfo);}

    @RequestMapping("delete")
    public void deleteMedicinePlan(@RequestBody String medicinePlanInfo){
        medicinePlanService.deleteMedicinePlan(medicinePlanInfo);}
}
