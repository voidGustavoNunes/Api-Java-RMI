/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class Cotacao {
    LocalDate dia;
    int mes;
    double valor;
    
    double mediaMovel3Dias;
    double mediaMovel6Dias;
    double mediaMovel9Dias;

    public Cotacao(LocalDate dia, int mes, double valor) {
        this.dia = LocalDate.now();
        this.valor = valor;
    }

    public Cotacao() {
    }

    public double getMediaMovel3Dias() {
        return mediaMovel3Dias;
    }

    public void setMediaMovel3Dias(double mediaMovel3Dias) {
        this.mediaMovel3Dias = mediaMovel3Dias;
    }

    public double getMediaMovel6Dias() {
        return mediaMovel6Dias;
    }

    public void setMediaMovel6Dias(double mediaMovel6Dias) {
        this.mediaMovel6Dias = mediaMovel6Dias;
    }

    public double getMediaMovel9Dias() {
        return mediaMovel9Dias;
    }

    public void setMediaMovel9Dias(double mediaMovel9Dias) {
        this.mediaMovel9Dias = mediaMovel9Dias;
    }

    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
    
    
}
