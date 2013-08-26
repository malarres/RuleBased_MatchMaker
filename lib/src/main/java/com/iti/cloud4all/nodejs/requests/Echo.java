package com.iti.cloud4all.nodejs.requests;

/**
 *
 * @author nkak
 */
import com.iti.cloud4all.nodejs.RequestMessage;
import com.iti.cloud4all.nodejs.responses.Info;

public class Echo extends RequestMessage {

    private String message;
    
    @Override
    public void process() {
        (new Info(message)).send();
    }
    
}