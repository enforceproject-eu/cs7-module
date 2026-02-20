UPDATE cs7_reference_plane
 SET name_eng = 'N/A' where id = 1;

UPDATE cs7_reference_plane
 SET name_eng = 'WATSGL' where id = 2;

UPDATE cs7_reference_plane
 SET name_eng = 'BODM' where id = 3;
 
UPDATE cs7_compartment_description
 SET name_eng = 'Surface water' where id = 2;
 
UPDATE cs7_compartment_description
 SET name_eng = 'Soil/sediment' where id = 3;
