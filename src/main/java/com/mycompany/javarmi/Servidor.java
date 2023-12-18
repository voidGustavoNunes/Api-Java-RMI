/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.*;
import java.util.Date;
import java.util.List;

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
    public synchronized double calcularMedia(int tipo, List<Economia> ecoList) throws RemoteException, DadosInsuficientes { // o usuario vai passar o tipo e os valores do dolar
        double[] tresUltimosValores = new double[9];
        double[] seisUltimosValores = new double[6];
        double[] noveUltimosValores = new double[3];
        double media = 0;
        double soma = 0;

        int tamanho = ecoList.size();
        if (tamanho >= 3) {
            switch (tipo) {
                case 1:
                    for (int i = tamanho - 3, j = 0; i < tamanho && j < tamanho; i++, j++) {
                        tresUltimosValores[i] = ecoList.get(j).cotacao;
                        soma += ecoList.get(j).cotacao;
                        media = soma / 3;
                        ecoList.get(j).setM3(media);
                    }
                    break;
                case 2:
                    if (tamanho >= 6) {
                        for (int i = tamanho - 6, j = 0; i < tamanho && j < tamanho; i++, j++) {
                            seisUltimosValores[i] = ecoList.get(j).cotacao;
                            soma += ecoList.get(j).cotacao;
                            media = soma / 6;
                            ecoList.get(j).setM6(media);
                        }
                    }
                    break;

                case 3:
                    if (tamanho >= 9) {
                        for (int i = tamanho - 9, j = 0; i < tamanho && j < tamanho; i++, j++) {
                            noveUltimosValores[i] = ecoList.get(j).cotacao;
                            soma += ecoList.get(j).cotacao;
                            media = soma / 9;
                            ecoList.get(j).setM9(media);
                        }
                    }
                    break;

                case 4:
                    if (tamanho >= 9) {
                        for (int i = tamanho - 9, j = 0; i < tamanho && j < tamanho; i++, j++) {
                            noveUltimosValores[i] = ecoList.get(j).cotacao;
                            soma += ecoList.get(j).cotacao;
                            media = soma / 3;
                            double resulta = media - ecoList.get(j).cotacao;
                            ecoList.get(j).setM3Cotacao(resulta);
                        }
                    }
                    break;
            }
            return media;
        }
//        throw new DadosInsuficientes();
        return 0;

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
