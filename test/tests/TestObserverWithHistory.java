/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Implementation.ObserverWithHistory;
import Implementation.SimpleObserver;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;

/**
 *
 * @author garrytrue
 */
public class TestObserverWithHistory {

    ObserverWithHistory mObserverWithHistory;

    @Before
    public void setUp() {
        mObserverWithHistory = new ObserverWithHistory();
    }

    @Test
    public void notyfiedAndUpdateDataMustBeEquals() {
        SimpleObserver mock = mock(SimpleObserver.class);
        mObserverWithHistory.addObserver(mock);
        mObserverWithHistory.notifyObservers(21);
        verify(mock).update(21);
    }

    @Test
    public void notifyTwoObservers() {
        SimpleObserver mSimpleObserver = mock(SimpleObserver.class);
        SimpleObserver mSimpleObserver1 = mock(SimpleObserver.class);
        mObserverWithHistory.addObserver(mSimpleObserver);
        mObserverWithHistory.addObserver(mSimpleObserver1);
        mObserverWithHistory.notifyObservers("Peter");
        verify(mSimpleObserver).update("Peter");
        verify(mSimpleObserver1).update("Peter");
    }

    @Test
    public void notyfiedObserverFromHistory() {
        SimpleObserver mSimpleObserver = mock(SimpleObserver.class);
        mObserverWithHistory.notifyObservers("Masha");
        mObserverWithHistory.notifyObservers("Peter");
        mObserverWithHistory.addObserver(mSimpleObserver);
        verify(mSimpleObserver).update("Masha");
        verify(mSimpleObserver).update("Peter");
    }
    @Test
    public void checkedHistoryOrderInvokeUpdateMethod(){
        SimpleObserver mSimpleObserver = mock(SimpleObserver.class);
        InOrder inOrder = inOrder(mSimpleObserver);
        mObserverWithHistory.notifyObservers("Masha");
        mObserverWithHistory.notifyObservers("Peter");
        mObserverWithHistory.addObserver(mSimpleObserver);
        inOrder.verify(mSimpleObserver).update("Masha");
        inOrder.verify(mSimpleObserver).update("Peter");
    }

}
