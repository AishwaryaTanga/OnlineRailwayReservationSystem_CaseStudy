package com.bookingorder.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.bookingorder.model.Booking;

public interface BookingRepository extends MongoRepository<Booking, String> {

}
