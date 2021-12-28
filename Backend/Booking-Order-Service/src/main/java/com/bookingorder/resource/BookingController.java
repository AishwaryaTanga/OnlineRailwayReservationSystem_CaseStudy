package com.bookingorder.resource;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.bookingorder.model.Booking;
import com.bookingorder.model.Train;
import com.bookingorder.service.BookingService;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private BookingService bookingService;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	
    //add booking
	@PostMapping("/add")
	public String addBooking(@RequestBody Booking booking) {
		bookingService.addBooking(booking);
	return "Booked ticket successfully with id :  " + booking.getId();
    }
	
	//get all booking
	@GetMapping("/findAll")
	public List<Booking> getBooking(){
		return bookingService.getBooking();
	}
	
	//get booking by id
	@GetMapping("findbyId/{id}")
	public Optional<Booking> getBookingbyId(@PathVariable String id){
		return bookingService.getBookingbyId(id);
	}
	
		
	//cancel booking
	 @DeleteMapping("/cancel/{id}")
	 public String cancelBooking (@PathVariable String id) {
		 bookingService.cancelBooking(id);
		return "Order deleted with id : "+id;
		}

	 
	@GetMapping("/alltrains")
	public List<Train> getAllTrains(){
        String baseurl ="http://localhost:8888/trains/findAllTrain";
	    Train[] train = restTemplate.getForObject(baseurl,Train[].class);
		return Arrays.asList(train);
		}
}


