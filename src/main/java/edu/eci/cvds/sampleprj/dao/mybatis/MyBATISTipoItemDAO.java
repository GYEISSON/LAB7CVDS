/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;
import java.util.List;

/**
 *
 * @author yeiso
 */
public class MyBATISTipoItemDAO implements TipoItemDAO{
    @Inject
    private TipoItemMapper tipoItemMapper;

    @Override
    public void save(TipoItem tipoItem) throws PersistenceException{
        try{
            tipoItemMapper.addTipoItem(tipoItem);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al registrar el tipo de item:"+ tipoItem.toString(),e);
        }
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws PersistenceException {
        try{
            return tipoItemMapper.getTipoItem(id);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error al consultar el tipo de item item "+id,e);
        }
    }
    @Override
    public List<TipoItem> consultarTiposItem() throws PersistenceException {
        try {
            return tipoItemMapper.getTipoItem();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar los tipos de item", e);
        }
    }
}
