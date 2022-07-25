create table if not exists app_user (
    id long auto_increment(3) not null primary key,
    username varchar(100) not null unique,
    password varchar(1000) not null,
    date_of_birth date,
    first_name varchar(255),
    last_name varchar(255),
    sex char(1));

create table if not exists authority (id identity, authority_name varchar(100) not null);

create table if not exists user_authority(
    user_id int not null,
    authority_id int not null,
    constraint fk_user foreign key (user_id) references app_user(id),
    constraint fk_authority foreign key (authority_id) references authority(id)
);
create table if not exists LU_JOB(
    id long auto_increment(10) not null primary key,
    title varchar(255),
    description varchar(3000),
    pickup_location varchar(255),
    target_location varchar(255),
    issuer_id int,
    driver_id int,
    issued_date date,
    price double,
    distance double,
    date_needed date,
    pickup_hours varchar,
    width double,
    lenght double,
    weight double,
    constraint fk_issuer foreign key (issuer_id) references app_user(id),
    constraint fk_driver foreign key (driver_id) references app_user(id)
);
create table if not exists image(
    id long auto_increment not null primary key,
    name varchar(255),
    type varchar(255),
    image blob(1000000)
)