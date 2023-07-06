/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.MaskFormatter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 *
 * @author Gerenciador
 */
public class TelaCadastroAluno {

    private JFrame tela;
    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    private JTextField tfNome;
    private JTextField tfEmail;
    private JTextField tfTelefone;
    private JComboBox<String> cbSexo;
    private JFormattedTextField tfDataNascimento;
    private JFormattedTextField tfCPF;
    private JPasswordField pfSenha;
    private JTextField tfPeso;
    private JTextField tfAltura;

    public void exibir() {
        tela = new JFrame("Cadastro de Aluno");
        
        tela.setSize(WIDTH, HEIGHT);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());

        JPanel painelFormulario = new JPanel(new GridLayout(0, 3, 10, 10));
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

        JLabel lblPeso = new JLabel("Peso (kg):");
        tfPeso = new JTextField(20);

        JLabel lblAltura = new JLabel("Altura (cm):");
        tfAltura = new JTextField(20);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new CadastrarAluno(this));

        painelFormulario.add(lblNome);
        painelFormulario.add(tfNome);
        painelFormulario.add(new JPanel()); 
        painelFormulario.add(lblEmail);
        painelFormulario.add(tfEmail);
        painelFormulario.add(new JPanel());
        painelFormulario.add(lblTelefone);
        painelFormulario.add(tfTelefone);
        painelFormulario.add(new JPanel());
        painelFormulario.add(lblSexo);
        painelFormulario.add(cbSexo);
        painelFormulario.add(new JPanel());
        painelFormulario.add(lblDataNascimento);
        painelFormulario.add(tfDataNascimento);
        painelFormulario.add(new JPanel());
        painelFormulario.add(lblCPF);
        painelFormulario.add(tfCPF);
        painelFormulario.add(new JPanel());
        painelFormulario.add(lblSenha);
        painelFormulario.add(pfSenha);
        painelFormulario.add(new JPanel());
        painelFormulario.add(lblPeso);
        painelFormulario.add(tfPeso);
        painelFormulario.add(new JPanel());
        painelFormulario.add(lblAltura);
        painelFormulario.add(tfAltura);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        painelBotoes.add(btnCadastrar);

        tela.add(painelFormulario, BorderLayout.CENTER);
        tela.add(painelBotoes, BorderLayout.SOUTH);

        tela.setVisible(true);
    }

    public void cadastrarAluno() {
    String nome = tfNome.getText();
    String email = tfEmail.getText();
    String telefone = tfTelefone.getText();
    String sexo = (String) cbSexo.getSelectedItem();
    String dataNascimento = tfDataNascimento.getText();
    String cpf = tfCPF.getText();
    String senha = new String(pfSenha.getPassword());
    String peso = tfPeso.getText();
    String altura = tfAltura.getText();

    Aluno aluno = new Aluno(nome, cpf, telefone, email, sexo.charAt(0), senha, dataNascimento, Double.parseDouble(peso), Double.parseDouble(altura));
    // Ler os alunos existentes do arquivo JSON
    ArrayList<Aluno> listaAlunos = lerAlunosDoArquivo();

    // Adicionar o novo aluno à lista
    listaAlunos.add(aluno);

    // Salvar a lista atualizada no arquivo JSON
    salvarAlunosNoArquivo(listaAlunos);

    // Exemplo de exibição dos dados cadastrados
    String mensagem = "Dados do Aluno:\n\n" +
            "Nome: " + nome + "\n" +
            "Email: " + email + "\n" +
            "Telefone: " + telefone + "\n" +
            "Sexo: " + sexo + "\n" +
            "Data de Nascimento: " + dataNascimento + "\n" +
            "CPF: " + cpf + "\n" +
            "Peso: " + peso + " kg\n" +
            "Altura: " + altura + " cm";

    JOptionPane.showMessageDialog(tela, mensagem);
    
    tela.dispose();
    }

    private ArrayList<Aluno> lerAlunosDoArquivo() {
        File arquivoJson = new File("alunos.json");

        if (!arquivoJson.exists()) {
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(arquivoJson)) {
            Type alunoListType = new TypeToken<ArrayList<Aluno>>() {}.getType();
            Gson gson = new Gson();
            return gson.fromJson(reader, alunoListType);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela, "Erro ao ler o arquivo JSON.");
        }

        return new ArrayList<>();
    }

    private void salvarAlunosNoArquivo(ArrayList<Aluno> listaAlunos) {
        File arquivoJson = new File("alunos.json");

        try (FileWriter writer = new FileWriter(arquivoJson)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(listaAlunos, writer);
            JOptionPane.showMessageDialog(tela, "Aluno cadastrado com sucesso!");
        } catch (JsonIOException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(tela, "Erro ao cadastrar aluno.");
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
}