create table s_user (
    id VARCHAR(36),
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN,
    PRIMARY KEY (id),
    UNIQUE(username)
) ;

create table s_group (
    id VARCHAR(36),
    nama VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(nama)
) ;

create table s_permission (
    id VARCHAR(36),
    nama VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE(nama)
) ;

create table s_user_group (
    id_user VARCHAR(36),
    id_group VARCHAR(36),
    PRIMARY KEY (id_user,id_group),
    FOREIGN KEY (id_user) 
        REFERENCES s_user(id),
    FOREIGN KEY (id_group) 
        REFERENCES s_group(id)
) ;

create table s_group_permission (
    id_group VARCHAR(36),
    id_permission VARCHAR(36),
    PRIMARY KEY (id_group,id_permission),
    FOREIGN KEY (id_permission) 
        REFERENCES s_permission(id),
    FOREIGN KEY (id_group) 
        REFERENCES s_group(id)
) ;