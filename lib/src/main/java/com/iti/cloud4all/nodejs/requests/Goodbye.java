package com.iti.cloud4all.nodejs.requests;

/**
 *
 * @author nkak
 */
import com.iti.cloud4all.nodejs.RequestMessage;

/**
 * Tells the java program that it is done and can end.
 */
public class Goodbye extends RequestMessage {
    
    @Override
    public void process() {
    }

}