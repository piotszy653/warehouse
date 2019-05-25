package warehouse.interfaces;

import warehouse.domains.Invoice;

import javax.ejb.Local;
import java.util.List;

@Local
public interface InvoiceCRUD {

    public abstract void save(Invoice invoice);

    public abstract Invoice get(int id);

    public abstract List<Invoice> get();

    public abstract List<Invoice> getBy(String filter);

    public abstract void update(Invoice invoice);

    public abstract void delete(int id);

}