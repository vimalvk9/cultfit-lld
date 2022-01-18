package com.company;

import com.company.dao.BookingDAO;
import com.company.dao.CalendarSlotDAO;
import com.company.dao.SessionDAO;
import com.company.dao.UserDAO;
import com.company.enums.SessionType;
import com.company.managers.BookingManager;
import com.company.managers.CalendarSlotManager;
import com.company.managers.SessionManager;
import com.company.managers.UserManager;
import com.company.request.BookSessionReq;
import com.company.request.CreateSessionReq;

public class Main {

    public static void main(String[] args) throws Exception {

        UserDAO userDAO = new UserDAO();
        BookingDAO bookingDAO = new BookingDAO();
        SessionDAO sessionDAO = new SessionDAO();
        CalendarSlotDAO calendarSlotDAO = new CalendarSlotDAO();

        CalendarSlotManager calendarSlotManager = new CalendarSlotManager(calendarSlotDAO);
        SessionManager sessionManager = new SessionManager(sessionDAO);
        BookingManager bookingManager = new BookingManager(bookingDAO);
        UserManager userManager = new UserManager(userDAO, calendarSlotManager, sessionManager, bookingManager);


        // 1. register users
        userManager.register("u1", "vimal");
        userManager.register("u2", "sourabh");
        System.out.println(userManager.getAllUsers());

        // 2. invalid users
        System.out.println(userManager.getUserById("u3"));

        // 3. create session
        Long time = System.currentTimeMillis();
        CreateSessionReq createSessionReq = new CreateSessionReq("s1", "c1", time, 0, 0, 2, SessionType.SELF_HELP);
        sessionManager.createSession(createSessionReq);
        System.out.println(sessionManager.getAllSessions());

        // 4. book session
        BookSessionReq bookSessionReq = new BookSessionReq("u1", "c1", "s1", time, 0, 0);
        System.out.println(userManager.bookSession(bookSessionReq));

        BookSessionReq bookSessionReq2 = new BookSessionReq("u2", "c1", "s1", time, 0, 0);
        System.out.println(userManager.bookSession(bookSessionReq2));

        // 5. list all sessions
        System.out.println(sessionManager.getAllSessions());

        // 6. list all bookings
        System.out.println(bookingManager.getAllBookings());

    }
}
