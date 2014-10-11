package tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import Implementation.ObserverManager;
import Implementation.ObserverWithCashe;
import Implementation.PrintObserver;
import Implementation.SimpleObserver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import static org.mockito.Mockito.*;

/**
 *
 * @author garrytrue
 */
public class TestObservable {

    static ObserverManager manager;
    static PrintObserver mPrintObserver;

    public TestObservable() {

    }

    @Before
    public void setUp() {
        System.out.println("Before");
        manager = new ObserverManager();

    }

    @After
    public void tearDown() {
        System.out.println("After");
    }

    @Test
    public void emptyObservableDoesNotTrowException() {
        manager.notifyObservers("test");

    }

    @Test
    public void dataInNotifyAndUpdateMustBeEquals() {
        PrintObserver mock = mock(PrintObserver.class);
        manager.addObserver(mock);
        manager.notifyObservers("Masha");
        verify(mock).update("Masha");

    }

    @Test
    public void notifyTwoObservers() {
        SimpleObserver mSimpleObserver = mock(SimpleObserver.class);
        SimpleObserver mSimpleObserver1 = mock(SimpleObserver.class);
        manager.addObserver(mSimpleObserver);
        manager.addObserver(mSimpleObserver1);
        manager.notifyObservers("Peter");
        verify(mSimpleObserver).update("Peter");
        verify(mSimpleObserver1).update("Peter");
    }

    @Test
    public void notInvokeUpdateWhenObserverIsNotBeenNotyfied() {
        SimpleObserver mSimpleObserver = mock(SimpleObserver.class);
        manager.addObserver(mSimpleObserver);
        manager.removeObserver(mSimpleObserver);
        manager.notifyObservers("Masha");
        verifyZeroInteractions(mSimpleObserver);
    }

}
