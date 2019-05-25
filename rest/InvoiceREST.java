package warehouse.rest;


import warehouse.beans.InvoiceEJB;
import warehouse.domains.Invoice;
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
	public void save(Invoice invoice) {
		bean.save(invoice);
		System.out.println("Invoice created. "+invoice.toString());
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
	@Path("/{filter}")
	public List<Invoice> getBy(@PathParam("filter") String filter) {
		return bean.getBy(filter);
	}

	@Override
	@PUT
	public void update(Invoice invoice) {
		try {
			bean.update(invoice);
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
