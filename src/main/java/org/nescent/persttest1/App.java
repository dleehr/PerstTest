package org.nescent.persttest1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PerstTester tester = new PerstTester();
        try {
            tester.testReadNoCatch(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            tester.testWriteCatch(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        tester.testReadCatch(false);
        tester.testWriteCatch(false);
    }
}
