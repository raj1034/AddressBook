package Application;
import Application.AddressBook;
import jakarta.persistence.*;

@Entity
public class BuddyInfo{

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String phoneNumber;

    public BuddyInfo(String name, String phoneNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public BuddyInfo() {

    }

    public String getName() {
        return name;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString()
    {
        return String.format("Buddy[id=%d, name='%s', phone number='%s']",
                id, name, phoneNumber);
    }
}