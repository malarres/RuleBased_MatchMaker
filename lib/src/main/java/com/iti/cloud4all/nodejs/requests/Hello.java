package com.iti.cloud4all.nodejs.requests;

/**
 *
 * @author nkak
 */
import com.iti.cloud4all.nodejs.NodejsManager;
import com.iti.cloud4all.nodejs.RequestMessage;
import com.iti.cloud4all.nodejs.ResponseMessage;
import com.iti.cloud4all.nodejs.responses.Error;
import com.iti.cloud4all.nodejs.responses.Info;

/**
 * A friendly hello from the client. We'll either reject with an error message
 * or accept with an Info message response.
 */
public class Hello extends RequestMessage {

    private String version;
    
    @Override
    public void process() {
        ResponseMessage response;
        if(!NodejsManager.APP_VERSION.equals(version)) {
            response = new Error(new Exception("Client does not match expected version " + NodejsManager.APP_VERSION));
        } else {
            response = new Info("Ready to receive requests.");
        }
        
        response.send();
    }
    
}