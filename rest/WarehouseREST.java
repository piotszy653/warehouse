package warehouse.rest;

import warehouse.DAO.Product;
import warehouse.DAO.Warehouse;
import warehouse.beans.ProductEJB;
import warehouse.beans.WarehouseEJB;
import warehouse.interfaces.WarehouseCRUD;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;

@Path("/warehouse")
@Consumes({ "application/json" })
@Produces({ "application/json" })

//@Consumes({ "application/xml" })
//@Produces({ "application/xml" })

public class WarehouseREST implements WarehouseCRUD {

	@EJB
	WarehouseEJB bean;
	
	@EJB
	ProductEJB productBean;

	@Override
	@POST
	public Warehouse save(Warehouse warehouse) {
		bean.save(warehouse);
		System.out.println("Warehouse created. "+warehouse.toString());
		return warehouse;
	}

	@Override
	@GET
	@Path("/{id}")
	public Warehouse get(@PathParam("id") int id) {
		return bean.get(id);
	}

	@Override
	@GET
	public List<Warehouse> get() {
		return bean.get();
	}

	@Override
	@GET
	@Path("/{filter}/{value}")
	public List<Warehouse> getBy(@PathParam("filter") String filter, @PathParam("value") String value) {
		return bean.getBy(filter, value);
	}

	@Override
	@PUT
	public Warehouse update(Warehouse warehouse) {
		try {
			bean.update(warehouse);
			return warehouse;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@PUT
	@Path("/{warehouseId}/{productId}")
	public Warehouse addProduct(@PathParam("warehouseId") Integer warehouseId, @PathParam("productId") Integer productId){
		Warehouse warehouse = bean.get(warehouseId);
		Product product = productBean.get(productId);
		warehouse.getProducts().add(product);
		bean.update(warehouse);
		return warehouse;
	}

	@Override
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		bean.delete(id);
	}


}
