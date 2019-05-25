package warehouse.beans;

import warehouse.domains.Invoice;
import warehouse.interfaces.InvoiceCRUD;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class InvoiceEJB implements InvoiceCRUD {

    @PersistenceContext(name="warehouse")
    EntityManager manager;


    @Override
    public void save(Invoice invoice) {
        System.out.println("Creating Invoice!");
        manager.persist(invoice);
    }

    @Override
    public Invoice get(int id) {
        return manager.find(Invoice.class, id);
    }

    @Override
    public List<Invoice> get() {
        Query q = manager.createQuery("select i from Invoice i");
        @SuppressWarnings("unchecked")
        List<Invoice> invoices = q.getResultList();
        return invoices;
    }

    @Override
    public List<Invoice> getBy(String filter){
        Query q = manager.createQuery("select i from Invoice i where i."+filter+" like :"+filter);
        q.setParameter(filter, filter);
        @SuppressWarnings("unchecked")
        List<Invoice> invoices =q.getResultList();
        return invoices;
    }

    @Override
    public void update(Invoice invoice) {
        manager.merge(invoice);
    }

    @Override
    public void delete(int id) {
        manager.remove(manager.find(Invoice.class, id));
    }
}
