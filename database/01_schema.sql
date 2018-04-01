# MySQL Setup
SET default_storage_engine=InnoDB;

USE epidemics;

DROP TABLE IF EXISTS login;

CREATE TABLE login (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`username` VARCHAR(25) NOT NULL,
`password` VARCHAR(50),
`active` BIT(1)
)ENGINE=InnoDB;

DROP TABLE IF EXISTS person;

CREATE TABLE person (
`id` INT NOT NULL PRIMARY KEY,
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

DROP TABLE IF EXISTS patient;

CREATE TABLE patient (
`id` INT NOT NULL PRIMARY KEY,
`personId` INT NOT NULL REFERENCES person(id),
`ssn` VARCHAR(25) NOT NULL,
`birthday` DATE NOT NULL # This will store just a day without a time.
)ENGINE=InnoDB;

DROP TABLE IF EXISTS doctor;

CREATE TABLE doctor (
`id` INT NOT NULL PRIMARY KEY,
`personId` INT NOT NULL REFERENCES person(id),
`employeeId` VARCHAR(25) NOT NULL,
`specialty` VARCHAR(25) NOT NULL,
`birthday` DATE NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS questionnaire;

CREATE TABLE questionnaire (
`id` INT NOT NULL PRIMARY KEY,
`ageGroup` ENUM('ZeroToFour', 'FiveToEleven', 'TwelvePlus') NOT NULL,
`questionNumber` INT NOT NULL,
`question` VARCHAR(100) NOT NULL,
`answerList` INT NOT NULL REFERENCES answerChoice(listId),
`domainOfControl` ENUM('Impairment', 'Risk') NOT NULL
)ENGINE=InnoDB;

DROP TABLE IF EXISTS answerChoice;

CREATE TABLE answerChoice (
`id` INT NOT NULL PRIMARY KEY,
`listId` INT NOT NULL,
`answerNumber` INT NOT NULL,
`description` VARCHAR(100) NOT NULL,
INDEX answerListChoice (listId, answerNumber)
)ENGINE=InnoDB;

DROP TABLE IF EXISTS visit;

CREATE TABLE visit (
`id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
`patientId` INT NOT NULL REFERENCES patient(id),
`doctorId` INT NOT NULL REFERENCES doctor(id),
`questionnaireId` INT NOT NULL REFERENCES questionnaire(id),
`answerId` INT NOT NULL REFERENCES answerChoice(id),
`visitDate` DATETIME NOT NULL
)ENGINE=InnoDB;
