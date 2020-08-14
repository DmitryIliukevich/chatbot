create database chat_bot;
create table chat_bot.city
(
    id    int auto_increment
        primary key,
    name  varchar(45) not null,
    brand varchar(45) not null
)charset = utf8;