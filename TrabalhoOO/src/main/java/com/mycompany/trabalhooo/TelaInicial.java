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
public class TelaInicial {

    private JFrame tela;
    private final int WIDTH = 300;
    private final int HEIGHT = 200;

    public void exibir() {
        tela = new JFrame("FitZone - Tela Inicial");
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel("Bem-vindo à ");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLabel.setForeground(Color.BLUE);

        JLabel academiaLabel = new JLabel("FitZone");
        academiaLabel.setFont(new Font("Arial", Font.BOLD, 20));
        academiaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        academiaLabel.setForeground(Color.BLUE);

        JPanel tituloPanel = new JPanel(new GridLayout(2, 1));
        tituloPanel.add(tituloLabel);
        tituloPanel.add(academiaLabel);

        JPanel botoesPanel = new JPanel(new GridLayout(2, 1));
        JButton loginButton = new JButton("Login");
        JButton cadastroButton = new JButton("Cadastro");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaLogin();
            }
        });

        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaCadastro();
            }
        });

        botoesPanel.add(loginButton);
        botoesPanel.add(cadastroButton);

        tela.add(tituloPanel, BorderLayout.NORTH);
        tela.add(botoesPanel, BorderLayout.CENTER);

        tela.setVisible(true);
    }

    private void abrirTelaCadastro() {
        TelaCadastroAluno telaAluno = new TelaCadastroAluno();
        telaAluno.exibir();
    }

    private void abrirTelaLogin() {
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.exibir();
    }

}
