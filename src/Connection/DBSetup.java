package Connection;

/**
 * Klassen indeholder login oplysninger til databasen.
 * **/

public class DBSetup {

    private String dbUrl = "jdbc:mysql://localhost:3306/crossword";
    private String username = "moduluser";
    private String password = "gruppe7";

    public DBSetup(){}

    public String getDbUrl(){
        return dbUrl;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

}