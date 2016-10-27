package com.braimatics.training.controller;

import com.braimatics.training.dao.InstitusiDao;
import com.braimatics.training.dao.PesertaDao;
import com.braimatics.training.entity.Institusi;
import com.braimatics.training.entity.Peserta;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/peserta")
public class PesertaController {
    
    @Autowired private PesertaDao pd;
    @Autowired private InstitusiDao id;
    
    @RequestMapping("list")
    public void daftarMateri(ModelMap mm, Pageable page){
        Page<Peserta> data = pd.findAll(page);
        mm.addAttribute("daftarPeserta", data);
    }
    
    @RequestMapping("view")
    public void detailMateri(){}
    
    @ModelAttribute("daftarInstitusi")
    public Iterable<Institusi> daftarInstitusi(){
        return id.findAll();
    }
    
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public void tampilkanForm(
            @RequestParam(required = false, name = "id") Peserta peserta, 
            ModelMap mm){
        if(peserta != null){
            mm.addAttribute("peserta", peserta);
        } else {
            mm.addAttribute("peserta", new Peserta());
        }
    }
    
    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String prosesForm(@ModelAttribute @Valid Peserta p, BindingResult hasilValidasi){
        if(hasilValidasi.hasErrors()){
            return "/peserta/form";
        }
        pd.save(p);
        return "redirect:list";
    }
}
