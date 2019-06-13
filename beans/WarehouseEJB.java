package warehouse.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import warehouse.DAO.Warehouse;

import java.util.List;

@Stateless
public class WarehouseEJB {

    @PersistenceContext(name="warehouse")
    EntityManager manager;


    public void save(Warehouse warehouse) {
        System.out.println("Creating Warehouse!");
        manager.persist(warehouse);
    }

    public Warehouse get(int id) {
        Warehouse warehouse = manager.find(Warehouse.class, id);
        warehouse.setProducts(null);
        return warehouse;
    }

    public List<Warehouse> get() {
        Query q = manager.createQuery("select w from Warehouse w");
        @SuppressWarnings("unchecked")
        List<Warehouse> warehouses = q.getResultList();
        for(Warehouse warehouse: warehouses){
        	warehouse.setProducts(null);
        }
        return warehouses;
    }

    public List<Warehouse> getBy(String filter, String value){
        Query q = manager.createQuery("select w from Warehouse w where w."+filter+" like :"+value);
        q.setParameter(filter, value);
        @SuppressWarnings("unchecked")
        List<Warehouse> warehouses =q.getResultList();
        for(Warehouse warehouse: warehouses){
        	warehouse.setProducts(null);
        }
        return warehouses;
    }

    public void update(Warehouse warehouse) {
        manager.merge(warehouse);
    }

    public void delete(int id) {
        manager.remove(manager.find(Warehouse.class, id));
    }
}
