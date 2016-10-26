package com.braimatics.training.controller;

import com.braimatics.training.dao.MateriDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/materi")
public class MateriController {
    
    @Autowired private MateriDao md;
    
    @RequestMapping("list")
    public ModelMap daftarMateri(Pageable page){
        ModelMap mm = new ModelMap();
        
        mm.addAttribute("daftarMateri", md.findAll(page));
        
        return mm;
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
