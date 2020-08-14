create database chat_bot;
create table city
(
    id    int auto_increment
        primary key,
    name  varchar(45) not null,
    brand varchar(45) not null
)charset = utf8;