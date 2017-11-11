/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio;

import Control.Semaforo;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana Paula Fidelis e Bárbara Marquez
 */
public class Cliente extends Thread {

    private Cadeira cadeira;
    private Semaforo cheio, vazio;
    private Semaforo cheio2, vazio2;
    private int numeroPedidos;
    private int nome;
    private int producaoTotal;
    private Tela tela;
    
//semaforos cheio2 e vazio2 devem ser as mesmas instâncias passadas para a thread atendente
    public Cliente(int nome, Cadeira dado, Semaforo cheioP, Semaforo vazioP,Semaforo cheio2,Semaforo vazio2, int producaoTotal, Tela tela) {
        this.nome = nome;
        cadeira = dado;
        cheio = cheioP;
        vazio = vazioP;
        this.cheio2=cheio2;
        this.vazio2=vazio2;
        this.numeroPedidos = producaoTotal;
        this.producaoTotal=producaoTotal;
        this.tela = tela;
    }

    public void run() {        
        try {
            cheio.checa();            
            cadeira.clienteSentar(this);        
            this.sleep(1000);
            
            for (int i = 1; i <= producaoTotal; i++) {
                cheio2.checa();                
                realizaPedido();
                this.sleep(1000);
                vazio2.libera();   
            }
            vazio.libera();            
            cadeira.clienteSair(this);        
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getNome() {
        return nome;
    }
    
    
    public String toString(){
        return "Cliente "+ this.nome;
    }
    public int getNumeroPedidos(){
        return numeroPedidos;
    }
    public void decrementaPedidos(){
        numeroPedidos--;
    }
    public void realizaPedido(){
        this.decrementaPedidos();
        tela.addTextoTxLista(this.toString()+" Fez seu pedido, pedidos restantes: "+this.getNumeroPedidos());
        
    }
    
}
