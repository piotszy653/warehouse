package warehouse.beans;

import warehouse.domains.Warehouse;
import warehouse.interfaces.WarehouseCRUD;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class WarehouseEJB implements WarehouseCRUD {

    @PersistenceContext(name="warehouse")
    EntityManager manager;


    @Override
    public void save(Warehouse warehouse) {
        System.out.println("Creating Warehouse!");
        manager.persist(warehouse);
        System.out.println("Warehouse created. "+warehouse.toString());
    }

    @Override
    public Warehouse get(int id) {
        return manager.find(Warehouse.class, id);
    }

    @Override
    public List<Warehouse> get() {
        Query q = manager.createQuery("select w from Warehouse w");
        @SuppressWarnings("unchecked")
        List<Warehouse> warehouses = q.getResultList();
        return warehouses;
    }

    @Override
    public List<Warehouse> getBy(String filter){
        Query q = manager.createQuery("select w from Warehouse w where w."+filter+" like :"+filter);
        q.setParameter(filter, filter);
        @SuppressWarnings("unchecked")
        List<Warehouse> warehouses =q.getResultList();
        return warehouses;
    }

    @Override
    public void update(Warehouse warehouse) {
        manager.merge(warehouse);
    }

    @Override
    public void delete(int id) {
        manager.remove(manager.find(Warehouse.class, id));
    }
}
