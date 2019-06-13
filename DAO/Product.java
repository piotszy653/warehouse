package warehouse.DAO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;

    @Column(nullable = false)
    private String name;

    private String description;

    private String manufacturer;

    @Column(nullable = false)
    private Boolean sold = false;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(fetch=FetchType.EAGER)
    private Warehouse warehouse;

    @ManyToOne(fetch=FetchType.EAGER)
    private Invoice invoice = null;



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

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public void setManufacturer(String manufacturer){
        this.manufacturer=manufacturer;
    }

    public Boolean getSold(){
        return sold;
    }

    public void setSold(Boolean sold){
        this.sold=sold;
    }

    public Float getPrice(){
        return price;
    }

    public void setPrice(Float price){
        this.price=price;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity=quantity;
    }

    public Warehouse getWarehouse(){
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse){
        this.warehouse=warehouse;
    }

    public Invoice getInvoice(){
        return invoice;
    }

    public void setInvoice(Invoice invoice){
        this.invoice=invoice;
    }

    @Override
    public String toString(){
        return id+". Product: "+name+", price: "+price+", quantity: "+quantity;
    }



}
