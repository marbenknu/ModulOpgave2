-- CREATE DATABASE AND TABLE
DROP DATABASE IF EXISTS crossword;
CREATE DATABASE IF NOT EXISTS crossword;
USE crossword;
DROP TABLE IF EXISTS wordlist;
CREATE TABLE IF NOT EXISTS wordlist
(
	words	CHAR(3)	NOT NULL
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




DROP TABLE IF EXISTS test;
CREATE TABLE IF NOT EXISTS test
(
	words	CHAR(3)	NOT NULL
);
INSERT INTO test
	(words)
VALUES
	("123"),
    ("456"),
    ("789"),
	("147"),
    ("258"),
    ("369"),    
    ("780"),
    ("360"),
    ("abc"),
    ("def"),
    ("ghi"),
	("adg"),
    ("beh"),
    ("cfi"),
    ("ghq"),
    ("cfq"),
    ("gh1"),
    ("2fq"),
	("14z"),
    ("r56")
;


-- HUSK AT DATATYPE ER ÆNDRET TIL CHAR
-- HUSK AT SLETTE TEST TABLE PERMANENT


SELECT ta.words AS ordA, tb.words AS ordB, tc.words AS ordC, td.words AS ordD
FROM test AS ta, test AS tb, test AS tc, test AS td
WHERE
-- a join b
SUBSTR(ta.words,1,1) = SUBSTR(tb.words,1,1)
-- a og b indeholder unikke bogstaver
&& SUBSTR(ta.words,2,1) != SUBSTR(tb.words,2,1) && SUBSTR(ta.words,2,1) != SUBSTR(tb.words,3,1)
&& SUBSTR(ta.words,3,1) != SUBSTR(tb.words,2,1) && SUBSTR(ta.words,3,1) != SUBSTR(tb.words,3,1)
-- c join a
&& SUBSTR(ta.words,2,1) = SUBSTR(tc.words,1,1)
-- a, b og c indeholder unikke bogstaver
&& SUBSTR(tc.words,2,1) != SUBSTR(ta.words,1,1) && SUBSTR(tc.words,2,1) != SUBSTR(ta.words,3,1)
&& SUBSTR(tc.words,2,1) != SUBSTR(tb.words,2,1) && SUBSTR(tc.words,2,1) != SUBSTR(tb.words,3,1)
&& SUBSTR(tc.words,3,1) != SUBSTR(ta.words,1,1) && SUBSTR(tc.words,3,1) != SUBSTR(ta.words,3,1)
&& SUBSTR(tc.words,3,1) != SUBSTR(tb.words,2,1) && SUBSTR(tc.words,3,1) != SUBSTR(tb.words,3,1)
-- test v1 for eksistens af e og f
&& CONCAT(SUBSTR(tb.words,2,1),SUBSTR(tc.words,2,1)) IN (SELECT CONCAT(SUBSTR(words,1,1),SUBSTR(words,2,1)) AS temp FROM test)
&& CONCAT(SUBSTR(tb.words,3,1),SUBSTR(tc.words,3,1)) IN (SELECT CONCAT(SUBSTR(words,1,1),SUBSTR(words,2,1)) AS temp FROM test)
-- d join a
&& SUBSTR(ta.words,3,1) = SUBSTR(td.words,1,1)
-- a, b, c og d indeholder unikke bogstaver
&& SUBSTR(td.words,2,1) != SUBSTR(ta.words,1,1) && SUBSTR(td.words,2,1) != SUBSTR(ta.words,2,1)
&& SUBSTR(td.words,2,1) != SUBSTR(tb.words,2,1) && SUBSTR(td.words,2,1) != SUBSTR(tb.words,3,1)
&& SUBSTR(td.words,2,1) != SUBSTR(tc.words,2,1) && SUBSTR(td.words,2,1) != SUBSTR(tc.words,3,1)
&& SUBSTR(td.words,3,1) != SUBSTR(ta.words,1,1) && SUBSTR(td.words,3,1) != SUBSTR(ta.words,2,1)
&& SUBSTR(td.words,3,1) != SUBSTR(tb.words,2,1) && SUBSTR(td.words,3,1) != SUBSTR(tb.words,3,1)
&& SUBSTR(td.words,3,1) != SUBSTR(tc.words,2,1) && SUBSTR(td.words,3,1) != SUBSTR(tc.words,3,1)
-- test v2 for eksistens af e og f
&& CONCAT(SUBSTR(tb.words,2,1),SUBSTR(tc.words,2,1),SUBSTR(td.words,2,1)) IN (SELECT words FROM test)
&& CONCAT(SUBSTR(tb.words,3,1),SUBSTR(tc.words,3,1),SUBSTR(td.words,3,1)) IN (SELECT words FROM test)
ORDER BY ta.words ASC, tb.words ASC, tc.words ASC, td.words ASC;


/*
SELECT ta.words AS ordA, tb.words AS ordB
FROM test AS ta, test AS tb
WHERE ta.words IN (SELECT tb.words
	FROM test AS tb
    WHERE);*/