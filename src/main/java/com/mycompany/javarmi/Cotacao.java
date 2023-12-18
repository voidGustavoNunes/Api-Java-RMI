/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public interface Cotacao extends Remote{

    public double calcularMedia(int tipo, List<Economia> eco) throws RemoteException, DadosInsuficientes;

}
