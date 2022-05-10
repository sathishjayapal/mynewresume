drop table if exists security_user CASCADE
create table security_user
(
    id        integer not null,
    active    boolean not null,
    password  varchar(255),
    roles     varchar(255),
    user_name varchar(255),
    primary key (id)
)
