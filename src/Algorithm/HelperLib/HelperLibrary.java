package Algorithm.HelperLib;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class HelperLibrary {

    public static boolean uniqueLettersValidation(int size, String b, String c, String d) {
        Set<Character> uniq = new HashSet<>();
        //Lægger ordene sammen og splitter dem op i et char array, som køres igennem og alle enkelte bogstaver lægges i et sæt.
        for (char x : (b + c + d).toCharArray()) {
            uniq.add(x);
        }
        //Returnerer true hvis ingen bogstaver er gået tabt.
        return (uniq.size() == size);
    }

    public static boolean wordsExist(String b, String c, String d, TreeSet<String> wordList) {
        return (wordList.contains(Character.toString(b.charAt(0)) + c.charAt(0) + d.charAt(0))
                && wordList.contains(Character.toString(b.charAt(1)) + c.charAt(1) + d.charAt(1))
                && wordList.contains(Character.toString(b.charAt(2)) + c.charAt(2) + d.charAt(2)));
    }

    public static void removeTransposedSolutions(Set<Set<String>> trans, String b, String c, String d) {
        Set<String> solution = new HashSet<>();
        solution.add(b);
        solution.add(c);
        solution.add(d);
        solution.add(Character.toString(b.charAt(0)) + c.charAt(0) + d.charAt(0));
        solution.add(Character.toString(b.charAt(1)) + c.charAt(1) + d.charAt(1));
        solution.add(Character.toString(b.charAt(2)) + c.charAt(2) + d.charAt(2));
        trans.add(solution);
    }

    public static void timeTotal(long tStart) {
        long timeTotal = currentTimeMillis() - tStart;
        System.out.printf("Total run time: %d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes(timeTotal),
                TimeUnit.MILLISECONDS.toSeconds(timeTotal) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeTotal)));
        System.out.println();
    }
}