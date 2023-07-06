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
 * @author Samuel
 */
public class TelaPagamento {
    
    private JFrame tela;
    private final int WIDTH = 800;
    private final int HEIGHT = 200;

    public void exibir() {
        tela = new JFrame("Pagamento");
        tela.setSize(WIDTH, HEIGHT);
        tela.setLocationRelativeTo(null);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(new BorderLayout());

        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 10, 10));
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnPagarMensal = new JButton("Pagar Plano Mensal");
        btnPagarMensal.addActionListener(e -> pagarMensal());
        
        JButton btnPagarTrimestral = new JButton("Pagar Plano Mensal");
        btnPagarTrimestral.addActionListener(e -> pagarTrimestral());
        
        JButton btnPagarAnual = new JButton("Pagar Plano Mensal");
        btnPagarAnual.addActionListener(e -> pagarAnual());

        painelBotoes.add(btnPagarMensal);
        painelBotoes.add(btnPagarTrimestral);
        painelBotoes.add(btnPagarAnual);
        

        tela.add(painelBotoes, BorderLayout.CENTER);

        tela.setVisible(true);
    }

    private void pagarMensal(){
        PlanoMensal plano = new PlanoMensal();
        
        String mensagem = "Você pagou " + plano.pagamento() + " reais e tem 1 mês de mensalidade paga(s)";

    JOptionPane.showMessageDialog(tela, mensagem);
    
    tela.dispose();
    }
    
    private void pagarTrimestral(){
        PlanoTrimestral plano = new PlanoTrimestral();
        
        String mensagem = "Você pagou " + plano.pagamento() + " reais e tem 3 mês de mensalidade paga(s)";

    JOptionPane.showMessageDialog(tela, mensagem);
    
    tela.dispose();
    }
    
    private void pagarAnual(){
        PlanoAnual plano = new PlanoAnual();
        
        String mensagem = "Você pagou " + plano.pagamento() + " reais e tem 12 mês de mensalidade paga(s)";

    JOptionPane.showMessageDialog(tela, mensagem);
    
    tela.dispose();
    }
}
