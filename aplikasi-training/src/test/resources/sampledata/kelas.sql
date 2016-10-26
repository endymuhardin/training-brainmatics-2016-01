insert into kelas (id, kode, nama, tanggal_mulai, tanggal_selesai) values 
('k001', 'K-001', 'Kelas 001', curdate(), curdate() + interval 4 day);

insert into kelas_detail_materi (id, id_kelas, id_materi, urutan) values 
('k00101', 'k001', 'jfu001', 1),
('k00102', 'k001', 'jsi001', 2);

insert into kelas_detail_peserta (id, id_kelas, id_peserta) values
('k00101', 'k001', 'p001'),
('k00102', 'k001', 'p002'),
('k00103', 'k001', 'p003'),
('k00104', 'k001', 'p004'),
('k00105', 'k001', 'p005');