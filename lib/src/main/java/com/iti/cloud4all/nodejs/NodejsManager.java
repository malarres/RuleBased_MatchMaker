package com.iti.cloud4all.nodejs;

import com.iti.cloud4all.nodejs.requests.Goodbye;
import com.iti.cloud4all.nodejs.responses.Hello;
import java.io.IOException;

/**
 *
 * @author nkak
 */
public class NodejsManager 
{
    public static final String APP_VERSION = "0.1";
    
    private static NodejsManager instance = null;
    
    private NodejsManager()
    {
    }
    
    public static NodejsManager getInstance() 
    {
        if(instance == null) 
            instance = new NodejsManager();
        return instance;
    }
    
    public void run() throws IOException 
    {
        // When started, we automatically send out a Hello message
        (new Hello()).send();

        // Now pump messages until we receive a Goodbye
        RequestMessage message;
        while ((message = RequestMessage.fetchRequest()) != null) 
        {
            if (message instanceof Goodbye)
                return;
            
            message.process();
        }
    }
}
