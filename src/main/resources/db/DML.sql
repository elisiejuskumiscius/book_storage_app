--DML

INSERT INTO book (name, author, barcode, quantity, price_per_unit)
VALUES ('War and Peace', 'Leo Tolstoy', '1234567891234', 2, 18.99);
INSERT INTO book (name, author, barcode, quantity, price_per_unit)
VALUES ('Song of Solomon', 'Toni Morrison', '1234567891235', 12, 15.99);
INSERT INTO book (name, author, barcode, quantity, price_per_unit)
VALUES ('Ulysses', 'James Joyce', '1234567891236', 100, 12.99);

INSERT INTO antique_book (name, author, barcode, quantity, price_per_unit, release_year)
VALUES ('Nicholas Nickleby', 'Charles Dickens', '1234567891237', 1, 949.99, '1839-01-01');
INSERT INTO antique_book (name, author, barcode, quantity, price_per_unit, release_year)
VALUES ('Selected Tales of Mystery', 'Edgar Allan Poe', '1234567891238', 3, 389.99, '1909-01-01');
INSERT INTO antique_book (name, author, barcode, quantity, price_per_unit, release_year)
VALUES ('Canzoniere et Trionfi', 'Francesco Petrarca', '1234567891239', 1, 75000.00, '1474-01-01');

INSERT INTO science_journal (name, author, barcode, quantity, price_per_unit, science_index)
VALUES ('Nature', 'Magdalena Skipper', '1234567891249', 50, 5.00, 9);
INSERT INTO science_journal (name, author, barcode, quantity, price_per_unit, science_index)
VALUES ('Science', 'Holden Thorp', '1234567891259', 25, 7.40, 10);
INSERT INTO science_journal (name, author, barcode, quantity, price_per_unit, science_index)
VALUES ('Journal of Zoology', 'Nigel Bennett', '1234567891269', 15, 3.40, 8);