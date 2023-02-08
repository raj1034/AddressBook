package Application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/view-address-book")
    public String displayAddressBook(@RequestParam("addressBookID") String addressBookID, Model model)
    {
        AddressBook addressBook = addressBookRepository.findById(Long.parseLong(addressBookID));
        Collection<BuddyInfo> buddies = addressBook.getListOfBuddies();
        model.addAttribute("buddies", buddies);
        return "a-book";
    }
}
