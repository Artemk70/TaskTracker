create table project
(
    id              bigint not null auto_increment,
    completion_date datetime(6),
    name            varchar(255),
    priority        integer,
    start_date      datetime(6),
    status          varchar(255),
    primary key (id)
) engine=InnoDB
GO

alter table task
    add constraint FKk8qrwowg31kx7hp93sru1pdqa foreign key (project_id) references project (id) on delete cascade
GO