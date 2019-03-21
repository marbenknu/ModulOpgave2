package Algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import Algorithm.HelperLib.HelperLibrary;

import static java.lang.System.currentTimeMillis;

public class Algorithm1v2 {

    //Listen af ord køres systematisk igennem og alle kombinationer af ord i én retning prøves af.
    public void algorithm1v2(TreeSet<String> wordList) {
        //Starttidspunktet markeres.
        long timeStart = currentTimeMillis();
        //Der oprettes et HashSet der indeholder endelige løsninger uden transponerede versioner.
        Set<Set<String>> transRemoved = new HashSet<>();
        //Første ord findes.
        for (String b : wordList) {
            //Andet ord findes.
            for (String c : wordList) {
                //Undersøger om første og andet ord indeholder 6 unikke bogstaver. Ja: fortsæt til tredje ord ellers find næste 'c' ord.
                if (HelperLibrary.uniqueLettersValidation(6, b, c, "")) {
                    //Tredje ord findes.
                    for (String d : wordList) {
                        //Undersøger om de tre ord der dannes i anden retning eksisterer i vores ordliste, og om de udgøres af 9 unikke bogstaver.
                        if (HelperLibrary.uniqueLettersValidation(9, b, c, d) && HelperLibrary.wordsExist(b, c, d, wordList)) {
                            //Hvis begge betingelser er overholdt, testes for om løsningen allerede eksisterer i transponeret udgave.
                            HelperLibrary.removeTransposedSolutions(transRemoved, b, c, d);
                        }
                    }
                }
            }
        }
        //Printer antal løsninger.
        System.out.println("Solutions: " + transRemoved.size());
        //Printer kørselstiden.
        HelperLibrary.timeTotal(timeStart);
    }
}