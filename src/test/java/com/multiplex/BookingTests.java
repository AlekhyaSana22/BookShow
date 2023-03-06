package com.multiplex;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import com.multiplex.entities.Booking;
import com.multiplex.entities.Show;
import com.multiplex.entities.User;

public class BookingTests {
	
	private Booking booking1;
	private Booking booking2;
	private User user;
	private Show show;
	
	@Before
	public void setUp() {
		user = new User();
		show = new Show();
		booking1 = new Booking(1, user, show, LocalDate.now(), LocalTime.now());
		booking2 = new Booking(2, user, show, LocalDate.now(), LocalTime.now());
	}
	
	@Test
	public void testConstructorAndGetters() {
		assertEquals(1, booking1.getBookingId().intValue());
		assertEquals(user, booking1.getUser());
		assertEquals(show, booking1.getShow());
		assertNotNull(booking1.getDate());
		assertNotNull(booking1.getTime());
	}
	
	@Test
	public void testEqualsAndHashCode() {
		Booking booking1Copy = new Booking(1, user, show, LocalDate.now(), LocalTime.now());
		
		assertEquals(booking1, booking1Copy);
		assertEquals(booking1.hashCode(), booking1Copy.hashCode());
		assertNotEquals(booking1, booking2);
		assertNotEquals(booking1.hashCode(), booking2.hashCode());
	}
	
	@Test
	public void testToString() {
		String expectedString = "Booking [bookingId=1, user=" + user.toString() + ", show=" + show.toString() 
			+ ", date=" + LocalDate.now().toString() + ", time=" + LocalTime.now().toString() + "]";
	}
}
