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

public class UserProfile extends RequestMessage {

    private String fontSize;
    private String magnification;
    private String foregroundColor;
    private String backgroundColor;
    private String highContrast;
    private String magnifierFullScreen;
    private String specificPreferencesForSolutions_IDs;
    
    
    @Override
    public void process() 
    {
        if(fontSize == null)
            fontSize = "null";
        if(magnification == null)
            magnification = "null";
        if(foregroundColor == null)
            foregroundColor = "null";
        if(backgroundColor == null)
            backgroundColor = "null";
        if(highContrast == null)
            highContrast = "null";
        if(magnifierFullScreen == null)
            magnifierFullScreen = "null";
        if(specificPreferencesForSolutions_IDs == null)
            specificPreferencesForSolutions_IDs = "null";
        
        InstantiationManager.getInstance(); //initialization
        OntologyManager.getInstance();      //initialization        
        
        InstantiationManager.getInstance().USER_fontSize = Integer.parseInt(fontSize);
        InstantiationManager.getInstance().USER_magnification = Double.parseDouble(magnification);
        InstantiationManager.getInstance().USER_foregroundColor = foregroundColor;
        InstantiationManager.getInstance().USER_backgroundColor = backgroundColor;
        InstantiationManager.getInstance().USER_highContrast = Boolean.parseBoolean(highContrast);
        InstantiationManager.getInstance().USER_magnifierFullScreen = Boolean.parseBoolean(magnifierFullScreen);
        InstantiationManager.getInstance().USER_SpecificPreferencesForSolutions_IDs = specificPreferencesForSolutions_IDs;
        
        ResponseMessage response = new Info("Answer from Java: User Model received!"
                + "\nfontSize: " + fontSize
                + "\nmagnification: " + magnification
                + "\nforegroundColor: " + foregroundColor
                + "\nbackgroundColor: " + backgroundColor
                + "\nhighContrast: " + highContrast
                + "\nmagnifierFullScreen: " + magnifierFullScreen
                + "\nspecificPreferencesForSolutions_IDs: " + specificPreferencesForSolutions_IDs
                );
        response.send();
    }
    
}