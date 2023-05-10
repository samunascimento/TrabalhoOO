/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;

import java.util.ArrayList;

/**
 *
 * @author Samuel
 */
public class Modalidade {
    private final String nome;
    private ArrayList<Professor> professores = new ArrayList<>();
    private static ArrayList<Modalidade> modalidades = new ArrayList<>();

    public static void addModalidade(Modalidade modalidade) {
        Modalidade.modalidades.add(modalidade);
    }

    public Modalidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public static ArrayList<Modalidade> getModalidades() {
        return modalidades;
    }
  
    
    public void adicionarProfessor(Professor professor){
        professores.add(professor);
    }
    
    public static void printModalidades(){
        for (Modalidade modalidade : modalidades) {
            System.out.println(modalidade.getNome() + ", ");
        }
    }
    
    public void print(){
        System.out.println(nome);
    }
    
    public void printProfessores(){        
        System.out.println("Professores de " + this.nome + ": \n");
        for (Professor professor : professores) {
            System.out.println(professor.getNome() + " \n");
        }
    }
}
