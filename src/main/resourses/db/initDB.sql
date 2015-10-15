DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS userinfo;


CREATE TABLE userinfo
(
  id			SERIAL PRIMARY KEY,
  first_name 	VARCHAR,
  last_name 	VARCHAR
);

CREATE TABLE roles
(
  id		SERIAL PRIMARY KEY,
  name    	VARCHAR
);

CREATE TABLE users
(
  id         	SERIAL PRIMARY KEY,
  user_info_id  INTEGER NOT NULL,
  role_id		INTEGER NOT NULL,
  email      	VARCHAR NOT NULL,
  password   	VARCHAR NOT NULL,
  FOREIGN KEY (user_info_id) REFERENCES userinfo (id) ON DELETE CASCADE,
  FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE RESTRICT
);