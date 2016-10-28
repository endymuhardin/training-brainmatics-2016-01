insert into s_user (id, username, password, enabled) values 
('u001', 'user001', '0001', true),
('u002', 'user002', '0002', true),
('u003', 'user003', '0003', false),
('u004', 'user004', '0004', false);

insert into s_group(id, nama) values
('g001', 'Operator'),
('g002', 'Supervisor');

insert into s_permission(id, nama) values
('p001', 'ROLE_VIEW_MATERI'),
('p002', 'ROLE_EDIT_MATERI'),
('p003', 'ROLE_VIEW_KELAS'),
('p004', 'ROLE_EDIT_KELAS');

insert into s_user_group(id_user, id_group) values
('u001', 'g001'),
('u002', 'g002');

insert into s_group_permission(id_group, id_permission) values 
('g001', 'p001'),
('g001', 'p003'),
('g002', 'p001'),
('g002', 'p002'),
('g002', 'p003'),
('g002', 'p004');