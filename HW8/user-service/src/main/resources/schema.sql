create schema if not exists s_users;

create table if not exists s_users.t_users(
    id serial primary key,
    c_username VARCHAR(50) NOT NULL,
    c_user_mail varchar(1000)
);