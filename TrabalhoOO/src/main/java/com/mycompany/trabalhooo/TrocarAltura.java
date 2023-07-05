/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Samuel
 */
public class TrocarAltura implements ActionListener {
    private final TelaIMC tela;

    public TrocarAltura(TelaIMC tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.trocarAltura();
    }
}
