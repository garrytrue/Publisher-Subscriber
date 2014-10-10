/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackadge;

import Implementation.*;

/**
 *
 * @author garrytrue
 */
public class ObserverPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ObserverWithCashe mObserverWithCashe = new ObserverWithCashe();

        PrintObserver mPrintObserver1 = new PrintObserver(1);
        mObserverWithCashe.addObserver(mPrintObserver1);
        mObserverWithCashe.notifyObservers("one");
        PrintObserver mPrintObserver2 = new PrintObserver(2);
        mObserverWithCashe.addObserver(mPrintObserver2);
        mObserverWithCashe.notifyObservers("Two");
        PrintObserver mPrintObserver3 = new PrintObserver(3);
        mObserverWithCashe.addObserver(mPrintObserver3);
         mObserverWithCashe.notifyObservers("Three");
         System.out.println("Delete observer one");
        mObserverWithCashe.removeObserver(mPrintObserver1);
        PrintObserver mPrintObserver4 = new PrintObserver(4);
        mObserverWithCashe.addObserver(mPrintObserver4);
        mObserverWithCashe.notifyObservers("Four");
        

    }

}
