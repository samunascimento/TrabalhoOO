/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gerenciador
 */
public class TelaAdmin {
     private JFrame tela;
    private final int WIDTH = 400;
    private final int HEIGHT = 200;

    public void exibir() {
        tela = new JFrame("Admin");
        tela.setLocationRelativeTo(null);
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());

        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 10, 10));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnCriarModalidade = new JButton("Criar Modalidade");
        btnCriarModalidade.addActionListener(e -> criarModalidade());

        JButton btnCriarProfessor = new JButton("Criar Professor");
        btnCriarProfessor.addActionListener(e -> criarProfessor());

        painelBotoes.add(btnCriarModalidade);
        painelBotoes.add(btnCriarProfessor);

        tela.add(painelBotoes, BorderLayout.CENTER);

        tela.setVisible(true);
    }

    private void criarModalidade() {
        TelaCriarModalidade telaCriarModalidade = new TelaCriarModalidade();
        telaCriarModalidade.exibir();
    }

    private void criarProfessor() {
        TelaCadastroProfessor telaCadastroProfessor = new TelaCadastroProfessor();
        telaCadastroProfessor.exibir();
    }
}
