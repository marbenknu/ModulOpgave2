package DatabaseHandler.DBQuery;

public class AllQueries {

    public AllQueries(){}

    private String  query = "SELECT * " +
                            "FROM wordlist " +
                            "ORDER BY words ASC ";

    private String  table = "CREATE TABLE IF NOT EXISTS nyListe "
                            + "(ordliste VARCHAR(3) NOT NULL);";


    public String getQuery()
    {
        return this.query;
    }

    public String getTable()
    {
        return this.table;
    }





}
