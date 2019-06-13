package warehouse.rest;


import warehouse.DAO.Product;
import warehouse.beans.ProductEJB;
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
	public Product save(Product product) {
		bean.save(product);
		System.out.println("Product created. "+product.toString());
		return product;
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
	@Path("/{filter}/{value}")
	public List<Product> getBy(@PathParam("filter") String filter, @PathParam("value") String value) {
		return bean.getBy(filter, value);
	}

	@Override
	@PUT
	public Product update(Product product) {
		try {
			bean.update(product);
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		bean.delete(id);
	}


}
