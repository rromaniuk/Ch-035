DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;


CREATE TABLE users
(
  id         SERIAL PRIMARY KEY,
  name       VARCHAR,
  lastname       VARCHAR,
  email      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL
);
CREATE UNIQUE INDEX unique_email ON USERS (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);