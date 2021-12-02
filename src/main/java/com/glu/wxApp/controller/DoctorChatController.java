package com.glu.wxApp.controller;

import com.glu.wxApp.domain.DoctorChat;
import com.glu.wxApp.service.DoctorChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("doctorChat")

public class DoctorChatController {

    @Autowired
    private DoctorChatService doctorChatService;

    @RequestMapping("add")
    public void addDoctorChat(@RequestBody String doctorChatInfo) throws ParseException {
        doctorChatService.addDoctorChat(doctorChatInfo);}

    @RequestMapping("find")
    public List<DoctorChat> findDoctorChat(@RequestBody String doctorChatInfo) throws ParseException {return doctorChatService.findDoctorChat(doctorChatInfo);}

    @RequestMapping("update")
    public void updateDoctorChat(@RequestBody String doctorChatInfo) throws ParseException {
        doctorChatService.updateDoctorChat(doctorChatInfo);}

    @RequestMapping("delete")
    public void deleteDoctorChat(@RequestBody String doctorChatInfo) throws ParseException {
        doctorChatService.deleteDoctorChat(doctorChatInfo);}
}
