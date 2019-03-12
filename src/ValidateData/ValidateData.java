package ValidateData;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class ValidateData {

    public TreeSet<String> validateData(ResultSet res)
    {

        TreeSet<String> set = new TreeSet<String>();
        TreeSet<String> newSet = new TreeSet<String>();

        try {
            while (res.next()) {
                String ord = res.getString("words").toLowerCase();

                if(letter(ord) && unique(ord))
                {
                    set.add(ord);
                }
            }

            //der saettes en iterator på settet og ordlisten smides ind i et nyt set
            //dette sker for at sortere æ ø å rigtigt...

            Iterator<String> itr = set.iterator();
            while(itr.hasNext())
            {
                String nytOrd = itr.next();
                newSet.add(nytOrd);
                System.out.println("Ord i den unikke liste, nu sorteret! " + nytOrd);
            }

        }

        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }



        return newSet;
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
