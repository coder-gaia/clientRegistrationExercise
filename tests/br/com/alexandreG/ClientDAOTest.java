/**
 @author alexandre.gaia
 */

package br.com.alexandreG;

import DAO.ClientDAOMock;
import br.com.alexandreG.DAO.IClientDAO;
import br.com.alexandreG.Domain.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ClientDAOTest {

    private Client client;
    private final IClientDAO clientDAO;

    public ClientDAOTest() {
        clientDAO = new ClientDAOMock();
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
    public void saveClientTest() {
       boolean response  = clientDAO.save(client);
       Assertions.assertTrue(response);
    }

    @Test
    public void searchClientTest() {
        Client consultedClient = clientDAO.searchByCpf(client.getCpf());

        Assertions.assertNotNull(consultedClient);
    }

    @Test
    public void deleteClientTest() {
        clientDAO.delete(client.getCpf());
    }
    @Test
    public void updateClientTest() {
        client.setName("Alexandre Gaia");
        clientDAO.update(client);

        Assertions.assertEquals("Alexandre Gaia", client.getName());
    }
}