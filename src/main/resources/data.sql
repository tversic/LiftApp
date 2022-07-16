insert into app_user (id, username, password) values
    (1, 'tome', '$2a$10$eALlaWi8QbGTU3oEbwKD1Op/EerkoScSU4q04.aT6y6ZHU70xBxda'), -- password user
    (2, 'pujo', '$2a$10$eALlaWi8QbGTU3oEbwKD1Op/EerkoScSU4q04.aT6y6ZHU70xBxda'),
    (3, 'dome', '$2a$10$eALlaWi8QbGTU3oEbwKD1Op/EerkoScSU4q04.aT6y6ZHU70xBxda'); -- password user

insert into authority(id, authority_name) values
    (1, 'ROLE_USER'),
    (2, 'ROLE_DRIVER'),
    (3, 'ROLE_ADMIN');

insert into user_authority(user_id, authority_id) values
    (1, 1),
    (3, 2),
    (2, 3);

insert into LU_JOB (id, title, description, location, issuer_id, driver_id, issued_date, price) values
    (1, 'prviJob', 'desc', 'Put Nina 19', 1, 2, '2022-05-08', 20),
    (2, 'drugiJob', 'desc', 'Put Nina 31', 1, null, '2022-06-07', 30),
    (3, 'treciJob', 'desc', 'Put Nina 31', 1, 3, '2019-05-08', 40),
    (4, 'cetvrtiJob', 'desc', 'Put Nina 31', 1, null, '2017-05-08', 50),
    (5, 'petiJob', 'desc', 'Put Nina 31', 1, 3, '2022-05-08', 60);
