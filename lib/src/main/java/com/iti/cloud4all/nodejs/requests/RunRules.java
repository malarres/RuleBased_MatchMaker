package com.iti.cloud4all.nodejs.requests;

/**
 *
 * @author nkak
 */

import com.iti.cloud4all.inference.RulesManager;
import com.iti.cloud4all.instantiation.InstantiationManager;
import com.iti.cloud4all.nodejs.RequestMessage;
import com.iti.cloud4all.nodejs.ResponseMessage;
import com.iti.cloud4all.nodejs.responses.Info;
import com.iti.cloud4all.ontology.OntologyManager;

public class RunRules extends RequestMessage 
{
    private String lastMessage;
    
    @Override
    public void process() 
    {
        OntologyManager.getInstance().fillSolutionsArrayList();
        
        InstantiationManager.getInstance().createInstanceInOntologyForJSONUserPreferencesSet();
        InstantiationManager.getInstance().createInstanceInOntologyForJSONEnvironment();
                
        String finalUserPrefs = RulesManager.getInstance().executeMyCloudRulesForFindingHandicapSituations(true);
        
        ResponseMessage response = new Info(finalUserPrefs);
        response.send();
    }
    
}