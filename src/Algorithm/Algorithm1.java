package Algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import static java.lang.System.currentTimeMillis;

public class Algorithm1 {

    public void algorithm1(TreeSet<String> wordList) {
        long timeStart = currentTimeMillis();
        int i = 0;
        for (String b : wordList) {
            for (String c : wordList) {
                for (String d : wordList) {
                    if (uniqueLettersValidation(b, c, d) && wordsExist(b, c, d, wordList)) {
                        i++;
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

    private boolean uniqueLettersValidation(String b, String c, String d) {
        Set<Character> uniq = new HashSet<>();
        for (char x : (b + c + d).toCharArray()) {
            uniq.add(x);
        }
        return (uniq.size() == 9);
    }

    private boolean wordsExist(String b, String c, String d, TreeSet<String> wordList) {
        return (wordList.contains(Character.toString(b.charAt(0)) + c.charAt(0) + d.charAt(0))
                && wordList.contains(Character.toString(b.charAt(1)) + c.charAt(1) + d.charAt(1))
                && wordList.contains(Character.toString(b.charAt(2)) + c.charAt(2) + d.charAt(2)));
    }
}