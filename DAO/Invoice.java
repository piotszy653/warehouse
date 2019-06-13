package warehouse.DAO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Invoice implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;

    @Column(nullable = false)
    Float totalCosts;

    @Column(nullable = false)
    String date;

    @ManyToOne(fetch=FetchType.EAGER)
    private Client client;




    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public Float getTotalCosts(){
        return totalCosts;
    }

    public void setTotalCosts(Float totalCosts){
        this.totalCosts=totalCosts;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date=date;
    }

    public Client getClient(){
        return client;
    }

    public void setClient(Client client){
        this.client=client;
    }



    @Override
    public String toString(){
        return id+". Invoice. Date: "+date+", client: "+client.getName()+", total costs: "+totalCosts;
    }

}
