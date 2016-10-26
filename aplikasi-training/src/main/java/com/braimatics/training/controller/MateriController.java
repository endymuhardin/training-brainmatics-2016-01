package com.braimatics.training.controller;

import com.braimatics.training.dao.MateriDao;
import com.braimatics.training.entity.Materi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public ModelMap tampilkanForm(@RequestParam(required = false) String id){
        ModelMap mm = new ModelMap();
        
        mm.addAttribute("materi", new Materi());
        
        if(StringUtils.hasText(id)){
            Materi m = md.findOne(id);
            if(m != null){
                mm.addAttribute("materi", m);
            }
        }
        
        return mm;
    }
    
    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute Materi m){
        md.save(m);
        return "redirect:list";
    }
}
