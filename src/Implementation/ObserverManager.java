/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;
import interfaces.Obsevable;
import interfaces.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 *
 * @author garrytrue
 */

public class ObserverManager implements Obsevable <String>{
    protected final CopyOnWriteArrayList<Observer> observers;
    private String mName;
    
    public ObserverManager(){
        observers = new CopyOnWriteArrayList<>();
    }
    
    /**
     *
     * @param o
     */
    @Override
    public  void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        
    }

    @Override
    public synchronized void notifyObservers(String value) {
        for(Observer obs:observers){
            obs.update(value);
        }
    }
//    public void setDataToObservers(String name){
//        mName = name;
//        notifyObservers();
//    }
//
//    @Override
//    public int getObserverNumber(Observer o) {
//        return o.getNumber();
//    }
//    public Observer getObserver(int pos){
//        return observers.get(pos);
//    }
//    
}
