-- CREATE DATABASE AND TABLE
DROP DATABASE IF EXISTS crossword;
CREATE DATABASE IF NOT EXISTS crossword;
USE crossword;
CREATE TABLE wordlist (
	words CHAR(3) NOT NULL
) CHARACTER SET UTF8MB4 COLLATE UTF8MB4_DANISH_CI;

-- LOAD DATAFILE
LOAD DATA INFILE "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\3LetterWord_Unicode_NOBOM_UTF8.txt"
INTO TABLE wordlist
CHARACTER SET UTF8MB4
FIELDS TERMINATED BY ';' ENCLOSED BY '' ESCAPED BY '\\';
-- IGNORE 1 LINES;

-- CREATE USER
DROP USER IF EXISTS 'moduluser'@'localhost';
CREATE USER IF NOT EXISTS 'moduluser'@'localhost' IDENTIFIED BY 'gruppe7';
GRANT ALL ON *.* TO 'moduluser'@'localhost';
FLUSH PRIVILEGES;-- Only needed when modifying the grant tables directly using statements such as INSERT, UPDATE, or DELETE

/*
SET @@global.time_zone = '+00:00';
SET @@session.time_zone = '+00:00';
SELECT @@global.time_zone, @@session.time_zone;
*/