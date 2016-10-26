package com.braimatics.training.controller;

import com.braimatics.training.dao.MateriDao;
import com.braimatics.training.entity.Materi;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/materi")
public class MateriRestController {
    
    @Autowired private MateriDao md;
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public Page<Materi> daftarMateri(Pageable page){
        return md.findAll(page);
    }
    
    @RequestMapping(value="/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid Materi m){
        md.save(m);
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Materi cariById(@PathVariable String id){
        return md.findOne(id);
    }
}
