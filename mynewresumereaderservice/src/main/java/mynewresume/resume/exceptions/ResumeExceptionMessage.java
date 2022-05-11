package mynewresume.resume.exceptions;

import java.util.Date;

public class ResumeExceptionMessage {
    private final Date timeStamp;
    private final String message;
    private final String details;

    public ResumeExceptionMessage(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }
}
