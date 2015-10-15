alter table users drop constraint FKp56c1712k691lhsyewcssf40f
alter table users drop constraint FK8k0h2vd2owoqn5wmo74ajf6o4
drop table if exists roles cascade
drop table if exists userinfo cascade
drop table if exists users cascade
drop sequence hibernate_sequence
