use hehe1;
create table equip(id smallint unsigned not null auto_increment,
name varchar(40) not null,
price float not null,
user_id smallint unsigned not null,
last_update timestamp default current_timestamp on update current_timestamp,
primary key (id),
key idx_fk_user_id (user_id), 
constraint `fk_eqiup_user` foreign key (user_id) references user(user_id)
on delete restrict on update cascade
)engine=innodb default charset=utf8;