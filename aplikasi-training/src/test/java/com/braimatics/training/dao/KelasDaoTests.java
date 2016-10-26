package com.braimatics.training.dao;

import com.braimatics.training.entity.Kelas;
import com.braimatics.training.entity.Materi;
import com.braimatics.training.entity.Peserta;
import java.time.LocalDate;
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
    
    @Test 
    @Transactional
    public void testKelasBaru(){
        Kelas k = new Kelas();
        k.setKode("K-002");
        k.setNama("Kelas 002");
        k.setTanggalMulai(LocalDate.now());
        k.setTanggalSelesai(LocalDate.now().plusDays(4));
        
        kd.save(k);
        Assert.assertNotNull(k.getId());
        
        // menambah materi
        Materi m1 = new Materi();
        // idnya sudah tahu, langsung set aja gak perlu query dari db
        m1.setId("jfu001"); 
        k.getDaftarMateri().add(m1);
        
        Materi m2 = new Materi();
        m2.setId("jsi001");
        k.getDaftarMateri().add(m2);
        
        // tambah peserta
        Peserta p = new Peserta();
        p.setId("p001");
        k.getDaftarPeserta().add(p);
        
        kd.save(k);
        
        Kelas kx = kd.findOne(k.getId());
        Assert.assertTrue(2 == kx.getDaftarMateri().size());
        Assert.assertTrue(1 == kx.getDaftarPeserta().size());
           
    }
}
