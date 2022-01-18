package com.company.dao;

import com.company.entity.CalendarSlot;


import java.util.HashMap;

public class CalendarSlotDAO {

    private HashMap<String, CalendarSlot> calendarSlotMap = new HashMap<>();

    public String getUniqueCalendarKey(String userId, Long dayStartTime) {
        return userId + ":" + dayStartTime.toString();
    }

    public CalendarSlot getCalendarSlotFromSlots(String userId, Long dayStartTime) {
        String key = getUniqueCalendarKey(userId, dayStartTime);
        return calendarSlotMap.getOrDefault(key, null);
    }

    public void addCalendarForStudent(String userId, Long dayStartTime) {
        String calendarKey = getUniqueCalendarKey(userId, dayStartTime);

        if (!calendarSlotMap.containsKey(calendarKey)) {

            CalendarSlot slot = new CalendarSlot(userId, dayStartTime);
            initAvailability(slot);

            calendarSlotMap.put(calendarKey, slot);
        }
    }

    public void bookCalendarForStudent(String userId, int startSlot, int endSlot, Long dayStartTime) {
        if (startSlot >= 0 && endSlot <= 23) {

            String calendarKey = getUniqueCalendarKey(userId, dayStartTime);

            if (!calendarSlotMap.containsKey(calendarKey)) {
                addCalendarForStudent(userId, dayStartTime);
            }

            CalendarSlot slot = calendarSlotMap.get(calendarKey);
            Boolean availability[] = slot.getAvailability();

            for (int i = startSlot; i < endSlot; i++) {
                availability[i] = Boolean.FALSE;
            }
        }
    }

    void initAvailability(CalendarSlot slot) {
        Boolean availability[] = slot.getAvailability();
        for(int i=0; i<24; i++) {
            availability[i] = Boolean.TRUE;
        }
    }
}
