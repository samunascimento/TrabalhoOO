/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;

/**
 *
 * @author Samuel Nascimento - Matrícula: 202165137AC
 *         Tamirys Visoná- Matrícula: 201865520B
 *         Allan Chang - Matrícula: 202135001
 */
public class Admin {
    private String login = "admin";
    private String senha = "admin";

    public Admin() {
    }
    
    public Admin(String login, String senha) {
    this.login = login;
    this.senha = senha;
    }

    
    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public static void cadastrarModalidade(String nome){
        Modalidade novaModalidade = new Modalidade(nome);
        Modalidade.addModalidade(novaModalidade);
    }
    
}
