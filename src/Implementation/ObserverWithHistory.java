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
 * @param <T>
 */
public class ObserverWithHistory<T> implements Obsevable<T> {

    private final CopyOnWriteArrayList<Observer> mObserverList;
    private final CopyOnWriteArrayList<T> mListHistory;

    public ObserverWithHistory() {
        mObserverList = new CopyOnWriteArrayList<>();
        mListHistory = new CopyOnWriteArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        if (o == null) {
            throw new IllegalArgumentException("Observer is NULL");
        }
        mObserverList.add(o);
        if (mListHistory != null) {
            for (T mListElement : mListHistory) {
                o.update(mListElement);
            }

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
        for (Observer obs : mObserverList) {
            obs.update(value);
        }
        mListHistory.add(value);
    }

}
