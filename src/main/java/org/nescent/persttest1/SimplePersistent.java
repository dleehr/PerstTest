/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nescent.persttest1;

import org.garret.perst.Persistent;

/**
 *
 * @author dan
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
