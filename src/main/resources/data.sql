DELETE FROM role;
INSERT INTO role (`id`,`description`, `name`) VALUES (1,'Admin role', 'ADMIN');
INSERT INTO role (`id`,`description`, `name`) VALUES (2,'Manager role', 'MANAGER');
INSERT INTO role (`id`,`description`, `name`) VALUES (3,'Employee role', 'EMPLOYEE');
DELETE FROM task_status_lu;
INSERT INTO task_status_lu(`id`,`description`,`statusname`)
values (1,'pending','pending');
INSERT INTO task_status_lu(`id`,`description`,`statusname`)
values (2,'working','working');
INSERT INTO task_status_lu(`id`,`description`,`statusname`)
values (3,'completed','completed');
