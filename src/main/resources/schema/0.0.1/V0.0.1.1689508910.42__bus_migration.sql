CREATE SCHEMA flt;

DO
$$
    BEGIN
        CREATE TYPE flt.BUS_TYPE AS ENUM (
            'REGULAR',
            'ORDINARY',
            'DELUXE',
            'FIRST_CLASS',
            'SLEEPER',
            'CARGO'
            );
    EXCEPTION
        WHEN duplicate_object THEN NULL;
    END
$$;

CREATE TABLE flt.bus (
                        id           BIGSERIAL   NOT NULL,
                        type         flt.BUS_TYPE NOT NULL,
                        plate_number TEXT        NOT NULL,
                        number       TEXT        NOT NULL,
                        t_active     BOOLEAN     NOT NULL DEFAULT TRUE,

                        PRIMARY KEY (id)
);

CREATE UNIQUE INDEX bus_uq_plate_number
    ON flt.bus(plate_number)
    WHERE t_active IS TRUE;

CREATE UNIQUE INDEX bus_uq_number
    ON flt.bus(number)
    WHERE t_active IS TRUE;

CREATE CAST (CHARACTER VARYING as flt.bus_type) WITH INOUT AS IMPLICIT;
