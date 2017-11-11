/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author leona
 */
public class Semaforo {

    private int count;

    public Semaforo(int i) {
        count = i;
    }

    public synchronized void checa() {
        if (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        count--;
    }

    public synchronized void libera() {
        count++;
        notify();
    }

}
