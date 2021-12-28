package com.bookingorder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookingorder.model.Booking;
import com.bookingorder.repository.BookingRepository;
import com.bookingorder.service.BookingService;



@RunWith(SpringRunner.class)
@SpringBootTest
class BookingOrderServiceApplicationTests {

	 @Autowired
	   private BookingService bookingService;
	   
	   @MockBean
	   private BookingRepository bookingRepository;
	   
		@Test
		public void getBookingTest() {
			when(bookingRepository.findAll()).thenReturn(Stream.of
					(new Booking("111","5","Banglore","Mysur"), new Booking("112","2","Bijapur","Banglore")).collect(Collectors.toList()));
			assertEquals(2,bookingService.getBooking().size());
		}
		@Test
		public void addBookingTest() {
			Booking booking =new Booking("111","5","Banglore","Mysur");
			when(bookingRepository.save( booking)).thenReturn(booking);
		    assertEquals( booking, bookingService.addBooking( booking));
			
			}

	
}
