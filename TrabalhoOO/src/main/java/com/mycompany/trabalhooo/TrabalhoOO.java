/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.trabalhooo;

import java.util.*;

/**
 *
 * @author Samuel Nascimento - Matrícula: 202165137AC
 *         Tamirys Visoná- Matrícula: 201865520B
 *         Allan Chang - Matrícula: 202135001
 *         Iago Mazzoni Matrícula - 202065568C
 */
public class TrabalhoOO {

    public static int inteface() {

        System.out.println("FitZone");
        System.out.println("Digite o número correspondente ao que deseja fazer:");
        System.out.println("""
                           1-Logar como um aluno.
                           2-Logar como um professor.
                           3-Logar como Admin.
                           0-Sair.""");
        //1-Cadastrar um professor.
        //2-Cadastrar um aluno.
        Scanner teclado = new Scanner(System.in);
        int opc = teclado.nextInt();
        return opc;
    }

    public static int intefaceAluno(Aluno aluno) {

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
            if (opc > 3 || opc < 0) {
                System.out.println("Entrada invalida!");
                opc = intefaceAluno(aluno);
            } else {
                switch (opc) {
                    case 1 -> {
                        //ver aulas
                        Aula.printTodasAulas();
                        System.out.println("Digite qualquer tecla para voltar: ");
                        int aux2Opc = teclado.nextInt();
                        opc = intefaceAluno(aluno);
                    }
                    case 2 -> {
                        //entra em aula
                        String aux = teclado.nextLine();
                        System.out.println("Escolha uma Aula: ");
                        ArrayList<Aula> aulas = Aula.getAulas();
                        for (int i = 0; i < aulas.size(); i++) {
                            System.out.println(aulas.get(i).getNome() + " : " + i);
                        }
                        int modal = teclado.nextInt();
                        System.out.println("");
                        aluno.entrarAula(aulas.get(modal));
                        System.out.println("Digite qualquer tecla para voltar: ");
                        int aux2Opc = teclado.nextInt();
                        opc = intefaceAluno(aluno);
                    }
                    case 3 -> {
                        //ver minhas aulas
                        aluno.printAulas();
                        System.out.println("Digite qualquer tecla para voltar: ");
                        int aux2Opc = teclado.nextInt();
                        opc = intefaceAluno(aluno);
                    }
                }
            }
        }
        return opc;
    }

    public static int intefaceProfessor(Professor professor) {

        System.out.println("FitZone");
        System.out.println("Digite o número correspondente ao que deseja fazer:");
        System.out.println("""
                           1-Ver todas as aulas.
                           2-Cadastrar uma aula.
                           3-Ver minhas aulas.
                           0-Sair.""");
        //4-Ver meus alunos em certa aula.

        Scanner teclado = new Scanner(System.in);
        int opc = teclado.nextInt();
        while (opc != 0) {

            switch (opc) {
                case 1 -> {
                    //ver todas aulas
                    Aula.printTodasAulas();
                    System.out.println("Digite qualquer tecla para voltar: ");
                    int aux2Opc = teclado.nextInt();
                    opc = intefaceProfessor(professor);
                }
                case 2 -> {
                    //cadastrar uma aula
                    String aux = teclado.nextLine();
                    System.out.print("Nome: ");
                    String nomeAula = teclado.nextLine();
                    System.out.println("");
                    System.out.print("Dias: ");
                    String dataAula = teclado.nextLine();
                    System.out.println("");
                    System.out.print("Horário: ");
                    String horarioAula = teclado.nextLine();
                    System.out.println("");
                    System.out.println("Escolha uma Modalidade: ");
                    ArrayList<Modalidade> modalidades = Modalidade.getModalidades();
                    for (int i = 0; i < modalidades.size(); i++) {
                        System.out.println(modalidades.get(i).getNome() + " : " + i);
                    }
                    int modal = teclado.nextInt();
                    System.out.println("");
                    professor.marcarAula(nomeAula, modalidades.get(modal), dataAula, horarioAula);
                    System.out.println("Digite qualquer tecla para voltar: ");
                    int aux2Opc = teclado.nextInt();
                    opc = intefaceProfessor(professor);
                }

                case 3 -> {//ver minhas aulas
                    professor.printAulas();
                    System.out.println("Digite qualquer tecla para voltar: ");
                    int aux2Opc = teclado.nextInt();
                    opc = intefaceProfessor(professor);
                }
                default -> {
                    System.out.println("Entrada invalida!");
                    opc = intefaceProfessor(professor);
                }
            }
        }

        return opc;
    }

    public static int intefaceAdmin() {

        System.out.println("FitZone");
        System.out.println("Digite o número correspondente ao que deseja fazer:");
        System.out.println("""
                           1-Ver todas as modalidades.
                           2-Cadastrar uma modalidade.
                           0-Sair.""");
        Scanner teclado = new Scanner(System.in);
        int opc = teclado.nextInt();
        String aux = "";
        while (opc != 0) {

            switch (opc) {
                case 1 -> {
                    //ver todas modalidades
                    Modalidade.printModalidades();
                    System.out.println("Digite qualquer tecla para voltar: ");
                    int auxOpc = teclado.nextInt();
                    opc = intefaceAdmin();
                }

                case 2 -> {
                    //cadastrar uma modalidade
                    aux = teclado.nextLine();
                    System.out.print("Nome da modalidade: ");
                    String nomeModalidade = teclado.nextLine();
                    if (!"".equals(nomeModalidade)) {
                        Admin.cadastrarModalidade(nomeModalidade);
                        System.out.println("Modalidade criada");
                    }
                    System.out.println("Digite qualquer tecla para voltar: ");
                    int aux2Opc = teclado.nextInt();
                    opc = intefaceAdmin();
                }
                default -> {
                    System.out.println("Entrada invalida!");
                    opc = intefaceAdmin();
                }
            }
        }
        return opc;
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        TelaInicial tela = new TelaInicial();
        tela.exibir();
        
        Aluno aluno1 = new Aluno("Allan Chang", "10559126654", "32991456644",
                "aluno@yahoo.com",
                'm', "aluno", "03/10/2002", 64, 1.71);

        //aluno1.print();
        Admin admin1 = new Admin();

        Modalidade boxe = new Modalidade("Boxe");
        Modalidade.addModalidade(boxe);

        Modalidade danca = new Modalidade("Dança");
        Modalidade.addModalidade(danca);
        //boxe.print();

      Professor professor1 = new Professor(boxe.getNome(), "Allan Chang", "10559126654", "32991456644",
               "professor@yahoo.com",
                'm', "professor", "03/10/2002");

        professor1.print();
        professor1.marcarAula("Aula de Boxe", boxe, "Terça e Quinta", "10:30");

        professor1.marcarAula("Aula de Boxe", boxe, "Segunda e Quarta", "12:00");

        professor1.printAulas();
        int opc = inteface();
        Scanner teclado = new Scanner(System.in);
        String senha = "";
        String login = "";

        while (opc != 0) {
            if (opc > 3 || opc < 0) {
                System.out.println("Entrada invalida!");
                opc = inteface();
            } else {
                switch (opc) {
                    // case 1://cadastrar prof
                    //sera implementado
                    //     break;
                    // case 2://cadastrar aluno
                    //sera implementado
                    //     break;
                    case 1://logar aluno
                        System.out.print("Login : ");
                        login = teclado.nextLine();
                        System.out.println("");
                        System.out.print("Senha : ");
                        senha = teclado.nextLine();
                        if (login.equals(aluno1.getEmail()) && senha.equals(aluno1.getSenha())) {
                            System.out.println("Login efetuado com sucesso!");
                            intefaceAluno(aluno1);
                        } else {
                            System.out.println("Login ou Senha incorretos!");
                        }
                        break;
                    case 2:// logar prof
                        System.out.print("Login : ");
                        login = teclado.nextLine();
                        System.out.println("");
                        System.out.print("Senha : ");
                        senha = teclado.nextLine();
                        if (login.equals(professor1.getEmail()) && senha.equals(professor1.getSenha())) {;
                            System.out.println("Login efetuado com sucesso!");
                            intefaceProfessor(professor1);
                        } else {
                            System.out.println("Login ou Senha incorretos!");
                        }
                        break;
                    case 3://logar admin
                        System.out.print("Login : ");
                        login = teclado.nextLine();
                        System.out.println("");
                        System.out.print("Senha : ");
                        senha = teclado.nextLine();
                        if (login.equals(admin1.getLogin()) && senha.equals(admin1.getSenha())) {
                            System.out.println("Login efetuado com sucesso!");
                            intefaceAdmin();
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
