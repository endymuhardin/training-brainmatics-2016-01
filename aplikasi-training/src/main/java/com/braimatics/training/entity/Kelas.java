package com.braimatics.training.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Kelas {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(unique = true, nullable = false)
    private String kode;
    
    @Column(nullable = false)
    private String nama;
    
    @Column(name = "tanggal_mulai", nullable = false)
    private LocalDate tanggalMulai;
    
    @Column(name = "tanggal_selesai", nullable = false)
    private LocalDate tanggalSelesai;
    
    @ManyToMany
    @JoinTable(
            name = "kelas_detail_peserta",
            joinColumns = @JoinColumn(name = "id_kelas"),
            inverseJoinColumns = @JoinColumn(name = "id_peserta")
    )
    private List<Peserta> daftarPeserta = new ArrayList<>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "kelas_detail_materi",
            joinColumns = @JoinColumn(name = "id_kelas"),
            inverseJoinColumns = @JoinColumn(name = "id_materi")
    )
    private List<Materi> daftarMateri = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public LocalDate getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(LocalDate tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public LocalDate getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(LocalDate tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    public List<Peserta> getDaftarPeserta() {
        return daftarPeserta;
    }

    public void setDaftarPeserta(List<Peserta> daftarPeserta) {
        this.daftarPeserta = daftarPeserta;
    }

    public List<Materi> getDaftarMateri() {
        return daftarMateri;
    }

    public void setDaftarMateri(List<Materi> daftarMateri) {
        this.daftarMateri = daftarMateri;
    }
    
    
}
