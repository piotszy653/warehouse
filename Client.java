package warehouse;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    int id;

    @Column(nullable = false)
    private String name;

    private String mail = null;


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


    @Override
    public String toString(){
       String str = id+"name of Client: "+name;

       if(mail!=null) str += (", mail: " + mail);

       return str;
    }
}
