package Application;

import Application.AddressBook;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long>{

    AddressBook findById(long id);

}
