/*
Created: 31.12.2022
Modified: 31.12.2022
Model: vacancy
Database: SQLite 3.7
*/

-- Create tables section -------------------------------------------------

-- Table vacancy

CREATE TABLE vacancy
(
  id bigint NOT NULL
        CONSTRAINT PK_vacancy PRIMARY KEY AUTOINCREMENT,
  name varchar(20) NOT NULL,
  skills varchar(20) NOT NULL,
  text varchar(20) NOT NULL,
  summa decimal(8, 2) NOT NULL,
  kind int NOT NULL
)
;

