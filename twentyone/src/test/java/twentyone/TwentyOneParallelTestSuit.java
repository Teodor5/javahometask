package twentyone;


import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

public class TwentyOneParallelTestSuit {

    @Test
    public void test() {
        Class[] cls = {TwentyOneTest.class};

        // Parallel among methods in a class
        JUnitCore.runClasses(ParallelComputer.methods(), cls);

        System.out.println("----------------------------");

        // Parallel among classes
        //JUnitCore.runClasses(ParallelComputer.classes(), cls);

        //System.out.println("----------------------------");

        // Parallel all methods in all classes
        //JUnitCore.runClasses(new ParallelComputer(true, true), cls);
    }
}