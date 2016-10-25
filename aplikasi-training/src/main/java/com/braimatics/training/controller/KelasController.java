package com.braimatics.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/kelas")
public class KelasController {
    
    @RequestMapping("list")
    public void daftarMateri(){}
    
    @RequestMapping("view")
    public void detailMateri(){}
    
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public void tampilkanForm(){}
    
    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String prosesForm(){
        return "redirect:list";
    }
}
