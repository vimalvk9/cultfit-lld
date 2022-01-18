package com.company.response;

public class BookSessionRes {

    private boolean booked;
    private boolean success;
    private String message;
    private String error;


    public BookSessionRes(boolean success, String message, String error, boolean booked) {
        this.success = success;
        this.message = message;
        this.error = error;
        this.booked = booked;
    }

    @Override
    public String toString() {
        return "BookSessionRes{" +
                "booked=" + booked +
                ", success=" + success +
                ", message='" + message + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
