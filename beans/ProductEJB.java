package warehouse.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import warehouse.DAO.Product;

import java.util.List;

@Stateless
public class ProductEJB {

    @PersistenceContext(name="warehouse")
    EntityManager manager;


    public void save(Product product) {
        System.out.println("Creating product!");
        manager.persist(product);
    }

    public Product get(int id) {
        return manager.find(Product.class, id);
    }

    public List<Product> get() {
        Query q = manager.createQuery("select p from Product p");
        @SuppressWarnings("unchecked")
        List<Product> products = q.getResultList();
        return products;
    }

    public List<Product> getBy(String filter, String value){
    	 Query q = manager.createQuery("select p from Product p where p."+filter+" = '"+value+"'");
        @SuppressWarnings("unchecked")
        List<Product> products =q.getResultList();
        return products;
    }

    public void update(Product product) {
        manager.merge(product);
    }

    public void delete(int id) {
        manager.remove(manager.find(Product.class, id));
    }
}
