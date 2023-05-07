/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalhooo;

/**
 *
 * @author Gerenciador
 */
public class TrabalhoOO {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Pessoa pessoa1 = new Pessoa("Allan Chang", "10559126654", "32991456644", "allan.jf@yahoo.com"
        ,'m',"allan123","03/10/2002");
        
        Pessoa pessoa2 = new Pessoa("Allan1 Chang", "105591266545", "329914566446", "allan.jfyahoo.com"
        ,'j',"allan123","03102002"); 
        
        pessoa1.printPessoa();
        
        pessoa2.printPessoa();
        
    }   
}
