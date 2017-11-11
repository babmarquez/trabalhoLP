package Exercicio;

import Control.Semaforo;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
/**
 *
 * @author Ana Paula Fidelis e Bárbara Marquez
 */
public class Atendente extends Thread {

    private TipoEstado estado;
    private Semaforo cheio, vazio;
    private int totalConsumir;
    private Tela tela;

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    public Atendente( Semaforo sem1, Semaforo sem2, Tela tela) {
        cheio = sem1;
        vazio = sem2;
        this.totalConsumir = totalConsumir;
        this.tela = tela;
    }

    public void run() {
        try {
            setEstado(TipoEstado.AFAZERES);


            while (true) {
                vazio.checa();
                setEstado(TipoEstado.ATENDENDO);
                cheio.libera();
                this.sleep(1000);
                setEstado(TipoEstado.AFAZERES);
                this.sleep(1000);
            }
        } catch (InterruptedException ex) {
                Logger.getLogger(Atendente.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
