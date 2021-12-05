package com.glu.wxApp.controller;

import com.glu.wxApp.domain.SportUser;
import com.glu.wxApp.service.SportUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sportUser")

public class SportUserController {

    @Autowired
    private SportUserService sportUserService;

    @RequestMapping("add")
    public void addSportUser(@RequestBody String sportUserInfo){
        sportUserService.addSportUser(sportUserInfo);}

    @RequestMapping("find")
    public List<SportUser> findSportUser(@RequestBody String sportUserInfo){return sportUserService.findSportUser(sportUserInfo);}

    @RequestMapping("update")
    public void updateSportUser(@RequestBody String sportUserInfo){
        sportUserService.updateSportUser(sportUserInfo);}

    @RequestMapping("delete")
    public void deleteSportUser(@RequestBody String sportUserInfo){
        sportUserService.deleteSportUser(sportUserInfo);}
}
