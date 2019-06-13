package warehouse.interfaces;

import javax.ejb.Local;

import warehouse.DAO.Invoice;

import java.util.List;

@Local
public interface InvoiceCRUD {

    public abstract Invoice save(Invoice invoice);

    public abstract Invoice get(int id);

    public abstract List<Invoice> get();

    public abstract List<Invoice> getBy(String filter, String value);

    public abstract Invoice update(Invoice invoice);

    public abstract void delete(int id);

}