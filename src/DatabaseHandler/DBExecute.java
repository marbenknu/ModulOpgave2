package DatabaseHandler;

import java.sql.*;

public class DBExecute {
    private DBConnection conn = new DBConnection();
    private Statement st;
    private ResultSet res;

    public DBExecute() {}


    //metode til at returnere et resultsæt fra et select statement
    public ResultSet executeSelect(String query) {
        try {
                st = conn.newConnection().createStatement();
                res = st.executeQuery(query);


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return res;

    }

    public void executeDrop(String query)
    {
        try
        {
            st = conn.newConnection().createStatement();
            st.execute(query);
            System.out.println("Tabel droppet!");
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void executeTable(String query)
    {
        try
        {
            st = conn.newConnection().createStatement();
            st.executeUpdate(query);
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
            st = conn.newConnection().createStatement();
            st.executeUpdate(query);
            System.out.println("Værdier indsat!");
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


}
