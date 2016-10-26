insert into kelas (id, kode, nama, tanggal_mulai, tanggal_selesai) values 
('k001', 'K-001', 'Kelas 001', curdate(), curdate() + interval 4 day);

insert into kelas_detail_materi (id_kelas, id_materi) values 
('k001', 'jfu001'),
('k001', 'jsi001');

insert into kelas_detail_peserta (id_kelas, id_peserta) values
('k001', 'p001'),
('k001', 'p002'),
('k001', 'p003'),
('k001', 'p004'),
('k001', 'p005');