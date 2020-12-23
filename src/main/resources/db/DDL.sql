-- DDL

CREATE SCHEMA book_store;

USE book_store;

CREATE TABLE book
(
    id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    barcode CHAR(13) NOT NULL UNIQUE,
    quantity INT UNSIGNED,
    price_per_unit DECIMAL(10,2) NOT NULL
);

CREATE TABLE antique_book
(
    id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    barcode CHAR(13) NOT NULL UNIQUE,
    quantity INT UNSIGNED,
    price_per_unit DECIMAL(10,2) NOT NULL,
    release_year DATE
);

CREATE TABLE science_journal
(
    id BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    barcode CHAR(13) NOT NULL UNIQUE,
    quantity INT UNSIGNED,
    price_per_unit DECIMAL(10,2) NOT NULL,
    science_index TINYINT NOT NULL
);
