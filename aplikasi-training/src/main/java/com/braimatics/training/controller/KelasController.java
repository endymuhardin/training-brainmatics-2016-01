package com.braimatics.training.controller;

import com.braimatics.training.dao.KelasDao;
import com.braimatics.training.entity.Kelas;
import com.braimatics.training.entity.Materi;
import com.braimatics.training.entity.Peserta;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@SessionAttributes(names = {"daftarMateri", "daftarPeserta"})
@Controller
@RequestMapping("/kelas")
public class KelasController {
    
    @Autowired private KelasDao kd;
    
    @RequestMapping("list")
    public void daftarKelas(Pageable page, ModelMap mm){
        mm.addAttribute("daftarKelas", kd.findAll(page));
    }
    
    @RequestMapping("view")
    public void detailKelas(){}
    
    @RequestMapping(value = "form", method = RequestMethod.GET)
    public void tampilkanForm(@RequestParam(name = "id", required = false) Kelas kelas, ModelMap mm){
        if(kelas != null){
            mm.addAttribute("kelas", kelas);
            mm.addAttribute("daftarMateri", kelas.getDaftarMateri());
            mm.addAttribute("daftarPeserta", kelas.getDaftarPeserta());
        } else {
            mm.addAttribute("kelas", new Kelas());
            mm.addAttribute("daftarMateri", new ArrayList<Materi>());
            mm.addAttribute("daftarPeserta", new ArrayList<Peserta>());
        }
    }
    
    @RequestMapping(value = "form", method = RequestMethod.POST)
    public String prosesForm(){
        return "redirect:list";
    }
}
