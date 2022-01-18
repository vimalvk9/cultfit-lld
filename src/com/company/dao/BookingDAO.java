package com.company.dao;

import com.company.entity.Booking;
import com.company.entity.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class BookingDAO {

    private HashMap<String, List<Booking>> userBookingsMap = new HashMap<>();

    public void addBookingForUser(String email, Booking booking) {
        if (Objects.nonNull(booking)) {
            List<Booking> bookings = userBookingsMap.get(email);
            if (bookings == null) {
                bookings = new ArrayList<>();
            }
            bookings.add(booking);
            userBookingsMap.put(email, bookings);
        }
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        for(List<Booking> list: userBookingsMap.values()) {
            bookings.addAll(list);
        }
        return bookings;
    }
}
