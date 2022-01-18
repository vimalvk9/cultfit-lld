package com.company.request;

public class BookSessionReq {

    private String email;
    private String centreId;
    private String sessionId;
    private Long dayStartTime;
    private int startingSlot;
    private int endingSlot;

    public BookSessionReq(String email, String centreId, String sessionId, Long dayStartTime, int startingSlot, int endingSlot) {
        this.email = email;
        this.centreId = centreId;
        this.sessionId = sessionId;
        this.dayStartTime = dayStartTime;
        this.startingSlot = startingSlot;
        this.endingSlot = endingSlot;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCentreId() {
        return centreId;
    }

    public void setCentreId(String centreId) {
        this.centreId = centreId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
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


}
