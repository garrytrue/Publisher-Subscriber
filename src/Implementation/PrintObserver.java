/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementation;
import interfaces.Observer;

/**
 *
 * @author garrytrue
 */
public class PrintObserver<T> implements Observer<T>{
    private int numb;
    
    public PrintObserver(int n){
        numb = n;
    }

    @Override
    public void update(T name) {
        System.out.println("I'm Observer numb "+numb+". My name is "+name);
       
    }
  }
