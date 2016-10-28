package com.braimatics.training.controller;

import com.braimatics.training.dao.MateriDao;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
@RequestMapping("/report")
public class ReportController {
    
    @Autowired private MateriDao md;
    
    @RequestMapping("/materi")
    public void daftarMateri(ModelMap mm){
        mm.addAttribute("dataDalamReport", md.findAll());
        mm.addAttribute("tanggalCetak", new Date());
        mm.addAttribute("format", "pdf");
    }
}
