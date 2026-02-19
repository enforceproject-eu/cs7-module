CREATE TABLE IF NOT EXISTS public.cs7_measuring_point_identification
(
    id int NOT NULL,
    name character varying(255),
    name_eng character varying(255),
    CONSTRAINT cs7_measuring_point_identification_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_measuring_point_identification_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_measuring_point_identification VALUES (1, 'N/A', 'N/A');

CREATE TABLE IF NOT EXISTS public.cs7_location_code
(
    id int NOT NULL,
    name character varying(255),
    CONSTRAINT cs7_location_code_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_location_code_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_location_code VALUES (1, 'N/A');
    
CREATE TABLE IF NOT EXISTS public.cs7_magnitude_description
(
    id int NOT NULL,
    name character varying(255),
    name_eng character varying(255),
    CONSTRAINT cs7_magnitude_description_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_magnitude_description_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_magnitude_description VALUES (1, 'N/A', 'N/A');
INSERT INTO public.cs7_magnitude_description VALUES (2, '(massa)Concentratie', '(mass) concentration');
INSERT INTO public.cs7_magnitude_description VALUES (3, 'Massafractie', 'mass fraction');
    
CREATE TABLE IF NOT EXISTS public.cs7_magnitude_code
(
    id int NOT NULL,
    name character varying(255),
    CONSTRAINT cs7_magnitude_code_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_magnitude_code_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    
    
INSERT INTO public.cs7_magnitude_code VALUES (1, 'N/A'); 
  
CREATE TABLE IF NOT EXISTS public.cs7_parameter_description
(
    id int NOT NULL,
    name character varying(255),
    name_eng character varying(255),
    CONSTRAINT cs7_parameter_description_pkey PRIMARY KEY (id)
);


CREATE SEQUENCE IF NOT EXISTS public.cs7_parameter_description_seq
    INCREMENT 1
    START 34
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_parameter_description VALUES (1, 'N/A', 'N/A');
INSERT INTO public.cs7_parameter_description VALUES (2, 'antraceen','Anthracene');
INSERT INTO public.cs7_parameter_description VALUES (3, 'arseen','Arsenic');
INSERT INTO public.cs7_parameter_description VALUES (4, 'benzo(a)antraceen','Benzo(a)antracene');
INSERT INTO public.cs7_parameter_description VALUES (5, 'benzo(a)pyreen','Benzo(a)pyrene');
INSERT INTO public.cs7_parameter_description VALUES (6, 'benzo(b)fluorantheen','Benzo(b)fluoranthene');
INSERT INTO public.cs7_parameter_description VALUES (7, 'benzo(ghi)peryleen','Benzo(ghi)perylene');
INSERT INTO public.cs7_parameter_description VALUES (8, 'benzo(k)fluorantheen','Benzo(k)fluoranthene');
INSERT INTO public.cs7_parameter_description VALUES (9, 'chryseen','Chrysene');
INSERT INTO public.cs7_parameter_description VALUES (10, 'dibenzo(a,h)antraceen','Dibenzo(a,h)anthracene');
INSERT INTO public.cs7_parameter_description VALUES (11, 'fenantreen' ,'Phenanthrene');
INSERT INTO public.cs7_parameter_description VALUES (12, 'fluorantheen','Fluoranthene');
INSERT INTO public.cs7_parameter_description VALUES (13, 'indeno(1,2,3-cd)pyreen','Indeno(1,2,3-cd)pyrene');
INSERT INTO public.cs7_parameter_description VALUES (14, 'perfluor-1-butaansulfonaat (lineair)','Perfluoro-1-butanesulfonate (linear)');
INSERT INTO public.cs7_parameter_description VALUES (15, 'perfluor-1-decaansulfonaat (lineair)','Perfluoro-1-decanesulfonate (linear)');
INSERT INTO public.cs7_parameter_description VALUES (16, 'perfluor-1-hexaansulfonaat (lineair)','Perfluoro-1-hexanesulfonate (linear)');
INSERT INTO public.cs7_parameter_description VALUES (17, 'perfluor-1-octaansulfonaat (lineair)','Perfluoro-1-octanesulfonate (linear)');
INSERT INTO public.cs7_parameter_description VALUES (18, 'naftaleen' ,'Naphthalene');
INSERT INTO public.cs7_parameter_description VALUES (19, 'perfluorbutaanzuur','Perfluorobutanoic acid');
INSERT INTO public.cs7_parameter_description VALUES (20, 'perfluordecaanzuur','Perfluorodecanoic acid');
INSERT INTO public.cs7_parameter_description VALUES (21, 'perfluorheptaanzuur','Perfluoroheptanoic acid');
INSERT INTO public.cs7_parameter_description VALUES (22, 'perfluorhexaanzuur' ,'Perfluorohexanoic acid');
INSERT INTO public.cs7_parameter_description VALUES (23, 'perfluornonaanzuur' ,'Perfluorononanoic acid');
INSERT INTO public.cs7_parameter_description VALUES (24, 'perfluoroctaanzuur' ,'Perfluorooctanoic acid');
INSERT INTO public.cs7_parameter_description VALUES (25, 'perfluorpentaanzuur' ,'Perfluoropentanoic acid');
INSERT INTO public.cs7_parameter_description VALUES (26, 'perfluortridecaanzuur' ,'Perfluorotridecanoic acid');
INSERT INTO public.cs7_parameter_description VALUES (27, 'perfluortetradecaanzuur' ,'Perfluorotetradecanoic acid');
INSERT INTO public.cs7_parameter_description VALUES (28, 'perfluorundecaanzuur' ,'Perfluoroundecanoic acid');
INSERT INTO public.cs7_parameter_description VALUES (29, 'lood' ,'Lead');
INSERT INTO public.cs7_parameter_description VALUES (30, 'pyreen' ,'Pyrene');
INSERT INTO public.cs7_parameter_description VALUES (31, 'som benzo(b)fluorantheen en benzo(j)fluoranthee','Sum of benzo(b)fluoranthene and benzo(j)fluoranthene');
INSERT INTO public.cs7_parameter_description VALUES (32, 'benzo(e)pyreen','benzo(e)pyrene');
INSERT INTO public.cs7_parameter_description VALUES (33, 'kwik','mercury');

    
CREATE TABLE IF NOT EXISTS public.cs7_parameter_code
(
    id int NOT NULL,
    name character varying(255),
    CONSTRAINT cs7_parameter_code_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_parameter_code_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    
    
INSERT INTO public.cs7_parameter_code VALUES (1, 'N/A');
    
CREATE TABLE IF NOT EXISTS public.cs7_cas_nr
(
    id int NOT NULL,
    name character varying(255),
    name_eng character varying(255),
    CONSTRAINT cs7_cas_nr_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_cas_nr_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_cas_nr VALUES (1, 'N/A', 'N/A');
    
CREATE TABLE IF NOT EXISTS public.cs7_unit_code
(
    id int NOT NULL,
    name character varying(255),
    CONSTRAINT cs7_unit_code_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_unit_code_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    
  
INSERT INTO public.cs7_unit_code VALUES (1, 'N/A');
    
CREATE TABLE IF NOT EXISTS public.cs7_capacity_description
(
    id int NOT NULL,
    name character varying(255),
    name_eng character varying(255),
    CONSTRAINT cs7_capacity_description_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_capacity_description_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_capacity_description VALUES (1, 'N/A', 'N/A');    
    
CREATE TABLE IF NOT EXISTS public.cs7_capacity_code
(
    id int NOT NULL,
    name character varying(255),
    CONSTRAINT cs7_capacity_code_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_capacity_code_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_capacity_code VALUES (1, 'N/A');

CREATE TABLE IF NOT EXISTS public.cs7_compartment_description
(
    id int NOT NULL,
    name character varying(255),
    name_eng character varying(255),
    CONSTRAINT cs7_compartment_description_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_compartment_description_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_compartment_description VALUES (1, 'N/A', 'N/A');        
    
CREATE TABLE IF NOT EXISTS public.cs7_compartment_code
(
    id int NOT NULL,
    name character varying(255),
    CONSTRAINT cs7_compartment_code_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_compartment_code_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_compartment_code VALUES (1, 'N/A');      
    
CREATE TABLE IF NOT EXISTS public.cs7_valuation_method_description
(
    id int NOT NULL,
    name character varying(255),
    name_eng character varying(255),
    CONSTRAINT cs7_valuation_method_description_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_valuation_method_description_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_valuation_method_description VALUES (1, 'N/A', 'N/A');       
    
CREATE TABLE IF NOT EXISTS public.cs7_valuation_method_code
(
    id int NOT NULL,
    name character varying(255),
    CONSTRAINT cs7_valuation_method_code_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_valuation_method_code_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_valuation_method_code VALUES (1, 'N/A');      
    
CREATE TABLE IF NOT EXISTS public.cs7_sampling_type_description
(
    id int NOT NULL,
    name character varying(255),
    name_eng character varying(255),
    CONSTRAINT cs7_sampling_type_description_pkey PRIMARY KEY (id)
);

INSERT INTO public.cs7_sampling_type_description VALUES (1, 'N/A', 'N/A');
INSERT INTO public.cs7_sampling_type_description VALUES (2, 'Steekbemonstering', 'cross-section sampling');
INSERT INTO public.cs7_sampling_type_description VALUES (3, 'Mengbemonstering', 'composite sampling');

CREATE SEQUENCE IF NOT EXISTS public.cs7_sampling_type_description_seq
    INCREMENT 1
    START 4
    MINVALUE 1
    MAXVALUE 1000    
    CACHE 1;    
    
CREATE TABLE IF NOT EXISTS public.cs7_sampling_type_code
(
    id int NOT NULL,
    name character varying(255),
    CONSTRAINT cs7_sampling_type_code_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_sampling_type_code_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_sampling_type_code VALUES (1, 'N/A');       
    
CREATE TABLE IF NOT EXISTS public.cs7_client_authority
(
    id int NOT NULL,
    name character varying(255),
    name_eng character varying(255),
    CONSTRAINT cs7_client_authority_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_client_authority_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_client_authority VALUES (1, 'N/A', 'N/A');
    
CREATE TABLE IF NOT EXISTS public.cs7_sampling_device_description
(
    id int NOT NULL,
    name character varying(255),
    name_eng character varying(255),
    CONSTRAINT cs7_sampling_device_description_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_sampling_device_description_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_sampling_device_description VALUES (1, 'N/A', 'N/A');
INSERT INTO public.cs7_sampling_device_description VALUES (70, 'Roset sampler', 'Rosette sampler');
INSERT INTO public.cs7_sampling_device_description VALUES (46, 'Box-corer', 'Box-corer');
INSERT INTO public.cs7_sampling_device_description VALUES (68, 'Pomp', 'Pump');
    
CREATE TABLE IF NOT EXISTS public.cs7_sampling_device_code
(
    id int NOT NULL,
    name character varying(255),
    CONSTRAINT cs7_sampling_device_code_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_sampling_device_code_seq
    INCREMENT 1
    START 2
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    

INSERT INTO public.cs7_sampling_device_code VALUES (1, 'N/A'); 
    
CREATE TABLE IF NOT EXISTS public.cs7_reference_plane
(
    id int NOT NULL,
    name character varying(255),
    name_eng character varying(255),
    CONSTRAINT cs7_reference_plane_pkey PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_reference_plane_seq
    INCREMENT 1
    START 4
    MINVALUE 1
    MAXVALUE 100
    CACHE 1;    
    
INSERT INTO public.cs7_reference_plane VALUES (1, 'N/A');
INSERT INTO public.cs7_reference_plane VALUES (2, 'WATSGL');
INSERT INTO public.cs7_reference_plane VALUES (3, 'BODM');

CREATE TABLE IF NOT EXISTS public.cs7_rws_data
(
    id int not null,
    coordinate geometry(Point,25831),
    measuring_point_identification_id int,
    location_code_id int,
    magnitude_description_id int,
    magnitude_code_id int,
    parameter_description_id int,
    parameter_code_id int,
    cas_nr_id int,
    unit_code_id int,
    capacity_description_id int,
    capacity_code_id int,
    compartment_description_id int,
    compartment_code_id int,
    valuation_method_description_id int,
    valuation_method_code_id int,
    sampling_type_description_id int,
    sampling_type_code_id int,
    client_authority_id int,
    sampling_device_description_id int,
    sampling_device_code_id int,
    sampling_height int,
    reference_plane_id int,
    value double precision,
    date timestamp without time zone,
    CONSTRAINT cs7_data_pkey PRIMARY KEY (id),
    CONSTRAINT cs7_measuring_point_identification_fkey FOREIGN KEY (measuring_point_identification_id)
        REFERENCES public.cs7_measuring_point_identification (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_location_code_fkey FOREIGN KEY (location_code_id)
        REFERENCES public.cs7_location_code (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_magnitude_description_fkey FOREIGN KEY (magnitude_description_id)
        REFERENCES public.cs7_magnitude_description (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_magnitude_code_fkey FOREIGN KEY (magnitude_code_id)
        REFERENCES public.cs7_magnitude_code (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_parameter_description_fkey FOREIGN KEY (parameter_description_id)
        REFERENCES public.cs7_parameter_description (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_parameter_code_fkey FOREIGN KEY (parameter_code_id)
        REFERENCES public.cs7_parameter_code (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_cas_nr_fkey FOREIGN KEY (cas_nr_id)
        REFERENCES public.cs7_cas_nr (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_unit_code_fkey FOREIGN KEY (unit_code_id)
        REFERENCES public.cs7_unit_code (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_capacity_description_fkey FOREIGN KEY (capacity_description_id)
        REFERENCES public.cs7_capacity_description (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_capacity_code_fkey FOREIGN KEY (capacity_code_id)
        REFERENCES public.cs7_capacity_code (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_compartment_description_fkey FOREIGN KEY (compartment_description_id)
        REFERENCES public.cs7_compartment_description (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_compartment_code_fkey FOREIGN KEY (compartment_code_id)
        REFERENCES public.cs7_compartment_code (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_valuation_method_description_fkey FOREIGN KEY (valuation_method_description_id)
        REFERENCES public.cs7_valuation_method_description (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_valuation_method_code_fkey FOREIGN KEY (valuation_method_code_id)
        REFERENCES public.cs7_valuation_method_code (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_sampling_type_description_fkey FOREIGN KEY (sampling_type_description_id)
        REFERENCES public.cs7_sampling_type_description (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_sampling_type_code_fkey FOREIGN KEY (sampling_type_code_id)
        REFERENCES public.cs7_sampling_type_code (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_client_authority_fkey FOREIGN KEY (client_authority_id)
        REFERENCES public.cs7_client_authority (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_sampling_device_description_fkey FOREIGN KEY (sampling_device_description_id)
        REFERENCES public.cs7_sampling_device_description (id) MATCH SIMPLE
        ON UPDATE NO ACTION,
    CONSTRAINT cs7_reference_plane_fkey FOREIGN KEY (reference_plane_id)
        REFERENCES public.cs7_reference_plane (id) MATCH SIMPLE
        ON UPDATE NO ACTION
);

CREATE SEQUENCE IF NOT EXISTS public.cs7_rws_data_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 10000
    CACHE 1;    

CREATE MATERIALIZED VIEW public.cs7_wgs84_full_properties
 AS
 SELECT 
    id,
    ST_Transform(coordinate, '+proj=utm +zone=31 +ellps=GRS80 +units=m +no_defs +type=crs', '+proj=longlat +datum=WGS84 +no_defs +type=crs') as coordinate,
    (SELECT d.name_eng FROM public.cs7_measuring_point_identification as d 
	  join public.cs7_rws_data as o on d.id = o.measuring_point_identification_id where o.id = cs7_rws_data.id) AS measuring_point_identification,
    (SELECT d.name FROM public.cs7_location_code as d 
	  join public.cs7_rws_data as o on d.id = o.location_code_id where o.id = cs7_rws_data.id) AS location_code,
    (SELECT d.name_eng FROM public.cs7_magnitude_description as d 
	  join public.cs7_rws_data as o on d.id = o.magnitude_description_id where o.id = cs7_rws_data.id) AS magnitude_description,
    (SELECT d.name FROM public.cs7_magnitude_code as d 
	  join public.cs7_rws_data as o on d.id = o.magnitude_code_id where o.id = cs7_rws_data.id) AS magnitude_code,
    (SELECT d.name_eng FROM public.cs7_parameter_description as d 
	  join public.cs7_rws_data as o on d.id = o.parameter_description_id where o.id = cs7_rws_data.id) AS parameter_description,
    (SELECT d.name FROM public.cs7_parameter_code as d 
	  join public.cs7_rws_data as o on d.id = o.parameter_code_id where o.id = cs7_rws_data.id) AS parameter_code,
    (SELECT d.name_eng FROM public.cs7_cas_nr as d 
	  join public.cs7_rws_data as o on d.id = o.cas_nr_id where o.id = cs7_rws_data.id) AS cas_nr,
    (SELECT d.name FROM public.cs7_unit_code as d 
	  join public.cs7_rws_data as o on d.id = o.unit_code_id where o.id = cs7_rws_data.id) AS unit_code,
    (SELECT d.name_eng FROM public.cs7_capacity_description as d 
	  join public.cs7_rws_data as o on d.id = o.capacity_description_id where o.id = cs7_rws_data.id) AS capacity_description,
    (SELECT d.name FROM public.cs7_capacity_code as d 
	  join public.cs7_rws_data as o on d.id = o.capacity_code_id where o.id = cs7_rws_data.id) AS capacity_code,
    (SELECT d.name_eng FROM public.cs7_compartment_description as d 
	  join public.cs7_rws_data as o on d.id = o.compartment_description_id where o.id = cs7_rws_data.id) AS compartment_description,
    (SELECT d.name FROM public.cs7_compartment_code as d 
	  join public.cs7_rws_data as o on d.id = o.compartment_code_id where o.id = cs7_rws_data.id) AS compartment_code,
    (SELECT d.name_eng FROM public.cs7_valuation_method_description as d 
	  join public.cs7_rws_data as o on d.id = o.valuation_method_description_id where o.id = cs7_rws_data.id) AS valuation_method_description,
    (SELECT d.name FROM public.cs7_valuation_method_code as d 
	  join public.cs7_rws_data as o on d.id = o.valuation_method_code_id where o.id = cs7_rws_data.id) AS valuation_method_code,
    (SELECT d.name_eng FROM public.cs7_sampling_type_description as d 
	  join public.cs7_rws_data as o on d.id = o.sampling_type_description_id where o.id = cs7_rws_data.id) AS sampling_type_description,
    (SELECT d.name FROM public.cs7_sampling_type_code as d 
	  join public.cs7_rws_data as o on d.id = o.sampling_type_code_id where o.id = cs7_rws_data.id) AS sampling_type_code,
    (SELECT d.name_eng FROM public.cs7_client_authority as d 
	  join public.cs7_rws_data as o on d.id = o.client_authority_id where o.id = cs7_rws_data.id) AS client_authority,
    (SELECT d.name_eng FROM public.cs7_sampling_device_description as d 
	  join public.cs7_rws_data as o on d.id = o.sampling_device_description_id where o.id = cs7_rws_data.id) AS sampling_device_description,
    (SELECT d.name_eng FROM public.cs7_reference_plane as d 
	  join public.cs7_rws_data as o on d.id = o.reference_plane_id where o.id = cs7_rws_data.id) AS reference_plane,
    value,
    date
   FROM cs7_rws_data;    

CREATE OR REPLACE FUNCTION ST_Cs7RwsDataToGeoJson()
RETURNS jsonb AS
$BODY$
    SELECT jsonb_build_object(
        'type',     'FeatureCollection',
        'features', jsonb_agg(feature)
    )
    FROM (
      SELECT jsonb_build_object(
        'type',       'Feature',
        'id',         row.id,
        'geometry',   ST_AsGeoJSON(coordinate)::jsonb,
        'properties', to_jsonb(row) - 'id' - 'coordinate'
      ) AS feature
      FROM (SELECT * FROM public.cs7_wgs84_full_properties) row) features;
$BODY$
LANGUAGE SQL;