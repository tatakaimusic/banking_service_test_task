CREATE SCHEMA IF NOT EXISTS production;

CREATE TABLE IF NOT EXISTS production.accounts
(
    id     BIGINT PRIMARY KEY,
    amount NUMERIC NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS production.users
(
    id            BIGINT PRIMARY KEY,
    username      VARCHAR(36) NOT NULL UNIQUE,
    password      VARCHAR(36) NOT NULL,
    name          VARCHAR(100) NOT NULL,
    email         VARCHAR NOT NULL UNIQUE,
    phone_number  VARCHAR NOT NULL UNIQUE,
    date_of_birth DATE    NOT NULL,
    account       BIGINT  NOT NULL,
    CONSTRAINT users_accounts FOREIGN KEY (account) REFERENCES production.accounts (id)
);
