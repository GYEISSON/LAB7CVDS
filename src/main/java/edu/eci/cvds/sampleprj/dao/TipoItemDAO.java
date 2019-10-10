/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;
import edu.eci.cvds.samples.entities.TipoItem;
import java.util.List;
/**
 *
 * @author Carlos Murillo
 */
public interface TipoItemDAO {
    public void save(TipoItem tipoItem) throws PersistenceException;

    public TipoItem consultarTipoItem(int id) throws PersistenceException;
    public List<TipoItem> consultarTiposItem() throws PersistenceException;
}
