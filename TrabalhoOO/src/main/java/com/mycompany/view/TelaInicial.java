/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Gerenciador
 */
public class TelaInicial extends JFrame {
    private JButton logarButton;
    private JButton cadastrarButton;

    public TelaInicial() {
        // Configurações da janela
        setTitle("FitZone");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setResizable(false);

        // Criação dos componentes
        JPanel panel = new JPanel(new GridLayout(2, 1));

        JLabel label = new JLabel("FitZone");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Arial", Font.BOLD, 24));

        logarButton = new JButton("Logar");
        cadastrarButton = new JButton("Cadastrar");

        // Adiciona os componentes ao painel
        panel.add(label);
        panel.add(logarButton);
        panel.add(cadastrarButton);

        // Adiciona o painel à janela
        add(panel);

        // Exibe a janela
        setVisible(true);

        // Adiciona um ActionListener para o botão "Cadastrar"
        cadastrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaRegistro();
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial();
            }
        });
    }
}