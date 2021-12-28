package com.bookingorder.service;

import java.util.List;
import java.util.Optional;

import com.bookingorder.model.Booking;

public interface BookingService {

	abstract Booking addBooking(Booking booking);

	abstract List<Booking> getBooking();

	abstract Optional<Booking> getBookingbyId(String id);

	abstract void cancelBooking(String id);

}