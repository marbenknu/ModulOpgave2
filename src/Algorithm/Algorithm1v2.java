package Algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class Algorithm1v2 {

    //Listen af ord køres systematisk igennem og alle kombinationer af ord i én retning prøves af.
    public void algorithm1v2(TreeSet<String> wordList) {
        long timeStart = currentTimeMillis();
        int i = 0;
        //Første ord findes.
        for (String b : wordList) {
            //Andet ord findes.
            for (String c : wordList) {
                //Undersøger om første og andet ord indeholder 6 unikke bogstaver. Ja: fortsæt til tredje ord ellers find næste 'c' ord.
                if (uniqueLettersValidation(6, b, c, "")) {
                    //Tredje ord findes.
                    for (String d : wordList) {
                        //Undersøger om de tre ord der dannes i anden retning eksisterer i vores ordliste og om de udgøres af 9 unikke bogstaver.
                        //Hvis begge betingelser er overholdt, gemmes løsningen.
                        if (uniqueLettersValidation(9, b, c, d) && wordsExist(b, c, d, wordList)) {
                            i++;
                        }
                    }
                }
            }
        }
        System.out.println("Solution: " + i);
        long timeTotal = currentTimeMillis() - timeStart;
        System.out.printf("Total run time: %d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes(timeTotal),
                TimeUnit.MILLISECONDS.toSeconds(timeTotal) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeTotal)));
    }

    private boolean uniqueLettersValidation(int size, String b, String c, String d) {
        Set<Character> uniq = new HashSet<>();
        //Lægger ordene sammen og splitter dem op i et char array, som køres igennem og alle enkelte bogstaver lægges i et sæt.
        for (char x : (b + c + d).toCharArray()) {
            uniq.add(x);
        }
        //Returnerer true hvis ingen bogstaer er gået tabt.
        return (uniq.size() == size);
    }

    private boolean wordsExist(String b, String c, String d, TreeSet<String> wordList) {
        return (wordList.contains(Character.toString(b.charAt(0)) + c.charAt(0) + d.charAt(0))
                && wordList.contains(Character.toString(b.charAt(1)) + c.charAt(1) + d.charAt(1))
                && wordList.contains(Character.toString(b.charAt(2)) + c.charAt(2) + d.charAt(2)));
    }
}