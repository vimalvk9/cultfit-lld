package com.company.entity;


public class CalendarSlot {

    private String userId;
    private Long dayStartTime;
    private Boolean[] availability;


    public CalendarSlot(String userId, Long dayStartTime) {
        this.userId = userId;
        this.dayStartTime = dayStartTime;
        this.availability = new Boolean[24];
    }


    public Long getDayStartTime() {
        return dayStartTime;
    }

    public void setDayStartTime(Long dayStartTime) {
        this.dayStartTime = dayStartTime;
    }

    public Boolean[] getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean[] availability) {
        this.availability = availability;
    }
}
