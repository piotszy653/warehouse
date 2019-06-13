package warehouse.interfaces;

import javax.ejb.Local;

import warehouse.DAO.Warehouse;

import java.util.List;

@Local
public interface WarehouseCRUD {

    public abstract Warehouse save(Warehouse warehouse);
    
    public abstract Warehouse get(int id);

    public abstract List<Warehouse> get();

    public abstract List<Warehouse> getBy(String filter, String value);

    public abstract Warehouse update(Warehouse warehouse);
    
    public abstract Warehouse addProduct(Integer warehouseId, Integer productId);

    public abstract void delete(int id);

}