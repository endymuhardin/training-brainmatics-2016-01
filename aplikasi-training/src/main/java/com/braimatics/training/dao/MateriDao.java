package com.braimatics.training.dao;

import com.braimatics.training.entity.Materi;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MateriDao extends PagingAndSortingRepository<Materi, String> {
    public Materi findByKode(String kode);
}
