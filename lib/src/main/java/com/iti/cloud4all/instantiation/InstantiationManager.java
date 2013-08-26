package com.iti.cloud4all.instantiation;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Statement;
import com.iti.cloud4all.ontology.OntologyManager;

/**
 *
 * @author nkak
 */
public class InstantiationManager 
{
    //Node.js
    public Integer USER_fontSize;
    public Double USER_magnification;
    public String USER_foregroundColor;
    public String USER_backgroundColor;
    public boolean USER_highContrast;
    public boolean USER_magnifierFullScreen;
    
    public String DEVICE_REPORTER_OS_id;
    public String DEVICE_REPORTER_OS_version;
    //-Node.js
    
    String SOURCE = "http://www.cloud4all.eu/SemanticFrameworkForContentAndSolutions.owl";
    String NS = SOURCE + "#";
    
    public String sammyFilepath;
    public String environmentProfileFilepath;
    
    private static InstantiationManager instance = null;
    
    private InstantiationManager() 
    {
        USER_fontSize = -1;
        USER_magnification = -1.0;
        USER_foregroundColor = "";
        USER_backgroundColor = "";
        USER_highContrast = false;
        USER_magnifierFullScreen = false;

        DEVICE_REPORTER_OS_id = "";
        DEVICE_REPORTER_OS_version = "";
    }
    
    public static InstantiationManager getInstance() 
    {
        if(instance == null) 
            instance = new InstantiationManager();
        return instance;
    }
    
    public String createInstanceInOntologyForJSONUserPreferencesSet()
    {
        String res = "createInstanceInOntologyForJSONUserPreferencesSet() -> ok";
        
        try
        {
            //add to ontology
            Individual tmpUserOntInstance = OntologyManager.getInstance().model.getOntClass(NS + "TempUsers").createIndividual(NS + "TEST_SAMMY");
            
            DatatypeProperty fontSizeProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempUsers_fontSize");
            Literal fontSizeProp_value;
            fontSizeProp_value = OntologyManager.getInstance().model.createTypedLiteral(USER_fontSize, XSDDatatype.XSDint);
            Statement fontSizeStat = OntologyManager.getInstance().model.createStatement(tmpUserOntInstance, fontSizeProp, fontSizeProp_value);
            OntologyManager.getInstance().model.add(fontSizeStat);
            
            DatatypeProperty magnificationProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempUsers_magnification");
            Literal magnificationProp_value;
            magnificationProp_value = OntologyManager.getInstance().model.createTypedLiteral(USER_magnification, XSDDatatype.XSDfloat);
            Statement magnificationStat = OntologyManager.getInstance().model.createStatement(tmpUserOntInstance, magnificationProp, magnificationProp_value);
            OntologyManager.getInstance().model.add(magnificationStat);
            
            DatatypeProperty foregroundColorProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempUsers_foregroundColor");
            Literal foregroundColorProp_value;
            foregroundColorProp_value = OntologyManager.getInstance().model.createTypedLiteral(USER_foregroundColor, XSDDatatype.XSDstring);
            Statement foregroundColorStat = OntologyManager.getInstance().model.createStatement(tmpUserOntInstance, foregroundColorProp, foregroundColorProp_value);
            OntologyManager.getInstance().model.add(foregroundColorStat);
            
            DatatypeProperty backgroundColorProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempUsers_backgroundColor");
            Literal backgroundColorProp_value;
            backgroundColorProp_value = OntologyManager.getInstance().model.createTypedLiteral(USER_backgroundColor, XSDDatatype.XSDstring);
            Statement backgroundColorStat = OntologyManager.getInstance().model.createStatement(tmpUserOntInstance, backgroundColorProp, backgroundColorProp_value);
            OntologyManager.getInstance().model.add(backgroundColorStat);
            
            DatatypeProperty highContrastProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempUsers_highContrast");
            Literal highContrastProp_value;
            highContrastProp_value = OntologyManager.getInstance().model.createTypedLiteral(USER_highContrast, XSDDatatype.XSDboolean);
            Statement highContrastStat = OntologyManager.getInstance().model.createStatement(tmpUserOntInstance, highContrastProp, highContrastProp_value);
            OntologyManager.getInstance().model.add(highContrastStat);
            
            DatatypeProperty magnifierFullScreenProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempUsers_magnifierFullScreen");
            Literal magnifierFullScreenProp_value;
            magnifierFullScreenProp_value = OntologyManager.getInstance().model.createTypedLiteral(USER_magnifierFullScreen, XSDDatatype.XSDboolean);
            Statement magnifierFullScreenStat = OntologyManager.getInstance().model.createStatement(tmpUserOntInstance, magnifierFullScreenProp, magnifierFullScreenProp_value);
            OntologyManager.getInstance().model.add(magnifierFullScreenStat);
            
            /*DatatypeProperty screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Prop = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempUsers_ScreenReaderTTSEnabled_whenLaunchAtStartupIsTrue");
            
            if( ((VariableStringValue)tmpUser.screenReaderTTSEnabled.get(0)).condition.operator.property.equals("http://gpii.org/ns/LaunchAtStartup")
                    && ((VariableStringValue)tmpUser.screenReaderTTSEnabled.get(0)).condition.operator.value.toLowerCase().equals("true") )
            {
                Literal screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Prop_value = null;
                if( ((VariableStringValue)tmpUser.screenReaderTTSEnabled.get(0)).value.toLowerCase().equals("true") )
                    screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Prop_value = OntologyManager.getInstance().model.createTypedLiteral(true, XSDDatatype.XSDboolean);
                else
                    screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Prop_value = OntologyManager.getInstance().model.createTypedLiteral(false, XSDDatatype.XSDboolean);
                Statement screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Stat = OntologyManager.getInstance().model.createStatement(tmpUserOntInstance, screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Prop, screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Prop_value);
                OntologyManager.getInstance().model.add(screenReaderTTSEnabled_whenLaunchAtStartupIsTrue_Stat);
            }*/
        }
        catch(Exception e)
        {
            System.out.println("\ncreateInstanceInOntologyForJSONUserPreferencesSet-> EXCEPTION CAUGHT!\n");
            e.printStackTrace();
            return "exception!!!!!";
        }
        return res;
    }
    
    public String createInstanceInOntologyForJSONEnvironment()
    {
        String res = "createInstanceInOntologyForJSONEnvironment() -> ok";
        try
        {
            //add to ontology
            Individual tmpEnvironmentOntInstance = OntologyManager.getInstance().model.getOntClass(NS + "TempEnvironment").createIndividual(NS + "TEST_ENVIRONMENT");
            
            DatatypeProperty platformNameProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempEnvironment_platformName");
            Literal platformNameProp_value = OntologyManager.getInstance().model.createTypedLiteral(DEVICE_REPORTER_OS_id, XSDDatatype.XSDstring);
            Statement platformNameStat = OntologyManager.getInstance().model.createStatement(tmpEnvironmentOntInstance, platformNameProp, platformNameProp_value);
            OntologyManager.getInstance().model.add(platformNameStat);
            
            DatatypeProperty platformVersionProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempEnvironment_platformVersion");
            Literal platformVersionProp_value = OntologyManager.getInstance().model.createTypedLiteral(DEVICE_REPORTER_OS_version, XSDDatatype.XSDstring);
            Statement platformVersionStat = OntologyManager.getInstance().model.createStatement(tmpEnvironmentOntInstance, platformVersionProp, platformVersionProp_value);
            OntologyManager.getInstance().model.add(platformVersionStat);
            
            DatatypeProperty windowManagerIdProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempEnvironment_windowManager_id");
            Literal windowManagerIdProp_value = OntologyManager.getInstance().model.createTypedLiteral("unknown", XSDDatatype.XSDstring);
            Statement windowManagerIdStat = OntologyManager.getInstance().model.createStatement(tmpEnvironmentOntInstance, windowManagerIdProp, windowManagerIdProp_value);
            OntologyManager.getInstance().model.add(windowManagerIdStat);
            
            DatatypeProperty windowManagerVersionProp = OntologyManager.getInstance().model.getDatatypeProperty(NS + "TempEnvironment_windowManager_version");
            Literal windowManagerVersionProp_value = OntologyManager.getInstance().model.createTypedLiteral("unknown", XSDDatatype.XSDstring);
            Statement windowManagerVersionStat = OntologyManager.getInstance().model.createStatement(tmpEnvironmentOntInstance, windowManagerVersionProp, windowManagerVersionProp_value);
            OntologyManager.getInstance().model.add(windowManagerVersionStat);
        }
        catch(Exception e)
        {
            System.out.println("\ncreateInstanceInOntologyForJSONEnvironment-> EXCEPTION CAUGHT!\n");
            e.printStackTrace();
        }
        return res;
    }
}