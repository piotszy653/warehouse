package warehouse.beans;

import warehouse.domains.Product;
import warehouse.interfaces.ProductCRUD;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ProductEJB implements ProductCRUD {

    @PersistenceContext(name="warehouse")
    EntityManager manager;


    @Override
    public void save(Product product) {
        System.out.println("Creating product!");
        manager.persist(product);
        System.out.println("Product created. "+product.toString());
    }

    @Override
    public Product get(int id) {
        return manager.find(Product.class, id);
    }

    @Override
    public List<Product> get() {
        Query q = manager.createQuery("select p from Product p");
        @SuppressWarnings("unchecked")
        List<Product> products = q.getResultList();
        return products;
    }

    @Override
    public List<Product> getBy(String filter){
        Query q = manager.createQuery("select p from Product p where p."+filter+" like :"+filter);
        q.setParameter(filter, filter);
        @SuppressWarnings("unchecked")
        List<Product> products =q.getResultList();
        return products;
    }

    @Override
    public void update(Product product) {
        manager.merge(product);
    }

    @Override
    public void delete(int id) {
        manager.remove(manager.find(Product.class, id));
    }
}
