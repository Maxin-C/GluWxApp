package com.glu.wxApp.controller;

import com.glu.wxApp.domain.GluPlan;
import com.glu.wxApp.service.GluPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("gluPlan")

public class GluPlanController {

    @Autowired
    private GluPlanService gluPlanService;

    @RequestMapping("add")
    public void addGluPlan(@RequestBody String gluPlanInfo){
        gluPlanService.addGluPlan(gluPlanInfo);}

    @RequestMapping("find")
    public List<GluPlan> findGluPlan(@RequestBody String gluPlanInfo){return gluPlanService.findGluPlan(gluPlanInfo);}

    @RequestMapping("update")
    public void updateGluPlan(@RequestBody String gluPlanInfo){
        gluPlanService.updateGluPlan(gluPlanInfo);}

    @RequestMapping("delete")
    public void deleteGluPlan(@RequestBody String gluPlanInfo){
        gluPlanService.deleteGluPlan(gluPlanInfo);}
}
