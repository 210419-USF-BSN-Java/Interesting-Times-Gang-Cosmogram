-- cosmogram.user_role definition

-- Drop table

-- DROP TABLE cosmogram.user_role;

CREATE TABLE cosmogram.user_role (
	role_id serial NOT NULL,
	role_name varchar(20) NOT NULL,
	CONSTRAINT user_role_pkey PRIMARY KEY (role_id)
);








-- cosmogram.tag definition

-- Drop table

-- DROP TABLE cosmogram.tag;

CREATE TABLE cosmogram.tag (
	tag_id serial NOT NULL,
	tag_name varchar(20) NOT NULL,
	CONSTRAINT tag_pkey PRIMARY KEY (tag_id)
);










-- cosmogram.cosmo_user definition

-- Drop table

-- DROP TABLE cosmogram.cosmo_user;

CREATE TABLE cosmogram.cosmo_user (
	user_id serial NOT NULL,
	username varchar(20) NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	"password" varchar(20) NOT NULL,
	role_id int4 NOT NULL,
	logged_on bool NULL,
	session_token varchar(128) NULL,
	CONSTRAINT cosmo_user_pkey PRIMARY KEY (user_id),
	CONSTRAINT cosmo_user_username_key UNIQUE (username)
);


-- cosmogram.cosmo_user foreign keys

ALTER TABLE cosmogram.cosmo_user ADD CONSTRAINT cosmo_user_role_id_fkey FOREIGN KEY (role_id) REFERENCES cosmogram.user_role(role_id) on delete cascade;













-- cosmogram.album definition

-- Drop table

-- DROP TABLE cosmogram.album;

CREATE TABLE cosmogram.album (
	album_id serial NOT NULL,
	album_name varchar(20) NOT NULL,
	user_id int4 NOT NULL,
	CONSTRAINT album_pkey PRIMARY KEY (album_id)
);


-- cosmogram.album foreign keys

ALTER TABLE cosmogram.album ADD CONSTRAINT album_user_id_fkey FOREIGN KEY (user_id) REFERENCES cosmogram.cosmo_user(user_id) on delete cascade;









-- cosmogram.album_junction definition

-- Drop table

-- DROP TABLE cosmogram.album_junction;

CREATE TABLE cosmogram.album_junction (
	album_junct_id serial primary key,
	album_id int4 NOT NULL,
	image_date date NOT NULL
);


-- cosmogram.album_junction foreign keys

ALTER TABLE cosmogram.album_junction ADD CONSTRAINT album_junction_album_id_fkey FOREIGN KEY (album_id) REFERENCES cosmogram.album(album_id) on delete cascade;


-- cosmogram.rating definition

-- Drop table

-- DROP TABLE cosmogram.rating;

CREATE TABLE cosmogram.rating (
	rating_id serial NOT NULL,
	rating_value numeric(1) NOT NULL,
	image_date date NOT NULL,
	user_id int4 NOT NULL,
	CONSTRAINT rating_pkey PRIMARY KEY (rating_id)
);


-- cosmogram.rating foreign keys

ALTER TABLE cosmogram.rating ADD CONSTRAINT rating_user_id_fkey FOREIGN KEY (user_id) REFERENCES cosmogram.cosmo_user(user_id) on delete cascade;


-- cosmogram.tag_junction definition

-- Drop table

-- DROP TABLE cosmogram.tag_junction;

CREATE TABLE cosmogram.tag_junction (
	tag_id int4 NOT NULL,
	image_date date NOT NULL,
	tj_id serial NOT NULL,
	CONSTRAINT tag_junction_pkey PRIMARY KEY (tj_id)
);


-- cosmogram.tag_junction foreign keys

ALTER TABLE cosmogram.tag_junction ADD CONSTRAINT tag_junction_tag_id_fkey FOREIGN KEY (tag_id) REFERENCES cosmogram.tag(tag_id) on delete cascade;



insert into cosmogram.user_role values
(1, 'User'),
(2, 'Moderator');

insert into cosmogram.cosmo_user values
(1, 'username1' ,'firstname', 'lastname', '1234', 1, false),
(2, 'username2', 'secondname', 'secondname', '1234', 1, false),
(3, 'moduser1', 'firstname', 'lastname', '1234', 1, false);

insert into cosmogram.album values 
(1, 'album1', 1),
(2, 'album2', 1),
(3, 'album3', 2),
(4, 'album4', 2),
(5, 'album5', 3),
(6, 'album6', 3);

insert into cosmogram.album_junction values 
(1, 1, '2001-12-01'),
(2, 2, '2001-12-02'),
(3, 2, '2001-12-03'),
(4, 3, '2001-12-04'),
(5, 3, '2001-12-05'),
(6, 4, '2001-12-04'),
(7, 5, '2001-12-05');

insert into cosmogram.rating values
(1, 1, '2001-12-01', 1),
(2, 2, '2001-12-01', 2);

insert into cosmogram.tag values
(1, 'planet'),
(2, 'moon'),
(3, 'nebula');

insert into cosmogram.tag_junction values
(1, '2001-12-01', 1),
(2, '2001-12-02', 2),
(3, '2001-12-03', 3);

truncate cosmogram.cosmo_user;
truncate cosmogram.album;

-- truncate cosmogram.tag_junction;
-- truncate cosmogram.album_junction;
-- truncate cosmogram.rating;

drop table force cosmogram.album;