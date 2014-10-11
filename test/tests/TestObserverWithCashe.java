/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import Implementation.PrintObserver;
import Implementation.ObserverWithCashe;
import Implementation.SimpleObserver;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author garrytrue
 */
public class TestObserverWithCashe {
    
    ObserverWithCashe mObserverWithCashe;
    
    @Before
    public void setUp() {
        mObserverWithCashe = new ObserverWithCashe<>();
    }
    
    @Test
    public void dataInNotifyAndUpdateMustBeEquals() {
        PrintObserver mock = mock(PrintObserver.class);
        mObserverWithCashe.addObserver(mock);
        mObserverWithCashe.notifyObservers(56);
        verify(mock).update(0x38);
    }
    
    @Test
    public void notifyTwoObservers() {
        SimpleObserver mSimpleObserver = mock(SimpleObserver.class);
        SimpleObserver mSimpleObserver1 = mock(SimpleObserver.class);
        mObserverWithCashe.addObserver(mSimpleObserver);
        mObserverWithCashe.addObserver(mSimpleObserver1);
        mObserverWithCashe.notifyObservers("Peter");
        verify(mSimpleObserver).update("Peter");
        verify(mSimpleObserver1).update("Peter");
    }

    @Test
    public void notyfiedObserverFromCashe() {
        SimpleObserver mSimpleObserver = mock(SimpleObserver.class);
        mObserverWithCashe.notifyObservers("Masha");
        mObserverWithCashe.addObserver(mSimpleObserver);
        verify(mSimpleObserver).update("Masha");
    }
    @Test
    public void rewriteCasheValue(){
        SimpleObserver mSimpleObserver = mock(SimpleObserver.class);
        mObserverWithCashe.notifyObservers("Masha");
        mObserverWithCashe.notifyObservers("Peter");
        mObserverWithCashe.addObserver(mSimpleObserver);
        verify(mSimpleObserver).update("Peter");
    }
    
}
