package Algorithm;

public class Algorithm2 {
    private String algo2 = "SELECT ta.words AS ordA, tb.words AS ordB, tc.words AS ordC, td.words AS ordD " +
                            "FROM test AS ta, test AS tb, test AS tc, test AS td " +
                            "WHERE SUBSTR(ta.words,1,1) = SUBSTR(tb.words,1,1) " +
                            "&& SUBSTR(ta.words,2,1) != SUBSTR(tb.words,2,1) && SUBSTR(ta.words,2,1) != SUBSTR(tb.words,3,1) " +
                            "&& SUBSTR(ta.words,3,1) != SUBSTR(tb.words,2,1) && SUBSTR(ta.words,3,1) != SUBSTR(tb.words,3,1) " +
                            "&& SUBSTR(ta.words,2,1) = SUBSTR(tc.words,1,1) " +
                            " && SUBSTR(tc.words,2,1) != SUBSTR(ta.words,1,1) && SUBSTR(tc.words,2,1) != SUBSTR(ta.words,3,1) " +
                            "&& SUBSTR(tc.words,2,1) != SUBSTR(tb.words,2,1) && SUBSTR(tc.words,2,1) != SUBSTR(tb.words,3,1) " +
                            "&& SUBSTR(tc.words,3,1) != SUBSTR(ta.words,1,1) && SUBSTR(tc.words,3,1) != SUBSTR(ta.words,3,1) " +
                            "&& SUBSTR(tc.words,3,1) != SUBSTR(tb.words,2,1) && SUBSTR(tc.words,3,1) != SUBSTR(tb.words,3,1) " +
                            "&& CONCAT(SUBSTR(tb.words,2,1),SUBSTR(tc.words,2,1)) IN (SELECT CONCAT(SUBSTR(words,1,1),SUBSTR(words,2,1)) AS temp FROM test) " +
                            "&& CONCAT(SUBSTR(tb.words,3,1),SUBSTR(tc.words,3,1)) IN (SELECT CONCAT(SUBSTR(words,1,1),SUBSTR(words,2,1)) AS temp FROM test) " +
                            "&& SUBSTR(ta.words,3,1) = SUBSTR(td.words,1,1) " +
                            "&& SUBSTR(td.words,2,1) != SUBSTR(ta.words,1,1) && SUBSTR(td.words,2,1) != SUBSTR(ta.words,2,1) " +
                            "&& SUBSTR(td.words,2,1) != SUBSTR(tb.words,2,1) && SUBSTR(td.words,2,1) != SUBSTR(tb.words,3,1) " +
                            "&& SUBSTR(td.words,2,1) != SUBSTR(tc.words,2,1) && SUBSTR(td.words,2,1) != SUBSTR(tc.words,3,1) " +
                            "&& SUBSTR(td.words,3,1) != SUBSTR(ta.words,1,1) && SUBSTR(td.words,3,1) != SUBSTR(ta.words,2,1) " +
                            "&& SUBSTR(td.words,3,1) != SUBSTR(tb.words,2,1) && SUBSTR(td.words,3,1) != SUBSTR(tb.words,3,1) " +
                            "&& SUBSTR(td.words,3,1) != SUBSTR(tc.words,2,1) && SUBSTR(td.words,3,1) != SUBSTR(tc.words,3,1) " +
                            "&& CONCAT(SUBSTR(tb.words,2,1),SUBSTR(tc.words,2,1),SUBSTR(td.words,2,1)) IN (SELECT words FROM test) " +
                            "&& CONCAT(SUBSTR(tb.words,3,1),SUBSTR(tc.words,3,1),SUBSTR(td.words,3,1)) IN (SELECT words FROM test) " +
                            "ORDER BY ta.words ASC, tb.words ASC, tc.words ASC, td.words ASC ";

            public String getAlgo2() { return this.algo2; }
                            }
