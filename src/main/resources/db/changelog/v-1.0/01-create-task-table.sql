create table task
(
    id                 bigint       not null auto_increment,
    description        varchar(255),
    name               varchar(255) not null,
    status varchar(255),
    project_id         bigint,
    primary key (id)
) engine=InnoDB
GO

alter table task
    add constraint UK_lerptdo9d67pejjpbfau899tm unique (name)
GO
