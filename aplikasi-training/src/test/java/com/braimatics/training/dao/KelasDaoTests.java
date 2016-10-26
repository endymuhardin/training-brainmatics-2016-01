package com.braimatics.training.dao;

import com.braimatics.training.entity.Kelas;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(
    scripts = {"/sampledata/clean.sql", "/sampledata/institusi.sql", "/sampledata/peserta.sql", "/sampledata/kelas.sql"}
)
public class KelasDaoTests {
    @Autowired private KelasDao kd;
    
    @Test
    @Transactional
    public void testCariKelasById(){
        Kelas k = kd.findOne("k001");
        Assert.assertNotNull(k);
        
        Assert.assertEquals("Kelas 001", k.getNama());
        Assert.assertTrue(2 == k.getDaftarMateri().size());
        Assert.assertTrue(5 == k.getDaftarPeserta().size());
    }
}
