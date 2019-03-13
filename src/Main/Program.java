package Main;

import Algorithm.Algorithm1;
import DatabaseHandler.DBExecute;
import DatabaseHandler.DBQuery.AllQueries;
import DataValidation.DataValidation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.TreeSet;

public class Program {


    private AllQueries queries = new AllQueries();
    private DBExecute execute = new DBExecute();
    private ResultSet res;
    private TreeSet<String> set;
    private DataValidation validation = new DataValidation();

    public Program(){}

    public TreeSet<String> runStandardization()
    {
        String select = queries.getQuery();
        res = execute.executeSelect(select);
        set = validation.validateData(res);
        return set;
    }

    public void runDrop()
    {
        String drop = queries.getDrop();
        execute.executeDrop(drop);
    }

    public void runTableMaking()
    {
        String table = queries.getTable();
        execute.executeTable(table);
    }

    public void runInsert(TreeSet<String> standartSet)
    {
        String insert = queries.getInsert();
        Iterator<String> itr = standartSet.iterator();
        String ord;
        while(itr.hasNext()) {

            for (int i = 0; i < standartSet.size() - 1; i++) {
                ord = itr.next();
                insert = insert + "('" + ord + "'),\n";
            }
            ord = itr.next();
            insert = insert + "('" + ord + "');";
        }
        execute.executeInsert(insert);
    }

    public void runAlgorithm()
    {
        String select = queries.getSelect();
        res = execute.executeSelect(select);
        TreeSet<String> nytSet = new TreeSet<String>();
        Algorithm.Algorithm1 algo = new Algorithm1();

        try
        {
            while(res.next())
            {
                String ord = res.getString("ordliste");
                nytSet.add(ord);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        algo.algorithm1(nytSet);
    }
}
