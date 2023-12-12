/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javarmi;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author Gustavo
 */
public class AgenteMM { //INDICA CORRETAMENETE A TENDENCIA DE EVOLUCAO DA COTACAO DO DOLAR EM TERMOS PERCENTUAIS

    Servidor servidor;
//LOGICA

    public AgenteMM(Servidor servidor) {
        this.servidor = servidor;
    }

    public double retornaValor(double[] valores) throws RemoteException, DadosInsuficientes { //FAZER A VERIFICACAO NO FRONTEND PARA QUE SO CHAME ESSA FUNCAO CASO TENHA 9 COTACOES
        double mediaTresUltimosValores;
        double mediaSeisUltimosValores;
        double mediaNoveUltimosValores;
        double valor = 0;

        int tamanho = valores.length;

        try {
            servidor = new Servidor();

        } catch (Exception e) {
            e.getMessage();
        }
        mediaTresUltimosValores = servidor.calcularMedia(1, valores);
        mediaSeisUltimosValores = servidor.calcularMedia(2, valores);
        mediaNoveUltimosValores = servidor.calcularMedia(3, valores);

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

    public String recomendacaoParaUsuario(double[] valores) throws RemoteException, DadosInsuficientes {
        double valor;

        valor = retornaValor(valores);

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

            //REALIZAR A LOGICA PARA CALCULAR A MEDIA E MOSTRAR PARA O USUARIO
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;

        }

    }

}
