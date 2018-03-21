# MySQL Setup
SET default_storage_engine=InnoDB;

USE epidemics;

DROP TABLE IF EXISTS login;

CREATE TABLE login (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`username` VARCHAR(25) NOT NULL,
`password` VARCHAR(50) ,
`active` BIT(1)
)ENGINE=InnoDB;