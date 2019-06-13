package warehouse.interfaces;

import javax.ejb.Local;

import warehouse.DAO.Client;

import java.util.List;

@Local
public interface ClientCRUD {

    public abstract Client save(Client client);

    public abstract Client get(int id);

    public abstract List<Client> get();

    public abstract List<Client> getBy(String filter, String value);

    public abstract Client update(Client client);

    public abstract void delete(int id);

}