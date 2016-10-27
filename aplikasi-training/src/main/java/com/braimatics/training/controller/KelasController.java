package com.braimatics.training.controller;

import com.braimatics.training.dao.KelasDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/kelas")
public class KelasController {
    
    @Autowired private KelasDao kd;
    
    @RequestMapping("list")
    public void daftarMateri(Pageable page, ModelMap mm){
        mm.addAttribute("daftarKelas", kd.findAll(page));
    }
    
    @RequestMapping("view")
    public void detailMateri(){}
    
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public void tampilkanForm(){}
    
    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String prosesForm(){
        return "redirect:list";
    }
}
