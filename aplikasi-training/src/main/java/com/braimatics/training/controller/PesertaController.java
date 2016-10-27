package com.braimatics.training.controller;

import com.braimatics.training.dao.PesertaDao;
import com.braimatics.training.entity.Peserta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/peserta")
public class PesertaController {
    
    @Autowired private PesertaDao pd;
    
    @RequestMapping("list")
    public void daftarMateri(ModelMap mm, Pageable page){
        Page<Peserta> data = pd.findAll(page);
        mm.addAttribute("daftarPeserta", data);
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
