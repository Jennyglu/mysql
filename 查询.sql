use hehe2;
DELIMITER $$
CREATE  PROCEDURE momo_pro (in momoname varchar(40),out xihuanname varchar(40))
reads sql data
begin
select * from xihuan where name_id=momoname;
select * into xihuanname;
end $$
DELIMITER ;
CALL momo_pro('zhangwei',@searchrest);
select @searchrest;