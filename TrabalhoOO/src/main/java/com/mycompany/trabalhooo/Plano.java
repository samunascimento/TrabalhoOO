/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;

/**
 *
 * @author Samuel
 */
public abstract class Plano {
    
    private final double valor = 90;

    public double getValor() {
        return valor;
    }

    public abstract double pagamento();
}
