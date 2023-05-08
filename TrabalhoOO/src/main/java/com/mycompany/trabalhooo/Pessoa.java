/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gerenciador
 */
public class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private char sexo;
    private String senha;
    private String data;
    
    private static boolean validarNome (String nomeCompleto) {
    // Cria um padrão de expressão regular que define o padrão de pesquisa
    Pattern padrao = Pattern.compile("^[A-Za-z\\s]+$");
    
    // Cria um objeto Matcher para aplicar o padrão na string
    Matcher matcher = padrao.matcher(nomeCompleto);
    
    // Verifica se a string corresponde ao padrão de expressão regular
    return matcher.matches();
    }

    
    private static boolean validarnum (String num) {
        
        // Verifica se o num possui 11 dígitos e se todos são números

        return num.length() == 11 && num.matches("[0-9]+");
    }
    
    private static boolean validaremail (String email) {
        // Verifica se o email contém pelo menos um @ e um ponto
        
        return email.matches(".*@.*\\..*");
    }
    
    private static boolean validarsexo (char sexo) {
        // Verifica se o caractere corresponde aos esperados
        return sexo == 'm' || sexo== 'M' || sexo == 'f' || sexo == 'F';
        
    }
    
    private static boolean validardata(String data) {
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";
        return data.matches(regex);
    }

    public Pessoa(String nome, String cpf, String telefone, String email, char
            sexo, String senha, String data){
        
        
        Scanner ler = new Scanner(System.in);
        
        if(validarNome(nome)){
            this.nome = nome;
        }else{
            System.out.println("Nome inválido.");
            while(validarNome(nome) != true){
                System.out.println("Insira um nome válido, composto apenas por letras e espaços.");
                nome = ler.nextLine();
            }
            this.nome = nome;
        }
        
        if(validarnum(cpf)){
            this.cpf = cpf;
        }else{
            System.out.println("CPF inválido.");
            while(validarnum(cpf) != true){
                System.out.println("Insira um nome CPF, composto apenas por 11 números.");
                cpf = ler.nextLine();
            }
            this.cpf = cpf;
        }
        
        if(validarnum(telefone)){
            this.telefone = telefone;
        }else{
            System.out.println("Telefone inválido.");
            while(validarnum(telefone) != true){
                System.out.println("Insira um telefone com DDD, composto apenas por 11 números.");
                telefone = ler.nextLine();
            }
            this.telefone = telefone;
        }
        
        
        if(validaremail(email)){
            this.email = email;
        }else{
            System.out.println("Email inválido.");
            while(validaremail(email) != true){
                System.out.println("Insira um email válido.");
                email = ler.nextLine();
            }
            this.email = email;
        }
        
        if(validarsexo(sexo)){
            this.sexo = sexo;
        }else{
            System.out.println("Insira um sexo válido.");
            while(validarsexo(sexo) != true){
                System.out.println("Insira um sexo válido (m) para masculino e (f) para feminino.");
                sexo = ler.nextLine().charAt(0);
            }
            this.sexo=sexo;
        }
        
        this.senha = senha;
        
        if(validardata(data)){
            this.data = data;
        }else{
            System.out.println("Insira uma data válida.");
            while(validardata(data) != true){
                System.out.println("Insira uma data válida no formado (dd/mm/aaaa)");
                data = ler.nextLine();
            }
            this.data=data;
        }
        
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCPF(){
        return this.cpf;
    }
    
    public String getTelefone(){
        return this.telefone;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getSexo(){
        
        if(this.sexo == 'm' || this.sexo =='M'){
            return "Masculino";
        }else{
            return "Feminino";
        }
    }
    
    public String getData(){
        return this.data;
    }
    
    
    
    public void print(){
        System.out.println("Nome: " + this.nome + "\n"
                           +"CPF: " + this.cpf + "\n"
                           +"Telefone: " + this.telefone + "\n"
                           +"Email: " + this.email + "\n"
                           +"Sexo: " + this.getSexo() + "\n"
                           +"Data de nascimento: "+ this.data);
    }
    
}
