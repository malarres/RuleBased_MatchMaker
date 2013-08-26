package com.iti.cloud4all.nodejs.responses;

/**
 *
 * @author nkak
 */
import com.iti.cloud4all.nodejs.ResponseMessage;

/**
 * A simple informational response message
 */
public class Info extends ResponseMessage {
    private String message;

    public Info(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}