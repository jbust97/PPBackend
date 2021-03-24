create database pwbe;

create user pwbe_user with password 'pwbe_pass';

grant all privileges on all tables in schema public to pwbe_user;
grant all privileges on all sequences in schema public to pwbe_user;

create table public.concepto_uso_puntos(
	id_concepto integer not null,
	descripcion character varying(50) not null,
	puntos_requeridos integer not null,
	constraint concepto_pkey primary key (id_concepto)
);
create sequence public.concepto_sec;

CREATE TABLE public.persona
(
    id_persona integer NOT NULL,
    apellido character varying(50) NOT NULL,
    nombre character varying(50) NOT NULL,
    numero_ci character varying (25) NOT NULL,
    tipo_ci character varying (25) NOT NULL,
    nacionalidad character varying (25) NOT NULL,
    email character varying (50) NOT NULL,
    telefono character varying (25) NOT NULL,
    fecha_de_nacimiento date NOT NULL,
    CONSTRAINT persona_pkey PRIMARY KEY (id_persona)
);
CREATE SEQUENCE public.persona_sec;
