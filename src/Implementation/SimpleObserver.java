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
public class SimpleObserver<T> implements Observer<T>{
    private int mNumber;
    private T mName;
    private Obsevable mManager;
    
    public SimpleObserver(Obsevable manager, int n){
        mManager = manager;
        mNumber = n;
        
    }

    @Override
    public void update(T name) {
        mName = name;
        System.out.println("I'm Observer. My name is "+mName+". My Number is "+mNumber);
        
    }
}
