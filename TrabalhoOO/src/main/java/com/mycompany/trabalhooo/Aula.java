/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;

import java.util.ArrayList;

/**
 *
 * @author Samuel Nascimento - Matrícula: 202165137AC
 *         Tamirys Visoná- Matrícula: 201865520B
 *         Allan Chang - Matrícula: 202135001
 *         Iago Mazzoni Matrícula - 202065568C
 */
public class Aula {

    private final String nome;
    private Modalidade modalidade;
    private String data;
    private String horario;
    private final Professor professor;
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private static ArrayList<Aula> aulas = new ArrayList<>();

    public static void addAula(Aula aula) {
        Aula.aulas.add(aula);
    }

    public Aula(String nome, String data, String horario, Modalidade modalidade, Professor professor) {
        this.nome = nome;
        this.modalidade = modalidade;
        // talvez precise de uma verificaçao de horario aqui
        this.data = data;
        this.horario = horario;
        this.professor = professor;
    }
    
    //contrutor sem modalidade
    public Aula(String nome, String data, String horario, Professor professor) {
        this.nome = nome;
        // talvez precise de uma verificaçao de horario aqui
        this.data = data;
        this.horario = horario;
        this.professor = professor;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
    
    public void entrarAula(Aluno aluno){
        alunos.add(aluno);
    }
            
    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    private void setData(String data) {
        this.data = data;
    }

    private void setHorario(String horario) {
        this.horario = horario;
    }

    public void mudarData(String data, String horario) {
        // talvez fazer uma verificaçao aqui
        this.setData(data);
        this.setHorario(horario);
    }

    public static ArrayList<Aula> getAulas() {
        return aulas;
    }

    public void print() {
        System.out.println("Nome: " + nome + "\n"
                + "Modalidade: " + modalidade.getNome() + "\n"
                + "Dias: " + data + "\n"
                + "Horario: " + horario + "\n"
                + "Professor: " + professor.getNome() + "\n");
    }

    public static void printTodasAulas() {
        for (Aula aula : aulas) {
            System.out.println("Nome: " + aula.nome + "\n"
                    + "Modalidade: " + aula.modalidade.getNome() + "\n"
                    + "Dias: " + aula.data + "\n"
                    + "Horario: " + aula.horario + "\n"
                    + "Professor: " + aula.professor.getNome() + "\n");
        }
    }
}
