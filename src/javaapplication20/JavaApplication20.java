/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

import Implementation.*;
import interfaces.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author garrytrue
 */
public class JavaApplication20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ObserverManager obsManager = new ObserverManager();
        ObserverCreater creater = new ObserverCreater(obsManager);
        Thread createrThread = new Thread(creater, "ObserverCreater");
        Thread senderThread = new Thread(new SendDataToObservers(obsManager), "Sender");
        Thread removerThread = new Thread(new DeleteSomeObservers(obsManager), "Deleter");

        createrThread.start();
        senderThread.start();
        removerThread.start();
    }

    static class ObserverCreater implements Runnable {

        final private IManageObservers mManageObservers;
        int counter;
        volatile boolean isRun = true;

        public ObserverCreater(IManageObservers manageObservers) {
            mManageObservers = manageObservers;
        }

        @Override
        public void run() {
            while (isRun) {
                counter++;
                System.out.println("Im Observer. My number is " + counter);
                new SimpleObserver(mManageObservers, counter).registerObserver();
                stop();
            }
        }

        void stop() {
            if (counter > 20) {
                System.out.println("We have a lot of Observers");
                isRun = false;
            }
        }
    }

    static class SendDataToObservers implements Runnable {

        private final ObserverManager mManager;
        volatile boolean isRun = true;
        long sleepTime = 1 * 1000; // 1 second

        public SendDataToObservers(ObserverManager manager) {
            mManager = manager;
        }

        @Override
        public void run() {
            while (isRun) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JavaApplication20.class.getName()).log(Level.SEVERE, null, ex);
                }
                mManager.setDataToObservers("Katy");
                mManager.notifyObservers();

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JavaApplication20.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Sender go to sleep. We try to delete some obserler");
                isRun = false;
            }
        }
    }

    static class DeleteSomeObservers implements Runnable {

        private final ObserverManager mManager;
        private SimpleObserver mSimpleObserver;
        volatile boolean isRun = true;
        Random r = new Random();
        long sleepTime = 1 * 1000; // 1 second

        public DeleteSomeObservers(ObserverManager manager) {
            mManager = manager;
        }

        @Override
        public void run() {
            mSimpleObserver = (SimpleObserver)mManager.getObserver(r.nextInt(22));
            if(mSimpleObserver!=null)
                System.out.println("Number " + mManager.getObserver(r.nextInt(22)).getNumber());
            else
                System.out.println("Observer is null");
        }
    }

}
