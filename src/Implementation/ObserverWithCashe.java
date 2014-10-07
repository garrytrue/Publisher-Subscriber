/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;

import interfaces.Observer;
import interfaces.Obsevable;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author garrytrue
 */
public class ObserverWithCashe implements Obsevable {

    private final CopyOnWriteArrayList<Observer> mObserverList;
    private String mStringCashe;
    private int count;

    public ObserverWithCashe() {
        mObserverList = new CopyOnWriteArrayList<>();
        count = mObserverList.size() - 1;
    }

    @Override
    public void addObserver(Observer o) {
        if (o == null) {
            throw new IllegalArgumentException("Observer is NULL");
        }
        mObserverList.add(o);
        count++;
    }

    @Override
    public void removeObserver(Observer o) {
        if (o == null) {
            throw new IllegalArgumentException("Observer is NULL");
        }
        mObserverList.remove(o);
        count--;
    }

    @Override
    public void notifyObservers(String value) {
//        Update new observers with cashed value
        for (int i = count; i < mObserverList.size(); i++) {
            mObserverList.get(i).update(mStringCashe);
        }
       
//  Update ALL observers with new value
        for (Observer obs : mObserverList) {
            obs.update(value);
        }
//      Update cashe
        mStringCashe = value;

    }

}
