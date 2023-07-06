/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import java.io.FileReader;
import java.util.Arrays;
/**
 *
 * @author Gerenciador
 */
public class TelaCriarModalidade {
        private JFrame tela;
    private final int WIDTH = 400;
    private final int HEIGHT = 200;

    private JTextField tfNome;

    public void exibir() {
        tela = new JFrame("Criar Modalidade");
        tela.setSize(WIDTH, HEIGHT);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());

        JPanel painelFormulario = new JPanel(new GridLayout(1, 2, 10, 10));
        painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblNome = new JLabel("Nome:");
        tfNome = new JTextField(20);

        JButton btnCriar = new JButton("Criar");
        btnCriar.addActionListener(e -> criarModalidade());

        painelFormulario.add(lblNome);
        painelFormulario.add(tfNome);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        painelBotoes.add(btnCriar);

        tela.add(painelFormulario, BorderLayout.CENTER);
        tela.add(painelBotoes, BorderLayout.SOUTH);

        tela.setVisible(true);
    }

    private void criarModalidade() {
        String nome = tfNome.getText();
        Modalidade modalidade = new Modalidade(nome);

        // Ler as modalidades existentes do arquivo JSON
        ArrayList<Modalidade> listaModalidades = lerModalidadesDoArquivo();

        // Adicionar a nova modalidade à lista
        listaModalidades.add(modalidade);

        // Salvar a lista atualizada no arquivo JSON
        salvarModalidadesNoArquivo(listaModalidades);

        tela.dispose();
    }

    private ArrayList<Modalidade> lerModalidadesDoArquivo() {
        File arquivoJson = new File("modalidades.json");

        if (!arquivoJson.exists()) {
            return new ArrayList<>();
        }

        try {
            Gson gson = new Gson();
            Modalidade[] modalidadesArray = gson.fromJson(new FileReader(arquivoJson), Modalidade[].class);
            return new ArrayList<>(Arrays.asList(modalidadesArray));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela, "Erro ao ler o arquivo JSON.");
        }

        return new ArrayList<>();
    }

    private void salvarModalidadesNoArquivo(ArrayList<Modalidade> listaModalidades) {
        File arquivoJson = new File("modalidades.json");

        try (FileWriter writer = new FileWriter(arquivoJson)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(listaModalidades, writer);
            JOptionPane.showMessageDialog(tela, "Modalidade criada com sucesso!");
        } catch (JsonIOException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela, "Erro ao criar modalidade.");
        }
    }
    
}
