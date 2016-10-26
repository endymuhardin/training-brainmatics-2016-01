package com.braimatics.training.dao;

import com.braimatics.training.entity.Kelas;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface KelasDao extends PagingAndSortingRepository<Kelas, String>{
    
}
