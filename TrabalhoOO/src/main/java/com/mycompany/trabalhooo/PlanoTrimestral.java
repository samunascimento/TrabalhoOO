/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhooo;

/**
 *
 * @author Samuel
 */
public class PlanoTrimestral extends Plano {
    
    @Override
    public double pagamento() {
        return 3*(super.getValor()*0.95);
    }
    
}
