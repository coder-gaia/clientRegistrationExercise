/**
 * @author alexandre.gaia
 */

package br.com.alexandreG.DAO.Generics;


import br.com.alexandreG.Domain.IPersistance;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends IPersistance> implements IGenericDAO<T>{

    protected Map<Class, Map<Long, T>> map;

    public abstract Class<T> getClassType();

    public abstract void updateData(T entity, T registeredEntity);

    public GenericDAO() {
        this.map = new HashMap<>();

    }

    @Override
    public boolean save(T entity) {
       Map<Long, T> innerMap = this.map.get(getClassType());
        if(innerMap.containsKey(entity.getCode())){
            return false;
        }
        innerMap.put(entity.getCode(), entity);
        return true;
    }

    @Override
    public void delete(Long value) {
        Map<Long, T> innerMap = this.map.get(getClassType());
        T registeredObject = innerMap.get(value);

        if(registeredObject != null){
            this.map.remove(value, registeredObject);
        }
    }

    @Override
    public void update(T entity) {
        Map<Long, T> innerMap = this.map.get(getClassType());
        T registeredObject = innerMap.get(entity.getCode());

        if(registeredObject != null){
            updateData(entity, registeredObject);
        }
    }

    @Override
    public T searchByCpf(Long value) {
        Map<Long, T> innerMap = this.map.get(getClassType());
        return innerMap.get(value);
    }

    @Override
    public Collection<T> searchALL() {
        Map<Long, T> innerMap = this.map.get(getClassType());
        return innerMap.values();
    }
}
