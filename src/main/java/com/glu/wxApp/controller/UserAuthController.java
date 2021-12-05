package com.glu.wxApp.controller;

import com.glu.wxApp.domain.UserAuth;
import com.glu.wxApp.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("userAuth")

public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    @RequestMapping("add")
    public void addUserAuth(@RequestBody String userAuthInfo) throws ParseException {
        userAuthService.addUserAuth(userAuthInfo);}

    @RequestMapping("find")
    public List<UserAuth> findUserAuth(@RequestBody String userAuthInfo) throws ParseException {return userAuthService.findUserAuth(userAuthInfo);}

    @RequestMapping("update")
    public void updateUserAuth(@RequestBody String userAuthInfo) throws ParseException {
        userAuthService.updateUserAuth(userAuthInfo);}

    @RequestMapping("delete")
    public void deleteUserAuth(@RequestBody String userAuthInfo) throws ParseException {
        userAuthService.deleteUserAuth(userAuthInfo);}

    @RequestMapping("addReturnId")
    public List<UserAuth> addReturnId(@RequestBody String userAuthInfo) throws ParseException {
        userAuthService.addUserAuth(userAuthInfo);
        return userAuthService.findUserAuth(userAuthInfo);}
}
