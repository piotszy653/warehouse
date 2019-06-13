package warehouse.interfaces;

import javax.ejb.Local;

import warehouse.DAO.Product;

import java.util.List;

@Local
public interface ProductCRUD {

    public abstract Product save(Product product);

    public abstract Product get(int id);

    public abstract List<Product> get();

    public abstract List<Product> getBy(String filter, String value);

    public abstract Product update(Product product);

    public abstract void delete(int id);

}