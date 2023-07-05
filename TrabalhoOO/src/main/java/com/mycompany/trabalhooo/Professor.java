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
public class Professor extends Pessoa {
    
    private final String modalidade;
    private ArrayList<Aula> aulas = new ArrayList<>();

    
    private void addProfessor(Modalidade modalidade) {
        modalidade.adicionarProfessor(this);
    }
    
    public Professor(String modalidade, String nome, String cpf, String telefone, String email, char sexo, String senha, String data) {
        super(nome, cpf, telefone, email, sexo, senha, data);
        this.modalidade = modalidade;
        //this.addProfessor(modalidade);
    }

    public String getModalidade() {
        return this.modalidade;
    }
    
    // metodo para marcar aula 
    public void marcarAula(String nome, Modalidade modalidade, String data, String horario){
        // recebe os dados da pagina 
        Aula novaAula = new Aula(nome, data, horario, modalidade, this);
        this.aulas.add(novaAula);
        Aula.addAula(novaAula);
    }
    
    public void printAulas(){
        

            
            System.out.println("Aulas do professor " + this.getNome() + "\n");
           
            for(Aula aula : this.aulas){

               aula.print();

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
