package com.braimatics.training.dao;

import com.braimatics.training.entity.Materi;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(
    statements = {"delete from materi where kode = 'T-001'"}
)
public class MateriDaoTests {
    @Autowired
    private MateriDao md;
    
    @Test
    public void testHitungMateri(){
        Long jumlahRecord = md.count();
        Assert.assertTrue(jumlahRecord == 2);
    }
    
    @Test
    public void testCariById(){
        Materi m = md.findOne("jfu001");
        Assert.assertNotNull(m);
        Assert.assertEquals("JFU-001", m.getKode());
        Assert.assertEquals("Java Fundamental", m.getNama());
        Assert.assertTrue(4 == m.getDurasi());
        
        Assert.assertNull(md.findOne("abc123"));
    }
    
    @Test
    public void testSimpan(){
        Materi m = new Materi();
        m.setKode("T-001");
        m.setNama("Materi Test");
        m.setDurasi(8);
        
        md.save(m);
        
        Materi mx = md.findByKode("T-001");
        Assert.assertNotNull(mx);
        
        Assert.assertNull(md.findByKode("X-001"));
    }
    
    @Test
    public void testPaging(){
        Page<Materi> hasil = md.findAll(new PageRequest(1, 1));
        Assert.assertTrue(2 == hasil.getTotalElements());
        Assert.assertTrue(2 == hasil.getTotalPages());
        Assert.assertFalse(hasil.isFirst());
        Assert.assertTrue(hasil.isLast());
    }
}
