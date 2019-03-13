package DatabaseHandler.DBQuery;

public class AllQueries {

    public AllQueries(){}

    private String  query = "SELECT * " +
                            "FROM wordlist " +
                            "ORDER BY words ASC ";

    private String drop = "DROP TABLE IF EXISTS nyListe;";

    private String  table =   "CREATE TABLE nyListe "
                            + "(ordliste VARCHAR(3) NOT NULL);";

    private String insert = "INSERT INTO nyListe (ordliste) "
                            + "VALUES ";

    private String select = "SELECT * "
                            + "FROM nyListe "
                            + "ORDER BY ordliste ASC;";

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
