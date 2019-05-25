package warehouse.interfaces;

import warehouse.domains.Client;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ClientCRUD {

    public abstract void save(Client client);

    public abstract Client get(int id);

    public abstract List<Client> get();

    public abstract List<Client> getBy(String filter);

    public abstract void update(Client client);

    public abstract void delete(int id);

}