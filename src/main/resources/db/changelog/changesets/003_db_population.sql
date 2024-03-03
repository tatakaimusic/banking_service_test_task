INSERT INTO accounts (amount, init_payment)
VALUES (100, 100),
       (100, 100);

INSERT INTO users (username, password, name, email, phone_number, date_of_birth, account_id)
VALUES ('nikita', '$2a$10$RWlH.Xu84qNugcJl9qXt7epMXcFtGnH9HAkgkH799stTR/9uUhY/.', 'nikita', 'nik@mail.ru',
        '897711973511', '2002-02-21', 1),
       ('max', '$2a$10$RWlH.Xu84qNugcJl9qXt7epMXcFtGnH9HAkgkH799stTR/9uUhY/.', 'nikita', 'max@mail.ru',
        '897711973510', '2002-02-21', 2)

