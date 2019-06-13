package warehouse.DAO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Warehouse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy="warehouse",fetch=FetchType.LAZY)
     private List<Product> products;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }
    
    public void setProducts(List<Product> products){
    	this.products=products;
    }

    public List<Product> getProducts(){
        return products;
    }


    @Override
    public String toString(){
        return id+". Warehouse: "+name+", address: "+address;
    }
}
