#create database
CREATE DATABASE `ssm` CHARACTER SET utf8;

#create table
DROP TABLE IF EXISTS  `ssm`.`tb_user`;
CREATE TABLE `ssm`.`tb_user`
(
  `id`   SMALLINT(16) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(16),
  `sex`  VARCHAR(2),
  PRIMARY KEY (`id`)
) ENGINE=INNODB CHARSET=utf8;

#init data
INSERT INTO tb_user (NAME, sex)
VALUES ("张三", "男"), ("李四", "男"),("王五", "女");
