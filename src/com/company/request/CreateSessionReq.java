package com.company.request;

import com.company.enums.SessionType;

public class CreateSessionReq {

    private String id;
    private String centreId;
    private Long dayStartTime;
    private int startingSlot;
    private int endingSlot;
    private int totalSeats;
    private SessionType sessionType;

    public CreateSessionReq(String id, String centreId, Long dayStartTime, int startingSlot, int endingSlot, int totalSeats, SessionType sessionType) {
        this.id = id;
        this.centreId = centreId;
        this.dayStartTime = dayStartTime;
        this.startingSlot = startingSlot;
        this.endingSlot = endingSlot;
        this.totalSeats = totalSeats;
        this.sessionType = sessionType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCentreId() {
        return centreId;
    }

    public void setCentreId(String centreId) {
        this.centreId = centreId;
    }

    public Long getDayStartTime() {
        return dayStartTime;
    }

    public void setDayStartTime(Long dayStartTime) {
        this.dayStartTime = dayStartTime;
    }

    public int getStartingSlot() {
        return startingSlot;
    }

    public void setStartingSlot(int startingSlot) {
        this.startingSlot = startingSlot;
    }

    public int getEndingSlot() {
        return endingSlot;
    }

    public void setEndingSlot(int endingSlot) {
        this.endingSlot = endingSlot;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }
}
