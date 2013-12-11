package org.nescent.persttest;

/**
 *
 * @author Dan Leehr (dan.leehr@nescent.org)
 */
public class Main
{
    public static void main( String[] args )
    {
        PerstTester tester = new PerstTester();
        boolean throwException = false;

        /* First, perform an operation that obtains a shared (read-only) lock */
        try {
            throwException = true;
            /* but throws an exception before the lock is released */
            tester.testReadNoCatch(throwException);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /* Now, the resource is locked.  Other shared locks will succeed, */
        try {
            throwException = false;
            tester.testReadNoCatch(throwException);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /* but an exclusive lock will wait for the resource to unlock. */

        try {
            throwException = false;
            /* this call cannot complete */
            tester.testWriteCatch(throwException);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        tester.testReadCatch(throwException);
        tester.testWriteCatch(throwException);
    }
}
