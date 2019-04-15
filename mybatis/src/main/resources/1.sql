create table address(
id int(50) not null primary key auto_increment,
user_id int(50) not null,
contry varchar(20),
province varchar(20),
city varchar(20),
detail varchar(300)
);

create table user(
id int(50) not null primary key auto_increment,
code varchar(50) not null,
name varchar(50),
pwd varchar(300)
);


create table hobby(
id int(50) not null primary key auto_increment,
user_id int(50) not null,
code varchar(50) not null,
name varchar(50)
);

INSERT INTO `user` (`id`,`code`,`name`,`pwd`) VALUES (1,'123','张三','123');
INSERT INTO `user` (`id`,`code`,`name`,`pwd`) VALUES (2,'124','李四','213');

INSERT INTO `address` (`id`,`user_id`,`contry`,`province`,`city`,`detail`) VALUES (11,1,'中国','上海','上海','鼓楼公路');
INSERT INTO `address` (`id`,`user_id`,`contry`,`province`,`city`,`detail`) VALUES (12,2,'中国','安徽','亳州','大杨');

INSERT INTO `hobby` (`id`,`user_id`,`code`,`name`) VALUES (21,1,'pp','乒乓球');
INSERT INTO `hobby` (`id`,`user_id`,`code`,`name`) VALUES (22,1,'b','篮球');
INSERT INTO `hobby` (`id`,`user_id`,`code`,`name`) VALUES (23,1,'f','足球');
INSERT INTO `hobby` (`id`,`user_id`,`code`,`name`) VALUES (24,2,'f','足球');
