package com.company.managers;

import com.company.dao.BookingDAO;
import com.company.entity.Booking;

import java.util.List;

public class BookingManager {

    private final BookingDAO bookingDAO;

    public BookingManager(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public void createBookingForUser(String email, String sessionId, String centreId) {
        if (!email.isEmpty() && !sessionId.isEmpty() && !centreId.isEmpty()) {
            Booking booking = new Booking(email, sessionId, centreId);
            bookingDAO.addBookingForUser(email, booking);
        }
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }


}
