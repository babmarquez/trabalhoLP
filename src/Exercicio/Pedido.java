/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio;

/**
 *
 * @author Ana Paula Fidelis e Bárbara Marquez
 */
public class Pedido{
      Cliente cliente;
      public Pedido(Cliente cliente){
          this.cliente=cliente;
      }
      public void realizarPedido(){
          System.out.println(cliente.toString()+" realizou pedido");
      }
 
    
}
