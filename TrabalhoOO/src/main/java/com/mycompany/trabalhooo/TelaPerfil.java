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
public class TelaPerfil {
       
    private JFrame tela;
    private final int WIDTH = 400;
    private final int HEIGHT = 300;

    private JLabel lblNome;
    private JLabel lblEmail;
    private JLabel lblTelefone;
    private JLabel lblSexo;
    private JLabel lblDataNascimento;
    private JLabel lblCPF;

    private Aluno aluno;

    public void exibir(Aluno aluno) {
        this.aluno = aluno;

        tela = new JFrame("Perfil");
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());

        JPanel painelInformacoes = new JPanel(new GridLayout(6, 2, 10, 10));
        painelInformacoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblNome = new JLabel();
        lblEmail = new JLabel();
        lblTelefone = new JLabel();
        lblSexo = new JLabel();
        lblDataNascimento = new JLabel();
        lblCPF = new JLabel();

        painelInformacoes.add(new JLabel("Nome:"));
        painelInformacoes.add(lblNome);
        painelInformacoes.add(new JLabel("Email:"));
        painelInformacoes.add(lblEmail);
        painelInformacoes.add(new JLabel("Telefone:"));
        painelInformacoes.add(lblTelefone);
        painelInformacoes.add(new JLabel("Sexo:"));
        painelInformacoes.add(lblSexo);
        painelInformacoes.add(new JLabel("Data de Nascimento:"));
        painelInformacoes.add(lblDataNascimento);
        painelInformacoes.add(new JLabel("CPF:"));
        painelInformacoes.add(lblCPF);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarTelaPosLogin();
            }
        });

        painelBotoes.add(btnVoltar);

        tela.add(painelInformacoes, BorderLayout.CENTER);
        tela.add(painelBotoes, BorderLayout.SOUTH);

        exibirDadosAluno();

        tela.setVisible(true);
    }

    private void exibirDadosAluno() {
        String sexo;
        lblNome.setText(aluno.getNome());
        lblEmail.setText(aluno.getEmail());
        lblTelefone.setText(aluno.getTelefone());
        lblSexo.setText(aluno.getSexo());
        lblDataNascimento.setText(aluno.getData());
        lblCPF.setText(aluno.getCPF());
    }

    private void voltarTelaPosLogin() {
        TelaPosLogin telaPosLogin = new TelaPosLogin();
        telaPosLogin.exibir(aluno);
        tela.dispose();
    }
}
