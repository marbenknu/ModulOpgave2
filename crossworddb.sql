USE crossword;

DROP TABLE wordlist;

CREATE TABLE wordlist
(
    words		VARCHAR(3)		NOT NULL
);

-- LOAD DATAFILE
LOAD DATA INFILE "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\3LetterWord_CSV.csv"
INTO TABLE wordlist
CHARACTER SET latin1;

-- Opret bruger
DROP USER IF EXISTS 'moduluser'@'localhost';
CREATE USER 'moduluser'@'localhost' IDENTIFIED BY 'gruppe7';
GRANT SELECT, UPDATE, DELETE ON crossword.* TO 'moduluser'@'localhost';
FLUSH PRIVILEGES;
