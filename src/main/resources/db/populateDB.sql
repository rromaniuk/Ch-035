DELETE FROM roles;
DELETE FROM userinfo;
DELETE FROM users;

ALTER SEQUENCE roles_id_seq  RESTART WITH 1;
ALTER SEQUENCE userinfo_id_seq RESTART WITH 1;
ALTER SEQUENCE users_id_seq  RESTART WITH 1;

INSERT INTO users (email, password, user_info_id, role_id) VALUES ( 'admin@gmail.com', 'admin', 1, 1);
INSERT INTO users (email, password, user_info_id, role_id) VALUES ('student@gmail.com', 'student', 2, 2);
INSERT INTO users (email, password, user_info_id, role_id) VALUES ('teacher@gmail.com', 'teacher', 3, 3);
INSERT INTO users (email, password, user_info_id, role_id) VALUES ('manager@gmail.com', 'manager', 4, 4);
INSERT INTO users (email, password, user_info_id, role_id) VALUES ('anonymous@gmail.com', 'anonymous', 5, 5);

INSERT INTO roles (name, user_id) VALUES ('ROLE_ADMIN', 1);
INSERT INTO roles (name, user_id) VALUES ('ROLE_STUDENT', 2);
INSERT INTO roles (name, user_id) VALUES ('ROLE_TEACHER', 3);
INSERT INTO roles (name, user_id) VALUES ('ROLE_MANAGER', 4);
INSERT INTO roles (name, user_id) VALUES ('ROLE_ANONYMOUS', 5);

INSERT INTO userinfo (first_name, last_name, user_id) VALUES ('Admin', 'Adminov', 1);
INSERT INTO userinfo (first_name, last_name, user_id) VALUES ('Student', 'Studentov', 2);
INSERT INTO userinfo (first_name, last_name, user_id) VALUES ('Teacher', 'Teacherov', 3);
INSERT INTO userinfo (first_name, last_name, user_id) VALUES ('Manager', 'Managerov', 4);
INSERT INTO userinfo (first_name, last_name, user_id) VALUES ('Anonym', 'Anonymov', 5);

