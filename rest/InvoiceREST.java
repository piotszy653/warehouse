package warehouse.rest;


import warehouse.DAO.Invoice;
import warehouse.beans.InvoiceEJB;
import warehouse.interfaces.InvoiceCRUD;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;

@Path("/invoice")
@Consumes({ "application/json" })
@Produces({ "application/json" })

//@Consumes({ "application/xml" })
//@Produces({ "application/xml" })

public class InvoiceREST implements InvoiceCRUD {

	@EJB
	InvoiceEJB bean;

	@Override
	@POST
	public Invoice save(Invoice invoice) {
		bean.save(invoice);
		System.out.println("Invoice created. "+invoice.toString());
		return invoice;
	}

	@Override
	@GET
	@Path("/{id}")
	public Invoice get(@PathParam("id") int id) {
		return bean.get(id);
	}

	@Override
	@GET
	public List<Invoice> get() {
		return bean.get();
	}

	@Override
	@GET
	@Path("/{filter}/{value}")
	public List<Invoice> getBy(@PathParam("filter") String filter, @PathParam("value") String value) {
		return bean.getBy(filter, value);
	}

	@Override
	@PUT
	public Invoice update(Invoice invoice) {
		try {
			bean.update(invoice);
			return invoice;
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
