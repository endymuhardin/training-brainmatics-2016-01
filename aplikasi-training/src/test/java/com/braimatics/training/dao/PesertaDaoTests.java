package com.braimatics.training.dao;

import com.braimatics.training.entity.Institusi;
import com.braimatics.training.entity.Peserta;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(
    scripts = {"/sampledata/clean.sql", "/sampledata/institusi.sql", "/sampledata/peserta.sql"}
)
public class PesertaDaoTests {
    
    @Autowired private PesertaDao pd;
    
    @Test
    public void testCariById(){
        Assert.assertNull(pd.findOne("x001"));
        
        Peserta p = pd.findOne("p001");
        Assert.assertNotNull(p);
        Assert.assertEquals("Peserta 001", p.getNama());
        Assert.assertNotNull(p.getInstitusi());
        Assert.assertEquals("Brainmatics", p.getInstitusi().getNama());
        
        Peserta p2 = pd.findOne("p008");
        Assert.assertNotNull(p2);
        Assert.assertNull(p2.getInstitusi());
    }
    
    @Test
    public void testSimpan(){
        Peserta p = new Peserta();
        p.setNama("Test 001");
        p.setEmail("test@example.com");
        p.setNomerHandphone("08111111111");
        
        Institusi a = new Institusi();
        a.setId("av-001");
        p.setInstitusi(a);
        
        pd.save(p);
        
        // test query
        Assert.assertNotNull(p.getId());
        System.out.println("ID Peserta baru : "+p.getId());
        Peserta px = pd.findOne(p.getId());
        Assert.assertNotNull(px.getInstitusi());
        Assert.assertEquals("ArtiVisi", px.getInstitusi().getNama());
    }
}
