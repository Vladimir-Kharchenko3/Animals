
-- Создаем базу данных
CREATE DATABASE IF NOT EXISTS FriendsOfHumans;
USE FriendsOfHumans;

-- Создаем таблицу Animals
CREATE TABLE IF NOT EXISTS Animals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    type ENUM('Domestic', 'Pack') NOT NULL
);

--  Создание таблиц для домашних и вьючных животных

CREATE TABLE IF NOT EXISTS DomesticAnimals (
    animal_id INT PRIMARY KEY,
    species ENUM('Dog', 'Cat', 'Hamster') NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES Animals(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS PackAnimals (
    animal_id INT PRIMARY KEY,
    species ENUM('Horse', 'Camel', 'Donkey') NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES Animals(id) ON DELETE CASCADE
);

-- Таблица команд для животных

CREATE TABLE IF NOT EXISTS Commands (
    id INT AUTO_INCREMENT PRIMARY KEY,
    animal_id INT,
    command VARCHAR(100) NOT NULL,
    FOREIGN KEY (animal_id) REFERENCES Animals(id) ON DELETE CASCADE
);

-- Заполнение таблицы Animals
INSERT INTO Animals (name, birth_date, type) VALUES 
('Барсик', '2020-05-10', 'Domestic'),
('Мурка', '2019-03-15', 'Domestic'),
('Шарик', '2021-01-21', 'Domestic'),
('Буцефал', '2018-07-12', 'Pack'),
('Гром', '2017-09-23', 'Pack');

INSERT INTO Animals (name, birth_date, type) VALUES 
('Барсик', '2020-05-10', 'Domestic'),
('Мурка', '2019-03-15', 'Domestic'),
('Шарик', '2021-01-21', 'Domestic');
-- Заполнение таблицы DomesticAnimals
INSERT INTO DomesticAnimals (animal_id, species) VALUES 
(41, 'Cat'), 
(42, 'Cat'), 
(43, 'Dog');

-- Заполнение таблицы PackAnimals
INSERT INTO PackAnimals (animal_id, species) VALUES 
(44, 'Horse'),
(45, 'Horse');

-- Заполнение таблицы Commands
INSERT INTO Commands (animal_id, command) VALUES 
(41, 'Сидеть'),
(41, 'Лежать'),
(42, 'Ко мне'),
(43, 'Голос'),
(44, 'Идти'),
(45, 'Стой');

-- SHOW COLUMNS FROM Animals LIKE 'type';
-- ALTER TABLE Animals MODIFY COLUMN type ENUM('Domestic', 'Pack') NOT NULL;
-- SELECT * FROM Animals;

-- Удаление всех верблюдов из таблицы PackAnimals
DELETE FROM PackAnimals WHERE species = 'Camel';

-- Создаем таблицу для объединения данных о лошадях и ослах:
CREATE TABLE IF NOT EXISTS HorsesAndDonkeys AS
SELECT * FROM PackAnimals WHERE species IN ('Horse', 'Donkey');

-- Составление таблиц для молодых животных (от 1 до 3 лет):

CREATE TABLE IF NOT EXISTS YoungAnimals AS
SELECT id, name, birth_date, TIMESTAMPDIFF(MONTH, birth_date, CURDATE()) AS age_in_months
FROM Animals
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) >= 1 
AND TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) < 3;

-- Создадим таблицу, объединяющую все данные:

CREATE TABLE IF NOT EXISTS AllAnimals AS
SELECT a.id, a.name, a.birth_date, a.type, d.species AS domestic_species, p.species AS pack_species
FROM Animals a
LEFT JOIN DomesticAnimals d ON a.id = d.animal_id
LEFT JOIN PackAnimals p ON a.id = p.animal_id;

-- Показать всех животных и их команды
SELECT a.name, a.birth_date, c.command 
FROM Animals a
LEFT JOIN Commands c ON a.id = c.animal_id;

-- Показать всех животных старше 1 года, но младше 3 лет
SELECT * FROM YoungAnimals;

-- Показать всех животных после объединения
SELECT * FROM AllAnimals;