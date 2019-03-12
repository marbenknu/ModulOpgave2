package Main;

import DatabaseHandler.DBExecute;
import DatabaseHandler.DBQuery.AllQueries;
import ValidateData.ValidateData;

import java.sql.ResultSet;
import java.util.TreeSet;

public class Program {


    private AllQueries queries = new AllQueries();
    private DBExecute execute = new DBExecute();
    private ResultSet res;
    private TreeSet<String> set;
    private ValidateData validation = new ValidateData();

    public Program(){}

    public void runStandardization()
    {
        String select = queries.getQuery();
        res = execute.executeSelect(select);
        set = validation.validateData(res);
    }

    public void runTableMaking()
    {
        String table = queries.getTable();
        execute.executeTable(table);
    }
}
