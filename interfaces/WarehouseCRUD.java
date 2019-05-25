package warehouse.interfaces;

import warehouse.domains.Warehouse;

import javax.ejb.Local;
import java.util.List;

@Local
public interface WarehouseCRUD {

    public abstract void save(Warehouse warehouse);

    public abstract Warehouse get(int id);

    public abstract List<Warehouse> get();

    public abstract List<Warehouse> getBy(String filter);

    public abstract void update(Warehouse warehouse);

    public abstract void delete(int id);

}