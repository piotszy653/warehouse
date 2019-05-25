package warehouse;

import javax.ejb.Local;
import java.util.Set;

@Local
public interface ProductCRUD {

    public abstract void save(Product product);

    public abstract Product get(int id);

    public abstract Set<Product> get();

    public abstract void update(Product product);

    public abstract void delete(int id);

}