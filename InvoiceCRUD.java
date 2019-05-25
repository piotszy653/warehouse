package warehouse;

import javax.ejb.Local;
import java.util.Set;

@Local
public interface InvoiceCRUD {

    public abstract void save(Invoice invoice);

    public abstract Invoice get(int id);

    public abstract Set<Invoice> get();

    public abstract void update(Invoice invoice);

    public abstract void delete(int id);

}