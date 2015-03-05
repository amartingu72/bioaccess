-- create database bioaccess;

-- Zonas. Almacena los festivos por c�digo postal.
-- locations (id,country, zipcode, date)
create table locations (
	id int AUTO_INCREMENT PRIMARY KEY,
	country int not null comment 'C�digo de pa�s seg�n ISO_3166-1. Espa�a: 724',
	zipcode varchar(5) not null comment 'C�digo postal',
	date timestamp not null
);

-- Instalaciones. Almacena las intalaciones de una empresa
-- facilities (id,name,description, last_test, zipcode)
create table facilities (
	id int AUTO_INCREMENT PRIMARY KEY,
	name varchar(32) not null comment 'Nombre de la instalaci�n.',
	descripci�n varchar(256) comment 'Descripci�n. Normalmente incluir� la direcci�n y tel�fonos de contacto.',
	last_test timestamp comment 'Fecha en que se realiz� el �ltimo test a los controladores de acceso de la instalaci�n.',
	zipcode varchar(5) not null comment 'C�digo postal. Determina los festivos que correspondier�a a esta instalaci�n'
);

-- Usuarios de la compa��a
-- users (id,name, surname1, surname2, dni, is_locked)
-- Las fotograf�as no se almacenar�n en base de datos.
create table users (
  id int AUTO_INCREMENT PRIMARY KEY,
  name varchar(32) not null comment 'Nombre',
  surname1 varchar(32) not null comment 'Primer apellido',
  surname2 varchar(32) comment 'Segundo apellido, si tiene.',
  dni varchar(9) comment 'DNI o NIE',
  is_locked tinyint not null default 0 comment 'Indicador de usuario bloqueado. Por defecto no lo est�'
);


-- Relaci�n entre cada usuario y las caracter�sticas recogidas para su identificaci�n: huella, tarjeta RFID...
-- users_features(id_user, id_feature)
create table users_features (
  id int AUTO_INCREMENT PRIMARY KEY,
  user_id int not null comment 'Identificador de usuario',
  feature_id int not null comment 'Caracter�stica: 0, huella; 1, tarjeta RFID', 
  FOREIGN KEY (user_id) references users(id)
);

-- �reas en que se descompone cada instalaci�n.
-- areas(id,name, description,parent_id,facility_id)
create table areas (
  id int AUTO_INCREMENT PRIMARY KEY,
  name varchar(32) not null comment 'Nombre del �rea',
  description varchar(256) comment 'Normalmente, indicaciones de ubicaci�n del �rea en la oficina',
  parent int comment'Identificador de �rea padre.',
  facility_id int not null comment 'Identificador de instalaci�n a la que pertenece el �rea',
  FOREIGN KEY (facility_id) references facilities(id)
);

-- Controladres de acceso
create table access_ctrls (
  id int AUTO_INCREMENT PRIMARY KEY,
  name varchar(32) not null comment 'Nombre del controlador (hostname).',
  ip varchar(15) comment 'IP. Si no se indica debe indicarse hostname.',
  description varchar(256) comment 'Normalmente, indicaciones de ubicaci�n en la instalaci�n',
  status int not null default 0 comment 'C�digo de error:0(ok), 1(error interno), 2(sin conexi�n)',
  area_id int not null comment 'Identificador del �rea de la instalaci�n donde est� ubicado.',
  is_exit tinyint not null default 0 comment 'Indica si el controlador regula una salida de la instalaci�n.',
  FOREIGN KEY (area_id) references areas(id)
);



-- Perfiles de acceso. 
-- profiles(id,title, start, end, availability,holiday_ck, is_guest)
create table profiles(
  id int AUTO_INCREMENT PRIMARY KEY,
  title varchar(32) not null comment 'Nombre del perfil',
  start varchar(4) not null comment 'Hora (HHMM), a partir de la cual se permite el acceso',
  end  varchar(4) not null comment 'Hora (HHMM), a partir de la cual ya no se permite el acceso',
  availability varchar(7) comment 'D�as de la semana en que se permite acceso. Cada posici�n es un d�a. 0 inidica no acceso y 1 indica acceso', 
  holiday_ck tinyint not null default 1 comment 'Indicador de si debe excluir festivos. Por defecto, si', 
  is_guest tinyint not null default 0 comment 'Indicador de visita. Defecto no es vista.' 
);

-- Relaci�n de �reas y perfiles de acceso
create table areas_profiles(
  id int AUTO_INCREMENT PRIMARY KEY,
  area_id int not null comment 'Identificador de �rea',
  profile_id int not null comment 'Identificador de perfil',
  FOREIGN KEY (area_id) references areas(id),
  FOREIGN KEY (profile_id) references profiles(id)
);

-- Relaci�n usuario perfiles. Cuando hay caducidad, se consideran perfiles de excepci�n.
-- Un usuario tendr� un perfil por instalaci�n. Puede tener un perfil excepcional pero llevar� caducidad.
create table users_profiles(
  id int AUTO_INCREMENT PRIMARY KEY,
  profile_id int not null comment 'Identificador de perfile', 
  user_id int not null comment 'Identificador de usuario', 
  start timestamp null comment 'Entrada en vigor. Solo para perfiles de excepci�n', 
  end timestamp null comment'Caducidad. Solo para perfiles de excepci�n',
  FOREIGN KEY (profile_id) references profiles(id),
  FOREIGN KEY (user_id) references users(id)
);
-- Registro de entradas y salidas
create table records(
  id int AUTO_INCREMENT PRIMARY KEY,
  area_id int not null comment 'Identificador de �rea', 
  user_id int not null comment 'Identificador de usuario', 
  crossing_date timestamp not null comment 'Fecha y hora de entrada/salida del usuario en el �rea',
  action_type tinyint not null comment '0, entrada; 1, salida',
  is_guest tinyint not null default 0 comment 'Indica si esl usuario accedi� a �rea como visita',
  FOREIGN KEY (area_id) references areas(id),
  FOREIGN KEY (user_id) references users(id),
  index record_idx00 (area_id,user_id)
);
  
-- Administradores
create table admins(
  id int AUTO_INCREMENT PRIMARY KEY,
  name varchar(32) not null comment 'Nombre',
  surname1 varchar(32) not null comment 'Primer apellido',
  surname2 varchar(32) comment 'Segundo apellido, si tiene.',
  email varchar(64) not null comment 'Correo',
  is_cia_admin tinyint not null default 0 comment 'Indicador de si es administrador de compa��a. Por defecto, no(0)'
);

create table admins_facilities(
  id int AUTO_INCREMENT PRIMARY KEY,
  admin_id int not null comment 'Identificador de administrador',
  facility_id int not null comment 'Identificador de instalaci�n',
  FOREIGN KEY (admin_id) references admins(id),
  FOREIGN KEY (facility_id) references facilities(id)
);