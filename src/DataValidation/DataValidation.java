package DataValidation;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.TreeSet;

public class DataValidation {

    public DataValidation() {}


    public TreeSet<String> validateData(ResultSet res)
    {

        TreeSet<String> set = new TreeSet<String>();

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



        return set;
    }

    private boolean letter(String ord)
    {
        char et = ord.charAt(0);
        char to = ord.charAt(1);
        char tre = ord.charAt(2);

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

        if(et == to || to == tre || et == tre)
        {
            return false;
        }
        return true;
    }
}
