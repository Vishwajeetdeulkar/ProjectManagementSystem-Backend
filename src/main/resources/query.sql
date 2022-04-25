drop table if exists role;
drop table if exists user;
drop table if exists user_roles;
create table role (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id)) engine=MyISAM;
create table user_roles (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id)) engine=MyISAM;


INSERT INTO role (id, description, name) VALUES (1, 'Admin role', 'ADMIN');
INSERT INTO role (id, description, name) VALUES (2, 'Manager role', 'MANAGER');
INSERT INTO role (id, description, name) VALUES (3, 'Employee role', 'EMPLOYEE');

