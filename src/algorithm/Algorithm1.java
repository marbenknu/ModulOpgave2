package algorithm;

import java.util.*;

public class Algorithm1 {

        public void hej()
        {

            Set<String> ord = new HashSet<>();

            ord.add("kro");
            ord.add("klo");
            ord.add("ræv");
            ord.add("ose");
            ord.add("øve");
            ord.add("læs");

            for (String a : ord) {
                for (String b : ord) {
                    while(a.charAt(0) == b.charAt(0))
                    {
                        for (String c: ord) {
                            while(a.charAt(1) == c.charAt(0))
                            {
                                for (String d: ord) {
                                    while(a.charAt(2) == d.charAt(0))
                                    {
                                        String e = Character.toString(a.charAt(1)) + Character.toString(c.charAt(1)) + Character.toString(d.charAt(1));
                                        String f = Character.toString(a.charAt(2)) + Character.toString(c.charAt(2)) + Character.toString(d.charAt(2));
                                        if (ord.contains(e) && ord.contains(f))
                                        {

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
    }
}
