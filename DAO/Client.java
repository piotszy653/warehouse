package warehouse.DAO;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement
public class Client implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;

    @Column(nullable = false)
    private String name;

    private String mail = null;

    @OneToMany(mappedBy="client",fetch=FetchType.LAZY)
    private List<Invoice> invoices;


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

    public String getMail(){
        return mail;
    }

    public void setMail(String mail){
        this.mail=mail;
    }

    public List<Invoice> getInvoices(){
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices){
        this.invoices=invoices;
    }

    @Override
    public String toString(){
       String str = id+"name of Client: "+name;

       if(mail!=null) str += (", mail: " + mail);

       return str;
    }
}
