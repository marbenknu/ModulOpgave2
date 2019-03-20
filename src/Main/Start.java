package Main;

import java.util.TreeSet;

public class Start {

    public static void main(String[] args) {

        Program run = new Program();
        //metoden runStandardization() returnerer et TreeSet som gives videre som parameter i runInsert metoden.
        TreeSet<String> set = run.runStandardization();
        run.runDrop();
        run.runTableMaking();
        run.runInsert(set);
        //run.runAlgorithm("algo1");
        run.runAlgo2();
        run.closeProgram();
    }
}
