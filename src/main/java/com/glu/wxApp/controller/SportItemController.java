package com.glu.wxApp.controller;

import com.glu.wxApp.domain.SportItem;
import com.glu.wxApp.service.SportItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sportItem")

public class SportItemController {

    @Autowired
    private SportItemService sportItemService;

    @RequestMapping("add")
    public void addSportItem(@RequestBody String sportItemInfo){
        sportItemService.addSportItem(sportItemInfo);}

    @RequestMapping("find")
    public List<SportItem> findSportItem(@RequestBody String sportItemInfo){return sportItemService.findSportItem(sportItemInfo);}

    @RequestMapping("update")
    public void updateSportItem(@RequestBody String sportItemInfo){
        sportItemService.updateSportItem(sportItemInfo);}

    @RequestMapping("delete")
    public void deleteSportItem(@RequestBody String sportItemInfo){
        sportItemService.deleteSportItem(sportItemInfo);}
}
