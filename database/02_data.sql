# MySQL Setup
SET default_storage_engine=InnoDB;

USE epidemics;

# GRANT ALL ON epidemics.* TO 'epidemics'@'localhost';
# GRANT ALL ON epidemics TO 'epidemics'@'localhost';
# GRANT CREATE ON epidemics.* TO 'epidemics'@'localhost';
# FLUSH PRIVILEGES;

SET SQL_SAFE_UPDATES = 0;
/*
DELETE FROM `login`;
INSERT INTO `login` (`username`, `password`, `active`) VALUES ('april', 'beiter', 1);
INSERT INTO `login` (`username`, `password`, `active`) VALUES ('jordan', 'rimmer', 1);
INSERT INTO `login` (`username`, `password`, `active`) VALUES ('shanon', 'johnson', 0);
*/
SET SQL_SAFE_UPDATES = 1;
