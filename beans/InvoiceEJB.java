package warehouse.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import warehouse.DAO.Invoice;

import java.util.List;

@Stateless
public class InvoiceEJB {

    @PersistenceContext(name="warehouse")
    EntityManager manager;


    public void save(Invoice invoice) {
        System.out.println("Creating Invoice!");
        manager.persist(invoice);
    }

    public Invoice get(int id) {
        return manager.find(Invoice.class, id);
    }

    public List<Invoice> get() {
        Query q = manager.createQuery("select i from Invoice i");
        @SuppressWarnings("unchecked")
        List<Invoice> invoices = q.getResultList();
        return invoices;
    }

    public List<Invoice> getBy(String filter, String value){
        Query q = manager.createQuery("select i from Invoice i where i."+filter+" like :"+value);
        q.setParameter(filter, value);
        @SuppressWarnings("unchecked")
        List<Invoice> invoices =q.getResultList();
        return invoices;
    }

    public void update(Invoice invoice) {
        manager.merge(invoice);
    }

    public void delete(int id) {
        manager.remove(manager.find(Invoice.class, id));
    }
}
