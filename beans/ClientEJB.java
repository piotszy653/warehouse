package warehouse.beans;

import warehouse.domains.Client;
import warehouse.interfaces.ClientCRUD;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ClientEJB implements ClientCRUD {

    @PersistenceContext(name="warehouse")
    EntityManager manager;


    @Override
    public void save(Client client) {
        System.out.println("Creating Client!");
        manager.persist(client);
    }

    @Override
    public Client get(int id) {
        return manager.find(Client.class, id);
    }

    @Override
    public List<Client> get() {
        Query q = manager.createQuery("select c from Client c");
        @SuppressWarnings("unchecked")
        List<Client> clients = q.getResultList();
        return clients;
    }

    @Override
    public List<Client> getBy(String filter){
        Query q = manager.createQuery("select c from Client c where c."+filter+" like :"+filter);
        q.setParameter(filter, filter);
        @SuppressWarnings("unchecked")
        List<Client> clients =q.getResultList();
        return clients;
    }

    @Override
    public void update(Client client) {
        manager.merge(client);
    }

    @Override
    public void delete(int id) {
        manager.remove(manager.find(Client.class, id));
    }
}
