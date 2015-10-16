DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS userinfo;
DROP TABLE IF EXISTS users;

CREATE TABLE users
(
  id         	SERIAL PRIMARY KEY,
  email      	VARCHAR NOT NULL,
  password   	VARCHAR NOT NULL,
  enabled		BOOL DEFAULT TRUE,
  role_id		INTEGER NOT NULL,
  user_info_id  INTEGER NOT NULL
);

CREATE TABLE userinfo
(
  id			SERIAL PRIMARY KEY,
  first_name 	VARCHAR,
  last_name 	VARCHAR,
  user_id	INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE roles
(
  id		SERIAL PRIMARY KEY,
  name    	VARCHAR,
  user_id	INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);


