package DatabaseHandler;

import DatabaseHandler.DBQuery.AllQueries;

import java.sql.*;

public class DBExecute {
    private DBConnection conn = new DBConnection();
    private Statement st;
    private ResultSet res;
    private AllQueries queries = new AllQueries();

    public DBExecute() {
        try {
            st = conn.newConnection().createStatement();
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    //metode til at returnere et resultsæt fra et select statement
    public ResultSet executeSelect1() {
        String select = queries.getQuery();

        try {

                res = st.executeQuery(select);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return res;

    }

    public ResultSet executeSelect2()
    {
        String select = queries.getSelect();
        try {

            res = st.executeQuery(select);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return res;

    }

    public void executeDrop()
    {
        String drop = queries.getDrop();
        try
        {

            st.execute(drop);
            System.out.println("Tabel droppet!");
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void executeTable()
    {
        String table = queries.getTable();
        try
        {

            st.executeUpdate(table);
            System.out.println("Tabel oprettet!");
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void executeInsert(String query)
    {

        try
        {

            st.executeUpdate(query);
            System.out.println("Værdier indsat!");
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


}
