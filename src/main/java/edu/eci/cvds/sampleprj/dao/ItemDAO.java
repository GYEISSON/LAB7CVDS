/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
//import javax.persistence.PersistenceException;

 
/**
 *
 * @author 2127790
 */
public interface ItemDAO {

    /**
     *
     * @param it

     * @throws edu.eci.cvds.sampleprj.dao.PersistenceException
     * @throws PersistenceException
     */

    public void save(Item it) throws PersistenceException;

    /**
     *
     * @param id
     * @return
     * @throws edu.eci.cvds.sampleprj.dao.PersistenceException
     * @throws PersistenceException
     */
    public Item load(int id) throws PersistenceException;
    
    public void actualizarTarifaItem( int id, long tarifa) throws PersistenceException;
}
