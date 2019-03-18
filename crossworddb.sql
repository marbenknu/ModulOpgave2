-- CREATE DATABASE AND TABLE
DROP DATABASE IF EXISTS crossword;
CREATE DATABASE IF NOT EXISTS crossword;
USE crossword;
CREATE TABLE wordlist (
    words CHAR(3) NOT NULL
)  CHARACTER SET UTF8MB4 COLLATE UTF8MB4_DANISH_CI;

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

SELECT 
    COUNT(*)
FROM
    wordlist AS ta,
    wordlist AS tb,
    wordlist AS tc,
    wordlist AS td
WHERE
    SUBSTR(ta.words, 1, 1) = SUBSTR(tb.words, 1, 1)
        && SUBSTR(ta.words, 2, 1) = SUBSTR(tc.words, 1, 1)
        && CONCAT(SUBSTR(tb.words, 2, 1),
            SUBSTR(tc.words, 2, 1)) IN (SELECT 
            SUBSTR(words, 1, 2) AS temp
        FROM
            wordlist)
        && CONCAT(SUBSTR(tb.words, 3, 1),
            SUBSTR(tc.words, 3, 1)) IN (SELECT 
            SUBSTR(words, 1, 2) AS temp
        FROM
            wordlist)
        && SUBSTR(ta.words, 3, 1) = SUBSTR(td.words, 1, 1)
        && CONCAT(SUBSTR(tb.words, 2, 1),
            SUBSTR(tc.words, 2, 1),
            SUBSTR(td.words, 2, 1)) IN (SELECT 
            words
        FROM
            wordlist)
        && CONCAT(SUBSTR(tb.words, 3, 1),
            SUBSTR(tc.words, 3, 1),
            SUBSTR(td.words, 3, 1)) IN (SELECT 
            words
        FROM
            wordlist)
        && SUBSTR(ta.words, 1, 1) != SUBSTR(tc.words, 2, 1)
        && SUBSTR(ta.words, 1, 1) != SUBSTR(tc.words, 3, 1)
        && SUBSTR(ta.words, 1, 1) != SUBSTR(td.words, 2, 1)
        && SUBSTR(ta.words, 1, 1) != SUBSTR(td.words, 3, 1)
        && SUBSTR(ta.words, 2, 1) != SUBSTR(tb.words, 2, 1)
        && SUBSTR(ta.words, 2, 1) != SUBSTR(tb.words, 3, 1)
        && SUBSTR(ta.words, 2, 1) != SUBSTR(td.words, 2, 1)
        && SUBSTR(ta.words, 2, 1) != SUBSTR(td.words, 3, 1)
        && SUBSTR(ta.words, 3, 1) != SUBSTR(tb.words, 2, 1)
        && SUBSTR(ta.words, 3, 1) != SUBSTR(tb.words, 3, 1)
        && SUBSTR(ta.words, 3, 1) != SUBSTR(tc.words, 2, 1)
        && SUBSTR(ta.words, 3, 1) != SUBSTR(tc.words, 3, 1)
        && SUBSTR(tb.words, 2, 1) != SUBSTR(tc.words, 2, 1)
        && SUBSTR(tb.words, 2, 1) != SUBSTR(tc.words, 3, 1)
        && SUBSTR(tb.words, 2, 1) != SUBSTR(td.words, 2, 1)
        && SUBSTR(tb.words, 2, 1) != SUBSTR(td.words, 3, 1)
        && SUBSTR(tb.words, 3, 1) != SUBSTR(tc.words, 2, 1)
        && SUBSTR(tb.words, 3, 1) != SUBSTR(tc.words, 3, 1)
        && SUBSTR(tb.words, 3, 1) != SUBSTR(td.words, 2, 1)
        && SUBSTR(tb.words, 3, 1) != SUBSTR(td.words, 3, 1)
        && SUBSTR(tc.words, 2, 1) != SUBSTR(td.words, 2, 1)
        && SUBSTR(tc.words, 2, 1) != SUBSTR(td.words, 3, 1)
        && SUBSTR(tc.words, 3, 1) != SUBSTR(td.words, 2, 1)
        && SUBSTR(tc.words, 3, 1) != SUBSTR(td.words, 3, 1)
;