package com.iti.cloud4all.nodejs.requests;

/**
 *
 * @author nkak
 */

import com.iti.cloud4all.instantiation.InstantiationManager;
import com.iti.cloud4all.nodejs.RequestMessage;
import com.iti.cloud4all.nodejs.ResponseMessage;
import com.iti.cloud4all.nodejs.responses.Info;

public class UserProfile extends RequestMessage {

    private String fontSize;
    private String magnification;
    private String foregroundColor;
    private String backgroundColor;
    private String highContrast;
    private String magnifierFullScreen;
    
    
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
        
        
        InstantiationManager.getInstance().USER_fontSize = Integer.parseInt(fontSize);
        InstantiationManager.getInstance().USER_magnification = Double.parseDouble(magnification);
        InstantiationManager.getInstance().USER_foregroundColor = foregroundColor;
        InstantiationManager.getInstance().USER_backgroundColor = backgroundColor;
        InstantiationManager.getInstance().USER_highContrast = Boolean.parseBoolean(highContrast);
        InstantiationManager.getInstance().USER_magnifierFullScreen = Boolean.parseBoolean(magnifierFullScreen);
        
        ResponseMessage response = new Info("Answer from Java: User Model received!"
                + "\nfontSize: " + fontSize
                + "\nmagnification: " + magnification
                + "\nforegroundColor: " + foregroundColor
                + "\nbackgroundColor: " + backgroundColor
                + "\nhighContrast: " + highContrast
                + "\nmagnifierFullScreen: " + magnifierFullScreen
                );
        response.send();
    }
    
}