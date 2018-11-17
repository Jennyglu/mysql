use hehe1;
create table user(user_id smallint unsigned not null auto_increment,
account varchar(40) not null,
password varchar(50) not null,
primary key(user_id)
)engine=innodb default charset=utf8;