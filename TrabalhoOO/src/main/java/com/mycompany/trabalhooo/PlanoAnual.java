/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;

/**
 *
 * @author Samuel
 */
public class PlanoAnual extends Plano {
    
    @Override
    public double pagamento() {
        return 12*(super.getValor()*0.80);
    }
    
}
