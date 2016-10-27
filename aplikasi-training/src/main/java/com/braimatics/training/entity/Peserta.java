package com.braimatics.training.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Peserta {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(nullable = false)
    @NotNull @NotEmpty @Size(min = 3, max = 255)
    private String nama;
    
    @Column(nullable = false, unique = true)
    @NotNull @NotEmpty @Email
    private String email;
    
    @Column(name = "no_hp", nullable = false)
    @NotNull @NotEmpty
    private String nomerHandphone;
    
    @ManyToOne
    @JoinColumn(name = "id_institusi")
    private Institusi institusi;
    
    @ManyToMany(mappedBy = "daftarPeserta")
    private List<Kelas> daftarKelas = new ArrayList<>();

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

    public List<Kelas> getDaftarKelas() {
        return daftarKelas;
    }

    public void setDaftarKelas(List<Kelas> daftarKelas) {
        this.daftarKelas = daftarKelas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nama);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.nomerHandphone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Peserta other = (Peserta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nomerHandphone, other.nomerHandphone)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
