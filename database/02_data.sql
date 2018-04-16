# MySQL Setup
SET default_storage_engine=InnoDB;

USE epidemics;

# GRANT ALL ON epidemics.* TO 'epidemics'@'localhost';
# GRANT ALL ON epidemics TO 'epidemics'@'localhost';
# GRANT CREATE ON epidemics.* TO 'epidemics'@'localhost';
# FLUSH PRIVILEGES;

SET SQL_SAFE_UPDATES = 0;

DROP PROCEDURE IF EXISTS reset_and_fill;

delimiter //

CREATE PROCEDURE reset_and_fill()
	BEGIN
		DELETE FROM `person`;
		DELETE FROM `age_group`;
		DELETE FROM `question`;
		DELETE FROM `answer_choice`;
		DELETE FROM `visit`;
		DELETE FROM `response`;


		ALTER TABLE `person` AUTO_INCREMENT = 1;
		INSERT INTO `person` (`id`, `username`, `password`, `active`, `person_type`, `first_name`, `middle_name`, `last_name`, `contact_phone`, `contact_email`, `contact_fax`, `address_line1`, `address_line2`, `city`, `state`, `zip`, `birthday`) 
		VALUES 
		(NULL, 'cory.rempel', 'c705d522bab6e3ba27b3f717062a116f81f7d7ca', 1, 'PATIENT', 'Rafael', 'Cassandra', 'Pagac', '05942567846', 'meagan.borer@example.com', '1-776-561-7474x2407', '296 Zemlak Lakes Apt. 213', NULL, 'Estellfort', 'Alabama', '64442-4566', '2017-01-01')
		, (NULL, 'destinee04', '6f3e7ed83350d98f37eacda698b253ae860f65bf', 1, 'PATIENT', 'Vilma', 'Kenny', 'Littel', '797-097-4004', 'alanna25@example.org', '695-400-3889', '637 Orlando Villages', NULL, 'South Shanelle', 'Idaho', '70626', '2012-01-01')
		, (NULL, 'jayne83', 'edbc5c5de12bafb9fc526bc7a07414ed8bca6912', 0, 'PATIENT', 'Germaine', 'Stefan', 'O''Connell', '1-175-844-0894x1179', 'wtowne@example.org', '1-057-191-2477x86919', '077 Kiana Meadow Apt. 294', NULL, 'Gennaroview', 'Idaho', '06492-5283', '2001-03-01')
		, (NULL, 'max98', 'a2b1461da75dfa3626b9e57194a723d97e531d98', 0, 'PATIENT', 'Adele', 'Louvenia', 'McGlynn', '(902)958-2151', 'oswald06@example.org', '1-107-279-0147x7515', '7836 Karl Light Suite 956', NULL, 'West Kadinburgh', 'Vermont', '46090-9722', '1979-12-31')
		, (NULL, 'goodwin.lilian', '6cab70f14ca8bd66fdcdca0ebe6abd19fa512b02', 1, 'PATIENT', 'Jarrett', 'Eryn', 'Monahan', '786-062-5270x1497', 'ziemann.paris@example.org', '353-641-8594x65082', '50474 Melissa Extension', NULL, 'South Rooseveltbury', 'Connecticut', '40059', '2018-02-01')
		, (NULL, 'domingo86', '1b8b0e5a41a9801e8d183384d8c8cc39dd65e1cf', 1, 'PATIENT', 'Raina', 'Ara', 'Hackett', '01162819571', 'kaycee.murazik@example.com', '(554)535-1305', '517 Hoeger Corner', NULL, 'South Danika', 'SouthDakota', '65486', '1955-06-15')
		, (NULL, 'jedidiah74', '8917728597287023859a36d85f104b973e78aad8', 0, 'DOCTOR', 'Laurianne', 'Jordon', 'Weimann', '422-049-5812x4040', 'oswald60@example.org', '(152)175-0155x9891', '68091 Wyman View', NULL, 'Gislasonville', 'Georgia', '42819', '1984-05-22')
		, (NULL, 'hackett.liana', '1d22f3bb84a492443eeb008cdf90ad435bade188', 1, 'DOCTOR', 'Lila', 'Isaiah', 'Dach', '912-201-2612x10631', 'ben.crist@example.com', '128-401-4330', '4918 Powlowski Station', NULL, 'Port Bonitahaven', 'Alabama', '90443-3715', '2005-03-22');

		ALTER TABLE `age_group` AUTO_INCREMENT = 1;
		INSERT INTO `age_group`(`id`,`min_age`,`max_age`, `description`) 
		VALUES 
		(NULL, 0, 4, '0-4 yrs of age')
		,(NULL, 5, 11, '5-11 yrs of age')
		,(NULL, 12, 1000, '>=12 yrs of age');

		ALTER TABLE `question` AUTO_INCREMENT = 1;
		INSERT INTO `question` 
		(`id`, `age_group_id`, `question_number`, `question_text`, `domain_of_control`)
		VALUES 
		(NULL,1,1,'Asthma symptoms in previous 2-4 weeks', 'Impairment')
		,(NULL,1,2,'Night time awakenings in previous 2-4 weeks','Impairment')
		,(NULL,1,3,'Interference with normal activity in previous 2-4 weeks','Impairment')
		,(NULL,1,4,'Short-acting beta2-agonist use for symptom control in previous 2-4 weeks (not prevention of exercise-induced bronchospasm)','Impairment')
		,(NULL,1,5,'Exacerbations requiring oral systemic corticosteroids','Risk')
		,(NULL,2,1,'Asthma symptoms in previous 2-4 weeks','Impairment')
		,(NULL,2,2,'Night  time awakenings In previous 2-4 weeks','Impairment')
		,(NULL,2,3,'Interference with normal activity in previous 2-4 weeks','Impairment')
		,(NULL,2,4,'Short-acting beta2-agonist use  for symptom control in previous 2-4 weeks (not prevention of exercise-induced bronchospasm)','Impairment')
		,(NULL,2,5,'FEV1or peak flow in previous 2-4 weeks','Impairment')
		,(NULL,2,6,'FEV1 /FVC','Impairment')
		,(NULL,2,7,'FEV1 /FVC Exacerbations requiring oral systemic corticosteroids','Risk')
		,(NULL,3,1,'Asthma symptoms in previous 2-4 weeks','Impairment')
		,(NULL,3,2,'Nighttime awakenings in previous 2-4 weeks','Impairment')
		,(NULL,3,3,'Interference with normal activity in previous 2-4 weeks','Impairment')
		,(NULL,3,4,'Short-acting beta2-agonist use for symptom control in previous 2-4 weeks (not prevention of exercise-induced bronchospasm)','Impairment')
		,(NULL,3,5,'FEV1 or peak flow in previous 2-4 weeks','Impairment')
		,(NULL,3,6,'Validated questionnaire: ATAQ','Impairment')
		,(NULL,3,7,'Validated questionnaire: ACQ','Impairment')
		,(NULL,3,8,'Validated questionnaire: ACT','Impairment')
		,(NULL,3,9,'Exacerbations requiring oral systemic corticosteroids','Risk');

		ALTER TABLE `answer_choice` AUTO_INCREMENT = 1;
		INSERT INTO `answer_choice` (`id`,`question_id`, `answer_number`, `answer_text`)
		VALUES
		(NULL,1,1,'<=2 days /week')
		,(NULL,1,2,'>2 days/week')
		,(NULL,1,3,'Throughout the day')
		,(NULL,2,1,'<= 1x/month')
		,(NULL,2,2,'> 1x/month')
		,(NULL,2,3,'>= 1x/week')
		,(NULL,3,1,'None')
		,(NULL,3,2,'Some limitation')
		,(NULL,3,3,'Extremely limited')
		,(NULL,4,1,'<= 2 days/week')
		,(NULL,4,2,' >2 days/week')
		,(NULL,4,3,'Several times per day')
		,(NULL,5,1,'0-1/ year')
		,(NULL,5,2,'2 - 3 / year')
		,(NULL,5,3,'>3 / year')
		,(NULL,6,1,'<=2 days /week but no more than once on each day')
		,(NULL,6,2,'>2 days/week or multiple times on <=2 days /week')
		,(NULL,6,3,'Throughout the day')
		,(NULL,7,1,'<= 1x/month')
		,(NULL,7,2,'>= 2x/month')
		,(NULL,7,3,'>= 2x/week')
		,(NULL,8,1,'None')
		,(NULL,8,2,'Some limitation')
		,(NULL,8,3,'Extremely limited')
		,(NULL,9,1,'<= 2 days/week')
		,(NULL,9,2,'>2 days/week')
		,(NULL,9,3,'Several times per day')
		,(NULL,10,1,'> 80% predicted / personal best')
		,(NULL,10,2,'60-80 % predicted/personal best')
		,(NULL,10,3,'< 60 % predicted / personal best')
		,(NULL,10,4,'Not available')
		,(NULL,11,1,'>80%')
		,(NULL,11,2,'75-80%')
		,(NULL,11,3,'<75%')
		,(NULL,11,4,'Not available')
		,(NULL,12,1,'0-1 /year')
		,(NULL,12,2,'>= 2  / year')
		,(NULL,13,1,'<=2 days /week')
		,(NULL,13,2,'>2 days/week')
		,(NULL,13,3,'Throughout the day')
		,(NULL,14,1,'<= 2x/month')
		,(NULL,14,2,'1-3x/week')
		,(NULL,14,3,'>= 4x/week')
		,(NULL,15,1,'None')
		,(NULL,15,2,'Some limitation')
		,(NULL,15,3,'Extremely limited')
		,(NULL,16,1,'<= 2 days/week')
		,(NULL,16,2,'>2 days/week')
		,(NULL,16,3,'Several times per day')
		,(NULL,17,1,'> 80% predicted / personal best')
		,(NULL,17,2,'60-80 % predicted/personal best')
		,(NULL,17,3,'< 60 % predicted / personal best')
		,(NULL,17,4,' Not available')
		,(NULL,18,1,'0')
		,(NULL,18,2,'1-2')
		,(NULL,18,3,'3-4')
		,(NULL,18,4,'Not available')
		,(NULL,19,1,'<= 0.75')
		,(NULL,19,2,'>=1.5')
		,(NULL,19,3,'N/A')
		,(NULL,20,1,'>= 20')
		,(NULL,20,2,'16-19')
		,(NULL,20,3,'<=15')
		,(NULL,20,4,'Not available')
		,(NULL,21,1,'0-1 /year')
		,(NULL,21,2,'>= 2  / year');


		ALTER TABLE `visit` AUTO_INCREMENT = 1;

		INSERT INTO `visit` (`id`,`patient_id`,`visit_date`) 
		VALUES 
		(NULL,1,'2018-01-01')
		,(NULL,2,'2018-02-01');

		ALTER TABLE `response` AUTO_INCREMENT = 1;
		INSERT INTO `response` (`id`,`visit_id`,`question_id`,`answer_id`) 
		VALUES 
		(NULL,1,6,16)
		,(NULL,1,7,21)
		,(NULL,1,8,23)
		,(NULL,1,9,26)
		,(NULL,1,10,28)
		,(NULL,1,11,33)
		,(NULL,1,12,36)
		,(NULL,2,1,1)
		,(NULL,2,2,4)
		,(NULL,2,3,7)
		,(NULL,2,4,10)
		,(NULL,2,5,13);
		
		
	END; //

CALL reset_and_fill();