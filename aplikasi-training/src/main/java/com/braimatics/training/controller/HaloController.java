package com.braimatics.training.controller;

import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HaloController {
    
    @RequestMapping("/halo")
    public ModelMap halo(){
        ModelMap data = new ModelMap();
        Date waktu = new Date();
        data.addAttribute("sekarang", waktu);
        return data;
    }
    
    @RequestMapping(value = "/registrasi", method = RequestMethod.GET)
    public void tampilkanFormRegistrasi(@RequestParam(required = false, name = "materi") String training){
        System.out.println("Training : "+training);
    }
    
    @RequestMapping(value = "/registrasi", method = RequestMethod.POST)
    public String prosesFormRegistrasi(@RequestParam String nama, @RequestParam String email){
        System.out.println("Memproses form registrasi");
        
        System.out.println("Nama : " +nama);
        System.out.println("Email : "+email);
        
        return "redirect:registrasi";
    }
}
