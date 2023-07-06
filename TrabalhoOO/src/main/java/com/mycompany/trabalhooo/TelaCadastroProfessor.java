package com.mycompany.trabalhooo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.text.MaskFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;

public class TelaCadastroProfessor {
    private JFrame tela;
    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    private JTextField tfNome;
    private JTextField tfEmail;
    private JTextField tfTelefone;
    private JComboBox<String> cbModalidades;
    private JFormattedTextField tfDataNascimento;
    private JFormattedTextField tfCPF;
    private JPasswordField pfSenha;
    private JComboBox<String> cbSexo;

    public void exibir() {
        tela = new JFrame("Cadastro de Professor");
        
        tela.setSize(WIDTH, HEIGHT);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());

        JPanel painelFormulario = new JPanel(new GridLayout(0, 2, 10, 10));
        painelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblNome = new JLabel("Nome:");
        tfNome = new JTextField(20);

        JLabel lblEmail = new JLabel("Email:");
        tfEmail = new JTextField(20);

        JLabel lblTelefone = new JLabel("Telefone:");
        tfTelefone = new JTextField(20);

        JLabel lblSexo = new JLabel("Sexo:");
        cbSexo = new JComboBox<>(new String[]{"Masculino", "Feminino"});

        JLabel lblDataNascimento = new JLabel("Data de Nascimento (dd/mm/aaaa):");
        tfDataNascimento = new JFormattedTextField(createMaskFormatter("##/##/####"));

        JLabel lblCPF = new JLabel("CPF:");
        tfCPF = new JFormattedTextField(createMaskFormatter("###.###.###-##"));

        JLabel lblSenha = new JLabel("Senha:");
        pfSenha = new JPasswordField(20);

        JLabel lblModalidades = new JLabel("Modalidades:");
        cbModalidades = new JComboBox<>();

        ArrayList<Modalidade> listaModalidades = lerModalidadesDoArquivo();
        for (Modalidade modalidade : listaModalidades) {
            cbModalidades.addItem(modalidade.getNome());
        }

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProfessor();
            }
        });

        painelFormulario.add(lblNome);
        painelFormulario.add(tfNome);
        painelFormulario.add(lblEmail);
        painelFormulario.add(tfEmail);
        painelFormulario.add(lblTelefone);
        painelFormulario.add(tfTelefone);
        painelFormulario.add(lblSexo);
        painelFormulario.add(cbSexo);
        painelFormulario.add(lblDataNascimento);
        painelFormulario.add(tfDataNascimento);
        painelFormulario.add(lblCPF);
        painelFormulario.add(tfCPF);
        painelFormulario.add(lblSenha);
        painelFormulario.add(pfSenha);
        painelFormulario.add(lblModalidades);
        painelFormulario.add(cbModalidades);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        painelBotoes.add(btnCadastrar);

        tela.add(painelFormulario, BorderLayout.CENTER);
        tela.add(painelBotoes, BorderLayout.SOUTH);

        tela.setVisible(true);
    }

    private void cadastrarProfessor() {
        ArrayList<Modalidade> listaModalidades = lerModalidadesDoArquivo();
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();
        String sexo = (String) cbSexo.getSelectedItem();
        String data = tfDataNascimento.getText();
        String cpf = tfCPF.getText();
        String senha = new String(pfSenha.getPassword());
        String modalidade = (String) cbModalidades.getSelectedItem();

        Professor professor = new Professor(modalidade, nome, cpf, telefone, email, sexo.charAt(0), senha, data);
        ArrayList<Professor> listaProfessores = lerProfessoresDoArquivo();
        listaProfessores.add(professor);
        salvarProfessoresNoArquivo(listaProfessores);

        tela.dispose();
    }

    private ArrayList<Professor> lerProfessoresDoArquivo() {
        File arquivoJson = new File("professores.json");

        if (!arquivoJson.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(arquivoJson)) {
            Type professorListType = new TypeToken<ArrayList<Professor>>() {}.getType();
            Gson gson = new Gson();
            return gson.fromJson(reader, professorListType);
        } catch (JsonSyntaxException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela, "Erro ao ler o arquivo JSON.");
        }

        return new ArrayList<>();
    }

    private void salvarProfessoresNoArquivo(ArrayList<Professor> listaProfessores) {
        File arquivoJson = new File("professores.json");

        try {
            if (!arquivoJson.exists()) {
                arquivoJson.createNewFile();
            }

            FileWriter writer = new FileWriter(arquivoJson);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(listaProfessores, writer);
            writer.close();
            JOptionPane.showMessageDialog(tela, "Professor cadastrado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela, "Erro ao cadastrar professor.");
        }
    }
    private MaskFormatter createMaskFormatter(String mask) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(mask);
            formatter.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter;
    }

    private ArrayList<Modalidade> lerModalidadesDoArquivo() {
        File arquivoJson = new File("modalidades.json");

        if (!arquivoJson.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(arquivoJson)) {
            Type modalidadeListType = new TypeToken<ArrayList<Modalidade>>() {}.getType();
            Gson gson = new Gson();
            return gson.fromJson(reader, modalidadeListType);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela, "Erro ao ler o arquivo JSON de modalidades.");
        }

        return new ArrayList<>();
    }
}
