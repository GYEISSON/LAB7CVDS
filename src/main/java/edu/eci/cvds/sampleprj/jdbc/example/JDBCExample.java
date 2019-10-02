/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.sampleprj.jdbc.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class JDBCExample {
    
    public static void main(String args[]){
        try {
            String url="jdbc:mysql://desarrollo.is.escuelaing.edu.co:3306/bdprueba";
            String driver="com.mysql.jdbc.Driver";
            String user="bdprueba";
            String pwd="prueba2019";
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pwd);
            con.setAutoCommit(false);
            System.out.println("Valor total pedido 1:"+valorTotalPedido(con, 1));
            List<String> prodsPedido=nombresProductosPedido(con, 1);
            
            System.out.println("Productos del pedido 1:");
            System.out.println("-----------------------");
            
            for (String nomprod:prodsPedido){
                System.out.println(nomprod);
                
            }
            System.out.println("-----------------------");
            int suCodigoECI=20134423;
            registrarNuevoProducto(con, suCodigoECI, "SU NOMBRE", 99999999);            
            con.commit();
                        
            
            con.close();
                                   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     * Agregar un nuevo producto con los parámetros dados
     * @param con la conexión JDBC
     * @param codigo
     * @param nombre
     * @param precio
     * @throws SQLException 
     */
    public static void registrarNuevoProducto(Connection con, int codigo, String nombre,int precio) throws SQLException{
        //Crear preparedStatement
        //Asignar parámetros
        //usar 'execute'
    	//PreparedStatement entrada = con.prepareCall("insert into VI_ITEM values ");
        
        con.commit();
        
    }
    
    /**
     * Consultar los nombres de los productos asociados a un pedido
     * @param con la conexión JDBC
     * @param codigoPedido el código del pedido
     * @return 
     * @throws SQLException 
     */
    public static List<String> nombresProductosPedido(Connection con, int codigoPedido) throws SQLException{
        List<String> np=new LinkedList<>();
        //Crear prepared statement
        PreparedStatement entrada = con.prepareCall("select NOMBRE from ORD_DETALLE_PEDIDO, ORD_PRODUCTOS where producto_fk=codigo and pedido_fk=? ");
        //asignar parámetros
        entrada.setInt(1, codigoPedido);
        //usar executeQuery
        ResultSet rs = entrada.executeQuery();
        //Sacar resultados del ResultSet
        //Llenar la lista y retornarla
        while(rs.next()){ np.add( 
            rs.getString(1));
        }
        return np;
    }

    
    /**
     * Calcular el costo total de un pedido
     * @param con
     * @param codigoPedido código del pedido cuyo total se calculará
     * @return el costo total del pedido (suma de: cantidades*precios)
     */
    public static int valorTotalPedido(Connection con, int codigoPedido) throws SQLException{
        
        //Crear prepared statement
        PreparedStatement entrada = con.prepareCall("select SUM(ORD_DETALLE_PEDIDO.cantidad*ORD_PRODUCTOS.precio) from ORD_PRODUCTOS,ORD_DETALLE_PEDIDO,ORD_PEDIDOS where producto_fk=ORD_PRODUCTOS.codigo and ORD_PEDIDOS.codigo = pedido_fk and ORD_PEDIDOS.codigo=?");
        //asignar parámetros
        //System.out.println(entrada.toString());
        entrada.setInt(1, codigoPedido);
        //usar executeQuery
        ResultSet rs = entrada.executeQuery();  
        //Sacar resultado del ResultSet
        rs.next();
        return rs.getInt(1);
    }
    

    
    
    
}