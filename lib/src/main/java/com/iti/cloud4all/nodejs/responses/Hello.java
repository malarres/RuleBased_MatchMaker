package com.iti.cloud4all.nodejs.responses;

/**
 *
 * @author nkak
 */
import com.iti.cloud4all.nodejs.NodejsManager;
import com.iti.cloud4all.nodejs.ResponseMessage;

/**
 * This message is sent out as soon as the java app is started. It informs the
 * client of the version and helps the client verify that it is indeed
 * talking to the expected host.
 */
public class Hello extends ResponseMessage
{
    private String appName = NodejsManager.class.getSimpleName();
    private String version = NodejsManager.APP_VERSION;
}