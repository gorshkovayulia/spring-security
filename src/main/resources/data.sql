INSERT INTO person (id, username, password, algorithm)
VALUES ('1', 'john', '$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG', 'BCRYPT');

INSERT INTO person (id, username, password, algorithm)
VALUES ('2', 'karl', '$2a$12$G8Epilc8q237X91HEB6sbe7Z8WYjdCsEOPmNagRsfDXW4vgV.gbse', 'BCRYPT');

INSERT INTO authority (id, name, person)
VALUES ('1','ROLE_ADMIN', '1');

INSERT INTO authority (id, name, person)
VALUES ('2','ROLE_MANAGER', '2');

INSERT INTO product (id, name, price, currency)
VALUES ('1', 'Chocolate', '10', 'USD');