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

    private String algo2 = "SELECT count(*) AS antal " +
            "FROM nyListe AS ta, nyListe AS tb, nyListe AS tc, nyListe AS td " +
            "WHERE SUBSTR(ta.ordliste,1,1) = SUBSTR(tb.ordliste,1,1) " +
            "&& SUBSTR(ta.ordliste,2,1) != SUBSTR(tb.ordliste,2,1) && SUBSTR(ta.ordliste,2,1) != SUBSTR(tb.ordliste,3,1) " +
            "&& SUBSTR(ta.ordliste,3,1) != SUBSTR(tb.ordliste,2,1) && SUBSTR(ta.ordliste,3,1) != SUBSTR(tb.ordliste,3,1) " +
            "&& SUBSTR(ta.ordliste,2,1) = SUBSTR(tc.ordliste,1,1) " +
            " && SUBSTR(tc.ordliste,2,1) != SUBSTR(ta.ordliste,1,1) && SUBSTR(tc.ordliste,2,1) != SUBSTR(ta.ordliste,3,1) " +
            "&& SUBSTR(tc.ordliste,2,1) != SUBSTR(tb.ordliste,2,1) && SUBSTR(tc.ordliste,2,1) != SUBSTR(tb.ordliste,3,1) " +
            "&& SUBSTR(tc.ordliste,3,1) != SUBSTR(ta.ordliste,1,1) && SUBSTR(tc.ordliste,3,1) != SUBSTR(ta.ordliste,3,1) " +
            "&& SUBSTR(tc.ordliste,3,1) != SUBSTR(tb.ordliste,2,1) && SUBSTR(tc.ordliste,3,1) != SUBSTR(tb.ordliste,3,1) " +
            "&& CONCAT(SUBSTR(tb.ordliste,2,1),SUBSTR(tc.ordliste,2,1)) IN (SELECT CONCAT(SUBSTR(ordliste,1,1),SUBSTR(ordliste,2,1)) AS temp FROM nyListe) " +
            "&& CONCAT(SUBSTR(tb.ordliste,3,1),SUBSTR(tc.ordliste,3,1)) IN (SELECT CONCAT(SUBSTR(ordliste,1,1),SUBSTR(ordliste,2,1)) AS temp FROM nyListe) " +
            "&& SUBSTR(ta.ordliste,3,1) = SUBSTR(td.ordliste,1,1) " +
            "&& SUBSTR(td.ordliste,2,1) != SUBSTR(ta.ordliste,1,1) && SUBSTR(td.ordliste,2,1) != SUBSTR(ta.ordliste,2,1) " +
            "&& SUBSTR(td.ordliste,2,1) != SUBSTR(tb.ordliste,2,1) && SUBSTR(td.ordliste,2,1) != SUBSTR(tb.ordliste,3,1) " +
            "&& SUBSTR(td.ordliste,2,1) != SUBSTR(tc.ordliste,2,1) && SUBSTR(td.ordliste,2,1) != SUBSTR(tc.ordliste,3,1) " +
            "&& SUBSTR(td.ordliste,3,1) != SUBSTR(ta.ordliste,1,1) && SUBSTR(td.ordliste,3,1) != SUBSTR(ta.ordliste,2,1) " +
            "&& SUBSTR(td.ordliste,3,1) != SUBSTR(tb.ordliste,2,1) && SUBSTR(td.ordliste,3,1) != SUBSTR(tb.ordliste,3,1) " +
            "&& SUBSTR(td.ordliste,3,1) != SUBSTR(tc.ordliste,2,1) && SUBSTR(td.ordliste,3,1) != SUBSTR(tc.ordliste,3,1) " +
            "&& CONCAT(SUBSTR(tb.ordliste,2,1),SUBSTR(tc.ordliste,2,1),SUBSTR(td.ordliste,2,1)) IN (SELECT ordliste FROM nyListe) " +
            "&& CONCAT(SUBSTR(tb.ordliste,3,1),SUBSTR(tc.ordliste,3,1),SUBSTR(td.ordliste,3,1)) IN (SELECT ordliste FROM nyListe) ";

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