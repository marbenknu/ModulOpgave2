package Main;

import algorithm.Algorithm1;
import DatabaseHandler.DBExecute;
import DatabaseHandler.DBQuery.AllQueries;
import DataValidation.DataValidation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class Program {


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

    public void runInsert(TreeSet<String> standardSet)
    {
        execute.executeInsert(standardSet);
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

    public void runAlgo2()
    {
        long timeStart = currentTimeMillis();
        ResultSet res3 = execute.executeSelect3();
        long timeTotal = currentTimeMillis() - timeStart;
        System.out.printf("Total run time: %d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes(timeTotal),
                TimeUnit.MILLISECONDS.toSeconds(timeTotal) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeTotal)));
    }
}
