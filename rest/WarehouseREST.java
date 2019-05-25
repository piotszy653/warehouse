package warehouse.rest;

import warehouse.beans.WarehouseEJB;
import warehouse.domains.Warehouse;
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

	@Override
	@POST
	public void save(Warehouse warehouse) {
		bean.save(warehouse);
		System.out.println("Warehouse created. "+warehouse.toString());
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
	@Path("/{filter}")
	public List<Warehouse> getBy(@PathParam("filter") String filter) {
		return bean.getBy(filter);
	}

	@Override
	@PUT
	public void update(Warehouse warehouse) {
		try {
			bean.update(warehouse);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		bean.delete(id);
	}


}
