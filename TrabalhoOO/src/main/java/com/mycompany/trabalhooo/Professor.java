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
public class Professor extends Pessoa {
    
    private String modalidade;
    private ArrayList<Aula> aulas = new ArrayList<Aula>();

    public Professor(String modalidade, String nome, String cpf, String telefone, String email, char sexo, String senha, String data) {
        super(nome, cpf, telefone, email, sexo, senha, data);
        this.modalidade = modalidade;
    }

    public String getModalidade() {
        return this.modalidade;
    }
    
    // metodo para marcar aula -- por enquanto esta retornando a aula
    public void marcarAula(String nome, String modalidade, String data, String horario){
        
        // recebe os dados da pagina 
        
        Aula novaAula = new Aula(nome, data, horario, modalidade);
        this.aulas.add(novaAula);
    }
    
    public void printAulas(){
        
        if(!this.aulas.isEmpty()){
            
            System.out.println("Aulas do professor " + this.getNome() + "\n");
            
            for(Aula aula : this.aulas){

               aula.print();

            }
        }else{
            System.out.println("Esse professor ainda não tem aulas cadastradas.");
        }
    }

    @Override
    public void print(){
        System.out.println("Nome: " + super.getNome() + "\n"
                           +"CPF: " + super.getCPF() + "\n"
                           +"Telefone: " + this.getTelefone() + "\n"
                           +"Email: " + this.getEmail() + "\n"
                           +"Sexo: " + this.getSexo() + "\n"
                           +"Data de nascimento: "+ this.getData() + "\n"
                           +"Modalidade: "+ this.modalidade + "\n");
    }
}
