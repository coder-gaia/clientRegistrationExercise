/**
 * @author alexandre.gaia
 */
package br.com.alexandreG.DAO.Generics;

import br.com.alexandreG.Domain.IPersistance;

import java.util.Collection;

public interface IGenericDAO <T extends IPersistance> {

    public boolean save(T entity);
    public void delete(Long value);
    public void update(T entity);
    public T searchByCpf(Long value);
    public Collection<T> searchALL();
}
