package warehouse;

import javax.ejb.Local;
import java.util.Set;

@Local
public interface ClientCRUD {

    public abstract void save(Client client);

    public abstract Client get(int id);

    public abstract Set<Client> get();

    public abstract void update(Client client);

    public abstract void delete(int id);

}