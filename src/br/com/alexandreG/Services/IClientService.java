/**
 * @author alexandre.gaia
 */
package br.com.alexandreG.Services;

import br.com.alexandreG.Domain.Client;

public interface IClientService {

    public Boolean save(Client client) throws ClassNotFoundException;

    Client searchByCpf(Long cpf);

    void delete(Long cpf);

    void update(Client client) throws ClassNotFoundException;
}
