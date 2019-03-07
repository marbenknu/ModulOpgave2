package Connection;

import java.sql.*;

public class DBExecute {

    private DBConnection conn;
    private Statement st;

    // Query info
    private String query = "SELECT * " +
                           "FROM wordlist " +
                           "ORDER BY words ASC ";

    public DBExecute()
    {
        conn = new DBConnection();
        try
        {
            st = conn.newConnection().createStatement();
            ResultSet res = st.executeQuery(query);

            int s = 0;

                res.beforeFirst();
                while(res.next())
                {
                    String ord = res.getString("words");
                    System.out.println("Dette er vores ord:" + ord );

                    s++;
                    System.out.println(s);
                }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}

