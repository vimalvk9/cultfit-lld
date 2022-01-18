package com.company.managers;

import com.company.dao.UserDAO;
import com.company.entity.User;
import com.company.request.BookSessionReq;
import com.company.response.BookSessionRes;

import java.util.List;
import java.util.Objects;

public class UserManager {

    private final UserDAO userDAO;
    private final CalendarSlotManager calendarSlotManager;
    private final SessionManager sessionManager;
    private final BookingManager bookingManager;

    public UserManager(UserDAO userDAO, CalendarSlotManager calendarSlotManager,
                       SessionManager sessionManager, BookingManager bookingManager) {
        this.userDAO = userDAO;
        this.calendarSlotManager = calendarSlotManager;
        this.sessionManager = sessionManager;
        this.bookingManager = bookingManager;
    }

    public void register(String email, String name) {
        if (!email.isEmpty() && !name.isEmpty()) {
            User user = new User(email, name);
            userDAO.addUser(user);
        }
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(String email) throws Exception {
        User user = userDAO.getUser(email);
        if (Objects.isNull(user)) {
            throw new Exception("invalid user");
        }

        return user;
    }

    public BookSessionRes bookSession(BookSessionReq bookSessionReq) throws Exception {

        // check valid user
        if (userDAO.isValidUser(bookSessionReq.getEmail())) {

            // TODO check valid session

            // check calendar
            boolean calendarFree  = calendarSlotManager.slotAvailableForStudent(bookSessionReq.getEmail(),
                    bookSessionReq.getDayStartTime(),
                    bookSessionReq.getStartingSlot(),
                    bookSessionReq.getEndingSlot());

            if (!calendarFree) {
                return new BookSessionRes(false, "","Calendar not free for student", false);
            }

            // check session seats
            boolean seatsAvailable = sessionManager.seatsRemainingForSession(bookSessionReq.getSessionId());

            if (!seatsAvailable) {
                return new BookSessionRes(false, "","Seats not available for session requested", false);
            }

            // decrement seats
            boolean sessionBooked = sessionManager.decrementSeatsVacantForSession(bookSessionReq.getSessionId());
            if (!sessionBooked) {
                throw new Exception("Error happened while booking session");
            }

            // store booking
            bookingManager.createBookingForUser(bookSessionReq.getEmail(), bookSessionReq.getEmail(), bookSessionReq.getEmail());
            return new BookSessionRes(true, "Session booked successfully", "", true);
        }

        return new BookSessionRes(false, "","Invalid user", false);
    }

}
