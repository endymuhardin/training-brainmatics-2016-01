package com.braimatics.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Peserta {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false)
    private String nama;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "no_hp", nullable = false)
    private String nomerHandphone;
    
    @ManyToOne
    @JoinColumn(name = "id_institusi")
    private Institusi institusi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomerHandphone() {
        return nomerHandphone;
    }

    public void setNomerHandphone(String nomerHandphone) {
        this.nomerHandphone = nomerHandphone;
    }

    public Institusi getInstitusi() {
        return institusi;
    }

    public void setInstitusi(Institusi institusi) {
        this.institusi = institusi;
    }
    
    
    
    
}
