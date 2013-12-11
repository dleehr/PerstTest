package org.nescent.persttest;

import org.garret.perst.Persistent;

/**
 *
 * @author Dan Leehr (dan.leehr@nescent.org)
 */
public class SimplePersistent extends Persistent {

    public void SimpleOperation(boolean fail) {
        if(fail) {
            PrintLength(null);
        } else {
            PrintLength("some string");
        }
    }

    private void PrintLength(String s) {
        int length = s.length();
        System.out.println("Length of string is s");
    }
}
