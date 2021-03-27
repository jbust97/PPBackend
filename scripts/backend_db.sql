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

CREATE TABLE public.regla
(
    id_regla integer NOT NULL,
    monto_de_equivalencia integer NOT NULL,
    limite_inferior INTEGER,
    limite_superior INTEGER,
    CONSTRAINT regla_pkey PRIMARY KEY (id_regla)
);
CREATE SEQUENCE public.regla_sec;


CREATE TABLE public.vencimiento
(
    id_vencimiento integer NOT NULL,
    dias_de_duracion integer NOT NULL,
    inicio_validez date,
    fin_validez date,
    CONSTRAINT vencimiento_pkey PRIMARY KEY (id_vencimiento)
);
CREATE SEQUENCE public.vencimiento_sec;

CREATE TABLE public.bolsa
(
    id_bolsa integer NOT NULL,
    id_persona integer NOT NULL,
    asignacion_de_puntaje DATE NOT NULL,
    caducidad_de_puntaje DATE NOT NULL,
    puntaje_asignado integer NOT NULL,
    puntaje_utilizado integer NOT NULL,
    saldo_de_puntos integer NOT NULL,
    monto_de_la_operacion integer NOT NULL,
    CONSTRAINT bolsa_pkey PRIMARY KEY (id_bolsa),
    CONSTRAINT  bolsa_persona_fkey FOREIGN KEY (id_persona) REFERENCES public.persona(id_persona)
);
CREATE SEQUENCE public.bolsa_sec;
