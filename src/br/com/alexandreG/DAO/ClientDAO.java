/**
 * @author alexandre.gaia
 */

package br.com.alexandreG.DAO;
import br.com.alexandreG.DAO.Generics.GenericDAO;
import br.com.alexandreG.Domain.Client;


public class ClientDAO extends GenericDAO<Client> implements IClientDAO{

    @Override
    public Class<Client> getClassType() {
        return null;
    }

    @Override
    public void updateData(Client entity, Client registeredEntity) {
    }

    public ClientDAO() {
        super();
    }
}
