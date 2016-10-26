package com.braimatics.training.controller;

import com.braimatics.training.dao.MateriDao;
import com.braimatics.training.entity.Materi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/materi")
public class MateriRestController {
    
    @Autowired private MateriDao md;
    
    @RequestMapping("/")
    public Page<Materi> daftarMateri(Pageable page){
        return md.findAll(page);
    }
}
