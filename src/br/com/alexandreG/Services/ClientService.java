/**
 * @author alexandre.gaia
 */

package br.com.alexandreG.Services;

import br.com.alexandreG.DAO.IClientDAO;
import br.com.alexandreG.Domain.Client;

public class ClientService implements IClientService {

    private final IClientDAO clientDAO;

    public ClientService(IClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    @Override
    public Boolean save(Client client) throws ClassNotFoundException {
        return clientDAO.save(client);
    }

    @Override
    public Client searchByCpf(Long cpf) {
        return clientDAO.searchByCpf(cpf);
    }

    @Override
    public void delete(Long cpf) {

    }

    @Override
    public void update(Client client) throws ClassNotFoundException {

    }
}
