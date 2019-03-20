package DataValidation;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.TreeSet;

public class DataValidation {

    public DataValidation() {}


    public TreeSet<String> validateData(ResultSet res)
    {

        //Opretter nyt TreeSet.
        TreeSet<String> set = new TreeSet<String>();

        //Kører resultst igennem og sætter alt til lowercase og tilføjer til 'set' hvis de to metoder returnerer 'true'.
        try {
            while (res.next()) {
                String ord = res.getString("words").toLowerCase();

                if(letter(ord) && unique(ord))
                {
                    set.add(ord);
                }
            }
        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("Data valideret!");
        return set;
    }

    private boolean letter(String ord)
    {
        char et = ord.charAt(0);
        char to = ord.charAt(1);
        char tre = ord.charAt(2);

        //Undersøger om ordene udelukkende udgøres af bogstaver.
        if (Character.isLetter(et) && Character.isLetter(to) && Character.isLetter(tre)) {
                return true;
        }
        return false;
    }

    private boolean unique(String ord)
    {
        char et = ord.charAt(0);
        char to = ord.charAt(1);
        char tre = ord.charAt(2);

        //Undersøger om alle bogstaver i hvert ord er unikke.
        if(et == to || to == tre || et == tre)
        {
            return false;
        }
        return true;
    }
}