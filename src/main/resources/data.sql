insert into app_user (id, username, password, date_of_birth, sex, first_name, last_name) values
    (1, 'tome', '$2a$10$eALlaWi8QbGTU3oEbwKD1Op/EerkoScSU4q04.aT6y6ZHU70xBxda', '2001-10-05', 'm', 'Tome', 'Versic'), -- password user
    (2, 'pujo', '$2a$10$eALlaWi8QbGTU3oEbwKD1Op/EerkoScSU4q04.aT6y6ZHU70xBxda', '1988-5-07', 'm', 'Ante', 'Jović'),
    (3, 'dome', '$2a$10$eALlaWi8QbGTU3oEbwKD1Op/EerkoScSU4q04.aT6y6ZHU70xBxda', '1996-12-12', 'm', 'Dominik', 'Jović'); -- password user

insert into authority(id, authority_name) values
    (1, 'ROLE_USER'),
    (2, 'ROLE_DRIVER'),
    (3, 'ROLE_ADMIN');

insert into user_authority(user_id, authority_id) values
    (1, 1),
    (3, 2),
    (2, 3);

insert into LU_JOB (id, title, description, pickup_location, target_location,
                    issuer_id, driver_id, issued_date, price, distance,
                    date_needed, pickup_hours, width, lenght, weight) values
    (1, 'prviJob', 'desc', 'Put Nina 19', 'Siroka ulica 12', 1, 2, '2022-05-08', 20, 30, '2022-10-05', '08-15', 10, 10, 30),
    (2, 'drugiJob', 'desc', 'Put Nina 31', 'Siroka ulica 12', 1, null, '2022-06-07', 30, 15, '2022-10-07', '11-15', 20, 20 , 40),
    (3, 'treciJob', 'desc', 'Put Nina 31', 'Siroka ulica 12', 1, 3, '2019-05-08', 40, 5, '2022-10-18', '09-15', 3, 4, 12),
    (4, 'cetvrtiJob', 'desc', 'Put Nina 31', 'Siroka ulica 12', 1, null, '2017-05-08', 50, 12, '2022-10-28', '09-15', 8, 8, 13),
    (5, 'petiJob', 'desc', 'Put Nina 31', 'Siroka ulica 12', 1, 3, '2022-05-08', 60, 13.3, '2022-11-08', '08-15', 12, 32, 32);
