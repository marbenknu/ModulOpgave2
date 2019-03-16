package DatabaseHandler.DBQuery;

public class AllQueries {

    public AllQueries(){}

    private String  query = "SELECT * " +
                            "FROM wordlist " +
                            "ORDER BY words ASC ";

    private String drop = "DROP TABLE IF EXISTS nyListe;";

    private String  table =   "CREATE TABLE nyListe "
                            + "(ordliste CHAR(3) NOT NULL) CHARACTER SET utf8 COLLATE utf8_danish_ci;";

    private String insert = "INSERT INTO nyListe (ordliste) "
                            + "VALUES ";

    private String select = "SELECT * "
                            + "FROM nyListe "
                            + "ORDER BY ordliste ASC;";

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

    public String getQuery()
    {
        return this.query;
    }

    public String getDrop() { return this.drop; }

    public String getTable()
    {
        return this.table;
    }

    public String getInsert() {return this.insert;}

    public String getSelect() { return this.select;}
}