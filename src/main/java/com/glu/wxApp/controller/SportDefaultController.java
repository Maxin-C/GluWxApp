package com.glu.wxApp.controller;

import com.glu.wxApp.domain.SportDefault;
import com.glu.wxApp.service.SportDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sportDefault")

public class SportDefaultController {

    @Autowired
    private SportDefaultService sportDefaultService;

    @RequestMapping("add")
    public void addSportDefault(@RequestBody String sportDefaultInfo){
        sportDefaultService.addSportDefault(sportDefaultInfo);}

    @RequestMapping("find")
    public List<SportDefault> findSportDefault(@RequestBody String sportDefaultInfo){return sportDefaultService.findSportDefault(sportDefaultInfo);}

    @RequestMapping("update")
    public void updateSportDefault(@RequestBody String sportDefaultInfo){
        sportDefaultService.updateSportDefault(sportDefaultInfo);}

    @RequestMapping("delete")
    public void deleteSportDefault(@RequestBody String sportDefaultInfo){
        sportDefaultService.deleteSportDefault(sportDefaultInfo);}
}
