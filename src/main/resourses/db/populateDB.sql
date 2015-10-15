DELETE FROM users;
DELETE FROM roles;
DELETE FROM userinfo;

ALTER SEQUENCE roles_id_seq  RESTART WITH 1;
ALTER SEQUENCE userinfo_id_seq RESTART WITH 1;
ALTER SEQUENCE users_id_seq  RESTART WITH 1;

INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_STUDENT');
INSERT INTO roles (name) VALUES ('ROLE_TEACHER');
INSERT INTO roles (name) VALUES ('ROLE_MANAGER');
INSERT INTO roles (name) VALUES ('ROLE_ANONYMOUS');

INSERT INTO userinfo (first_name, last_name) VALUES ('Admin', 'Adminov');
INSERT INTO userinfo (first_name, last_name) VALUES ('Student', 'Studentov');
INSERT INTO userinfo (first_name, last_name) VALUES ('Teacher', 'Teacherov');
INSERT INTO userinfo (first_name, last_name) VALUES ('Manager', 'Managerov');
INSERT INTO userinfo (first_name, last_name) VALUES ('Anonym', 'Anonymov');

INSERT INTO users (email, password, user_info_id, role_id) VALUES ( 'admin@gmail.com', 'admin', 1, 1);
INSERT INTO users (email, password, user_info_id, role_id) VALUES ('student@gmail.com', 'student', 2, 2);
INSERT INTO users (email, password, user_info_id, role_id) VALUES ('teacher@gmail.com', 'teacher', 3, 3);
INSERT INTO users (email, password, user_info_id, role_id) VALUES ('manager@gmail.com', 'manager', 4, 4);
INSERT INTO users (email, password, user_info_id, role_id) VALUES ('anonymous@gmail.com', 'anonymous', 5, 5);