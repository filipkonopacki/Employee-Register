import java.io.Serializable;
import java.math.BigDecimal;

public class Employee implements Serializable {

    private String pesel;
    private String name;
    private String surname;
    private String position;
    private BigDecimal payment;
    private String phoneNumber;


    public void setPesel(String pesel){
        this.pesel = pesel;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setPayment(BigDecimal payment){
        this.payment = payment;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }


    public String getPesel(){
        return pesel;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getPosition(){
        return position;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }




}
