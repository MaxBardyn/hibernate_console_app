CREATE DATABASE IF NOT EXISTS bardyn_lab3;

USE bardyn_lab3;

# ================================= DROP TABLES =================================

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS event;
DROP TABLE IF EXISTS ticket_office;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS artist;

# ================================= CREATE NEW TABLES =================================

CREATE TABLE artist
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    age     INT,
    alias   VARCHAR(15)
);

CREATE TABLE user
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(15) NOT NULL,
    surname   VARCHAR(15) NOT NULL,
    age       INT,
    ticket_id INT
);

CREATE TABLE location
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(45),
    address VARCHAR(45) NOT NULL
);

CREATE TABLE event
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(45) NOT NULL,
    location_id INT         NOT NULL,
    artist_id   INT         NOT NULL
);

CREATE TABLE ticket_office
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    location_id INT NOT NULL
);

CREATE TABLE ticket
(
    id               INT PRIMARY KEY AUTO_INCREMENT,
    price            INT         NOT NULL,
    sector           VARCHAR(10),
    place_number     VARCHAR(15) NOT NULL,
    event_id         INT         NOT NULL,
    ticket_office_id INT         NOT NULL
);

# ================================= FOREIGN KEYS =================================

ALTER TABLE event
    ADD CONSTRAINT fk_event_location
        FOREIGN KEY (location_id)
            REFERENCES location (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    ADD CONSTRAINT fk_event_artist
        FOREIGN KEY (artist_id)
            REFERENCES artist (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE ticket_office
    ADD CONSTRAINT fk_ticket_office_location
        FOREIGN KEY (location_id)
            REFERENCES location (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

ALTER TABLE ticket
    ADD CONSTRAINT fk_ticket_event
        FOREIGN KEY (event_id)
            REFERENCES event (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    ADD CONSTRAINT fk_ticket_ticket_office
        FOREIGN KEY (ticket_office_id)
            REFERENCES ticket_office (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE user
    ADD CONSTRAINT fk_user_ticket
        FOREIGN KEY (ticket_id)
            REFERENCES ticket (id)
            ON DELETE SET NULL
            ON UPDATE NO ACTION;

# ================================= FILL THE TABLES =================================

INSERT INTO artist (name, surname, age, alias)
VALUES ('Billie', 'Eilish', 18, NULL),
       ('Rakim ', 'Mayers', 32, 'ASAP Rocky'),
       ('Darold ', 'Brown ', 32, 'ASAP Ferg'),
       ('Unknown', 'Unknown', NULL, NULL),
       ('Artist5', 'Artist5', NULL, NULL),
       ('Artist6', 'Artist6', 21, NULL),
       ('Artist7', 'Artist7', 45, 'Unknown'),
       ('Artist8', 'Artist8', 12, 'Nameless'),
       ('Artist9', 'Artist9', 33, NULL),
       ('Artist10', 'Artist10', 24, NULL);

INSERT INTO location (name, address)
VALUES ('NSK Olimpiyskiy', 'Velyka Vasylkivska'),
       ('Dovzhenko Theater', 'Dovzhenka Street'),
       ('Arena Lviv', 'Stryjska');

INSERT INTO event (name, location_id, artist_id)
VALUES ('Birthday Party1', 1, 1),
       ('Party2', 2, 3),
       ('New Year Party', 3, 4),
       ('Birthday Party4', 1, 5),
       ('Birthday Party5', 2, 7),
       ('Birthday Party6', 3, 2),
       ('Birthday Party7', 3, 6),
       ('Birthday Party8', 2, 9),
       ('Birthday Party9', 2, 8),
       ('Birthday Party10', 1, 1);

INSERT INTO ticket_office (location_id)
VALUES (1),
       (2),
       (3),
       (3),
       (2),
       (1),
       (1),
       (2),
       (3),
       (1);

INSERT INTO ticket(price, sector, place_number, event_id, ticket_office_id)
VALUES (1300, '1B', '32A', 2, 3),
       (2100, NULL, '4', 3, 4),
       (200, '32B', '65', 5, 6),
       (500, '48H', '11', 7, 7),
       (100, NULL, '65', 8, 1),
       (350, '1B', '2', 10, 4),
       (500, NULL, '1', 2, 9),
       (900, '1B', '92B', 4, 10),
       (300, '1B', '31', 1, 3),
       (60, NULL, '142', 7, 2);

INSERT INTO user(name, surname, age, ticket_id)
VALUES ('User1', 'User1', 19, 1),
       ('User2', 'User2', 32, 2),
       ('User3', 'User3', 14, 3),
       ('User4', 'User4', 64, 4),
       ('User5', 'User5', 12, 5),
       ('User6', 'User5', 76, 6),
       ('User7', 'User6', 54, 7),
       ('User8', 'User7', 45, 8),
       ('User9', 'User8', 32, 9),
       ('User10', 'User10', 45, 10);

# ================================= CREATE INDEXES =================================

CREATE INDEX user_age ON user (age);

CREATE INDEX ticket_price ON ticket (price);
