create sequence hibernate_sequence start 1 increment 1
create table roles (id int8 not null, name varchar(255) not null, primary key (id))
create table userinfo (id int8 not null, first_name varchar(255) not null, last_name varchar(255) not null, primary key (id))
create table users (id int8 not null, email varchar(255) not null, password varchar(255) not null, role_id int8 not null, user_info_id int8 not null, primary key (id))
alter table users add constraint UK_6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles
alter table users add constraint FK8k0h2vd2owoqn5wmo74ajf6o4 foreign key (user_info_id) references userinfo
