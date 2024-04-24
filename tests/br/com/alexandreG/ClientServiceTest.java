/**
 @author alexandre.gaia
 */

package br.com.alexandreG;

import DAO.ClientDAOMock;
import br.com.alexandreG.DAO.IClientDAO;
import br.com.alexandreG.Domain.Client;
import br.com.alexandreG.Services.ClientService;
import br.com.alexandreG.Services.IClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientServiceTest {

    private final IClientService clientService;

    private Client client;

    public ClientServiceTest() {
        IClientDAO daoMock = new ClientDAOMock();
        clientService = new ClientService(daoMock);
    }

    @BeforeEach
    public void init(){

        client = new Client();
        client.setName("Alexandre");
        client.setCpf(90123456789L);
        client.setTel(42998571395L);
        client.setAddress("Main Street Av.");
        client.setNumber(1100);
        client.setCity("Beverly Hills");
        client.setState("California");
    }

    @Test
    public void testSaveClient() throws ClassNotFoundException {
        Boolean response  = clientService.save(client);
        Assertions.assertTrue(response);
    }

    @Test
    public void searchClientTest() {
        Client consultedClient = clientService.searchByCpf(client.getCpf());

        Assertions.assertNotNull(consultedClient);
    }

    @Test
    public void deleteClientTest() {
        clientService.delete(client.getCpf());
    }
    @Test
    public void updateClientTest() throws ClassNotFoundException {
        client.setName("Alexandre Gaia");
        clientService.update(client);

        Assertions.assertEquals("Alexandre Gaia", client.getName());
    }
}