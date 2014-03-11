insert into users (username, password, enabled) values ('admin', '123', true);
insert into users (username, password, enabled) values ('test', 'test.11', true);

insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('admin', 'ROLE_USER');
insert into authorities (username, authority) values ('admin', 'ROLE_MODERATOR');

insert into authorities (username, authority) values ('test', 'ROLE_USER');

insert into productcategory (category_name) values ('test');
insert into productcategory (category_name) values ('test2');