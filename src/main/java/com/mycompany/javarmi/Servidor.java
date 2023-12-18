/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi;

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.server.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class Servidor extends UnicastRemoteObject implements Cotacao {

    public Servidor() throws RemoteException, DadosInsuficientes, MalformedURLException {
        super();
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            // Se chegar aqui, o registro já existe, não precisa criar outro

            System.setProperty("java.rmi.server.hostname", "192.168.15.5");

        } catch (Exception e) {
            LocateRegistry.createRegistry(1099);
            Cotacao co = new Servidor();
            System.setProperty("java.rmi.server.hostname", "192.168.15.5");

            Naming.rebind("SERVIDOR_COTACAO", (Remote) co);
            System.out.println(e.getMessage());
        }

    }

    @Override
    public synchronized double calcularMedia(int tipo, List<Economia> ecoList) throws RemoteException, DadosInsuficientes { // o usuario vai passar o tipo e os valores do dolar
        double[] tresUltimosValores = new double[3];
        double[] seisUltimosValores = new double[6];
        double[] noveUltimosValores = new double[9];
        double media = 0;
        double soma = 0;

        int tamanho = ecoList.size();
        if (tamanho >= 3) {
            switch (tipo) {
                case 1:
                    for (int i = tamanho - 3; i < tamanho; i++) {
                        soma += ecoList.get(i).cotacao;
                    }
                    media = soma / 3;
                    for (int i = tamanho - 3; i < tamanho; i++) {
                        ecoList.get(i).setM3(media);
                    }
                    break;

                case 2:
                    if (tamanho >= 6) {
                        for (int i = tamanho - 6; i < tamanho; i++) {
                            soma += ecoList.get(i).cotacao;
                        }
                        media = soma / 6;
                        for (int i = tamanho - 6; i < tamanho; i++) {
                            ecoList.get(i).setM6(media);
                        }
                    }
                    break;

                case 3:
                    if (tamanho >= 9) {
                        for (int i = tamanho - 9; i < tamanho; i++) {
                            soma += ecoList.get(i).cotacao;
                        }
                        media = soma / 9;
                        for (int i = tamanho - 9; i < tamanho; i++) {
                            ecoList.get(i).setM9(media);
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

    public static void main() {
        try {
            new Servidor();
            System.out.println("\n\n SERVIDOR INICIADO \n\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

    }

}
