# MySQL Setup
SET default_storage_engine=InnoDB;

USE epidemics;

DROP TABLE IF EXISTS person_type;

CREATE TABLE person_type (
`id` INT NOT NULL PRIMARY KEY,
`person_type_name` VARCHAR(100) NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS person;

CREATE TABLE person (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`username` VARCHAR(25) NOT NULL,
`password` VARCHAR(50),
`active` BIT(1),
`person_type_id` INT NOT NULL REFERENCES person_type(id),
`firstName` VARCHAR(50) NOT NULL,
`middleName` VARCHAR(50) NULL,
`lastName` VARCHAR(50) NOT NULL,
`contactPhone` VARCHAR(50) NULL,
`contactEmail` VARCHAR(50) NULL,
`contactFax` VARCHAR(50) NULL,
`addressLine1` VARCHAR(100) NULL,
`addressLine2` VARCHAR(100) NULL,
`city` VARCHAR(50) NULL,
`state` VARCHAR(50) NULL,
`zip` VARCHAR(10) NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS questions;

CREATE TABLE questions (
`id` INT NOT NULL PRIMARY KEY,
`question_text` VARCHAR(2000) NOT NULL,
`domainOfControl` ENUM('Impairment', 'Risk') NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS ageGroup;

CREATE TABLE ageGroup (
`id` INT NOT NULL PRIMARY KEY,
`minAge` INT NOT NULL,
`maxAge` INT NOT NULL,
`description` VARCHAR(100) NOT NULL
)ENGINE=InnoDB;


DROP TABLE IF EXISTS questionnaire;

CREATE TABLE questionnaire (
`id` INT NOT NULL PRIMARY KEY,
`questionNumber` INT NOT NULL REFERENCES questions(id),
`ageGroupId` INT NOT NULL REFERENCES ageGroup(id)
)ENGINE=InnoDB;

DROP TABLE IF EXISTS answerChoice;

CREATE TABLE answerChoice (
`id` INT NOT NULL PRIMARY KEY,
`question_id` INT NOT NULL REFERENCES questions(id),
`answer_desc` VARCHAR(1000) NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS visit;
-- Here we are assuming that patient is not a doctor. Need to fix this deficinecy somepoint soon
CREATE TABLE visit (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`patientId` INT NOT NULL REFERENCES person(id),
`doctorId` INT NOT NULL REFERENCES person(id),
`visitDate` DATETIME NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS response;

CREATE TABLE response (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`visitId` INT NOT NULL REFERENCES visit(id),
`questionnaireId` INT NOT NULL REFERENCES questionnaire(id),
`questionId` INT NOT NULL REFERENCES questions(id),
`answerId` INT NOT NULL REFERENCES answerChoice(id)
)ENGINE=InnoDB;