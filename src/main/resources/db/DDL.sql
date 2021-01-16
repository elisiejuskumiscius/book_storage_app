-- DDL

CREATE SCHEMA book_store;

CREATE TABLE book_store.book
(
    id             SERIAL PRIMARY KEY NOT NULL,
    name           VARCHAR(50)        NOT NULL,
    author         VARCHAR(50)        NOT NULL,
    barcode        VARCHAR(13)        NOT NULL UNIQUE,
    quantity       INT,
    price_per_unit DOUBLE PRECISION NOT NULL
);

CREATE TABLE book_store.antique_book
(
    id           SERIAL NOT NULL,
    CONSTRAINT PK_ANTIQUE PRIMARY KEY (id),
    CONSTRAINT FK_ANTIQUE_BOOK FOREIGN KEY (id) REFERENCES book_store.book (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    release_year INT NOT NULL
);

CREATE TABLE book_store.science_journal
(
    id            SERIAL   NOT NULL,
    CONSTRAINT PK_JOURNAL PRIMARY KEY (id),
    CONSTRAINT FK_JOURNAL_BOOK FOREIGN KEY (id) REFERENCES book_store.book (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    science_index smallint NOT NULL
);