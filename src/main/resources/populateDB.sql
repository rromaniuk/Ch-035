DELETE FROM roles;
DELETE FROM userinfo;
DELETE FROM users;

INSERT INTO users (email, password, isenabled) VALUES ( 'admin@gmail.com', 'admin', true);
INSERT INTO users (email, password, isenabled) VALUES ('student@gmail.com', 'student', true);
INSERT INTO users (email, password, isenabled) VALUES ('teacher@gmail.com', 'teacher', true);
INSERT INTO users (email, password, isenabled) VALUES ('manager@gmail.com', 'manager', true);
INSERT INTO users (email, password, isenabled) VALUES ('anonymous@gmail.com', 'anonymous', true);

INSERT INTO roles (name, user_id) VALUES ('ADMIN', 1);
INSERT INTO roles (name, user_id) VALUES ('STUDENT', 2);
INSERT INTO roles (name, user_id) VALUES ('TEACHER', 3);
INSERT INTO roles (name, user_id) VALUES ('MANAGER', 4);
INSERT INTO roles (name, user_id) VALUES ('ANONYMOUS', 5);

INSERT INTO userinfo (first_name, last_name, user_id) VALUES ('Admin', 'Adminov', 1);
INSERT INTO userinfo (first_name, last_name, user_id) VALUES ('Student', 'Studentov', 2);
INSERT INTO userinfo (first_name, last_name, user_id) VALUES ('Teacher', 'Teacherov', 3);
INSERT INTO userinfo (first_name, last_name, user_id) VALUES ('Manager', 'Managerov', 4);
INSERT INTO userinfo (first_name, last_name, user_id) VALUES ('Anonym', 'Anonymov', 5);



