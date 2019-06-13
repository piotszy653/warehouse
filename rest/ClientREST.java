package warehouse.rest;

import warehouse.DAO.Client;
import warehouse.beans.ClientEJB;
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
	public Client save(Client client) {
		bean.save(client);
		System.out.println("Client created. "+client.toString());
		return client;
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
	@Path("/{filter}/{value}")
	public List<Client> getBy(@PathParam("filter") String filter, @PathParam("value") String value) {
		return bean.getBy(filter, value);
	}

	@Override
	@PUT
	public Client update(Client client) {
		try {
			bean.update(client);
			return client;
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
