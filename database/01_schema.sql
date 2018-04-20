# MySQL Setup
SET default_storage_engine=InnoDB;

USE epidemics;

DROP TABLE IF EXISTS assessment;
DROP TABLE IF EXISTS response;
DROP TABLE IF EXISTS visit;
DROP TABLE IF EXISTS answer_choice;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS age_group;
DROP TABLE IF EXISTS person;

CREATE TABLE person (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`username` VARCHAR(25) NOT NULL,
`password` VARCHAR(50) NULL,
`active` BIT(1) NULL,
`person_type` VARCHAR(50) NOT NULL,
`first_name` VARCHAR(50) NOT NULL,
`middle_name` VARCHAR(50) NULL,
`last_name` VARCHAR(50) NOT NULL,
`contact_phone` VARCHAR(50) NULL,
`contact_email` VARCHAR(50) NULL,
`contact_fax` VARCHAR(50) NULL,
`address_line1` VARCHAR(100) NULL,
`address_line2` VARCHAR(100) NULL,
`city` VARCHAR(50) NULL,
`state` VARCHAR(50) NULL,
`zip` VARCHAR(10) NULL,
`birthday` DATE NOT NULL
)ENGINE=InnoDB;

CREATE TABLE age_group (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`min_age` INT NOT NULL,
`max_age` INT NOT NULL,
`description` VARCHAR(100) NOT NULL
)ENGINE=InnoDB;

CREATE TABLE question (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`age_group_id` INT NOT NULL,
`question_number` INT NOT NULL,
`question_text` VARCHAR(2000) NOT NULL,
`domain_of_control` VARCHAR(50) NOT NULL,
FOREIGN KEY(age_group_id)
  REFERENCES age_group(id)
  ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE answer_choice (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`question_id` INT NOT NULL,
`answer_number` INT NOT NULL,
`answer_text` VARCHAR(1000) NOT NULL,
FOREIGN KEY(question_id)
  REFERENCES question(id)
  ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE visit (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`patient_id` INT NOT NULL,
`visit_date` DATETIME NOT NULL,
FOREIGN KEY(patient_id)
  REFERENCES person(id)
  ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE response (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`visit_id` INT NOT NULL,
`question_id` INT NOT NULL,
`answer_id` INT NOT NULL,
FOREIGN KEY(visit_id)
  REFERENCES visit(id)
  ON DELETE CASCADE,
FOREIGN KEY(question_id)
  REFERENCES question(id)
  ON DELETE CASCADE,
FOREIGN KEY(answer_id)
  REFERENCES answer_choice(id)
  ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE assessment (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`visit_id` INT NOT NULL,
`domain_of_control` VARCHAR(50) NOT NULL,
`assessment_level` VARCHAR(50) NOT NULL,
`treatment_text` VARCHAR(2000) NOT NULL,
FOREIGN KEY(visit_id)
  REFERENCES visit(id)
  ON DELETE CASCADE
)ENGINE=InnoDB;
