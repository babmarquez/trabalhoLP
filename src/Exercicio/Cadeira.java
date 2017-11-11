/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Ana Paula Fidelis e Bárbara Marquez
 */
public class Cadeira {
    
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private Tela tela;

    public Cadeira(Tela tela) {
        this.tela = tela;
    }
    
    public void clienteSentar(Cliente cliente) {
        tela.addCorClienteCadeira(cliente.getNome(), Color.RED);       
        if (clientes.isEmpty()){
           tela.addTextoTxLista(cliente.toString()+" entrou e chamou Dona Joana.");
           tela.addCorClienteCadeira(0, Color.RED);
        }else   
            tela.addTextoTxLista(cliente.toString()+" entrou e sentou.");
        clientes.add(cliente);        
    }
    public void clienteSair(Cliente cliente){
        tela.addTextoTxLista(cliente.toString()+" Saiu");
        tela.addCorClienteCadeira(cliente.getNome(), Color.GREEN);
        clientes.remove(cliente);
        
        if (clientes.isEmpty())
            tela.addCorClienteCadeira(0, Color.GREEN);
    }

    public void realizarPedido(Cliente cliente) {
        cliente.decrementaPedidos();
        System.out.println(cliente.toString()+" Fez seu pedido, pedidos restantes: "+cliente.getNumeroPedidos());
        
       
    }
    
}
