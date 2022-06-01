create table if not exists t_artists(
    id bigint not null,
    `name` varchar(255) not null,
    bio varchar(255) not null,
    created_date timestamp not null,
    constraint pk_id primary key(id)
)