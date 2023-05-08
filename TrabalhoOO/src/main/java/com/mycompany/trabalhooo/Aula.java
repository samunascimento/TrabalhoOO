/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;


/**
 *
 * @author Samuel
 */
public class Aula {
    
    private final String nome;
    private final String modalidade;
    private String data;  
    private String horario;
   
    public Aula(String nome, String data, String horario, String modalidade) {
        this.nome = nome;
        this.modalidade = modalidade;
        
        // talvez precise de uma verificaçao de horario aqui

        this.data = data; 
        this.horario = horario;
        
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

    public String getModalidade() {
        return modalidade;
    }

    private void setData(String data) {
        this.data = data;
    }

    private void setHorario(String horario) {
        this.horario = horario;
    }
    
    public void mudarData(String data, String horario){
        
        // talvez fazer uma verificaçao aqui
        
        this.setData(data);
        this.setHorario(horario);
    }

    public void print(){
        System.out.println("Nome: " + nome + "\n"
        +"Modalidade: "+ modalidade + "\n"
        +"Dias: "+ data + "\n"
        +"Horario: "+ horario+ "\n");
    }
    
}

