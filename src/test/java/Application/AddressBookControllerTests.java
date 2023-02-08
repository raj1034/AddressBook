package Application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class AddressBookControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void createAddressBookTest() throws Exception{
        this.mockMvc.perform(post("/create-address-book"))
                .andExpect(status().isOk()).andExpect(content()
                .string(containsString("{\"listOfBuddies\":[]")));
    }

    @Test
    public void addBuddyTest() throws Exception{
        this.mockMvc.perform(post("/create-address-book"));
        this.mockMvc.perform(post("/add-buddy?addressBookID=1&buddyName=Raj&buddyNumber=613-987-6543"))
                .andExpect(status().isOk()).andExpect(content()
                        .string(containsString("{\"listOfBuddies\":[{\"id\":1,\"name\":\"Raj\",\"phoneNumber\":\"613-987-6543\"}]")));

    }

    @Test
    public void removeBuddyTest() throws Exception{
        this.mockMvc.perform(post("/remove-buddy?buddyID=1&addressBookID=1"))
                .andExpect(status().isOk()).andExpect(content()
                        .string(containsString("{\"listOfBuddies\":[]")));

    }
}
