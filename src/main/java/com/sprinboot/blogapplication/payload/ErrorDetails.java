package com.sprinboot.blogapplication.payload;

import java.util.Date;

public class ErrorDetails {
    private Date timeStamp;
    private String status;
    private String details;

    public ErrorDetails(){

    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public ErrorDetails(Date timeStamp, String status, String details) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.details = details;
    }
}
