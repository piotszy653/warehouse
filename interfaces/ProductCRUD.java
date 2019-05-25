package warehouse.interfaces;

import warehouse.domains.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductCRUD {

    public abstract void save(Product product);

    public abstract Product get(int id);

    public abstract List<Product> get();

    public abstract List<Product> getBy(String filter);

    public abstract void update(Product product);

    public abstract void delete(int id);

}