insert into app_user (id, username, password) values
    (1, 'tome', '$2a$10$eALlaWi8QbGTU3oEbwKD1Op/EerkoScSU4q04.aT6y6ZHU70xBxda'), -- password user
    (2, 'pujo', '$2a$10$eALlaWi8QbGTU3oEbwKD1Op/EerkoScSU4q04.aT6y6ZHU70xBxda'); -- password user

insert into authority(id, authority_name) values
    (1, 'ROLE_USER'),
    (2, 'ROLE_DRIVER'),
    (3, 'ROLE_ADMIN');

insert into user_authority(user_id, authority_id) values
    (1, 1),
    (2, 3);
