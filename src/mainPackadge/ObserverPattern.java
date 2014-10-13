/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackadge;

import Implementation.*;


/**
 *
 * @author garrytrue
 */
public class ObserverPattern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ObserverManager manager = new ObserverManager();
        for(int i=0; i<3; i++){
            manager.addObserver(new ObserverCounter());
        }
        Thread notyfier = new Thread(new Notyfier(manager));
        notyfier.start();

    }
    static class Notyfier implements Runnable{
        ObserverManager manager;
        int mNotyfierCounter;

        public Notyfier(ObserverManager om) {
            manager = om;
        }
        @Override
        public void run() {
            while(true){
                manager.notifyObservers(mNotyfierCounter++);
                if(mNotyfierCounter>100)
                    break;
            }
        }
    }

}
