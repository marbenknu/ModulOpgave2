-- CREATE DATABASE AND TABLE
DROP DATABASE IF EXISTS crossword;
CREATE DATABASE IF NOT EXISTS crossword;
USE crossword;
DROP TABLE IF EXISTS wordlist;
CREATE TABLE IF NOT EXISTS wordlist
(
	words	CHAR(3)	NOT NULL
) CHARACTER SET utf8 COLLATE utf8_danish_ci;

-- LOAD DATAFILE
LOAD DATA INFILE "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\3LetterWord_CSV.csv"
INTO TABLE wordlist
CHARACTER SET latin1;

-- CREATE USER
DROP USER IF EXISTS 'moduluser'@'localhost';
CREATE USER IF NOT EXISTS 'moduluser'@'localhost' IDENTIFIED BY 'gruppe7';
GRANT ALL ON *.* TO 'moduluser'@'localhost';
FLUSH PRIVILEGES; -- Only needed when modifying the grant tables directly using statements such as INSERT, UPDATE, or DELETE

-- Algorithm2
SELECT COUNT(*)-- ta.words AS ordA, tb.words AS ordB, tc.words AS ordC, td.words AS ordD
FROM wordlist AS ta, wordlist AS tb, wordlist AS tc, wordlist AS td
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
&& CONCAT(SUBSTR(tb.words,2,1),SUBSTR(tc.words,2,1)) IN (SELECT CONCAT(SUBSTR(words,1,1),SUBSTR(words,2,1)) AS temp FROM wordlist)
&& CONCAT(SUBSTR(tb.words,3,1),SUBSTR(tc.words,3,1)) IN (SELECT CONCAT(SUBSTR(words,1,1),SUBSTR(words,2,1)) AS temp FROM wordlist)
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
&& CONCAT(SUBSTR(tb.words,2,1),SUBSTR(tc.words,2,1),SUBSTR(td.words,2,1)) IN (SELECT words FROM wordlist)
&& CONCAT(SUBSTR(tb.words,3,1),SUBSTR(tc.words,3,1),SUBSTR(td.words,3,1)) IN (SELECT words FROM wordlist)
ORDER BY ta.words ASC, tb.words ASC, tc.words ASC, td.words ASC;