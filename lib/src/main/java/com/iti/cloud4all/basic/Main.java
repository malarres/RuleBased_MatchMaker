package com.iti.cloud4all.basic;

import java.io.IOException;
import com.iti.cloud4all.nodejs.NodejsManager;

//import javax.ws.rs.core.MediaType;
// import com.sun.jersey.api.client.Client;
// import com.sun.jersey.api.client.ClientResponse;
// import com.sun.jersey.api.client.WebResource;

public class Main 
{
    public static void main(String[] args) throws IOException 
    {
        //Communication with Node.js
        NodejsManager.getInstance().run();
    }
}
