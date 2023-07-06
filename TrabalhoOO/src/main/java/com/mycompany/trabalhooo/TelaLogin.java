/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.awt.Color;

/**
 *
 * @author Gerenciador
 */
public class TelaLogin {

    private JFrame tela;
    private final int WIDTH = 300;
    private final int HEIGHT = 200;

    private JTextField tfEmail;
    private JPasswordField pfSenha;

    public void exibir() {
        tela = new JFrame("Login");
        tela.setSize(WIDTH, HEIGHT);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());

        JPanel painelFormulario = new JPanel(new GridBagLayout());
        painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel lblLogin = new JLabel("Login");
        lblLogin.setForeground(Color.BLUE);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        painelFormulario.add(lblLogin, constraints);

        JLabel lblEmail = new JLabel("Email:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        painelFormulario.add(lblEmail, constraints);

        tfEmail = new JTextField(13);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        painelFormulario.add(tfEmail, constraints);

        JLabel lblSenha = new JLabel("Senha:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        painelFormulario.add(lblSenha, constraints);

        pfSenha = new JPasswordField(13);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        painelFormulario.add(pfSenha, constraints);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> fazerLogin());
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        painelFormulario.add(btnLogin, constraints);

        tela.add(painelFormulario, BorderLayout.CENTER);

        tela.setVisible(true);
    }

    private void fazerLogin() {
        String email = tfEmail.getText();
        String senha = new String(pfSenha.getPassword());
        String admin = "admin";

        List<Aluno> listaAlunos = lerAlunosDoArquivo();
        
        if(email.equals(admin) && senha.equals(admin)){
            TelaAdmin telaAdmin = new TelaAdmin();
            telaAdmin.exibir();
            tela.dispose();
            return;
        }

        for (Aluno aluno : listaAlunos) {
            if (aluno.getEmail().equals(email) && aluno.getSenha().equals(senha)) {
                TelaPosLogin telaPrincipal = new TelaPosLogin();
                telaPrincipal.exibir(aluno);
                tela.dispose();
                return;
            }
        }

        JOptionPane.showMessageDialog(tela, "Email ou senha incorretos.");
    }

    private List<Aluno> lerAlunosDoArquivo() {
        File arquivoJson = new File("alunos.json");

        if (!arquivoJson.exists()) {
            return List.of();
        }

        try (FileReader reader = new FileReader(arquivoJson)) {
            Type alunoListType = new TypeToken<List<Aluno>>() {}.getType();
            Gson gson = new Gson();
            return gson.fromJson(reader, alunoListType);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela, "Erro ao ler o arquivo JSON.");
        }

        return List.of();
    }

}