DELETE FROM user_roles;
DELETE FROM users;

INSERT INTO users (id, name, lastName, email, password) VALUES (1, 'admin', 'adminLastName', 'admin@gmail.com', 'admin');
INSERT INTO users (id, name, lastName, email, password) VALUES (2, 'student', 'studentLastName', 'student@gmail.com', 'student');


INSERT INTO user_roles (role, user_id ) VALUES ('ROLE_ADMIN', 1);
INSERT INTO user_roles (role, user_id) VALUES ('ROLE_STUDENT', 2);