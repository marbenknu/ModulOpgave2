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