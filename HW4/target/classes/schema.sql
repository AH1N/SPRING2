create schema if not exists s_users;

create table if not exists s_users.t_users(
    id serial primary key,
    c_username VARCHAR(50) NOT NULL CHECK (LENGTH(TRIM(c_username)) >= 3),
    c_user_mail varchar(1000)
);