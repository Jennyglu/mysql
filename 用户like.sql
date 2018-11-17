use hehe2;
create table xihuan(
like_id int  unsigned not null auto_increment ,
like_name varchar(40) not null,
name_id varchar(40)  not null  ,
like_weixing varchar(40) not null,
primary key (like_id),
key idx_fk_name_id (name_id), 
constraint `fk_xihuan_momo` foreign key (name_id) references momo(name_id)
on delete restrict on update cascade
)engine=innodb default charset=utf8;