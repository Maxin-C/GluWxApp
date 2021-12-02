package com.glu.wxApp.controller;

import com.glu.wxApp.domain.Doctor;
import com.glu.wxApp.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("doctor")

public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @RequestMapping("add")
    public void addDoctor(@RequestBody String doctorInfo){doctorService.addDoctor(doctorInfo);}

    @RequestMapping("find")
    public List<Doctor> findDoctor(@RequestBody String doctorInfo){return doctorService.findDoctor(doctorInfo);}

    @RequestMapping("update")
    public void updateDoctor(@RequestBody String doctorInfo){doctorService.updateDoctor(doctorInfo);}

    @RequestMapping("delete")
    public void deleteDoctor(@RequestBody String doctorInfo){doctorService.deleteDoctor(doctorInfo);}
}
