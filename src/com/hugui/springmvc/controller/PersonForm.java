package com.hugui.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.hugui.springmvc.model.Person;
import com.hugui.springmvc.service.DummyService;

@Controller 
@RequestMapping("/personForm.do") 
@SessionAttributes("person") 
public class PersonForm { 

    private final DummyService dummyService; 

    @Autowired 
    public PersonForm(DummyService dummyService) { 
        this.dummyService = dummyService; 
    } 

    @RequestMapping(method = RequestMethod.GET) 
    public String setupForm(@RequestParam("personId") int id, ModelMap model) { 
    	System.out.println("--2--");
        Person person = this.dummyService.retrievePerson(id); 
        model.addAttribute("person", person); 
        return "personForm"; 
    } 

    @RequestMapping(method = RequestMethod.POST) 
    public String processSubmit(@ModelAttribute("person") Person person, 
            BindingResult result, SessionStatus status) { 
    	System.out.println("--3--");
        this.dummyService.savePerson(person); 
        status.setComplete(); 
        return "redirect:personDisplay.do"; 
    } 
}


