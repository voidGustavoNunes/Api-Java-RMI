/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi;

/**
 *
 * @author Gustavo
 */
public class DadosInsuficientes extends Exception{

    public DadosInsuficientes() {
        super();
        System.out.println("\n DADOS DE COTACAO INSUFICIENTES!\n OS DADOS PRECISAM TER MAIS QUE 3 VALORES DE COTACAO!\n");
    }
    
    
   
}
