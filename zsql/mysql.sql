-----------------create database begin-------------------------------
-- 远程连接
mysql -u root -p -h x.x.x.x [-P 3306] [-D test1]
-- 创建用户
CREATE USER 'testUser'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'testUser'@'%' IDENTIFIED BY 'password';
-- 创建数据库
CREATE DATABASE test_db DEFAULT CHARSET utf8 COLLATE utf8_bin;
-- 授权用户
GRANT ALL PRIVILEGES ON test_db.* TO 'testUser'@'localhost' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON test_db.* TO 'testUser'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
-- 删除用户
DELETE FROM mysql.user WHERE USER='test1' AND HOST='localhost';
FLUSH PRIVILEGES;
DROP DATABASE test1;
DROP USER 'testUser'@'%';
DROP USER 'testUser'@'localhost';
-- 修改密码
ALTER USER 'testUser'@'localhost' IDENTIFIED BY 'new password';
ALTER USER 'testUser'@'%' IDENTIFIED BY 'new password';
-- 密码策略
grep "password" /var/log/mysqld.log;
SHOW VARIABLES LIKE 'validate_password%';
set global validate_password.policy=LOW;
set global validate_password.length=4;
set global validate_password.mixed_case_count=0;
set global validate_password.number_count=0;
set global validate_password.number_count=0;
-----------------create database end-------------------------------