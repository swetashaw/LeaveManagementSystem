/*-Insert inot users value-*/

insert into user (user_id,active,email,first_name,last_name, role,user_name) values ('1','F','abc@hcl.com','sweta','shaw','admin','swetashaw');
insert into user (user_id,active,email,first_name,last_name, role,user_name) values ('2','T','anup@hcl.com','anup','kmar','admin','anup');
insert into user (user_id,active,email,first_name,last_name, role,user_name) values ('3','T','swetashaw@hcl.com','sweta','shaw','user','sweta');
/*-Insert inot Leave Request value-*/


insert into user_leaves(id,Quantity,employee_name,leave_type,user_id) values ('3','16','Sweta Shaw','Casual',3);
insert into user_leaves(id,Quantity,employee_name,leave_type,user_id) values ('1','16','Sweta Shaw','Sick',3);
insert into user_leaves(id,Quantity,employee_name,leave_type,user_id) values ('2','16','Sweta Shaw','RH',3);

insert into leave_request (id,accept_reject_flag,employee_name,from_date,leave_type,reason,to_date,user_id) values ('1','N','Sweta Shaw',CURRENT_TIMESTAMP,'Casual','Vacation',CURRENT_TIMESTAMP,2);
insert into leave_request  (id,accept_reject_flag,employee_name,from_date,leave_type,reason,to_date,user_id) values ('2','N','Sweta Shaw',CURRENT_TIMESTAMP,'Sick','Vacation',CURRENT_TIMESTAMP,2);
insert into leave_request(id,accept_reject_flag,employee_name,from_date,leave_type,reason,to_date,user_id) values ('3','N','Sweta Shaw',CURRENT_TIMESTAMP,'Sick','Vacation',CURRENT_TIMESTAMP,3);