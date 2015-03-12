-- Juego de datos.
-- Carga de festivos Pozuelo de Alarcón para 2015
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20150101');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20150106');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20150319');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20150402');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20150403');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20150501');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20150502');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20150604');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20150716');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20150815');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20150907');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20151012');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20151208');
INSERT INTO locations (country,zipcode,date) VALUES (724,'28223','20151225');
--Creación de una instalación
INSERT INTO facilities (name, description, last_test, zipcode) VALUES ( 'Pozuelo de Alarcón', 'Cerro de los Gamos, 1 edificio 6 1ªPlanta  91 183 03 00',null,'28224');
-- Creación del administrador de compañía root
INSERT INTO admins (name, surname1, surname2, email, pwd, is_cia_admin) VALUES ('root','root','root','root@vector-itcgroup.com','r',1);
-- Creación del administrador de local
INSERT INTO admins (name, surname1, surname2, email, pwd, is_cia_admin) VALUES ('Alberto','Martín','Gutiérrez','amarting@vector-itcgroup.com','a',0);
-- Vinculación admin local con instalación.
NSERT INTO admins_facilities (admin_id, facility_id) VALUES (2,1);
-- Creación de áreas para Pozuelo de Alarcón: parking, edificio CPD1, CPD2, CPD3, Dirección
INSERT INTO areas(name, description, parent, facility_id) VALUES('PARK01', 'Sótano -1', 0, 1);
INSERT INTO areas(name, description, parent, facility_id) VALUES('EDIF01', 'Edificio principal', 0, 1);
INSERT INTO areas(name, description, parent, facility_id) VALUES('CPD01', 'Centro de cálculo planta 1', 2, 1);
INSERT INTO areas(name, description, parent, facility_id) VALUES('CPD02', 'Centro de cálculo planta 2', 2, 1);
INSERT INTO areas(name, description, parent, facility_id) VALUES('CPD03', 'Centro de cálculo planta 3', 2, 1);
-- Creción de controladores de acceso para las áreas de Pozuelo de Alarcón
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('PARK_ENT_DESDE_CALLE', '172.3.4.234', 'Parking. Acceso desde la calle', 0, 1,0);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('PARK_SAL_A_CALLE', '172.3.4.234', 'Parking. Salida a la calle', 0, 1,1);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('PARK_ENT_DESDE_EDIFICIO', '', 'Parking. Acceso desde edificio', 0, 1,0);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('EDF_ENT_HALL01', '', 'Edificio. Entrada desde calle. Hall 01', 0, 2,0);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('EDF_ENT_HALL02', '', 'Edificio. Entrada desde calle. Hall 02', 0, 2,0);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('EDF_ENT_HALL03', '', 'Edificio. Entrada desde calle. Hall 03', 0, 2,0);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('EDF_ENT_HALL04', '', 'Edificio. Entrada desde calle. Hall 04', 0, 2,0);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('EDF_SAL_HALL01', '', 'Edificio. Salida a calle. Hall 01', 0, 2,1);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('EDF_SAL_HALL02', '', 'Edificio. Salida a calle. Hall 02', 0, 2,1);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('EDF_SAL_HALL03', '', 'Edificio. Salida a calle. Hall 03', 0, 2,1);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('EDF_SAL_HALL04', '', 'Edificio. Salida a  calle. Hall 04', 0, 2,1);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('CPD01_ENT', '', 'CPD 01. Entrada a CPD 1 desde edificio', 0, 3,0);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('CPD01_SAL', '', 'CPD 01. Salida de CPD 1 a edificio', 0, 3,1);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('CPD02_ENT', '', 'CPD 02. Entrada a CPD 2 desde edificio', 0, 4,0);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('CPD02_SAL', '', 'CPD 02. Salida de CPD 2 a edificio', 0, 4,1);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('CPD03_ENT', '', 'CPD 03. Entrada a CPD 3 desde edificio', 0, 5,0);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('CPD03_SAL', '', 'CPD 03. Salida de CPD 3 a edificio', 0, 5,1);
INSERT INTO access_ctrls (name, ip, description, status, area_id, is_exit) VALUES ('EDF_ENT_PARKING', '', 'Edificio. Entrada desde parking', 0, 2,0);


-- Perfiles
INSERT INTO profiles (title, start, end, availability,holiday_ck,is_guest) VALUES ( 'POZUELO_INVIERNO', '0730', '2030', '1111100', 1, 0);
INSERT INTO profiles (title, start, end, availability,holiday_ck,is_guest) VALUES ( 'POZUELO_INVIERNO_CPD1', '0730', '2030', '1111100', 1, 0);
INSERT INTO profiles (title, start, end, availability,holiday_ck,is_guest) VALUES ( 'POZUELO_INVIERNO_CPD2', '0730', '2030', '1111100', 1, 0);
INSERT INTO profiles (title, start, end, availability,holiday_ck,is_guest) VALUES ( 'POZUELO_INVIERNO_CPD1_CPD3', '0730', '2030', '1111100', 1, 0);
INSERT INTO profiles (title, start, end, availability,holiday_ck,is_guest) VALUES ( 'POZUELO_INVIERNO_PARKING', '0730', '2030', '1111100', 1, 0);
INSERT INTO profiles (title, start, end, availability,holiday_ck,is_guest) VALUES ( 'POZUELO_VERANO', '0730', '1630', '1111100', 1, 0);
INSERT INTO profiles (title, start, end, availability,holiday_ck,is_guest) VALUES ( 'POZUELO_VISITA', '0730', '2030', '1111100', 1, 1);
INSERT INTO profiles (title, start, end, availability,holiday_ck,is_guest) VALUES ( '24x7', '0000', '2359', '1111111', 0, 0);

--Vinculación perfiles a áreas de la instalación de Pozuelo de Alarcón.
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (2, 1);
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (2, 2);
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (2, 3);
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (2, 4);
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (2, 5);
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (3, 5);
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (2, 6);
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (4, 6);
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (2, 7);
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (3, 7);
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (5, 7);
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (1, 8);
INSERT INTO areas_profiles (area_id,profile_id ) VALUES (2, 8);

--Usuarios. Ninguno bloqueado.
INSERT INTO users ( name, surname1, surname2, dni, is_locked) VALUES ( 'User00001', 'Apll1_user00001', 'Apll2User0001', '89185362X', 0);
INSERT INTO users ( name, surname1, surname2, dni, is_locked) VALUES ( 'User00002', 'Apll1_user00002', 'Apll2User0002', '41775950S', 0);
INSERT INTO users ( name, surname1, surname2, dni, is_locked) VALUES ( 'User00003', 'Apll1_user00003', 'Apll2User0003', '28262384F', 0);
INSERT INTO users ( name, surname1, surname2, dni, is_locked) VALUES ( 'User00004', 'Apll1_user00004', 'Apll2User0004', '23535771D', 0);
INSERT INTO users ( name, surname1, surname2, dni, is_locked) VALUES ( 'User00005', 'Apll1_user00005', 'Apll2User0005', '89165068W', 0);
INSERT INTO users ( name, surname1, surname2, dni, is_locked) VALUES ( 'User00006', 'Apll1_user00006', 'Apll2User0006', '88326341Q', 0);
INSERT INTO users ( name, surname1, surname2, dni, is_locked) VALUES ( 'User00007', 'Apll1_user00007', 'Apll2User0007', '62886965C', 0);
INSERT INTO users ( name, surname1, surname2, dni, is_locked) VALUES ( 'User00008', 'Apll1_user00008', 'Apll2User0008', '54593480J', 0);
INSERT INTO users ( name, surname1, surname2, dni, is_locked) VALUES ( 'User00009', 'Apll1_user00009', 'Apll2User0009', '13015076C', 0);
INSERT INTO users ( name, surname1, surname2, dni, is_locked) VALUES ( 'User00010', 'Apll1_user00010', 'Apll2User0010', '22356159K', 0);

-- Relación entre usuarios y las características biométricas capturadas de cada uno.
-- Los cinco primeros tienes RFID además de huella.
INSERT INTO users_features (user_id, feature_id) VALUES (1,0);
INSERT INTO users_features (user_id, feature_id) VALUES (1,1);
INSERT INTO users_features (user_id, feature_id) VALUES (2,0);
INSERT INTO users_features (user_id, feature_id) VALUES (2,1);
INSERT INTO users_features (user_id, feature_id) VALUES (3,0);
INSERT INTO users_features (user_id, feature_id) VALUES (3,1);
INSERT INTO users_features (user_id, feature_id) VALUES (4,0);
INSERT INTO users_features (user_id, feature_id) VALUES (4,1);
INSERT INTO users_features (user_id, feature_id) VALUES (5,0);
INSERT INTO users_features (user_id, feature_id) VALUES (5,1);
INSERT INTO users_features (user_id, feature_id) VALUES (6,0);
INSERT INTO users_features (user_id, feature_id) VALUES (7,0);
INSERT INTO users_features (user_id, feature_id) VALUES (8,0);
INSERT INTO users_features (user_id, feature_id) VALUES (9,0);
INSERT INTO users_features (user_id, feature_id) VALUES (10,0);

-- Relación entre usuarios y perfiles.
-- 1 a 4: POZUELO_INVIERNO
INSERT INTO users_profiles (profile_id, user_id, start,end)  VALUES  ( 1, 1, null, null);
INSERT INTO users_profiles (profile_id, user_id, start,end)  VALUES  ( 1, 2, null, null);
INSERT INTO users_profiles (profile_id, user_id, start,end)  VALUES  ( 1, 3, null, null);
INSERT INTO users_profiles (profile_id, user_id, start,end)  VALUES  ( 1, 4, null, null);
-- 4 con perfil excepcional 24x7
INSERT INTO users_profiles (profile_id, user_id, start,end)  VALUES  ( 1, 4, '2015-03-05', '2015-04-05');
-- 5 con POZUELO_INVIERNO_CPD1
INSERT INTO users_profiles (profile_id, user_id, start,end)  VALUES  ( 5, 5, null, null);
-- 6 con POZUELO_INVIERNO_CPD2
INSERT INTO users_profiles (profile_id, user_id, start,end)  VALUES  ( 6, 6, null, null);
-- 7 con POZUELO_INVIERNO_CPD1_CPD3
INSERT INTO users_profiles (profile_id, user_id, start,end)  VALUES  ( 7, 7, null, null);
-- 8 con 24x7
INSERT INTO users_profiles (profile_id, user_id, start,end)  VALUES  ( 4, 8, null, null);
-- 9 y 10:POZUELO_INVIERNO_PARKING
INSERT INTO users_profiles (profile_id, user_id, start,end)  VALUES  ( 8, 9, null, null);
INSERT INTO users_profiles (profile_id, user_id, start,end)  VALUES  ( 8, 10, null, null);