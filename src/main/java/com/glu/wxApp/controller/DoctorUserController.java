package com.glu.wxApp.controller;

import com.glu.wxApp.domain.DoctorUser;
import com.glu.wxApp.service.DoctorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("doctorUser")

public class DoctorUserController {

    @Autowired
    private DoctorUserService doctorUserService;

    @RequestMapping("add")
    public void addDoctorUser(@RequestBody String doctorUserInfo){
        doctorUserService.addDoctorUser(doctorUserInfo);}

    @RequestMapping("find")
    public List<DoctorUser> findDoctorUser(@RequestBody String doctorUserInfo){return doctorUserService.findDoctorUser(doctorUserInfo);}

    @RequestMapping("update")
    public void updateDoctorUser(@RequestBody String doctorUserInfo){
        doctorUserService.updateDoctorUser(doctorUserInfo);}

    @RequestMapping("delete")
    public void deleteDoctorUser(@RequestBody String doctorUserInfo){
        doctorUserService.deleteDoctorUser(doctorUserInfo);}
}
