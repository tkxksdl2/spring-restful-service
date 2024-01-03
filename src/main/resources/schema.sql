insert into user_detail(id,birth_date,name)
values (10001, current_date(), 'kim');
insert into user_detail(id,birth_date,name)
values (10002, current_date(), 'Kan');
insert into user_detail(id,birth_date,name)
values (10003, current_date(), 'kon');


insert into post(id, description, user_id)
values (100, 'hello', 10002);
insert into post(id, description, user_id)
values (101, 'mindo', 10001);
insert into post(id, description, user_id)
values (103, 'Delete Me', 10003);
insert into post(id, description, user_id)
values (104, 'I don''t care', 10001);

