# MySQL Setup
SET default_storage_engine=InnoDB;

USE epidemics;

# GRANT ALL ON epidemics.* TO 'epidemics'@'localhost';
# GRANT ALL ON epidemics TO 'epidemics'@'localhost';
# GRANT CREATE ON epidemics.* TO 'epidemics'@'localhost';
# FLUSH PRIVILEGES;

SET SQL_SAFE_UPDATES = 0;
INSERT INTO `epidemics`.`person` (`username`, `password`, `active`, `person_type`, `first_name`, `middle_name`, `last_name`, `contact_phone`, `contact_email`, `contact_fax`, `address_line1`, `address_line2`, `city`, `state`, `zip`, `birthday`) VALUES ('aarsh', 'talati', True, 'patient', 'Aarsh', '', 'Talati', '1234567890', 'write@wordpress.com', '9874561230', '123 My Street', 'Not your street', 'Atlana', 'GA', '12345', '01-01-01');
-- INSERT INTO `epidemics`.`authorities` (`username`, `authority`) VALUES ('aarsh', 'patient');
SET SQL_SAFE_UPDATES = 1;