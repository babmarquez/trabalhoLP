/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio;

import java.util.Stack;

/**
 *
 * @author Ana Paula Fidelis e Bárbara Marquez
 */
public class Pedidos {
      private Stack pilha = new Stack();
  
   public void adicionaPedido(Pedido pedido){
       pilha.push(pedido);
   }
   public void removePedido(){
        pilha.pop();
        
   }
   public boolean vazio(){
       return pilha.empty();
   }
}
