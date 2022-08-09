## Database 
``` sql
mysql> CREATE DATABASE `school` /*!40100 COLLATE 'utf8mb4_general_ci' */;
USE `school`;

mysql> CREATE USER 'microservicesuser'@'localhost' IDENTIFIED BY 'Fajar123';

mysql> GRANT ALL PRIVILEGES ON school . * TO 'microservicesuser'@'localhost';

mysql> FLUSH PRIVILEGES;