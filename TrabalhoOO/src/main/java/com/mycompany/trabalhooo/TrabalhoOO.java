/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalhooo;

import java.util.*;

/**
 *
 * @author Gerenciador
 */
public class TrabalhoOO {
    
    public void inteface(){
        
        System.out.println("FitZone");
        System.out.println("Digite o número correspondente ao que deseja fazer:");
        System.out.println("""
                           1-Cadastrar um professor.
                           2-Cadastrar um aluno.
                           3-Logar como um aluno.
                           4-Logar como um professor.
                           5-Ver todas as aulas.
                           6-Entrar em uma aula.
                           7-Cadastrar uma aula.
                           8-Ver minhas aulas.
                           9-Ver meus alunos em certa aula.""");
        
    }    
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Aluno pessoa1 = new Aluno("Allan Chang", "10559126654", "32991456644", "allan.jf@yahoo.com"
        ,'m',"allan123","03/10/2002", 64, 1.71);
       
        pessoa1.print();
        
        Professor professor1 = new Professor("Boxe","Allan Chang", "10559126654", "32991456644", "allan.jf@yahoo.com"
        ,'m',"allan123","03/10/2002");

        professor1.print();
        
        professor1.marcarAula("Aula de Boxe", "Boxe", "Terça e Quinta", "10:30");
        
        professor1.marcarAula("Aula de Boxe", "Boxe", "Segunda e Quarta", "12:00");
        
        
        professor1.printAulas();

    }   
}
