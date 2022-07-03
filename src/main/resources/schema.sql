create table if not exists app_user (
    id identity,
    username varchar(100) not null unique,
    password varchar(1000) not null);

create table if not exists authority (id identity, authority_name varchar(100) not null);

create table if not exists user_authority(
    user_id int not null,
    authority_id int not null,
    constraint fk_user foreign key (user_id) references app_user(id),
    constraint fk_authority foreign key (authority_id) references authority(id)
);