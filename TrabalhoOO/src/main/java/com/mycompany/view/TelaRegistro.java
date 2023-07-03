/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

/**
 *
 * @author Gerenciador
 */
public class TelaRegistro extends JFrame {
    private JTextField nomeField;
    private JTextField emailField;
    private JTextField telefoneField;
    private JRadioButton masculinoRadioButton;
    private JRadioButton femininoRadioButton;
    private JTextField dataNascimentoField;
    private JTextField cpfField;
    private JPasswordField senhaField;
    private JTextField pesoField;
    private JTextField alturaField;
    private JButton registrarButton;

    public TelaRegistro() {
        // Configurações da janela
        setTitle("FitZone - Registro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);

        // Criação dos componentes
        JPanel panel = new JPanel(new GridLayout(11, 2));

        JLabel nomeLabel = new JLabel("Nome:");
        nomeField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneField = new JTextField(20);

        JLabel sexoLabel = new JLabel("Sexo:");
        masculinoRadioButton = new JRadioButton("Masculino");
        femininoRadioButton = new JRadioButton("Feminino");
        ButtonGroup sexoButtonGroup = new ButtonGroup();
        sexoButtonGroup.add(masculinoRadioButton);
        sexoButtonGroup.add(femininoRadioButton);

        JLabel dataNascimentoLabel = new JLabel("Data de Nascimento:");
        dataNascimentoField = new JTextField(20);

        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField(20);

        JLabel senhaLabel = new JLabel("Senha:");
        senhaField = new JPasswordField(20);

        JLabel pesoLabel = new JLabel("Peso:");
        pesoField = new JTextField(20);

        JLabel alturaLabel = new JLabel("Altura:");
        alturaField = new JTextField(20);

        registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para registrar o usuário
                if (validarCampos()) {
                    Usuario usuario = criarUsuario();
                    salvarUsuario(usuario);

                    JOptionPane.showMessageDialog(null, "Registro realizado com sucesso!");
                    dispose();
                }
            }
        });

        // Adiciona os componentes ao painel
        panel.add(nomeLabel);
        panel.add(nomeField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(telefoneLabel);
        panel.add(telefoneField);
        panel.add(sexoLabel);
        panel.add(masculinoRadioButton);
        panel.add(new JLabel());
        panel.add(femininoRadioButton);
        panel.add(dataNascimentoLabel);
        panel.add(dataNascimentoField);
        panel.add(cpfLabel);
        panel.add(cpfField);
        panel.add(senhaLabel);
        panel.add(senhaField);
        panel.add(pesoLabel);
        panel.add(pesoField);
        panel.add(alturaLabel);
        panel.add(alturaField);
        panel.add(new JLabel());
        panel.add(registrarButton);

        // Adiciona o painel à janela
        add(panel);

        // Exibe a janela
        setVisible(true);
    }

    private boolean validarCampos() {
        // Validação dos campos
        if (nomeField.getText().isEmpty() ||
                emailField.getText().isEmpty() ||
                telefoneField.getText().isEmpty() ||
                (!masculinoRadioButton.isSelected() && !femininoRadioButton.isSelected()) ||
                dataNascimentoField.getText().isEmpty() ||
                cpfField.getText().isEmpty() ||
                senhaField.getPassword().length == 0 ||
                pesoField.getText().isEmpty() ||
                alturaField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            return false;
        }

        return true;
    }

    private Usuario criarUsuario() {
        // Criação do objeto Usuario com os dados do usuário
        Usuario usuario = new Usuario();
        usuario.setNome(nomeField.getText());
        usuario.setEmail(emailField.getText());
        usuario.setTelefone(telefoneField.getText());
        usuario.setSexo(masculinoRadioButton.isSelected() ? "Masculino" : "Feminino");
        usuario.setDataNascimento(dataNascimentoField.getText());
        usuario.setCpf(cpfField.getText());
        usuario.setSenha(new String(senhaField.getPassword()));
        usuario.setPeso(pesoField.getText());
        usuario.setAltura(alturaField.getText());

        return usuario;
    }

    private void salvarUsuario(Usuario usuario) {
        // Salva o objeto Usuario em um arquivo JSON
        try (FileWriter file = new FileWriter("data/usuarios.json", true)) {
            Gson gson = new Gson();
            String usuarioJson = gson.toJson(usuario);
            file.write(usuarioJson);
            file.write(System.lineSeparator()); // Adiciona uma quebra de linha após cada registro
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistro();
            }
        });
    }
}