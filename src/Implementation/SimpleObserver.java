/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;
import interfaces.*;

/**
 *
 * @author garrytrue
 */
public class SimpleObserver implements Observer{
    private int mNumber;
    private String mName;
    private Obsevable mManager;
    
    public SimpleObserver(Obsevable manager, int n){
        mManager = manager;
        mNumber = n;
        
    }

    @Override
    public void update(String name) {
        mName = name;
        System.out.println("I'm Observer. My name is "+mName+". My Number is "+mNumber);
        
    }

//    @Override
//    public synchronized int getNumber() {
//        return mNumber;
//    }
//
//    @Override
//    public void registerObserver() {
//        mManager.addObserver(this);
//        System.out.println("Observer "+mNumber+" will be registered");
//    }
    
}
