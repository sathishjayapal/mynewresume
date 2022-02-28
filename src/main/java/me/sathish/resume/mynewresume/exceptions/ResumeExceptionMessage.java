package me.sathish.resume.mynewresume.exceptions;

import java.util.Date;

public class ResumeExceptionMessage {
    private Date timeStamp;
    private String message;
    private String details;

    public ResumeExceptionMessage(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
