-- Table: public.clients

-- DROP TABLE IF EXISTS public.clients;

CREATE TABLE IF NOT EXISTS public.clients
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    first_name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    email character varying(128) COLLATE pg_catalog."default" NOT NULL,
    address character varying(128) COLLATE pg_catalog."default",
    phone bigint,
    status bigint NOT NULL,
    CONSTRAINT clients_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.clients
    OWNER to postgres;


INSERT INTO public.clients (id, first_name, last_name, email, address, phone, status) OVERRIDING SYSTEM VALUE VALUES (1, 'Alex', 'Senkin', '1@alexsenkin.ru', 'SPB', 123, 1);
INSERT INTO public.clients (id, first_name, last_name, email, address, phone, status) OVERRIDING SYSTEM VALUE VALUES (2, 'Maria', 'Kuzmina', '2@maria.ru', 'SPB', 345, 1);


	
-- Table: public.movie_theaters

-- DROP TABLE IF EXISTS public.movie_theaters;

CREATE TABLE IF NOT EXISTS public.movie_theaters
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    cinema_name character varying(128) COLLATE pg_catalog."default",
    cinema_address character varying(128) COLLATE pg_catalog."default",
    CONSTRAINT cinema_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.movie_theaters
    OWNER to postgres;
	
INSERT INTO public.movie_theaters (id, cinema_name, cinema_address) OVERRIDING SYSTEM VALUE VALUES (1, 'Киномак', 'SPB1');
INSERT INTO public.movie_theaters (id, cinema_name, cinema_address) OVERRIDING SYSTEM VALUE VALUES (2, 'КАРО', 'SPB2');


-- Table: public.movies

-- DROP TABLE IF EXISTS public.movies;

CREATE TABLE IF NOT EXISTS public.movies
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    movie_name character varying(128) COLLATE pg_catalog."default" NOT NULL,
    movie_duration bigint,
    CONSTRAINT film_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.movies
    OWNER to postgres;
	
INSERT INTO public.movies (id, movie_name, movie_duration) OVERRIDING SYSTEM VALUE VALUES (1, 'Лили и море', 60);
INSERT INTO public.movies (id, movie_name, movie_duration) OVERRIDING SYSTEM VALUE VALUES (2, 'Чебурашка', 90);
INSERT INTO public.movies (id, movie_name, movie_duration) OVERRIDING SYSTEM VALUE VALUES (3, 'Аватар', 120);
INSERT INTO public.movies (id, movie_name, movie_duration) OVERRIDING SYSTEM VALUE VALUES (4, 'Терминатор', 120);
INSERT INTO public.movies (id, movie_name, movie_duration) OVERRIDING SYSTEM VALUE VALUES (5, 'Терминатор-2', 120);	
	
-- Table: public.sessions

-- DROP TABLE IF EXISTS public.sessions;

CREATE TABLE IF NOT EXISTS public.sessions
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    id_movie_theater bigint NOT NULL,
    id_movie bigint NOT NULL,
    start_time timestamp without time zone,
    ticket_price money,
    CONSTRAINT sessions_pkey PRIMARY KEY (id),
    CONSTRAINT fk_session_movie FOREIGN KEY (id_movie)
        REFERENCES public.movies (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_session_movie_theater FOREIGN KEY (id_movie_theater)
        REFERENCES public.movie_theaters (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.sessions
    OWNER to postgres;
	
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (1, 1, 1, '2023-01-30 10:00:00', '500,00 ?');
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (2, 1, 2, '2023-01-30 12:00:00', '500,00 ?');
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (3, 1, 3, '2023-01-30 14:00:00', '500,00 ?');
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (4, 1, 1, '2023-01-30 16:00:00', '400,00 ?');
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (5, 1, 1, '2023-01-30 18:00:00', '300,00 ?');
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (6, 1, 2, '2023-01-30 20:00:00', '400,00 ?');
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (7, 1, 2, '2023-01-30 22:00:00', '300,00 ?');
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (8, 1, 3, '2023-01-30 06:00:00', '300,00 ?');
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (9, 1, 3, '2023-01-30 08:00:00', '400,00 ?');
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (10, 2, 1, '2023-01-30 10:00:00', '150,00 ?');
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (11, 2, 2, '2023-01-30 12:00:00', '250,00 ?');
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (12, 2, 1, '2023-01-31 12:00:00', '250,00 ?');
INSERT INTO public.sessions (id, id_movie_theater, id_movie, start_time, ticket_price) OVERRIDING SYSTEM VALUE VALUES (13, 2, 2, '2023-01-31 14:00:00', '250,00 ?');	
	
-- Table: public.tickets

-- DROP TABLE IF EXISTS public.tickets;

CREATE TABLE IF NOT EXISTS public.tickets
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    id_session bigint NOT NULL,
    id_client bigint NOT NULL,
    place_number bigint NOT NULL,
    CONSTRAINT tickets_pkey PRIMARY KEY (id),
    CONSTRAINT fk_ticket_cliet FOREIGN KEY (id_client)
        REFERENCES public.clients (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_ticket_session FOREIGN KEY (id_session)
        REFERENCES public.sessions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tickets
    OWNER to postgres;
	
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (1, 1, 1, 1);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (2, 1, 2, 2);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (3, 2, 1, 1);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (4, 2, 2, 2);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (6, 3, 1, 1);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (7, 3, 2, 2);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (8, 4, 1, 1);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (9, 4, 2, 2);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (10, 5, 1, 1);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (11, 5, 2, 2);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (12, 6, 1, 1);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (13, 6, 2, 2);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (14, 7, 1, 1);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (15, 7, 2, 2);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (16, 8, 1, 1);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (17, 8, 2, 2);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (18, 9, 1, 1);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (19, 9, 2, 2);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (20, 9, 1, 3);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (21, 9, 2, 4);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (22, 9, 1, 5);
INSERT INTO public.tickets (id, id_session, id_client, place_number) OVERRIDING SYSTEM VALUE VALUES (23, 9, 2, 6);	