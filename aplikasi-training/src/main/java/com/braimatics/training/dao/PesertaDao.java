package com.braimatics.training.dao;

import com.braimatics.training.entity.Peserta;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PesertaDao extends PagingAndSortingRepository<Peserta, String>{
    
}
