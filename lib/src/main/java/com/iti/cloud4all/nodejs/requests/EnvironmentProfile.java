package com.iti.cloud4all.nodejs.requests;

/**
 *
 * @author nkak
 */

import com.iti.cloud4all.instantiation.InstantiationManager;
import com.iti.cloud4all.nodejs.RequestMessage;
import com.iti.cloud4all.nodejs.ResponseMessage;
import com.iti.cloud4all.nodejs.responses.Info;
import com.iti.cloud4all.ontology.OntologyManager;

public class EnvironmentProfile extends RequestMessage {

    String os_id;
    String os_version;
    String installed_solutions_ids;
    String available_solutions_ids;
    
    
    @Override
    public void process() 
    {
        if(os_id == null)
            os_id = "null";
        if(os_version == null)
            os_version = "null";
        if(installed_solutions_ids == null)
            installed_solutions_ids = "null";
        if(available_solutions_ids == null)
            available_solutions_ids = "null";
        
        InstantiationManager.getInstance().DEVICE_REPORTER_OS_id = os_id;
        if(os_version.startsWith("6.1"))
            os_version = "6.1";
        InstantiationManager.getInstance().DEVICE_REPORTER_OS_version = os_version;
        InstantiationManager.getInstance().DEVICE_REPORTER_INSTALLEDSOLUTIONS_IDs = installed_solutions_ids;
        InstantiationManager.getInstance().DEVICE_REPORTER_AVAILABLESOLUTIONS_IDs = available_solutions_ids;
        
        ResponseMessage response = new Info("Answer from Java: Device Reporter payload received!"
                + "\nos_id: " + os_id
                + "\nos_version: " + os_version
                + "\ninstalled_solutions_ids: " + installed_solutions_ids
                + "\navailable_solutions_ids: " + available_solutions_ids
                );
        response.send();
    }
    
}