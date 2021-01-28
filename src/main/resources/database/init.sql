create schema demo;
create user 'root'@'172.17.0.1' identified by 'root';
grant all privileges on demo.* TO 'root'@'172.17.0.1';
flush privileges;

INSERT INTO `demo`.`employees` (`id`, `email`, `first_name`, `last_name`) VALUES ('1', 'ironman@starkindustries.com', 'Tony', 'STARK');
INSERT INTO `demo`.`employees` (`id`, `email`, `first_name`, `last_name`) VALUES ('2', 'batman@gothamcity.com', 'Bruce', 'WAYNE');
INSERT INTO `demo`.`employees` (`id`, `email`, `first_name`, `last_name`) VALUES ('3', 'jbond@mi6.org', 'James', 'BOND');
