CREATE SCHEMA IF NOT EXISTS production;

CREATE TABLE IF NOT EXISTS production.accounts
(
    id     BIGSERIAL PRIMARY KEY,
    amount NUMERIC NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS production.users
(
    id            BIGSERIAL PRIMARY KEY,
    username      VARCHAR(100) NOT NULL UNIQUE,
    password      VARCHAR(100) NOT NULL,
    name          VARCHAR(100) NOT NULL,
    email         VARCHAR      NOT NULL UNIQUE,
    phone_number  VARCHAR      NOT NULL UNIQUE,
    date_of_birth DATE         NOT NULL,
    account_id    BIGINT,
    CONSTRAINT users_accounts FOREIGN KEY (account_id) REFERENCES production.accounts (id)
);
