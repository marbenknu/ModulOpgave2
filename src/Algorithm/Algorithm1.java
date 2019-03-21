package Algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import Algorithm.HelperLib.HelperLibrary;

import static java.lang.System.currentTimeMillis;

public class Algorithm1 {

    public void algorithm1(TreeSet<String> wordList) {
        long timeStart = currentTimeMillis();
        Set<Set<String>> transRemoved = new HashSet<>();
        for (String b : wordList) {
            for (String c : wordList) {
                for (String d : wordList) {
                    if (HelperLibrary.uniqueLettersValidation(9, b, c, d) && HelperLibrary.wordsExist(b, c, d, wordList)) {
                        HelperLibrary.removeTransposedSolutions(transRemoved, b, c, d);
                    }
                }
            }
        }
        System.out.println("Solutions: " + transRemoved.size());
        HelperLibrary.timeTotal(timeStart);
    }
}