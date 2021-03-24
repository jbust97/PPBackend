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