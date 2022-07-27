#### Site Info :

``` console
Base Url : https://start.spring.io/starter.zip

Full Url : https://start.spring.io/starter.zip?name=demo&groupId=id.co.ofon&artifactId=dev&version=0.0.1-SNAPSHOT&description=Demo+project+for+Spring+Boot&packageName=id.co.ofon.dev&type=maven-project&packaging=jar&javaVersion=17&language=java&bootVersion=2.7.2&dependencies=mysql&dependencies=data-jpa&dependencies=web
```

#### MySQL Database :

``` mysql
mysql> CREATE DATABASE `db_spring`;

mysql> CREATE TABLE `users` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`last_name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

mysql> CREATE USER 'alterra'@'localhost' IDENTIFIED BY 'spring2022';

mysql> GRANT ALL PRIVILEGES ON db_spring . * TO 'alterra'@'localhost';

mysql> FLUSH PRIVILEGES;
```


