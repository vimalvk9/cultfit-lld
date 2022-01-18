package com.company.entity;

public class Booking {

    private String userId;
    private String sessionId;
    private String centreId;

    public Booking(String userId, String sessionId, String centreId) {
        this.userId = userId;
        this.sessionId = sessionId;
        this.centreId = centreId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userId='" + userId + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", centreId='" + centreId + '\'' +
                '}';
    }
}
