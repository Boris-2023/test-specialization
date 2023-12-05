-- Task #7. В подключенном MySQL репозитории создать базу данных “Друзья человека”

CREATE SCHEMA IF NOT EXISTS HumanFriends;
USE HumanFriends;


-- Task #8. Создать таблицы с иерархией из диаграммы в БД

CREATE TABLE dog
(
	dog_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR (50),
    birth_date DATE,
    commands VARCHAR(255)
);

CREATE TABLE cat
(
	cat_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR (50),
    birth_date DATE,
    commands VARCHAR(255)
);

CREATE TABLE hamster
(
	hamster_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR (50),
    birth_date DATE,
    commands VARCHAR(255)
);

CREATE TABLE horse
(
	horse_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR (50),
    birth_date DATE,
    commands VARCHAR(255)
);

CREATE TABLE camel
(
	camel_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR (50),
    birth_date DATE,
    commands VARCHAR(255)
);

CREATE TABLE donkey
(
	donkey_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR (50),
    birth_date DATE,
    commands VARCHAR(255)
);


-- Task #9. Заполнить низкоуровневые таблицы именами(животных) командами, которые они выполняют и датами рождения

INSERT INTO dog(name, birth_date, commands) VALUES
	('Fido', '2021-01-01', 'Sit, Stay, Fetch'),
	('Buddy', '2018-12-10', 'Sit, Paw, Bark'),	
	('Bella', '2019-11-11', 'Sit, Stay, Roll'),
    ('Bobik', '2022-02-08', 'Sit, Bark');

INSERT INTO cat(name, birth_date, commands) VALUES
	('Wiskers', '2019-05-15', 'Sit, Pounce'),
	('Smudge', '2021-02-20', 'Sit, Pounce, Scratch'),	
	('Oliver', '2020-06-30', 'Meow, Scratch, Jump');
    
INSERT INTO hamster(name, birth_date, commands) VALUES
	('Hammy', '2021-03-10', 'Roll, Hide'),
	('Peanut', '2021-08-01', 'Roll, Spin'),
    ('Chip', '2022-08-01', 'Roll, Drink');
    
INSERT INTO horse(name, birth_date, commands) VALUES
	('Thunder', '2015-07-21', 'Trot, Canter, Gallop'),
	('Storm', '2014-05-05', 'Trot, Canter'),	
	('Blaze', '2016-02-29', 'Trot, Jump, Gallop');

INSERT INTO camel(name, birth_date, commands) VALUES
	('Sandy', '2016-11-03', 'Walk, Carry Load'),
	('Dune', '2018-12-12', 'Walk, Sit'),	
	('Sahara', '2015-08-14', 'Walk, Run');
    
INSERT INTO donkey(name, birth_date, commands) VALUES
	('Eeyore', '2017-09-18', 'Walk, Carry Load, Bray'),
	('Burro', '2021-01-23', 'Walk, Bray, Kick');


-- Task #10. 	Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
-- 				питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

TRUNCATE TABLE camel;

CREATE TABLE horse_donkey
	SELECT name, birth_date, commands FROM horse 
	UNION 
	SELECT name, birth_date, commands FROM donkey;
# add new 'id' column if needed
ALTER TABLE horse_donkey ADD COLUMN id INT PRIMARY KEY AUTO_INCREMENT FIRST; 

SELECT * FROM horse_donkey;


-- Task #11. Создать новую таблицу “молодые животные” в которую попадут все
-- 			животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- 			до месяца подсчитать возраст животных в новой таблице

CREATE TABLE young_animals
	SELECT name, birth_date, commands, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) age_months 
		FROM dog WHERE DATEDIFF(CURDATE(), birth_date) BETWEEN 1*365 AND 3*365
    UNION SELECT name, birth_date, commands, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) age_months 
		FROM cat WHERE DATEDIFF(CURDATE(), birth_date) BETWEEN 1*365 AND 3*365
    UNION SELECT name, birth_date, commands, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) age_months 
		FROM hamster WHERE DATEDIFF(CURDATE(), birth_date) BETWEEN 1*365 AND 3*365
    UNION SELECT name, birth_date, commands, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) age_months 
		FROM horse WHERE DATEDIFF(CURDATE(), birth_date) BETWEEN 1*365 AND 3*365
    UNION SELECT name, birth_date, commands, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) age_months 
		FROM donkey WHERE DATEDIFF(CURDATE(), birth_date) BETWEEN 1*365 AND 3*365;

SELECT * FROM young_animals;


-- Task #12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
-- 			прошлую принадлежность к старым таблицам
CREATE TABLE human_friends
	SELECT name, 'Dog' animal_type, birth_date, commands FROM dog
    UNION SELECT name, 'Cat' animal_type, birth_date, commands FROM cat
    UNION SELECT name, 'Hamster' animal_type, birth_date, commands FROM hamster
    UNION SELECT name, 'Horse' animal_type, birth_date, commands FROM horse
    UNION SELECT name, 'Donkey' animal_type, birth_date, commands FROM donkey;
# add new 'id' column if needed
ALTER TABLE human_friends ADD COLUMN id INT PRIMARY KEY AUTO_INCREMENT FIRST; 

SELECT * FROM human_friends;