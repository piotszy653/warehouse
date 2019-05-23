package warehouse;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Warehouse implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    int id;
    String name;
    String address;

    @OneToMany(mappedBy="warehouse",fetch=FetchType.LAZY)
     List<Product> products = new ArrayList();

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

    public List<Product> getProducts(){
        return products;
    }


    @Override
    public String toString(){
        return id+"Warehouse: "+name+", address: "+address;
    }
}
