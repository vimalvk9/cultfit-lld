package com.company.managers;

import com.company.dao.CalendarSlotDAO;
import com.company.entity.CalendarSlot;

import java.util.Objects;

public class CalendarSlotManager {

    private final CalendarSlotDAO calendarSlotDAO;

    public CalendarSlotManager(CalendarSlotDAO calendarSlotDAO) {
        this.calendarSlotDAO = calendarSlotDAO;
    }

    public boolean slotAvailableForStudent(String userId, Long dayStartTime, int startingSlot, int endingSlot) {
        CalendarSlot slot = calendarSlotDAO.getCalendarSlotFromSlots(userId, dayStartTime);

        if (Objects.nonNull(slot)) {

            boolean available = true;

            for(int i=startingSlot; i<=endingSlot; i++) {
                if (slot.getAvailability()[i] == Boolean.FALSE) {
                    available = false;
                    break;
                }
            }

            return available;
        }
        else {
            calendarSlotDAO.addCalendarForStudent(userId, dayStartTime);
        }

        return true;
    }
}
