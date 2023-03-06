package com.multiplex;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.multiplex.entities.User;

public class UserTests extends MultiplexProjectApplicationTests {
	private User user1;
    private User user2;

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
    @Before
    public void setUp() {
        user1 = new User(1, "Alekhya", "7981018537", "ale123@gmail.com", "Ale@123");
        user2 = new User(2, "Anusha", "8328261057", "anu234@gmail.com", "Anu@456");
    }
    
    @Test
    public void testGetUserName() {
        assertEquals("Alekhya", user1.getUserName());
        assertEquals("Anusha", user2.getUserName());
    }
    
    @Test
    public void testGetPhoneNumber() {
        assertEquals("7981018537", user1.getPhoneNumber());
        assertEquals("8328261057", user2.getPhoneNumber());
    }
    
    @Test
    public void testGetEmailId() {
        assertEquals("ale123@gmail.com", user1.getEmailId());
        assertEquals("anu234@gmail.com", user2.getEmailId());
    }
    
    @Test
    public void testGetPassword() {
        assertEquals("Ale@123", user1.getPassword());
        assertEquals("Anu@456", user2.getPassword());
    }
    
    @Test
    public void testEquals() {
        User user3 = new User(1, "Alekhya", "7981018537", "ale123@gmail.com", "Ale@123");
        assertEquals(user1, user3);
        assertNotEquals(user1, user2);
    }
    
    @Test
    public void testHashCode() {
        User user3 = new User(1, "Alekhya", "7981018537", "ale123@gmail.com", "Ale@123");
        assertEquals(user1.hashCode(), user3.hashCode());
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }
    
    @Test
    public void testToString() {
        String expected1 = "User [userId=1, userName=Alekhya, phoneNumber=7981018537, emailId=ale123@gmail.com, password=Ale@123]";
        String expected2 = "User [userId=2, userName=Anusha, phoneNumber=8328261057, emailId=anu234@gmail.com, password=Anu@456]";
        assertEquals(expected1, user1.toString());
        assertEquals(expected2, user2.toString());
    }
    
}
	

//	@Test
//	public void testGetUserById() throws Exception {
//		mockMvc.perform(get("/usertable")).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(jsonPath("$.userName").value("Anusha")).andExpect(jsonPath("$.phoneNumber").value("8328261057"))
//				.andExpect(jsonPath("$.emailId").value("anu123@gmail.com")).andExpect(jsonPath("$.password").value("Anu@1234"));
//
//	}
