use crossword;

DROP TABLE IF EXISTS algo3;
CREATE TABLE algo3
AS (SELECT a.ordliste as ordA, b.ordliste as ordB
FROM nyListe as a, nyListe as b
WHERE substr(a.ordliste, 1, 1) = substr(b.ordliste, 1, 1) && a.ordliste != b.ordliste 
&& substr(a.ordliste, 2, 1) != substr(b.ordliste, 2, 1)
&& substr(a.ordliste, 3, 1) != substr(b.ordliste, 2, 1)
&& substr(a.ordliste, 2, 1) != substr(b.ordliste, 3, 1)
&& substr(a.ordliste, 3, 1) != substr(b.ordliste, 3, 1));

DROP TABLE IF EXISTS algo3v1;
CREATE TABLE algo3v1
AS (SELECT d.ordliste as ordD, f.ordliste as ordF
FROM nyListe as d, nyListe as f
WHERE substr(d.ordliste, 3, 1) = substr(f.ordliste, 3, 1) && d.ordliste != f.ordliste 
&& substr(d.ordliste, 2, 1) != substr(f.ordliste, 2, 1)
&& substr(d.ordliste, 1, 1) != substr(f.ordliste, 2, 1)
&& substr(d.ordliste, 2, 1) != substr(f.ordliste, 1, 1)
&& substr(d.ordliste, 1, 1) != substr(f.ordliste, 1, 1));

SELECT x.ordA, x.ordB, y.ordD, y.ordF, z.ordliste AS ordC
FROM algo3 as x INNER JOIN algo3v1 as y ON (substr(x.ordA, 3,1) = substr(y.ordD, 1,1)
&& substr(x.ordB, 3,1) = substr(y.ordF, 1, 1)) 
INNER JOIN nyListe as z ON CONCAT(substr(x.ordB, 2, 1), "_", substr(y.ordD, 2, 1)) IN (select ordliste from nyListe)
&& CONCAT(substr(x.ordA, 2, 1), "_", substr(y.ordF, 2, 1)) IN (select ordliste from nyListe)
WHERE substr(x.ordA, 1, 1) != substr(y.ordF, 2, 1)
&& substr(x.ordA, 1, 1) != substr(y.ordF, 3, 1)
&& substr(x.ordA, 1, 1) != substr(y.ordD, 2, 1)
&& substr(x.ordA, 2, 1) != substr(y.ordF, 2, 1)
&& substr(x.ordA, 2, 1) != substr(y.ordF, 3, 1)
&& substr(x.ordA, 2, 1) != substr(y.ordD, 2, 1)
&& substr(x.ordB, 2, 1) != substr(y.ordF, 2, 1)
&& substr(x.ordB, 2, 1) != substr(y.ordF, 3, 1)
&& substr(x.ordB, 2, 1) != substr(y.ordD, 2, 1)
&& substr(x.ordA, 1, 1) != substr(ordliste, 2, 1)
&& substr(x.ordB, 3, 1) != substr(ordliste, 2, 1)
&& substr(y.ordF, 3, 1) != substr(ordliste, 2, 1)
&& substr(y.ordD, 1, 1) != substr(ordliste, 2, 1);