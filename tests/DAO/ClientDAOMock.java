/**
 * @author alexandre.gaia
 */

package DAO;

import br.com.alexandreG.DAO.IClientDAO;
import br.com.alexandreG.Domain.Client;

import java.util.Collection;
import java.util.List;

public class ClientDAOMock implements IClientDAO {
    @Override
    public boolean save(Client client) {
        return true;
    }

    @Override
    public Client searchByCpf(Long cpf) {
       Client client = new Client();
       client.setCpf(cpf);
       return client;
    }

    @Override
    public Collection<Client> searchALL() {
        return List.of();
    }

    @Override
    public void delete(Long cpf) {

    }

    @Override
    public void update(Client client) {

    }
}
