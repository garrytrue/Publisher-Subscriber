/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import interfaces.Observer;
import java.util.ArrayList;

/**
 *
 * @author garrytrue
 * @param <Integer>
 */
public class ObserverCounter implements Observer<Integer>{
    private final ArrayList<Integer> mDataInt;

    public ObserverCounter() {
        this.mDataInt = new ArrayList<>();
    }

    @Override
    public void update(Integer name) {
        mDataInt.add(name);
    }
    public boolean isListOrdered(){
        int last = mDataInt.get(mDataInt.size()-1);
        int preLast = mDataInt.get(mDataInt.size()-2);
       return (preLast>last);
    }
    
}
