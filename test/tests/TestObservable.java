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

    @BeforeClass
    public static void setUpClass() throws Exception {
        manager = new ObserverManager();
        mPrintObserver = new PrintObserver(1);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
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
    public void testInvokeMethodsInObserver() {
        ObserverWithCashe mockCashObserver = mock(ObserverWithCashe.class);
        mockCashObserver.addObserver(mPrintObserver);
        mockCashObserver.removeObserver(mPrintObserver);
        mockCashObserver.notifyObservers("null");
        verify(mockCashObserver).notifyObservers("null");
        verify(mockCashObserver).addObserver(mPrintObserver);
        verify(mockCashObserver).removeObserver(mPrintObserver);
    }

    @Ignore
    @Test
    public void invokeMedhotChainInObserver() {
        ObserverWithCashe mock = mock(ObserverWithCashe.class);
        PrintObserver mock2 = mock(PrintObserver.class);
        mock.addObserver(mock2);
        mock.notifyObservers("null");
        verify(mock2).update("null");

    }

}