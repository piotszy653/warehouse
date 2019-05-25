package warehouse.rest;

import warehouse.beans.ClientEJB;
import warehouse.domains.Client;
import warehouse.interfaces.ClientCRUD;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;

@Path("/client")
@Consumes({ "application/json" })
@Produces({ "application/json" })

//@Consumes({ "application/xml" })
//@Produces({ "application/xml" })

public class ClientREST implements ClientCRUD {

	@EJB
	ClientEJB bean;

	@Override
	@POST
	public void save(Client client) {
		bean.save(client);
		System.out.println("Client created. "+client.toString());
	}

	@Override
	@GET
	@Path("/{id}")
	public Client get(@PathParam("id") int id) {
		return bean.get(id);
	}

	@Override
	@GET
	public List<Client> get() {
		return bean.get();
	}

	@Override
	@GET
	@Path("/{filter}")
	public List<Client> getBy(@PathParam("filter") String filter) {
		return bean.getBy(filter);
	}

	@Override
	@PUT
	public void update(Client client) {
		try {
			bean.update(client);
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
