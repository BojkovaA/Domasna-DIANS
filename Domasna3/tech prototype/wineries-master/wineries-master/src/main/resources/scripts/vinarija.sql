-- Table: public.vinarija

-- DROP TABLE IF EXISTS public.vinarija;

CREATE TABLE IF NOT EXISTS public.vinarija
(
    id bigint NOT NULL DEFAULT nextval('vinarija_id_seq'::regclass),
    name text COLLATE pg_catalog."default",
    location text COLLATE pg_catalog."default",
    "workingTime" text COLLATE pg_catalog."default",
    lon bigint,
    lat bigint,
    "phoneNumber" text COLLATE pg_catalog."default",
    city text COLLATE pg_catalog."default",
    website text COLLATE pg_catalog."default",
    CONSTRAINT vinarija_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.vinarija
    OWNER to postgres;