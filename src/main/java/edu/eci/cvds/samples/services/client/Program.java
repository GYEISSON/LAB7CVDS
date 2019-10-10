/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.services.client;


import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;

/**
 *
 * @author yeiso
 */
public class Program {
        public static void main(String[] args) throws ExcepcionServiciosAlquiler{
        
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarCliente(0));
        System.out.println(ServiciosAlquilerFactory.getInstance().getServiciosAlquiler().consultarCostoAlquiler(99,2));

        System.exit(0);
    }
}
