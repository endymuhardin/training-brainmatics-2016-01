create table materi (
    id VARCHAR(36),
    kode VARCHAR(10) NOT NULL,
    nama VARCHAR(255) NOT NULL,
    durasi INT NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(kode)
) ;

create table institusi (
    id VARCHAR(36),
    kode VARCHAR(10) NOT NULL,
    nama VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(kode),
    UNIQUE(email)
) ;

create table peserta (
    id VARCHAR(36),
    id_institusi VARCHAR(36),
    nama VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    no_hp VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(email),
    FOREIGN KEY (id_institusi) 
        REFERENCES institusi(id)
) ;

create table kelas (
    id VARCHAR(36),
    kode VARCHAR(10) NOT NULL,
    nama VARCHAR(255) NOT NULL,
    tanggal_mulai DATE NOT NULL,
    tanggal_selesai DATE NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(kode)
) ;

create table kelas_detail_materi (
    id_kelas VARCHAR(36) NOT NULL,
    id_materi VARCHAR(36) NOT NULL,
    PRIMARY KEY (id_kelas, id_materi),
    UNIQUE(id_kelas, id_materi),
    FOREIGN KEY (id_materi) 
        REFERENCES materi(id),
    FOREIGN KEY (id_kelas) 
        REFERENCES kelas(id)
) ;

create table kelas_detail_peserta (
    id_kelas VARCHAR(36) NOT NULL,
    id_peserta VARCHAR(36) NOT NULL,
    PRIMARY KEY (id_kelas, id_peserta),
    UNIQUE(id_kelas, id_peserta),
    FOREIGN KEY (id_peserta) 
        REFERENCES peserta(id),
    FOREIGN KEY (id_kelas) 
        REFERENCES kelas(id)
) ;