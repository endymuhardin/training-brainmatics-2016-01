create table s_user (
    id VARCHAR(36),
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN,
    CONSTRAINT `pk_user` PRIMARY KEY (`id`),
    CONSTRAINT `uk_username` UNIQUE(`username`)
) Engine=InnoDB ;

create table s_group (
    id VARCHAR(36),
    nama VARCHAR(255) NOT NULL,
    CONSTRAINT `pk_group` PRIMARY KEY (`id`),
    CONSTRAINT `uk_nama` UNIQUE(`nama`)
) Engine=InnoDB ;

create table s_permission (
    id VARCHAR(36),
    nama VARCHAR(255) NOT NULL,
    CONSTRAINT `pk_permission` PRIMARY KEY (`id`),
    CONSTRAINT `uk_nama` UNIQUE(`nama`)
) Engine=InnoDB ;

create table s_user_group (
    id_user VARCHAR(36),
    id_group VARCHAR(36),
    CONSTRAINT `pk_user_group` PRIMARY KEY (`id_user`,`id_group`)
) Engine=InnoDB ;

create table s_group_permission (
    id_group VARCHAR(36),
    id_permission VARCHAR(36),
    CONSTRAINT `pk_group_permission` PRIMARY KEY (`id_group`,`id_permission`)
) Engine=InnoDB ;