package warehouse.beans;

import warehouse.domains.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class InvoiceEJB {

    @PersistenceContext(name="warehouse")
    EntityManager manager;


    public void save(Client client) {
        System.out.println("Creating Client!");
        manager.persist(client);
        System.out.println("Client created. "+client.toString());
    }

    public Client get(int id) {
        return manager.find(Client.class, id);
    }

    public List<Client> get() {
        Query q = manager.createQuery("select c from Client c");
        @SuppressWarnings("unchecked")
        List<Client> clients = q.getResultList();
        return clients;
    }

    public List<Client> getByName(String name) {
        Query q = manager.createQuery("select c from Client c where c.name like :name");
        q.setParameter("name", name);
        @SuppressWarnings("unchecked")
        List<Client> clients =q.getResultList();
        return clients;
    }

    public List<Client> getByMail(String mail) {
        Query q = manager.createQuery("select c from Client c where c.mail like :mail");
        q.setParameter("mail", mail);
        @SuppressWarnings("unchecked")
        List<Client> clients =q.getResultList();
        return clients;
    }

    public void update(Client client) {
        manager.merge(client);
    }

    public void delete(int id) {
        manager.remove(manager.find(Client.class, id));
    }

}
