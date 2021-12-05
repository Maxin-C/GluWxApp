package com.glu.wxApp.controller;

import com.glu.wxApp.domain.UserInfo;
import com.glu.wxApp.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("userInfo")

public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("add")
    public void addUserInfo(@RequestBody String userInfoInfo) throws ParseException {
        userInfoService.addUserInfo(userInfoInfo);}

    @RequestMapping("find")
    public List<UserInfo> findUserInfo(@RequestBody String userInfoInfo) throws ParseException {return userInfoService.findUserInfo(userInfoInfo);}

    @RequestMapping("update")
    public void updateUserInfo(@RequestBody String userInfoInfo) throws ParseException {
        userInfoService.updateUserInfo(userInfoInfo);}

    @RequestMapping("delete")
    public void deleteUserInfo(@RequestBody String userInfoInfo) throws ParseException {
        userInfoService.deleteUserInfo(userInfoInfo);}
}
