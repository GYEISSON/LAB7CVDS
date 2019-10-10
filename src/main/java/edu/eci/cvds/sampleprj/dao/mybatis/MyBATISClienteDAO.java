/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import java.util.Date;
import java.util.List;

/**
 *
 * @author yeiso
 */
public class MyBATISClienteDAO implements ClienteDAO{
    @Inject
    private ClienteMapper clienteMapper;

    @Override
    public void save(Cliente cliente) throws PersistenceException{
        try{
            clienteMapper.insertarCliente(cliente);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el cliente "+cliente.toString(),e);
        }

    }

    @Override
    public Cliente consultarCliente(long id) throws PersistenceException {
        try{
            return clienteMapper.consultarCliente((int) id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el cliente "+id,e);
        }
    }

   
    @Override
    public List<Cliente> consultarClientes() throws  PersistenceException{
        try{
            return clienteMapper.consultarCliente();
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar los clientes ", e);
        }
    }

    @Override
    public void agregarItemRentadoACliente(long idCliente, int idItem, Date fechainicio, Date fechafin) throws PersistenceException {
        try{
            clienteMapper.agregarItemRentadoACliente((int) idCliente,idItem,fechainicio,fechafin);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al agregar el item"
                    +idItem+" a los items rentados del cliente"+idCliente, e);
        }
    }

    @Override
    public void vetarCliente(long idCliente, int estado) throws PersistenceException {
        try{
            clienteMapper.vetarCliente(idCliente,estado);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al cambiar el estado del cliente "+idCliente, e);
        }

    }
    
}
