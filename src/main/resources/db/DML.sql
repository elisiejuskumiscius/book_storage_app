--DML

INSERT INTO book_store.book (name, author, barcode, quantity, price_per_unit)
VALUES ('War and Peace', 'Leo Tolstoy', '1234567891234', 2, 18.99);
INSERT INTO book_store.book (name, author, barcode, quantity, price_per_unit)
VALUES ('Song of Solomon', 'Toni Morrison', '1234567891235', 12, 15.99);
INSERT INTO book_store.book (name, author, barcode, quantity, price_per_unit)
VALUES ('Ulysses', 'James Joyce', '1234567891236', 100, 12.99);

INSERT INTO book_store.book (name, author, barcode, quantity, price_per_unit)
VALUES ('Nicholas Nickleby', 'Charles Dickens', '1234567891237', 1, 949.99);
INSERT INTO book_store.antique_book (id, release_year)
VALUES (lastval(), 1337);
INSERT INTO book_store.book (name, author, barcode, quantity, price_per_unit)
VALUES ('Selected Tales of Mystery', 'Edgar Allan Poe', '1234567891238', 3, 389.99);
INSERT INTO book_store.antique_book (id, release_year)
VALUES (lastval(), 1809);
INSERT INTO book_store.book (name, author, barcode, quantity, price_per_unit)
VALUES ('Canzoniere et Trionfi', 'Francesco Petrarca', '1234567891239', 1, 75000.00);
INSERT INTO book_store.antique_book (id, release_year)
VALUES (lastval(), 1474);

INSERT INTO book_store.book (name, author, barcode, quantity, price_per_unit)
VALUES ('Nature', 'Magdalena Skipper', '1234567891249', 50, 5.00);
INSERT INTO book_store.science_journal(id, science_index)
VALUES (lastval(), 9);
INSERT INTO book_store.book (name, author, barcode, quantity, price_per_unit)
VALUES ('Science', 'Holden Thorp', '1234567891259', 25, 7.40);
INSERT INTO book_store.science_journal(id, science_index)
VALUES (lastval(), 10);
INSERT INTO book_store.book (name, author, barcode, quantity, price_per_unit)
VALUES ('Journal of Zoology', 'Nigel Bennett', '1234567891269', 15, 3.40);
INSERT INTO book_store.science_journal(id, science_index)
VALUES (lastval(), 8);
