package com.hugui.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hugui.springmvc.service.DummyService;

@Controller
public class PersonDisplay { 

    private final DummyService dummyService; 

    @Autowired 
    public PersonDisplay(DummyService dummyService) { 
        this.dummyService = dummyService; 
    } 

    @RequestMapping("/personDisplay.do") 
    public ModelMap defaultHandler() { 
    	System.out.println("---1-----");
        return new ModelMap("personList", this.dummyService.getDummyList()); 
    }


}


