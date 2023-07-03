/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.view;

/**
 *
 * @author Gerenciador
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import com.google.gson.Gson;

public class TelaLogin extends JFrame {
    private JTextField emailField;
    private JPasswordField senhaField;
    private JButton loginButton;

    public TelaLogin() {
        // Configurações da janela
        setTitle("FitZone - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setResizable(false);

        // Criação dos componentes
        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField(20);

        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para fazer o login
                String email = emailField.getText();
                String senha = new String(senhaField.getPassword());

                if (realizarLogin(email, senha)) {
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                    dispose();
                    // Adicione a lógica para exibir a tela principal após o login
                } else {
                    JOptionPane.showMessageDialog(null, "Email ou senha incorretos!");
                }
            }
        });

        // Adiciona os componentes ao painel
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(senhaLabel);
        panel.add(senhaField);
        panel.add(new JLabel());
        panel.add(loginButton);

        // Adiciona o painel à janela
        add(panel);

        // Exibe a janela
        setVisible(true);
    }

    private boolean realizarLogin(String email, String senha) {
        // Lógica para realizar o login
        String filePath = "data/usuarios.json"; // Caminho do arquivo JSON
        JSONParser parser = new JSONParser();

        try {
            // Lê o arquivo JSON
            Object obj = parser.parse(new FileReader(filePath));
            JSONObject jsonObject = (JSONObject) obj;

            // Obtém as informações do usuário
            String storedEmail = (String) jsonObject.get("email");
            String storedSenha = (String) jsonObject.get("senha");

            // Verifica se o email e senha coincidem
            if (storedEmail.equals(email) && storedSenha.equals(senha)) {
                return true;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return false;
    }
}
