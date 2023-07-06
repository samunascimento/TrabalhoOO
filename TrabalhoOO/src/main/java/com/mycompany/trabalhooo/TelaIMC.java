/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Gerenciador
 */
public class TelaIMC {

    private JFrame tela;
    private final int WIDTH = 400;
    private final int HEIGHT = 300;
    
    private JLabel lblPeso;
    private JLabel lblAltura;
    private JLabel lblIMC;
    
    private Aluno aluno;
    
    public void exibir(Aluno aluno) {
        this.aluno = aluno;
        
        tela = new JFrame("Perfil");
        tela.setSize(WIDTH, HEIGHT);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());
        
        JPanel painelInformacoes = new JPanel(new GridLayout(3, 2, 10, 10));
        painelInformacoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel lblTituloPeso = new JLabel("Peso:");
        lblPeso = new JLabel();
        
        JLabel lblTituloAltura = new JLabel("Altura:");
        lblAltura = new JLabel();
        
        JLabel lblTituloIMC = new JLabel("IMC:");
        lblIMC = new JLabel();
        
        painelInformacoes.add(lblTituloPeso);
        painelInformacoes.add(lblPeso);
        painelInformacoes.add(lblTituloAltura);
        painelInformacoes.add(lblAltura);
        painelInformacoes.add(lblTituloIMC);
        painelInformacoes.add(lblIMC);
        
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        
        JButton btnTrocarPeso = new JButton("Trocar Peso");
        btnTrocarPeso.addActionListener(new TrocarPeso(this));
        
        JButton btnTrocarAltura = new JButton("Trocar Altura");
        btnTrocarAltura.addActionListener(new TrocarAltura(this));
        
        JButton btnVoltar = new JButton("Voltar");
//        btnVoltar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                voltarTelaPosLogin();
//            }
//        });
        btnVoltar.addActionListener(new VoltarIMC(this));
        
        painelBotoes.add(btnTrocarPeso);
        painelBotoes.add(btnTrocarAltura);
        painelBotoes.add(btnVoltar);
        
        tela.add(painelInformacoes, BorderLayout.CENTER);
        tela.add(painelBotoes, BorderLayout.SOUTH);
        
        exibirDadosAluno();
        
        tela.setVisible(true);
    }
    
    private void exibirDadosAluno() {
        lblPeso.setText(String.format("%.1f kg", aluno.getPeso()));
        lblAltura.setText(String.format("%.2f m", aluno.getAltura()));
        
        double imc = calcularIMC(aluno.getPeso(), aluno.getAltura());
        lblIMC.setText(String.format("%.2f", imc));
    }
    
    public void trocarPeso() {
        String novoPesoStr = JOptionPane.showInputDialog(tela, "Digite o novo peso (em kg):");
        if (novoPesoStr != null && !novoPesoStr.isEmpty()) {
            try {
                double novoPeso = Double.parseDouble(novoPesoStr);
                aluno.setPeso((float) novoPeso);
                atualizarPesoNoBancoDeDados(novoPeso);
                exibirDadosAluno();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(tela, "Valor de peso inválido.");
            }
        }
    }
    
    public void trocarAltura() {
        String novaAlturaStr = JOptionPane.showInputDialog(tela, "Digite a nova altura (em centimetros):");
        if (novaAlturaStr != null && !novaAlturaStr.isEmpty()) {
            try {
                double novaAltura = Double.parseDouble(novaAlturaStr) / 100;
                aluno.setAltura((float) novaAltura);
                atualizarAlturaNoBancoDeDados(novaAltura);
                exibirDadosAluno();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(tela, "Valor de altura inválido.");
            }
        }
    }
    
    private void atualizarPesoNoBancoDeDados(double novoPeso) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            // Ler o arquivo JSON existente
            File arquivoJson = new File("alunos.json");
            FileReader reader = new FileReader(arquivoJson);
            Type alunoListType = new TypeToken<ArrayList<Aluno>>() {
            }.getType();
            ArrayList<Aluno> listaAlunos = gson.fromJson(reader, alunoListType);
            reader.close();

            // Atualizar o peso do aluno
            for (Aluno aluno : listaAlunos) {
                if (aluno.getEmail().equals(this.aluno.getEmail())) {
                    aluno.setPeso((float) novoPeso);
                    break;
                }
            }

            // Escrever a lista atualizada no arquivo JSON
            FileWriter writer = new FileWriter(arquivoJson);
            gson.toJson(listaAlunos, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela, "Erro ao atualizar o peso no banco de dados.");
        }
    }
    
    private void atualizarAlturaNoBancoDeDados(double novaAltura) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            File arquivoJson = new File("alunos.json");
            FileReader reader = new FileReader(arquivoJson);
            Type alunoListType = new TypeToken<ArrayList<Aluno>>() {
            }.getType();
            ArrayList<Aluno> listaAlunos = gson.fromJson(reader, alunoListType);
            reader.close();
            
            for (Aluno aluno : listaAlunos) {
                if (aluno.getEmail().equals(this.aluno.getEmail())) {
                    aluno.setAltura((float) novaAltura);
                    break;
                }
            }
            
            FileWriter writer = new FileWriter(arquivoJson);
            gson.toJson(listaAlunos, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela, "Erro ao atualizar a altura no banco de dados.");
        }
    }
    
    private double calcularIMC(double peso, double altura) {
        if (altura > 0) {
            return peso / (altura * altura);
        } else {
            return 0;
        }
    }
    
    public void voltarTelaPosLogin() {
        TelaPosLogin telaPosLogin = new TelaPosLogin();
        telaPosLogin.exibir(aluno);
        tela.dispose(); // Fechar a tela atual
    }
    
}
