/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class AgenteMM { //INDICA CORRETAMENETE A TENDENCIA DE EVOLUCAO DA COTACAO DO DOLAR EM TERMOS PERCENTUAIS

    Servidor servidor;
    List<Economia> ecoList = new ArrayList<>();
    int tipoMedia;
//LOGICA

    public int getTipoMedia() {
        return tipoMedia;
    }

    public void setTipoMedia(int tipoMedia) {
        this.tipoMedia = tipoMedia;
    }
    
    public void adicionaEconomia(Economia eco){
        ecoList.add(eco);
    }

    public List<Economia> getEcoList() {
        return ecoList;
    }

    public AgenteMM(Servidor servidor) {
        this.servidor = servidor;
    }

    public AgenteMM() {
    }

    public double retornaValor() throws RemoteException, DadosInsuficientes { //FAZER A VERIFICACAO NO FRONTEND PARA QUE SO CHAME ESSA FUNCAO CASO TENHA 9 COTACOES
        double mediaTresUltimosValores;
        double mediaSeisUltimosValores;
        double mediaNoveUltimosValores;
        double tresMenosCotacaoValores;
        double valor = 0;
        int i = 0;

        try {
            servidor = new Servidor();
        } catch (Exception e) {
            e.getMessage();
        }
        mediaTresUltimosValores = servidor.calcularMedia(tipoMedia, ecoList);
        mediaSeisUltimosValores = servidor.calcularMedia(tipoMedia, ecoList);
        mediaNoveUltimosValores = servidor.calcularMedia(tipoMedia, ecoList);
        tresMenosCotacaoValores = servidor.calcularMedia(tipoMedia, ecoList);

        if ((!(mediaSeisUltimosValores > mediaTresUltimosValores)) && (!(mediaNoveUltimosValores > mediaTresUltimosValores))) {
            valor = 1.00;

        } else if ((!(mediaSeisUltimosValores > mediaTresUltimosValores)) && ((mediaNoveUltimosValores > mediaSeisUltimosValores))) {
            valor = 0.75;

        } else if (((mediaSeisUltimosValores > mediaTresUltimosValores)) && (!(mediaNoveUltimosValores > mediaSeisUltimosValores))) {
            valor = 0;

        } else if (((mediaSeisUltimosValores > mediaTresUltimosValores)) && (!(mediaNoveUltimosValores > mediaSeisUltimosValores))) {
            valor = 0.25;
        }
        return valor;
    }

    public String recomendacaoParaUsuario() throws RemoteException, DadosInsuficientes {
        double valor;

        valor = retornaValor();

        String resultado = null;

        if (valor == 0) {
            resultado = "\n\n A tendência de BAIXA do dólar é igual a 0, possível BOM momento para COMPRA, possível momento RUIM para VENDA";

        } else if (valor == 0.25) {
            resultado = "\n\n A tendência de BAIXA do dólar é igual a 0.25, possível  BOM momento para COMPRA, possível momento RUIM para VENDA";

        } else if (valor == 0.75) {
            resultado = "\n\n A tendência de ALTA do dóllar é igual a 0.75, possível RUIM momento para COMPRA, possível  momento BOM para VENDA";

        } else {
            resultado = "\n\n A tendência de ALTA do dólar é igual a 1,  possível RUIM momento para COMPRA, possível  momento BOM para VENDA";

        }

        return resultado;
    }

    public double calculaM3Cotacao(double cotacao1, double cotacao2){ //AINDA NAO SEI COMO FAZ
        double cotacaoFinal = 0;
        
        
        
        
        
    
        return cotacaoFinal;
    }
    
    public static void main() {
        try {
            Cotacao cotacao = (Cotacao) Naming.lookup("rmi://192.168.15.5:1099/SERVIDOR_COTACAO");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;

        }

    }

}
