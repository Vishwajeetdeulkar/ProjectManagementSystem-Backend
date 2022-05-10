DELETE FROM role;
INSERT IGNORE INTO role (`id`,`description`, `name`) VALUES (1,'Admin role', 'ADMIN');
INSERT IGNORE INTO role (`id`,`description`, `name`) VALUES (2,'Manager role', 'MANAGER');
INSERT IGNORE INTO role (`id`,`description`, `name`) VALUES (3,'Employee role', 'EMPLOYEE');
DELETE FROM task_status_lu;
INSERT IGNORE INTO task_status_lu(`id`,`description`,`statusname`)
values (1,'pending','pending');
INSERT IGNORE INTO task_status_lu(`id`,`description`,`statusname`)
values (2,'working','working');
INSERT IGNORE INTO task_status_lu(`id`,`description`,`statusname`)
values (3,'completed','completed');
