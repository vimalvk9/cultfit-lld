package com.company.entity;

import com.company.enums.SessionState;
import com.company.enums.SessionType;

public class Session {

    private String id;
    private String centreId;
    private Long dayStartTime;
    private int startingSlot;
    private int endingSlot;
    private int totalSeats;
    private int seatsVacant;
    private SessionState sessionState;
    private SessionType sessionType;

    public Session(String id, String centreId, Long dayStartTime, int startingSlot,
                   int endingSlot, int totalSeats, SessionType sessionType) {
        this.id = id;
        this.centreId = centreId;
        this.dayStartTime  = dayStartTime;
        this.startingSlot = startingSlot;
        this.endingSlot = endingSlot;
        this.totalSeats = totalSeats;
        this.seatsVacant = totalSeats;
        this.sessionState = SessionState.SCHEDULED;
        this.sessionType = sessionType;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getSeatsVacant() {
        return seatsVacant;
    }

    public void setSeatsVacant(int seatsVacant) {
        this.seatsVacant = seatsVacant;
    }

    public SessionState getSessionState() {
        return sessionState;
    }

    public void setSessionState(SessionState sessionState) {
        this.sessionState = sessionState;
    }

    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
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

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", centreId='" + centreId + '\'' +
                ", dayStartTime=" + dayStartTime +
                ", startingSlot=" + startingSlot +
                ", endingSlot=" + endingSlot +
                ", totalSeats=" + totalSeats +
                ", seatsVacant=" + seatsVacant +
                ", sessionState=" + sessionState +
                ", sessionType=" + sessionType +
                '}';
    }
}
