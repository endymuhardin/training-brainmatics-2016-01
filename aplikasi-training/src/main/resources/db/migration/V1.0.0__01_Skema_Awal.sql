create table materi (
    id VARCHAR(36),
    kode VARCHAR(10) NOT NULL,
    nama VARCHAR(255) NOT NULL,
    durasi INT NOT NULL,
    CONSTRAINT `pk_materi` PRIMARY KEY (`id`),
    CONSTRAINT `uk_kode` UNIQUE(`kode`)
) Engine=InnoDB ;

create table institusi (
    id VARCHAR(36),
    kode VARCHAR(10) NOT NULL,
    nama VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    CONSTRAINT `pk_institusi` PRIMARY KEY (`id`),
    CONSTRAINT `uk_kode` UNIQUE(`kode`),
    CONSTRAINT `uk_email` UNIQUE(`email`)
) Engine=InnoDB ;

create table peserta (
    id VARCHAR(36),
    id_institusi VARCHAR(36),
    nama VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    no_hp VARCHAR(255) NOT NULL,
    CONSTRAINT `pk_peserta` PRIMARY KEY (`id`),
    CONSTRAINT `uk_email` UNIQUE(`email`),
    CONSTRAINT `fk_institusi` FOREIGN KEY (`id_institusi`) 
        REFERENCES institusi(`id`)
) Engine=InnoDB ;

create table kelas (
    id VARCHAR(36),
    kode VARCHAR(10) NOT NULL,
    nama VARCHAR(255) NOT NULL,
    tanggal_mulai DATE NOT NULL,
    tanggal_selesai DATE NOT NULL,
    CONSTRAINT `pk_kelas` PRIMARY KEY (`id`),
    CONSTRAINT `uk_kode` UNIQUE(`kode`)
) Engine=InnoDB ;

create table kelas_detail_materi (
    id VARCHAR(36),
    id_kelas VARCHAR(36) NOT NULL,
    id_materi VARCHAR(36) NOT NULL,
    urutan INT NOT NULL,
    CONSTRAINT `pk_kelas_detail_materi` PRIMARY KEY (`id`),
    CONSTRAINT `uk_urutan_materi` UNIQUE(`urutan`),
    CONSTRAINT `uk_materi_kelas` UNIQUE(`id_kelas`, `id_materi`),
    CONSTRAINT `fk_materi` FOREIGN KEY (`id_materi`) 
        REFERENCES materi(`id`),
    CONSTRAINT `fk_kelas_detail_materi` FOREIGN KEY (`id_kelas`) 
        REFERENCES kelas(`id`)
) Engine=InnoDB ;

create table kelas_detail_peserta (
    id VARCHAR(36),
    id_kelas VARCHAR(36) NOT NULL,
    id_peserta VARCHAR(36) NOT NULL,
    CONSTRAINT `pk_kelas_detail_peserta` PRIMARY KEY (`id`),
    CONSTRAINT `uk_peserta_kelas` UNIQUE(`id_kelas`, `id_peserta`),
    CONSTRAINT `fk_peserta_kelas` FOREIGN KEY (`id_peserta`) 
        REFERENCES peserta(`id`),
    CONSTRAINT `fk_kelas_detail_peserta` FOREIGN KEY (`id_kelas`) 
        REFERENCES kelas(`id`)
) Engine=InnoDB ;