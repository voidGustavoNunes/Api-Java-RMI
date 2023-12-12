/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.*;

/**
 *
 * @author Gustavo
 */
public class Servidor extends UnicastRemoteObject implements Cotacao {
    
    public Servidor() throws RemoteException , DadosInsuficientes{
        super();
        try{
        
            System.setProperty("java.rmi.server.hostname", "192.168.15.5");
            LocateRegistry.createRegistry(1099);
            Cotacao co = new Servidor();
            
            Naming.rebind("SERVIDOR_COTACAO", (Remote) co);
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        

    }

    @Override
    public synchronized double calcularMedia(int tipo, double[] valor) throws RemoteException, DadosInsuficientes { // o usuario vai passar o tipo e os valores do dolar
        double[] tresUltimosValores = null;
        double[] seisUltimosValores = null;
        double[] noveUltimosValores = null;
        double media = 0;
        double soma = 0;

        int tamanho = valor.length;
        if (tamanho >= 3) {
            switch (tipo) {
                case 0:
                    for (int i = tamanho - 3, j = 0; i < tamanho; i++, j++) {
                        tresUltimosValores[i] = valor[j];
                        soma += valor[j];
                        media = soma / 3;
                    }
                    break;
                case 1:
                    for (int i = tamanho - 6, j = 0; i < tamanho; i++, j++) {
                        seisUltimosValores[i] = valor[j];
                        soma += valor[j];
                        media = soma / 6;
                    }
                    break;

                case 2:
                    for (int i = tamanho - 3, j = 0; i < tamanho; i++, j++) {
                        noveUltimosValores[i] = valor[j];
                        soma += valor[j];
                        media = soma / 9;
                    }
                    break;
            }
            return media;
        }
        throw new DadosInsuficientes();

    }
    
    
    
    public static void main(){
        try{
            new Servidor();
        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
    
    
    }

}
