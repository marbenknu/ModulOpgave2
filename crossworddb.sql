-- CREATE DATABASE AND TABLE
DROP DATABASE IF EXISTS crossword;
CREATE DATABASE IF NOT EXISTS crossword;
USE crossword;
DROP TABLE IF EXISTS wordlist;
CREATE TABLE IF NOT EXISTS wordlist
(
	words	VARCHAR(3)	NOT NULL
);

-- LOAD DATAFILE
LOAD DATA INFILE "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\3LetterWord_CSV.csv"
INTO TABLE wordlist
CHARACTER SET latin1;

-- CREATE USER
DROP USER IF EXISTS 'moduluser'@'localhost';
CREATE USER IF NOT EXISTS 'moduluser'@'localhost' IDENTIFIED BY 'gruppe7';
GRANT ALL ON *.* TO 'moduluser'@'localhost';
FLUSH PRIVILEGES; -- Only needed when modifying the grant tables directly using statements such as INSERT, UPDATE, or DELETE