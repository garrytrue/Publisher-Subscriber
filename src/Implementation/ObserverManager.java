/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;
import interfaces.IManageObservers;
import interfaces.IObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 *
 * @author garrytrue
 */

public class ObserverManager implements IManageObservers{
    protected final CopyOnWriteArrayList<IObserver> observers;
    private String mName;
    
    public ObserverManager(){
        observers = new CopyOnWriteArrayList<>();
    }
    
    /**
     *
     * @param o
     */
    @Override
    public  void addObserver(IObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observers.remove(o);
        
    }

    @Override
    public synchronized void notifyObservers() {
        for(IObserver obs:observers){
            obs.update(mName);
        }
    }
    public void setDataToObservers(String name){
        mName = name;
        notifyObservers();
    }

    @Override
    public int getObserverNumber(IObserver o) {
        return o.getNumber();
    }
    public IObserver getObserver(int pos){
        return observers.get(pos);
    }
    
}
