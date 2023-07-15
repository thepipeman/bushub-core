CREATE schema mng;

DO
$$
    BEGIN
        CREATE TYPE mng.ROLE AS ENUM (
            'ADMIN',
            'RESERVATION_OFFICER',
            'MANAGER'
            );
    EXCEPTION
        WHEN duplicate_object THEN NULL;
    END
$$;

CREATE TABLE mng.user
(
    id          BIGSERIAL NOT NULL,
    role        mng.ROLE  NOT NULL,
    first_name  TEXT      NOT NULL,
    middle_name TEXT,
    last_name   TEXT      NOT NULL,
    birth_date  DATE      NOT NULL,
    email       TEXT      NOT NULL,
    username    TEXT      NOT NULL,

    PRIMARY KEY (id)
);

-- CREATE DEFAULT USER
INSERT INTO mng.user (role,
                      first_name,
                      last_name,
                      birth_date,
                      email,
                      username)
VALUES ('ADMIN' :: mng.ROLE,
        'Hub',
        'Admin',
        '1990-01-01' :: DATE,
        'admin@bushub.ph',
        'bh-admin');

CREATE CAST (CHARACTER VARYING as mng.ROLE) WITH INOUT AS IMPLICIT;
