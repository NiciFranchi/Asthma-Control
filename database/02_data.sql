# MySQL Setup
SET default_storage_engine=InnoDB;

USE epidemics;

# GRANT ALL ON epidemics.* TO 'epidemics'@'localhost';
# GRANT ALL ON epidemics TO 'epidemics'@'localhost';
# GRANT CREATE ON epidemics.* TO 'epidemics'@'localhost';
# FLUSH PRIVILEGES;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM `personType`;
# This should be all the data we ever need for this table.
# For this project, we will probably only use the patient row.
INSERT INTO `personType` (`id`, `personTypeName`) VALUES (1, 'patient');
INSERT INTO `personType` (`id`, `personTypeName`) VALUES (2, 'provider');

/*
select * from personType;
+----+----------------+
| id | personTypeName |
+----+----------------+
|  1 | patient        |
|  2 | provider       |
+----+----------------+
*/

SET SQL_SAFE_UPDATES = 1;
