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
public class ObserverWithCashe<T> implements Obsevable<T> {

    private final CopyOnWriteArrayList<Observer> mObserverList;
    private T mStringCashe;

    public ObserverWithCashe() {
        mObserverList = new CopyOnWriteArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        if (o == null) {
            throw new IllegalArgumentException("Observer is NULL");
        }
        mObserverList.add(o);
        if (mStringCashe == null) {
        } else {
            o.update(mStringCashe);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if (o == null) {
            throw new IllegalArgumentException("Observer is NULL");
        }
        mObserverList.remove(o);
    }

    @Override
    public void notifyObservers(T value) {
//  Update ALL observers with new value
        for (Observer obs : mObserverList) {
            obs.update(value);
        }
//      Update cashe
        mStringCashe = value;

    }

}
