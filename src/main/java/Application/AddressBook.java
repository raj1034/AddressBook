package Application;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class AddressBook{

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Collection<BuddyInfo> listOfBuddies;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public AddressBook()
    {
        listOfBuddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy)
    {
        //String buddyData = buddy.toString();
        if(!listOfBuddies.contains(buddy))
        {
            listOfBuddies.add(buddy);

            //System.out.println(buddyData);
        }
    }

/*
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuddyInfo buddyInfo = (BuddyInfo) o;
        return id == buddyInfo.getId() &&
    }
*/


    public void removeBuddy(BuddyInfo buddy)
    {
        if(listOfBuddies.contains(buddy))
        {
            listOfBuddies.remove(buddy);
            //System.out.println("Buddy: " + buddy.getName() + " has been removed from the system.");
        }
        else
        {
            //System.out.println("Buddy: " + buddy.getName() + " is not in the system.");
        }
    }

    public void displayBuddyData()
    {
        if (listOfBuddies.size() > 0)
        {
            int buddyCounter = 1;
            for (BuddyInfo buddy : listOfBuddies)
            {
                //System.out.println("Buddy " + buddyCounter + ": name: " + buddy.getName() + ". Phone number: " + buddy.getPhoneNumber());
                buddyCounter++;
            }
        }
        else
        {
            //System.out.println("No buddies in system.");
        }
    }

    public int getSize()
    {
        return listOfBuddies.size();
    }

    public Collection<BuddyInfo> getListOfBuddies()
    {
        return this.listOfBuddies;
    }

    public void setListOfBuddies(ArrayList<BuddyInfo> listOfBuddies) {
        this.listOfBuddies = listOfBuddies;
    }

    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String toString()
    {
        String s =  String.format("Address Book[id=%d]",
                id);
        s += "\n";
        for (BuddyInfo b: listOfBuddies)
        {
            s += b.toString();
            s +="\n";
        }
        return s;
    }

}