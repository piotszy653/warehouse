package warehouse;

import javax.ejb.Local;
import java.util.Set;

@Local
public interface WarehouseCRUD {

    public abstract void save(Warehouse warehouse);

    public abstract Warehouse get(int id);

    public abstract Set<Warehouse> get();

    public abstract void update(Warehouse warehouse);

    public abstract void delete(int id);

}