/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LEDS
 */
public class Economia {
    Date dtCota;
    double cotacao;
    double m3;
    double m6;
    double m9;
    double m3Cotacao;
    
    public Object[] toArray() throws ParseException {
        return new Object[] { dateToStr(dtCota), cotacao, m3, m6, m9, m3Cotacao };
    }

    public Economia(Date dtCota, double cotacao) {
        this.dtCota = dtCota;
        this.cotacao = cotacao;
    }

    public Date getDtCota() {
        return dtCota;
    }

    public double getCotacao() {
        return cotacao;
    }
   
    public double getM3() {
        return m3;
    }

    public void setM3(double m3) {
        this.m3 = m3;
    }

    public double getM6() {
        return m6;
    }

    public void setM6(double m6) {
        this.m6 = m6;
    }

    public double getM9() {
        return m9;
    }

    public void setM9(double m9) {
        this.m9 = m9;
    }

    public double getM3Cotacao() {
        return m3Cotacao;
    }

    public void setM3Cotacao(double m3Cotacao) {
        this.m3Cotacao = m3Cotacao;
    }
    
     public static String dateToStr( Date dt) throws ParseException {
         DateFormat dtForm = new SimpleDateFormat("dd/MM/yyyy");
        dtForm.setLenient(false);
        return dtForm.format(dt);
    }
}
