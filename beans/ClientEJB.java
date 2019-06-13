package warehouse.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import warehouse.DAO.Client;

import java.util.List;

@Stateless
public class ClientEJB {

    @PersistenceContext(name="warehouse")
    EntityManager manager;


    public void save(Client client) {
        System.out.println("Creating Client!");
        manager.persist(client);
    }

    public Client get(int id) {
        Client client = manager.find(Client.class, id);
        client.setInvoices(null);
        return client;
    }

    public List<Client> get() {
        Query q = manager.createQuery("select c from Client c");
        @SuppressWarnings("unchecked")
        List<Client> clients = q.getResultList();
        for(Client client: clients){
        	client.setInvoices(null);
        }
        return clients;
    }

    public List<Client> getBy(String filter, String value){
        Query q = manager.createQuery("select c from Client c where c."+filter+" = '"+value+"'");
        @SuppressWarnings("unchecked")
        List<Client> clients =q.getResultList();
        for(Client client: clients){
        	client.setInvoices(null);
        }
        return clients;
    }

    public void update(Client client) {
        manager.merge(client);
    }

    public void delete(int id) {
        manager.remove(manager.find(Client.class, id));
    }
}
