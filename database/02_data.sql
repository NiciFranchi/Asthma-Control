# MySQL Setup
SET default_storage_engine=InnoDB;

USE epidemics;

# GRANT ALL ON epidemics.* TO 'epidemics'@'localhost';
# GRANT ALL ON epidemics TO 'epidemics'@'localhost';
# GRANT CREATE ON epidemics.* TO 'epidemics'@'localhost';
# FLUSH PRIVILEGES;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM `login`;
INSERT INTO `login` (`username`, `password`, `active`) VALUES ('april', 'beiter', 1);
INSERT INTO `login` (`username`, `password`, `active`) VALUES ('jordan', 'rimmer', 1);
INSERT INTO `login` (`username`, `password`, `active`) VALUES ('shanon', 'johnson', 0);

DELETE FROM `person`;
INSERT INTO `person` (`id`, `firstName`, `lastName`) VALUES(0, 'Lewis', 'Zimmerman');
INSERT INTO `person` (`id`, `firstName`, `lastName`) VALUES(1, 'Tom', 'Paris');

DELETE FROM `doctor`;
INSERT INTO `doctor` (`id`, `personId`, `employeeId`, `specialty`, `birthday`) VALUES(0, 0, 'NCC-74656', 'medical hologram', '1995-01-16');

DELETE FROM `patient`;
INSERT INTO `patient` (`id`, `personId`, `ssn`, `birthday`) VALUES(0, 1, 'NCC-74656-1', '1995-01-16');

DELETE FROM `answerChoice`;
INSERT INTO `answerChoice` (`id`, `listId`, `answerNumber`, `description`) VALUES(0, 1, 1, '<=2 days/week');
INSERT INTO `answerChoice` (`id`, `listId`, `answerNumber`, `description`) VALUES(1, 1, 2, '>2 days/week');
INSERT INTO `answerChoice` (`id`, `listId`, `answerNumber`, `description`) VALUES(2, 1, 3, 'Throughout the day');
INSERT INTO `answerChoice` (`id`, `listId`, `answerNumber`, `description`) VALUES(3, 2, 1, '<= 1x/month');
INSERT INTO `answerChoice` (`id`, `listId`, `answerNumber`, `description`) VALUES(4, 2, 2, '> 1x/month');
INSERT INTO `answerChoice` (`id`, `listId`, `answerNumber`, `description`) VALUES(5, 2, 3, '>= 1x/week');
INSERT INTO `answerChoice` (`id`, `listId`, `answerNumber`, `description`) VALUES(6, 3, 1, '<=2 days /week but no more than once on each day');
INSERT INTO `answerChoice` (`id`, `listId`, `answerNumber`, `description`) VALUES(7, 3, 2, '>2 days/week or multiple times on <=2 days /week');
INSERT INTO `answerChoice` (`id`, `listId`, `answerNumber`, `description`) VALUES(8, 3, 3, 'Throughout the day');

DELETE FROM `questionnaire`;
INSERT INTO `questionnaire` (`id`, `ageGroup`, `questionNumber`, `question`, `answerList`, `domainOfControl`) VALUES(0, 'ZeroToFour', 1, 'Asthma symptoms in previous 2 - 4 weeks', 1, 'Impairment');
INSERT INTO `questionnaire` (`id`, `ageGroup`, `questionNumber`, `question`, `answerList`, `domainOfControl`) VALUES(1, 'ZeroToFour', 2, 'Night time awakenings in previous 2 - 4 weeks', 2, 'Impairment');
INSERT INTO `questionnaire` (`id`, `ageGroup`, `questionNumber`, `question`, `answerList`, `domainOfControl`) VALUES(2, 'FiveToEleven', 1, 'Asthma symptoms in previous 2 - 4 weeks', 3, 'Impairment');

SET SQL_SAFE_UPDATES = 1;
