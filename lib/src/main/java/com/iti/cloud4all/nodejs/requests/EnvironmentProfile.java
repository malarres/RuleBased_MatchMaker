package com.iti.cloud4all.nodejs.requests;

/**
 *
 * @author nkak
 */

import com.iti.cloud4all.instantiation.InstantiationManager;
import com.iti.cloud4all.nodejs.RequestMessage;
import com.iti.cloud4all.nodejs.ResponseMessage;
import com.iti.cloud4all.nodejs.responses.Info;

public class EnvironmentProfile extends RequestMessage {

    String os_id;
    String os_version;
    
    
    @Override
    public void process() 
    {
        if(os_id == null)
            os_id = "null";
        if(os_version == null)
            os_version = "null";
        
        InstantiationManager.getInstance().DEVICE_REPORTER_OS_id = os_id;
        if(os_version.startsWith("6.1"))
            os_version = "6.1";
        InstantiationManager.getInstance().DEVICE_REPORTER_OS_version = os_version;
        
        ResponseMessage response = new Info("Answer from Java: Device Reporter payload received!"
                + "\nos_id: " + os_id
                + "\nos_version: " + os_version
                );
        response.send();
    }
    
}