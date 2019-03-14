package Main;

import algorithm.Algorithm1;
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

        res = execute.executeSelect1();
        set = validation.validateData(res);
        return set;
    }

    public void runDrop()
    {

        execute.executeDrop();
    }

    public void runTableMaking()
    {

        execute.executeTable();
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

        ResultSet res2 = execute.executeSelect2();
        TreeSet<String> nytSet = new TreeSet<String>();
        Algorithm1 algo = new Algorithm1();

        try
        {
            while(res2.next())
            {
                String ord = res2.getString("ordliste");
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
