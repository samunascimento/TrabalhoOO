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
public class TelaPosLogin {
private JFrame tela;
    private final int WIDTH = 400;
    private final int HEIGHT = 300;
    private Aluno aluno;

    public void exibir(Aluno aluno1) {
        
        this.aluno = aluno1;
        
        tela = new JFrame("FitZone");
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());

        JPanel painelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitulo = new JLabel("FitZone");
        lblTitulo.setForeground(Color.BLUE);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        painelTitulo.add(lblTitulo);

        JPanel painelBotoes = new JPanel(new GridLayout(2, 2, 10, 10));

        JButton btnPerfil = new JButton("Perfil");
        btnPerfil.addActionListener(e -> abrirPerfil());

        JButton btnVisualizarIMC = new JButton("Visualizar IMC");
        btnVisualizarIMC.addActionListener(e -> abrirVisualizarIMC());

        JButton btnVisualizarAulas = new JButton("Visualizar Aulas");
        btnVisualizarAulas.addActionListener(e -> abrirVisualizarAulas());

        JButton btnPagarMensalidade = new JButton("Pagar Mensalidade");
        btnPagarMensalidade.addActionListener(e -> abrirPagarMensalidade());

        painelBotoes.add(btnPerfil);
        painelBotoes.add(btnVisualizarIMC);
        painelBotoes.add(btnVisualizarAulas);
        painelBotoes.add(btnPagarMensalidade);

        tela.add(painelTitulo, BorderLayout.NORTH);
        tela.add(painelBotoes, BorderLayout.CENTER);

        tela.setVisible(true);
    }

    private void abrirPerfil() {
        TelaPerfil telaPerfil = new TelaPerfil();
        telaPerfil.exibir(aluno);
        tela.dispose();
    }

    private void abrirVisualizarIMC() {
        TelaIMC telaIMC = new TelaIMC();
        telaIMC.exibir(aluno);
        tela.dispose();
    }

    private void abrirVisualizarAulas() {
        JOptionPane.showMessageDialog(tela, "Abrir página de visualização de aulas");
    }

    private void abrirPagarMensalidade() {
        JOptionPane.showMessageDialog(tela, "Abrir página de pagamento de mensalidade");
    }

}
