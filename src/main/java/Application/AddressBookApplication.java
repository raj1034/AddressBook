package Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;

@SpringBootApplication
public class AddressBookApplication {

	private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class);
	}
/*
	@Bean
	public CommandLineRunner demoBuddy(BuddyRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new BuddyInfo("Jack", "613-123-4567"));
			repository.save(new BuddyInfo("Chloe", "613-456-8765"));
			repository.save(new BuddyInfo("Kim", "613-987-6543"));
			// fetch all customers
			log.info("Buddies found with findAll():");
			log.info("-------------------------------");
			for (BuddyInfo buddy : repository.findAll()) {
				log.info(buddy.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			BuddyInfo buddy = repository.findById(1L);
			log.info("Buddy found with findById(1L):");
			log.info("--------------------------------");
			log.info(buddy.toString());
			log.info("");
			log.info("");

			// fetch buddies by last name
			log.info("Buddy found with findByName('Jack'):");
			log.info("--------------------------------------------");
			repository.findByName("Jack").forEach(jack -> {
				log.info(jack.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}

	@Bean
	public CommandLineRunner demoAddress(AddressBookRepository repository) {
		return (args) -> {
			// save a few AddressBooks
			AddressBook book1 = new AddressBook();
			book1.addBuddy(new BuddyInfo("Jack", "613-123-4567"));
			book1.addBuddy(new BuddyInfo("Chloe", "613-456-8765"));
			repository.save(book1);

			AddressBook book2 = new AddressBook();
			book2.addBuddy(new BuddyInfo("Kim", "613-987-6543"));
			repository.save(book2);

			//Fetch an Individual AddressBook by ID

			AddressBook addressBook = repository.findById(1L);
			log.info("Addressbook with id 1L:");
			log.info("------------------------------------");
			log.info(addressBook.toString());
			log.info("");


		};
	}*/
}