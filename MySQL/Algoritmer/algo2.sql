SELECT 
    /*COUNT(*),*/ ta.ordliste AS ordA, tb.ordliste AS ordB, tc.ordliste AS ordC, td.ordliste AS ordD,
    CONCAT(SUBSTR(tb.ordliste,2,1),SUBSTR(tc.ordliste,2,1),SUBSTR(td.ordliste,2,1)) AS ordE,
    CONCAT(SUBSTR(tb.ordliste,3,1),SUBSTR(tc.ordliste,3,1),SUBSTR(td.ordliste,3,1)) AS ordF
FROM
    nyListe AS ta,
    nyListe AS tb,
    nyListe AS tc,
    nyListe AS td
WHERE
    SUBSTR(ta.ordliste, 1, 1) = SUBSTR(tb.ordliste, 1, 1)
        && SUBSTR(ta.ordliste, 2, 1) = SUBSTR(tc.ordliste, 1, 1)
        && CONCAT(SUBSTR(tb.ordliste, 2, 1),
            SUBSTR(tc.ordliste, 2, 1)) IN (SELECT 
            SUBSTR(ordliste, 1, 2) AS temp
        FROM
            nyListe)
        && CONCAT(SUBSTR(tb.ordliste, 3, 1),
            SUBSTR(tc.ordliste, 3, 1)) IN (SELECT 
            SUBSTR(ordliste, 1, 2) AS temp
        FROM
            nyListe)
        && SUBSTR(ta.ordliste, 3, 1) = SUBSTR(td.ordliste, 1, 1)
        && CONCAT(SUBSTR(tb.ordliste, 2, 1),
            SUBSTR(tc.ordliste, 2, 1),
            SUBSTR(td.ordliste, 2, 1)) IN (SELECT 
            ordliste
        FROM
            nyListe)
        && CONCAT(SUBSTR(tb.ordliste, 3, 1),
            SUBSTR(tc.ordliste, 3, 1),
            SUBSTR(td.ordliste, 3, 1)) IN (SELECT 
            ordliste
        FROM
            nyListe)
        && SUBSTR(ta.ordliste, 1, 1) != SUBSTR(tc.ordliste, 2, 1)
        && SUBSTR(ta.ordliste, 1, 1) != SUBSTR(tc.ordliste, 3, 1)
        && SUBSTR(ta.ordliste, 1, 1) != SUBSTR(td.ordliste, 2, 1)
        && SUBSTR(ta.ordliste, 1, 1) != SUBSTR(td.ordliste, 3, 1)
        && SUBSTR(ta.ordliste, 2, 1) != SUBSTR(tb.ordliste, 2, 1)
        && SUBSTR(ta.ordliste, 2, 1) != SUBSTR(tb.ordliste, 3, 1)
        && SUBSTR(ta.ordliste, 2, 1) != SUBSTR(td.ordliste, 2, 1)
        && SUBSTR(ta.ordliste, 2, 1) != SUBSTR(td.ordliste, 3, 1)
        && SUBSTR(ta.ordliste, 3, 1) != SUBSTR(tb.ordliste, 2, 1)
        && SUBSTR(ta.ordliste, 3, 1) != SUBSTR(tb.ordliste, 3, 1)
        && SUBSTR(ta.ordliste, 3, 1) != SUBSTR(tc.ordliste, 2, 1)
        && SUBSTR(ta.ordliste, 3, 1) != SUBSTR(tc.ordliste, 3, 1)
        && SUBSTR(tb.ordliste, 2, 1) != SUBSTR(tc.ordliste, 2, 1)
        && SUBSTR(tb.ordliste, 2, 1) != SUBSTR(tc.ordliste, 3, 1)
        && SUBSTR(tb.ordliste, 2, 1) != SUBSTR(td.ordliste, 2, 1)
        && SUBSTR(tb.ordliste, 2, 1) != SUBSTR(td.ordliste, 3, 1)
        && SUBSTR(tb.ordliste, 3, 1) != SUBSTR(tc.ordliste, 2, 1)
        && SUBSTR(tb.ordliste, 3, 1) != SUBSTR(tc.ordliste, 3, 1)
        && SUBSTR(tb.ordliste, 3, 1) != SUBSTR(td.ordliste, 2, 1)
        && SUBSTR(tb.ordliste, 3, 1) != SUBSTR(td.ordliste, 3, 1)
        && SUBSTR(tc.ordliste, 2, 1) != SUBSTR(td.ordliste, 2, 1)
        && SUBSTR(tc.ordliste, 2, 1) != SUBSTR(td.ordliste, 3, 1)
        && SUBSTR(tc.ordliste, 3, 1) != SUBSTR(td.ordliste, 2, 1)
        && SUBSTR(tc.ordliste, 3, 1) != SUBSTR(td.ordliste, 3, 1)
;