package Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookRestController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    private BuddyRepository buddyRepository;

    @PostMapping("/create-address-book")
    public AddressBook addBook()
    {
        AddressBook addressbook = new AddressBook();
        addressBookRepository.save(addressbook);
        return addressbook;

    }

    @PostMapping("/add-buddy")
    public AddressBook addBuddy(@RequestParam("addressBookID") String addressBookID,
                                @RequestParam("buddyName") String buddyName,
                                @RequestParam("buddyNumber") String  buddyNumber)
    {
        AddressBook addressBook = addressBookRepository.findById(Long.parseLong(addressBookID));
        BuddyInfo buddyInfo = new BuddyInfo(buddyName, buddyNumber);
        System.out.println(addressBook.getListOfBuddies());
        addressBook.addBuddy(buddyInfo);
        buddyRepository.save(buddyInfo);
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    @PostMapping("/remove-buddy")
    public AddressBook removeBuddy(@RequestParam("buddyID") String buddyID,
                                   @RequestParam("addressBookID") String addressBookID)
    {
        AddressBook addressBook = addressBookRepository.findById(Long.parseLong(addressBookID));
        BuddyInfo buddyInfo = buddyRepository.findById(Long.parseLong(buddyID));
        addressBook.removeBuddy(buddyInfo);
        buddyRepository.delete(buddyInfo);
        addressBookRepository.save(addressBook);
        buddyRepository.save(buddyInfo);
        return addressBook;
    }


}
