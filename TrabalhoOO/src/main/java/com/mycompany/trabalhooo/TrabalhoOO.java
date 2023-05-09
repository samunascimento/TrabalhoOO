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

    public static int inteface() {

        System.out.println("FitZone");
        System.out.println("Digite o número correspondente ao que deseja fazer:");
        System.out.println("""
                           1-Cadastrar um professor.
                           2-Cadastrar um aluno.
                           3-Logar como um aluno.
                           4-Logar como um professor.
                           0-Sair.""");
        Scanner teclado = new Scanner(System.in);
        int opc = teclado.nextInt();
        return opc;
    }

    public static int intefaceAluno() {

        System.out.println("FitZone");
        System.out.println("Digite o número correspondente ao que deseja fazer:");
        System.out.println("""
                           1-Ver todas as aulas.
                           2-Entrar em uma aula.
                           3-Ver minhas aulas.
                           0-Sair.""");
        Scanner teclado = new Scanner(System.in);
        int opc = teclado.nextInt();
        while (opc != 0) {
            if (opc > 3 && opc < 0) {
                System.out.println("Entrada invalida!");
                opc = intefaceAluno();
            } else {
                switch (opc) {
                    case 1://ver aulas
                        //sera implementado
                        break;
                    case 2://entra em aula
                        //sera implementado
                        break;
                    case 3://ver minhas aulas                                         
                        break;
                }
            }
            opc = intefaceAluno();
        }
        System.out.println("Saindo!!");
        return opc;
    }

    public static int intefaceProfessor() {

        System.out.println("FitZone");
        System.out.println("Digite o número correspondente ao que deseja fazer:");
        System.out.println("""
                           1-Ver todas as aulas.
                           2-Cadastrar uma aula.
                           3-Ver minhas aulas.
                           4-Ver meus alunos em certa aula.
                           0-Sair.""");
        Scanner teclado = new Scanner(System.in);
        int opc = teclado.nextInt();
        while (opc != 0) {
            if (opc > 3 && opc < 0) {
                System.out.println("Entrada invalida!");
                opc = intefaceProfessor();
            } else {
                switch (opc) {
                    case 1://ver todas aulas
                        //sera implementado
                        break;
                    case 2://cadastrar uma aula
                        //sera implementado
                        break;
                    case 3://ver minhas aulas
                           //sera implementado 
                        break;
                    case 4://ver meus alunos em certa aula
                           //sera implementado
                        break;    
                }
            }
            opc = intefaceProfessor();
        }
        System.out.println("Saindo!!");
        return opc;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Aluno pessoa1 = new Aluno("Allan Chang", "10559126654", "32991456644", "allan.jf@yahoo.com",
                'm', "allan123", "03/10/2002", 64, 1.71);

        pessoa1.print();

        Professor professor1 = new Professor("Boxe", "Allan Chang", "10559126654", "32991456644", "allan.jf@yahoo.com",
                'm', "allan123", "03/10/2002");

        professor1.print();

        professor1.marcarAula("Aula de Boxe", "Boxe", "Terça e Quinta", "10:30");

        professor1.marcarAula("Aula de Boxe", "Boxe", "Segunda e Quarta", "12:00");

        professor1.printAulas();

        int opc = inteface();
        Scanner teclado = new Scanner(System.in);
        String senha = "";
        String login = "";
        
        while (opc != 0) {
            if (opc > 4 && opc < 0) {
                System.out.println("Entrada invalida!");
                opc = inteface();
            } else {
                switch (opc) {
                    case 1://cadastrar prof
                        //sera implementado
                        break;
                    case 2://cadastrar aluno
                        //sera implementado
                        break;
                    case 3://logar aluno
                        System.out.print("Login : ");
                        login = teclado.nextLine();
                        System.out.println("");
                        System.out.print("Senha : ");
                        senha = teclado.nextLine();
                        if (login.equals(pessoa1.getCPF()) && senha.equals(pessoa1.getSenha())) {
                            System.out.println("Login efetuado com sucesso!");
                            intefaceAluno();
                        } else {
                            System.out.println("Login ou Senha incorretos!");
                        }
                        break;
                    case 4:// logar prof
                        System.out.print("Login : ");
                        login = teclado.nextLine();
                        System.out.println("");
                        System.out.print("Senha : ");
                        senha = teclado.nextLine();
                        if (login.equals(professor1.getCPF()) && senha.equals(professor1.getSenha())) {
                            System.out.println("Login efetuado com sucesso!");
                            intefaceProfessor();
                        } else {
                            System.out.println("Login ou Senha incorretos!");
                        }
                        break;
                }
            }

            opc = inteface();
        }
        System.out.println("Saindo!!");
    }
}
