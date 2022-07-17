drop table if exists users;

create table users
(
    id bigint(20) not null auto_increment,
    name varchar(100) not null,
    email varchar(150) not null,
    salary decimal(10,2) not null,
    primary key (id)
);
