-- use hehe1;
-- insert into user(account ,password) values('zhangsan',md5('123456')), ('wangwu',md5('345678'));
-- select * from user;
-- use hehe1;
-- insert into equip(name,price,user_id) values
-- ('huwan',12,1),('shoutao',13,1),('manzi',16,2),('xiezi',18,2);
-- select * from equip;
-- use hehe1;
-- select *  from equip where user_id=1;
use hehe1;
select * from equip where equip.user_id in(select user_id from user);