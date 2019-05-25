package warehouse.rest;


import warehouse.beans.ProductEJB;
import warehouse.domains.Product;
import warehouse.interfaces.ProductCRUD;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;

@Path("/product")
@Consumes({ "application/json" })
@Produces({ "application/json" })

//@Consumes({ "application/xml" })
//@Produces({ "application/xml" })

public class ProductREST implements ProductCRUD {

	@EJB
	ProductEJB bean;

	@Override
	@POST
	public void save(Product product) {
		bean.save(product);
		System.out.println("Product created. "+product.toString());
	}

	@Override
	@GET
	@Path("/{id}")
	public Product get(@PathParam("id") int id) {
		return bean.get(id);
	}

	@Override
	@GET
	public List<Product> get() {
		return bean.get();
	}

	@Override
	@GET
	@Path("/{filter}")
	public List<Product> getBy(@PathParam("filter") String filter) {
		return bean.getBy(filter);
	}

	@Override
	@PUT
	public void update(Product product) {
		try {
			bean.update(product);
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
