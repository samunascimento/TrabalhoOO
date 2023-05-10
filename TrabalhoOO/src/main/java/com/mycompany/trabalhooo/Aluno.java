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
public class Aluno extends Pessoa {
    
    public double peso;
    public double altura;
    private double imc;
    private ArrayList<Aula> participaAula = new ArrayList<>();
    
    public Aluno(String nome, String cpf, String telefone, String email, char sexo, String senha, String data, double peso, double altura) {
        super(nome, cpf, telefone, email, sexo, senha, data);
        this.peso = peso;
        this.altura = altura;
        this.imc =(this.peso/(this.altura*this.altura));
    }
    
    public void setPeso(float peso){
        this.peso = peso;
        this.imc = (this.peso/(this.altura*this.altura));
    }
    
    public void setAltura(float altura){
        this.altura = altura;
        this.imc = (this.peso/(this.altura*this.altura));
    }
    
    public double getPeso(){
        return this.peso;
    }
    
    public double getAltura(){
        return this.altura;
    }
    
    public double getImc(){
        return this.imc;
    }

    @Override
    public void print(){
        
        String resultado = String.format("%.2f", this.getImc());
        
        System.out.println("Nome: " + super.getNome() + "\n"
                   +"CPF: " + super.getCPF() + "\n"
                   +"Telefone: " + this.getTelefone() + "\n"
                   +"Email: " + this.getEmail() + "\n"
                   +"Sexo: " + this.getSexo() + "\n"
                   +"Data de nascimento: "+ this.getData() + "\n"
                   +"IMC: "+ resultado + "\n"
                   +"Peso: "+ this.getPeso() + "\n"
                   +"Altura: "+ this.getAltura() + "\n");
        
    }
    
    public void entrarAula(Aula aula){
        aula.entrarAula(this);
        participaAula.add(aula);
    }

    public ArrayList<Aula> getParticipaAula() {
        return participaAula;
    }
    
    public void printAulas(){
        for (Aula aula : participaAula) {
            aula.print();
        }
    }
}