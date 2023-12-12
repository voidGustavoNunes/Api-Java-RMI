/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.javarmi;

import java.rmi.*;
import java.net.MalformedURLException;
/**
 *
 * @author Gustavo
 */
public class JavaRMI { // CLIENTE
    
    public static void main(){
        try{
            Cotacao cotacao = (Cotacao)Naming.lookup("rmi://192.168.15.5:1099/SERVIDOR_COTACAO");
            
            //REALIZAR A LOGICA PARA CALCULAR A MEDIA E MOSTRAR PARA O USUARIO
        
        }catch(Exception e){
            System.out.println(e.getMessage());
            return;
        
        
        }
    
    
    }
    
}
