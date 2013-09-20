package com.iti.cloud4all.ontology;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;
import com.hp.hpl.jena.vocabulary.RDF;
import com.iti.cloud4all.instantiation.InstantiationManager;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nkak
 */
public class OntologyManager 
{
    boolean printDebugInfo;
    
    public static final int TempUsers_ID = -1000;
    public static final int TempEnvironment_ID = -1001;
    public static final int TempHandicapSituations_ID = -1002;
    public static final int TempPossibleSolutions_ID = -1003;
    public static final int TempSolutionsToBeLaunched_ID = -1004;
    
    public static final int DTVDevices_ID = 1;
    public static final int GamingConsoleDevices_ID = 2;
    public static final int ATMDevices_ID = 3;
    public static final int InfokioskDevices_ID = 4;
    public static final int SmartHomeDevices_ID = 5;
    public static final int MSSurfaceDevices_ID = 6;
    public static final int SimpleMobilePhoneDevices_ID = 7;
    public static final int SmartMobilePhoneDevices_ID = 8;
    public static final int PDADevices_ID = 9;
    public static final int AtDriving_ID = 10;
    public static final int AtEntertainment_ID = 11;
    public static final int AtHome_ID = 12;
    public static final int AtWork_ID = 13;
    public static final int HoursOfTheDay_ID = 14;
    public static final int LinuxOSPlatforms_ID = 15;
    public static final int SUNOSOSPlatforms_ID = 16;
    public static final int Windows7OSPlatforms_ID = 17;
    public static final int WES2007_ID = 18;
    public static final int WES2009_ID = 19;
    public static final int WindowsVistaOSPlatform_ID = 20;
    public static final int WindowsXPOSPlatform_ID = 21;
    public static final int BrowserWithJava_ID = 22;
    public static final int Services_ID = 23;
    public static final int AccessSettings_ID = 24;
    public static final int AudioNotificationsGeneralSettings_ID = 25;
    public static final int AudioNotificationsLinkSettings_ID = 26;
    public static final int AudioVolumeSettings_ID = 27;
    public static final int SpeechRecognitionSettings_ID = 28;
    public static final int EchoOptionsSettings_ID = 29;
    public static final int TextToSpeechEngineSettings_ID = 30;
    public static final int TextToSpeechLanguageSettings_ID = 31;
    public static final int PunctuationSettings_ID = 32;
    public static final int ReadingCapitalsSettings_ID = 33;
    public static final int SpeakingRateSettings_ID = 34;
    public static final int SpeekingPitchSettings_ID = 35;
    public static final int VoiceSettings_ID = 36;
    public static final int VoiceVolume_ID = 37;
    public static final int EasyOneCommunicatorSeetings_ID = 38;
    public static final int LanguageSettings_ID = 39;
    public static final int MsSurfaceSettings_ID = 40;
    public static final int SAToGoSettings_ID = 41;
    public static final int SmartHouseSettings_ID = 42;
    public static final int BrailleDisplaySettings_ID = 43;
    public static final int GestureSettings_ID = 44;
    public static final int UsersAssistantsIDSettings_ID = 45;
    public static final int UsersContactsSettings_ID = 46;
    public static final int Gmail_ID = 47;
    public static final int UsersIDSettings_ID = 48;
    public static final int UsersLanguageSettings_ID = 49;
    public static final int UsersXMPPChatIDSettings_ID = 50;
    public static final int UsersXMPPPasswordSettings_ID = 51;
    public static final int ColorSettings_ID = 52;
    public static final int ButtonSettings_ID = 53;
    public static final int InterfaceSettings_ID = 54;
    public static final int KeyboardLayoutSettings_ID = 55;
    public static final int MagnifierSettings_ID = 56;
    public static final int SubtitleSettings_ID = 57;
    public static final int TextSizeSettings_ID = 58;
    public static final int TextStyleSettings_ID = 59;
    public static final int VisualNotificationsSettings_ID = 60;
    public static final int VisualResponseSettings_ID = 61;
    public static final int WebAnywhereSettings_ID = 62;
    public static final int SystemsToTransformImagesIntoSoundOrVoice_ID = 63;
    public static final int SatelliteNavigationSystem_ID = 64;
    public static final int WordProcessingSoftware_ID = 65;
    public static final int EasyOneCommunicator_ID = 66;
    public static final int SocialNetworkApp_ID = 67;
    public static final int SoftwareForSoundOrSpeechAmplification_ID = 68;
    public static final int PaperDocumentsReadingSystemOCR_ID = 69;
    public static final int SAToGo_ID = 70;
    public static final int SpeechStreamTextHelp_ID = 71;
    public static final int WebAnywhere_ID = 72;
    public static final int VideoMagnifier_ID = 73;
    public static final int DelayedCaptioningSystem_ID = 74;
    public static final int RealTimeCaptioningSystem_ID = 75;
    public static final int SoftwareInterfaceForComputer_ID = 76;
    public static final int eKiosk_ID = 77;
    public static final int AlternativeInputDeviceForComputer_ID = 78;
    public static final int EyegazeSystem_ID = 79;
    public static final int MsSurface_ID = 80;
    public static final int VoiceRecognitionSystem_ID = 81;
    public static final int PointingDevice_ID = 82;
    public static final int SwitchInterface_ID = 83;
    public static final int MouseControlSoftware_ID = 84;
    public static final int OnScreenKeyboard_ID = 85;
    public static final int SoftwareForAdjustingInoutDevicesResponse_ID = 86;
    public static final int WordPredictionSoftware_ID = 87;
    public static final int SpeechSynthesis_ID = 88;
    public static final int MagnifyingSoftware_ID = 89;
    public static final int ScreenReader_ID = 90;
    public static final int SoftwareForAdjustingColorCombinationAndTextSize_ID = 91;
    public static final int SoftwareToModifyThePointerAppearance_ID = 92;
    public static final int SmartHouse_ID = 93;
    public static final int DeviceVendors_ID = 94;
    public static final int PlatformVendors_ID = 95;
    public static final int SolutionVendors_ID = 96;
    
    //version 1_2
    
    public static final int PlatformSettings_AndroidPhoneInteractionSettings_ID = 97;
    public static final int PlatformSettings_AndroidPhoneSettings_ID = 98;
    public static final int PlatformSettings_DesktopSettings_ID = 99;
    public static final int PlatformSettings_DigitalTV_ID = 100;
    public static final int PlatformSettings_IOSPhoneSettings_ID = 101;
    public static final int PlatformSettings_SimplePhoneSettings_ID = 102;
    public static final int PlatformSettings_WindowsPhoneSettings_ID = 103;

    public static final int ApplicationSettings_EasyOneCommunicatorSettings_ID = 104;
    public static final int ApplicationSettings_EKioskSettings_ID = 105;
    public static final int ApplicationSettings_Maavis_ID = 106;
    public static final int ApplicationSettings_MSSurfaceSettings_ID = 107;
    public static final int ApplicationSettings_ReadWriteGold_TextHelp_ID = 108;
    public static final int ApplicationSettings_SAToGoSettings_ID = 109;
    public static final int ApplicationSettings_SocialNetworkAppSettings_ID = 110;
    public static final int ApplicationSettings_SpeechStream_TextHelp_ID = 111;
    public static final int ApplicationSettings_WebAnywhereSettings_ID = 112;

    public static final int GNOMEDesktopAccessibilitySettings_ID = 113;

    public static final int BrowserSettings_Firefox10_0_1Settings_ID = 114;
    public static final int BrowserSettings_IE8Settings_ID = 115;

    public static final int ScreenMagnifierSettings_ISO24751ScreenMagnifierSettings_ID = 116;
    public static final int ScreenMagnifierSettings_LinuxBuiltInScreenMagnifierSettings_ID = 117;
    public static final int ScreenMagnifierSettings_WindowsBuiltInScreenMagnifierSettings_ID = 118;
    public static final int ScreenMagnifierSettings_ZoomTextSettings_ID = 119;

    public static final int ScreenReaderSettings_ISO24751ScreenReaderSettings_ID = 120;
    public static final int ScreenReaderSettings_JAWSSettings_ID = 121;
    public static final int ScreenReaderSettings_NVDASettings_ID = 122;
    public static final int ScreenReaderSettings_OrcaSettings_ID = 123;
    public static final int ScreenReaderSettings_WinSevenBuiltInNarratorSettings_ID = 124;
    
    public static final int lastID = 124;
    
    public ArrayList<TempUser> allInstances_TempUser;
    public ArrayList<TempEnvironment> allInstances_TempEnvironment;
    public ArrayList<TempHandicapSituation> allInstances_TempHandicapSituation;
    public ArrayList<TempPossibleSolution> allInstances_TempPossibleSolution;
    public ArrayList<TempSolutionsToBeLaunched> allInstances_TempSolutionsToBeLaunched;
    public ArrayList<Solution> allInstances_Solution;
    
    public OntModel model;
    
    private static OntologyManager instance = null;
    
    
    private OntologyManager() 
    {
        printDebugInfo = false;
        
        allInstances_TempUser = new ArrayList<TempUser>();
        allInstances_TempEnvironment = new ArrayList<TempEnvironment>();
        allInstances_TempHandicapSituation = new ArrayList<TempHandicapSituation>();
        allInstances_TempPossibleSolution = new ArrayList<TempPossibleSolution>();
        allInstances_TempSolutionsToBeLaunched = new ArrayList<TempSolutionsToBeLaunched>();
        allInstances_Solution = new ArrayList<Solution>();
        
        // create an empty model
        model = ModelFactory.createOntologyModel();
        
        String owlPathStr = System.getProperty("user.dir") + "/lib/RB_MM/extra-resources/semantincFrameworkOfContentAndSolutions.owl";
        InputStream in = null;
        try {
            in = new FileInputStream(owlPathStr);
        } catch(Exception ex) {
            Logger.getLogger(OntologyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (in == null) {
            throw new IllegalArgumentException( "File: semantincFrameworkOfContentAndSolutions.owl not found!");
        }
        
        // read the RDF/XML file
        model.read(in, "");
        
        try
        {
            in.close();
        }  catch(Exception ex) {
            Logger.getLogger(OntologyManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String fromStream(InputStream in) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        return out.toString();
    }
    
    public static OntologyManager getInstance() 
    {
        if(instance == null) 
            instance = new OntologyManager();
        return instance;
    }
    
    public int getClassIDByName(String tmpClassName)
    {
        if(tmpClassName != null)
        {
            if(tmpClassName.equals("TempUsers"))
                return TempUsers_ID;
            else if(tmpClassName.equals("TempEnvironment"))
                return TempEnvironment_ID;
            else if(tmpClassName.equals("TempHandicapSituations"))
                return TempHandicapSituations_ID;
            else if(tmpClassName.equals("TempPossibleSolutions"))
                return TempPossibleSolutions_ID;
            else if(tmpClassName.equals("TempSolutionsToBeLaunched"))
                return TempSolutionsToBeLaunched_ID;


            else if(tmpClassName.equals("DTVDevices"))
                return DTVDevices_ID;
            else if(tmpClassName.equals("GamingConsoleDevices"))
                return GamingConsoleDevices_ID;
            else if(tmpClassName.equals("ATMDevices"))
                return ATMDevices_ID;
            else if(tmpClassName.equals("InfokioskDevices"))
                return InfokioskDevices_ID;
            else if(tmpClassName.equals("SmartHomeDevices"))
                return SmartHomeDevices_ID;
            else if(tmpClassName.equals("MSSurfaceDevices"))
                return MSSurfaceDevices_ID;
            else if(tmpClassName.equals("SimpleMobilePhoneDevices"))
                return SimpleMobilePhoneDevices_ID;
            else if(tmpClassName.equals("SmartMobilePhoneDevices"))
                return SmartMobilePhoneDevices_ID;
            else if(tmpClassName.equals("PDADevices"))
                return PDADevices_ID;
            else if(tmpClassName.equals("AtDriving"))
                return AtDriving_ID;
            else if(tmpClassName.equals("AtEntertainment"))
                return AtEntertainment_ID;
            else if(tmpClassName.equals("AtHome"))
                return AtHome_ID;
            else if(tmpClassName.equals("AtWork"))
                return AtWork_ID;
            else if(tmpClassName.equals("HoursOfTheDay"))
                return HoursOfTheDay_ID;
            else if(tmpClassName.equals("LinuxOSPlatforms"))
                return LinuxOSPlatforms_ID;
            else if(tmpClassName.equals("SUNOSOSPlatforms"))
                return SUNOSOSPlatforms_ID;
            else if(tmpClassName.equals("Windows7OSPlatforms"))
                return Windows7OSPlatforms_ID;
            else if(tmpClassName.equals("WES2007"))
                return WES2007_ID;
            else if(tmpClassName.equals("WES2009"))
                return WES2009_ID;
            else if(tmpClassName.equals("WindowsVistaOSPlatform"))
                return WindowsVistaOSPlatform_ID;
            else if(tmpClassName.equals("WindowsXPOSPlatform"))
                return WindowsXPOSPlatform_ID;
            else if(tmpClassName.equals("BrowserWithJava"))
                return BrowserWithJava_ID;
            else if(tmpClassName.equals("Services"))
                return Services_ID;
            else if(tmpClassName.equals("AccessSettings"))
                return AccessSettings_ID;
            else if(tmpClassName.equals("AudioNotificationsGeneralSettings"))
                return AudioNotificationsGeneralSettings_ID;
            else if(tmpClassName.equals("AudioNotificationsLinkSettings"))
                return AudioNotificationsLinkSettings_ID;
            else if(tmpClassName.equals("AudioVolumeSettings"))
                return AudioVolumeSettings_ID;
            else if(tmpClassName.equals("SpeechRecognitionSettings"))
                return SpeechRecognitionSettings_ID;
            else if(tmpClassName.equals("EchoOptionsSettings"))
                return EchoOptionsSettings_ID;
            else if(tmpClassName.equals("TextToSpeechEngineSettings"))
                return TextToSpeechEngineSettings_ID;
            else if(tmpClassName.equals("TextToSpeechLanguageSettings"))
                return TextToSpeechLanguageSettings_ID;
            else if(tmpClassName.equals("PunctuationSettings"))
                return PunctuationSettings_ID;
            else if(tmpClassName.equals("ReadingCapitalsSettings"))
                return ReadingCapitalsSettings_ID;
            else if(tmpClassName.equals("SpeakingRateSettings"))
                return SpeakingRateSettings_ID;
            else if(tmpClassName.equals("SpeekingPitchSettings"))
                return SpeekingPitchSettings_ID;
            else if(tmpClassName.equals("VoiceSettings"))
                return VoiceSettings_ID;
            else if(tmpClassName.equals("VoiceVolume"))
                return VoiceVolume_ID;
            else if(tmpClassName.equals("EasyOneCommunicatorSeetings"))
                return EasyOneCommunicatorSeetings_ID;
            else if(tmpClassName.equals("LanguageSettings"))
                return LanguageSettings_ID;
            else if(tmpClassName.equals("MsSurfaceSettings"))
                return MsSurfaceSettings_ID;
            else if(tmpClassName.equals("SAToGoSettings"))
                return SAToGoSettings_ID;
            else if(tmpClassName.equals("SmartHouseSettings"))
                return SmartHouseSettings_ID;
            else if(tmpClassName.equals("BrailleDisplaySettings"))
                return BrailleDisplaySettings_ID;
            else if(tmpClassName.equals("GestureSettings"))
                return GestureSettings_ID;
            else if(tmpClassName.equals("UsersAssistantsIDSettings"))
                return UsersAssistantsIDSettings_ID;
            else if(tmpClassName.equals("UsersContactsSettings"))
                return UsersContactsSettings_ID;
            else if(tmpClassName.equals("Gmail"))
                return Gmail_ID;
            else if(tmpClassName.equals("UsersIDSettings"))
                return UsersIDSettings_ID;
            else if(tmpClassName.equals("UsersLanguageSettings"))
                return UsersLanguageSettings_ID;
            else if(tmpClassName.equals("UsersXMPPChatIDSettings"))
                return UsersXMPPChatIDSettings_ID;
            else if(tmpClassName.equals("UsersXMPPPasswordSettings"))
                return UsersXMPPPasswordSettings_ID;
            else if(tmpClassName.equals("ColorSettings"))
                return ColorSettings_ID;
            else if(tmpClassName.equals("ButtonSettings"))
                return ButtonSettings_ID;
            else if(tmpClassName.equals("InterfaceSettings"))
                return InterfaceSettings_ID;
            else if(tmpClassName.equals("KeyboardLayoutSettings"))
                return KeyboardLayoutSettings_ID;
            else if(tmpClassName.equals("MagnifierSettings"))
                return MagnifierSettings_ID;
            else if(tmpClassName.equals("SubtitleSettings"))
                return SubtitleSettings_ID;
            else if(tmpClassName.equals("TextSizeSettings"))
                return TextSizeSettings_ID;
            else if(tmpClassName.equals("TextStyleSettings"))
                return TextStyleSettings_ID;
            else if(tmpClassName.equals("VisualNotificationsSettings"))
                return VisualNotificationsSettings_ID;
            else if(tmpClassName.equals("VisualResponseSettings"))
                return VisualResponseSettings_ID;
            else if(tmpClassName.equals("WebAnywhereSettings"))
                return WebAnywhereSettings_ID;
            else if(tmpClassName.equals("SystemsToTransformImagesIntoSoundOrVoice"))
                return SystemsToTransformImagesIntoSoundOrVoice_ID;
            else if(tmpClassName.equals("SatelliteNavigationSystem"))
                return SatelliteNavigationSystem_ID;
            else if(tmpClassName.equals("WordProcessingSoftware"))
                return WordProcessingSoftware_ID;
            else if(tmpClassName.equals("EasyOneCommunicator"))
                return EasyOneCommunicator_ID;
            else if(tmpClassName.equals("SocialNetworkApp"))
                return SocialNetworkApp_ID;
            else if(tmpClassName.equals("SoftwareForSoundOrSpeechAmplification"))
                return SoftwareForSoundOrSpeechAmplification_ID;
            else if(tmpClassName.equals("PaperDocumentsReadingSystemOCR"))
                return PaperDocumentsReadingSystemOCR_ID;
            else if(tmpClassName.equals("SAToGo"))
                return SAToGo_ID;
            else if(tmpClassName.equals("SpeechStreamTextHelp"))
                return SpeechStreamTextHelp_ID;
            else if(tmpClassName.equals("WebAnywhere"))
                return WebAnywhere_ID;
            else if(tmpClassName.equals("VideoMagnifier"))
                return VideoMagnifier_ID;
            else if(tmpClassName.equals("DelayedCaptioningSystem"))
                return DelayedCaptioningSystem_ID;
            else if(tmpClassName.equals("RealTimeCaptioningSystem"))
                return RealTimeCaptioningSystem_ID;
            else if(tmpClassName.equals("SoftwareInterfaceForComputer"))
                return SoftwareInterfaceForComputer_ID;
            else if(tmpClassName.equals("eKiosk"))
                return eKiosk_ID;
            else if(tmpClassName.equals("AlternativeInputDeviceForComputer"))
                return AlternativeInputDeviceForComputer_ID;
            else if(tmpClassName.equals("EyegazeSystem"))
                return EyegazeSystem_ID;
            else if(tmpClassName.equals("MsSurface"))
                return MsSurface_ID;
            else if(tmpClassName.equals("VoiceRecognitionSystem"))
                return VoiceRecognitionSystem_ID;
            else if(tmpClassName.equals("PointingDevice"))
                return PointingDevice_ID;
            else if(tmpClassName.equals("SwitchInterface"))
                return SwitchInterface_ID;
            else if(tmpClassName.equals("MouseControlSoftware"))
                return MouseControlSoftware_ID;
            else if(tmpClassName.equals("OnScreenKeyboard"))
                return OnScreenKeyboard_ID;
            else if(tmpClassName.equals("SoftwareForAdjustingInoutDevicesResponse"))
                return SoftwareForAdjustingInoutDevicesResponse_ID;
            else if(tmpClassName.equals("WordPredictionSoftware"))
                return WordPredictionSoftware_ID;
            else if(tmpClassName.equals("SpeechSynthesis"))
                return SpeechSynthesis_ID;
            else if(tmpClassName.equals("MagnifyingSoftware"))
                return MagnifyingSoftware_ID;
            else if(tmpClassName.equals("ScreenReaderSoftware"))
                return ScreenReader_ID;
            else if(tmpClassName.equals("SoftwareForAdjustingColorCombinationAndTextSize"))
                return SoftwareForAdjustingColorCombinationAndTextSize_ID;
            else if(tmpClassName.equals("SoftwareToModifyThePointerAppearance"))
                return SoftwareToModifyThePointerAppearance_ID;
            else if(tmpClassName.equals("SmartHouse"))
                return SmartHouse_ID;
            else if(tmpClassName.equals("DeviceVendors"))
                return DeviceVendors_ID;
            else if(tmpClassName.equals("PlatformVendors"))
                return PlatformVendors_ID;
            else if(tmpClassName.equals("SolutionVendors"))
                return SolutionVendors_ID;

            //version 1_2

            else if(tmpClassName.equals("AndroidPhoneInteractionSettings"))
                return PlatformSettings_AndroidPhoneInteractionSettings_ID;
            else if(tmpClassName.equals("AndroidPhoneSettings"))
                return PlatformSettings_AndroidPhoneSettings_ID;
            else if(tmpClassName.equals("DesktopSettings"))
                return PlatformSettings_DesktopSettings_ID;
            else if(tmpClassName.equals("DigitalTV"))
                return PlatformSettings_DigitalTV_ID;
            else if(tmpClassName.equals("IOSPhoneSettings"))
                return PlatformSettings_IOSPhoneSettings_ID;
            else if(tmpClassName.equals("SimplePhoneSettings"))
                return PlatformSettings_SimplePhoneSettings_ID;
            else if(tmpClassName.equals("WindowsPhoneSettings"))
                return PlatformSettings_WindowsPhoneSettings_ID;

            else if(tmpClassName.equals("EasyOneCommunicatorSettings"))
                return ApplicationSettings_EasyOneCommunicatorSettings_ID;
            else if(tmpClassName.equals("EKioskSettings"))
                return ApplicationSettings_EKioskSettings_ID;
            else if(tmpClassName.equals("Maavis"))
                return ApplicationSettings_Maavis_ID;
            else if(tmpClassName.equals("MSSurfaceSettings"))
                return ApplicationSettings_MSSurfaceSettings_ID;
            else if(tmpClassName.equals("ReadWriteGold_TextHelp"))
                return ApplicationSettings_ReadWriteGold_TextHelp_ID;
            else if(tmpClassName.equals("SAToGoSettings"))
                return ApplicationSettings_SAToGoSettings_ID;
            else if(tmpClassName.equals("SocialNetworkAppSettings"))
                return ApplicationSettings_SocialNetworkAppSettings_ID;
            else if(tmpClassName.equals("SpeechStream_TextHelp"))
                return ApplicationSettings_SpeechStream_TextHelp_ID;
            else if(tmpClassName.equals("WebAnywhereSettings"))
                return ApplicationSettings_WebAnywhereSettings_ID;

            else if(tmpClassName.equals("GNOMEDesktopAccessibilitySettings"))
                return GNOMEDesktopAccessibilitySettings_ID;

            else if(tmpClassName.equals("Firefox10_0_1Settings"))
                return BrowserSettings_Firefox10_0_1Settings_ID;
            else if(tmpClassName.equals("IE8Settings"))
                return BrowserSettings_IE8Settings_ID;

            else if(tmpClassName.equals("ISO24751ScreenMagnifierSettings"))
                return ScreenMagnifierSettings_ISO24751ScreenMagnifierSettings_ID;
            else if(tmpClassName.equals("LinuxBuiltInScreenMagnifierSettings"))
                return ScreenMagnifierSettings_LinuxBuiltInScreenMagnifierSettings_ID;
            else if(tmpClassName.equals("WindowsBuiltInScreenMagnifierSettings"))
                return ScreenMagnifierSettings_WindowsBuiltInScreenMagnifierSettings_ID;
            else if(tmpClassName.equals("ZoomTextSettings"))
                return ScreenMagnifierSettings_ZoomTextSettings_ID;

            else if(tmpClassName.equals("ISO24751ScreenReaderSettings"))
                return ScreenReaderSettings_ISO24751ScreenReaderSettings_ID;
            else if(tmpClassName.equals("JAWSSettings"))
                return ScreenReaderSettings_JAWSSettings_ID;
            else if(tmpClassName.equals("NVDASettings"))
                return ScreenReaderSettings_NVDASettings_ID;
            else if(tmpClassName.equals("OrcaSettings"))
                return ScreenReaderSettings_OrcaSettings_ID;
            else if(tmpClassName.equals("WinSevenBuiltInNarratorSettings"))
                return ScreenReaderSettings_WinSevenBuiltInNarratorSettings_ID;
        }
        return -1;
    }
    
    public String getClassNameByID(int tmpClassID)
    {
        if(tmpClassID == TempUsers_ID)
            return "TempUsers";
        else if(tmpClassID == TempEnvironment_ID)
            return "TempEnvironment";
        else if(tmpClassID == TempHandicapSituations_ID)
            return "TempHandicapSituations";
        else if(tmpClassID == TempPossibleSolutions_ID)
            return "TempPossibleSolutions";
        else if(tmpClassID == TempSolutionsToBeLaunched_ID)
            return "TempSolutionsToBeLaunched";
        
        
        else if(tmpClassID == DTVDevices_ID)
            return "DTVDevices";
        else if(tmpClassID == GamingConsoleDevices_ID)
            return "GamingConsoleDevices";
        else if(tmpClassID == ATMDevices_ID)
            return "ATMDevices";
        else if(tmpClassID == InfokioskDevices_ID)
            return "InfokioskDevices";
        else if(tmpClassID == SmartHomeDevices_ID)
            return "SmartHomeDevices";
        else if(tmpClassID == MSSurfaceDevices_ID)
            return "MSSurfaceDevices";
        else if(tmpClassID == SimpleMobilePhoneDevices_ID)
            return "SimpleMobilePhoneDevices";
        else if(tmpClassID == SmartMobilePhoneDevices_ID)
            return "SmartMobilePhoneDevices";
        else if(tmpClassID == PDADevices_ID)
            return "PDADevices";
        else if(tmpClassID == AtDriving_ID)
            return "AtDriving";
        else if(tmpClassID == AtEntertainment_ID)
            return "AtEntertainment";
        else if(tmpClassID == AtHome_ID)
            return "AtHome";
        else if(tmpClassID == AtWork_ID)
            return "AtWork";
        else if(tmpClassID == HoursOfTheDay_ID)
            return "HoursOfTheDay";
        else if(tmpClassID == LinuxOSPlatforms_ID)
            return "LinuxOSPlatforms";
        else if(tmpClassID == SUNOSOSPlatforms_ID)
            return "SUNOSOSPlatforms";
        else if(tmpClassID == Windows7OSPlatforms_ID)
            return "Windows7OSPlatforms";
        else if(tmpClassID == WES2007_ID)
            return "WES2007";
        else if(tmpClassID == WES2009_ID)
            return "WES2009";
        else if(tmpClassID == WindowsVistaOSPlatform_ID)
            return "WindowsVistaOSPlatform";
        else if(tmpClassID == WindowsXPOSPlatform_ID)
            return "WindowsXPOSPlatform";
        else if(tmpClassID == BrowserWithJava_ID)
            return "BrowserWithJava";
        else if(tmpClassID == Services_ID)
            return "Services";
        else if(tmpClassID == AccessSettings_ID)
            return "AccessSettings";
        else if(tmpClassID == AudioNotificationsGeneralSettings_ID)
            return "AudioNotificationsGeneralSettings";
        else if(tmpClassID == AudioNotificationsLinkSettings_ID)
            return "AudioNotificationsLinkSettings";
        else if(tmpClassID == AudioVolumeSettings_ID)
            return "AudioVolumeSettings";
        else if(tmpClassID == SpeechRecognitionSettings_ID)
            return "SpeechRecognitionSettings";
        else if(tmpClassID == EchoOptionsSettings_ID)
            return "EchoOptionsSettings";
        else if(tmpClassID == TextToSpeechEngineSettings_ID)
            return "TextToSpeechEngineSettings";
        else if(tmpClassID == TextToSpeechLanguageSettings_ID)
            return "TextToSpeechLanguageSettings";
        else if(tmpClassID == PunctuationSettings_ID)
            return "PunctuationSettings";
        else if(tmpClassID == ReadingCapitalsSettings_ID)
            return "ReadingCapitalsSettings";
        else if(tmpClassID == SpeakingRateSettings_ID)
            return "SpeakingRateSettings";
        else if(tmpClassID == SpeekingPitchSettings_ID)
            return "SpeekingPitchSettings";
        else if(tmpClassID == VoiceSettings_ID)
            return "VoiceSettings";
        else if(tmpClassID == VoiceVolume_ID)
            return "VoiceVolume";
        else if(tmpClassID == EasyOneCommunicatorSeetings_ID)
            return "EasyOneCommunicatorSeetings";
        else if(tmpClassID == LanguageSettings_ID)
            return "LanguageSettings";
        else if(tmpClassID == MsSurfaceSettings_ID)
            return "MsSurfaceSettings";
        else if(tmpClassID == SAToGoSettings_ID)
            return "SAToGoSettings";
        else if(tmpClassID == SmartHouseSettings_ID)
            return "SmartHouseSettings";
        else if(tmpClassID == BrailleDisplaySettings_ID)
            return "BrailleDisplaySettings";
        else if(tmpClassID == GestureSettings_ID)
            return "GestureSettings";
        else if(tmpClassID == UsersAssistantsIDSettings_ID)
            return "UsersAssistantsIDSettings";
        else if(tmpClassID == UsersContactsSettings_ID)
            return "UsersContactsSettings";
        else if(tmpClassID == Gmail_ID)
            return "Gmail";
        else if(tmpClassID == UsersIDSettings_ID)
            return "UsersIDSettings";
        else if(tmpClassID == UsersLanguageSettings_ID)
            return "UsersLanguageSettings";
        else if(tmpClassID == UsersXMPPChatIDSettings_ID)
            return "UsersXMPPChatIDSettings";
        else if(tmpClassID == UsersXMPPPasswordSettings_ID)
            return "UsersXMPPPasswordSettings";
        else if(tmpClassID == ColorSettings_ID)
            return "ColorSettings";
        else if(tmpClassID == ButtonSettings_ID)
            return "ButtonSettings";
        else if(tmpClassID == InterfaceSettings_ID)
            return "InterfaceSettings";
        else if(tmpClassID == KeyboardLayoutSettings_ID)
            return "KeyboardLayoutSettings";
        else if(tmpClassID == MagnifierSettings_ID)
            return "MagnifierSettings";
        else if(tmpClassID == SubtitleSettings_ID)
            return "SubtitleSettings";
        else if(tmpClassID == TextSizeSettings_ID)
            return "TextSizeSettings";
        else if(tmpClassID == TextStyleSettings_ID)
            return "TextStyleSettings";
        else if(tmpClassID == VisualNotificationsSettings_ID)
            return "VisualNotificationsSettings";
        else if(tmpClassID == VisualResponseSettings_ID)
            return "VisualResponseSettings";
        else if(tmpClassID == WebAnywhereSettings_ID)
            return "WebAnywhereSettings";
        else if(tmpClassID == SystemsToTransformImagesIntoSoundOrVoice_ID)
            return "SystemsToTransformImagesIntoSoundOrVoice";
        else if(tmpClassID == SatelliteNavigationSystem_ID)
            return "SatelliteNavigationSystem";
        else if(tmpClassID == WordProcessingSoftware_ID)
            return "WordProcessingSoftware";
        else if(tmpClassID == EasyOneCommunicator_ID)
            return "EasyOneCommunicator";
        else if(tmpClassID == SocialNetworkApp_ID)
            return "SocialNetworkApp";
        else if(tmpClassID == SoftwareForSoundOrSpeechAmplification_ID)
            return "SoftwareForSoundOrSpeechAmplification";
        else if(tmpClassID == PaperDocumentsReadingSystemOCR_ID)
            return "PaperDocumentsReadingSystemOCR";
        else if(tmpClassID == SAToGo_ID)
            return "SAToGo";
        else if(tmpClassID == SpeechStreamTextHelp_ID)
            return "SpeechStreamTextHelp";
        else if(tmpClassID == WebAnywhere_ID)
            return "WebAnywhere";
        else if(tmpClassID == VideoMagnifier_ID)
            return "VideoMagnifier";
        else if(tmpClassID == DelayedCaptioningSystem_ID)
            return "DelayedCaptioningSystem";
        else if(tmpClassID == RealTimeCaptioningSystem_ID)
            return "RealTimeCaptioningSystem";
        else if(tmpClassID == SoftwareInterfaceForComputer_ID)
            return "SoftwareInterfaceForComputer";
        else if(tmpClassID == eKiosk_ID)
            return "eKiosk";
        else if(tmpClassID == AlternativeInputDeviceForComputer_ID)
            return "AlternativeInputDeviceForComputer";
        else if(tmpClassID == EyegazeSystem_ID)
            return "EyegazeSystem";
        else if(tmpClassID == MsSurface_ID)
            return "MsSurface";
        else if(tmpClassID == VoiceRecognitionSystem_ID)
            return "VoiceRecognitionSystem";
        else if(tmpClassID == PointingDevice_ID)
            return "PointingDevice";
        else if(tmpClassID == SwitchInterface_ID)
            return "SwitchInterface";
        else if(tmpClassID == MouseControlSoftware_ID)
            return "MouseControlSoftware";
        else if(tmpClassID == OnScreenKeyboard_ID)
            return "OnScreenKeyboard";
        else if(tmpClassID == SoftwareForAdjustingInoutDevicesResponse_ID)
            return "SoftwareForAdjustingInoutDevicesResponse";
        else if(tmpClassID == WordPredictionSoftware_ID)
            return "WordPredictionSoftware";
        else if(tmpClassID == SpeechSynthesis_ID)
            return "SpeechSynthesis";
        else if(tmpClassID == MagnifyingSoftware_ID)
            return "MagnifyingSoftware";
        else if(tmpClassID == ScreenReader_ID)
            return "ScreenReaderSoftware";
        else if(tmpClassID == SoftwareForAdjustingColorCombinationAndTextSize_ID)
            return "SoftwareForAdjustingColorCombinationAndTextSize";
        else if(tmpClassID == SoftwareToModifyThePointerAppearance_ID)
            return "SoftwareToModifyThePointerAppearance";
        else if(tmpClassID == SmartHouse_ID)
            return "SmartHouse";
        else if(tmpClassID == DeviceVendors_ID)
            return "DeviceVendors";
        else if(tmpClassID == PlatformVendors_ID)
            return "PlatformVendors";
        else if(tmpClassID == SolutionVendors_ID)
            return "SolutionVendors";
        
        //version 1_2
        
        else if(tmpClassID == PlatformSettings_AndroidPhoneInteractionSettings_ID)
            return "AndroidPhoneInteractionSettings";
        else if(tmpClassID == PlatformSettings_AndroidPhoneSettings_ID)
            return "AndroidPhoneSettings";
        else if(tmpClassID == PlatformSettings_DesktopSettings_ID)
            return "DesktopSettings";
        else if(tmpClassID == PlatformSettings_DigitalTV_ID)
            return "DigitalTV";
        else if(tmpClassID == PlatformSettings_IOSPhoneSettings_ID)
            return "IOSPhoneSettings";
        else if(tmpClassID == PlatformSettings_SimplePhoneSettings_ID)
            return "SimplePhoneSettings";
        else if(tmpClassID == PlatformSettings_WindowsPhoneSettings_ID)
            return "";

        else if(tmpClassID == ApplicationSettings_EasyOneCommunicatorSettings_ID)
            return "EasyOneCommunicatorSettings";
        else if(tmpClassID == ApplicationSettings_EKioskSettings_ID)
            return "EKioskSettings";
        else if(tmpClassID == ApplicationSettings_Maavis_ID)
            return "Maavis";
        else if(tmpClassID == ApplicationSettings_MSSurfaceSettings_ID)
            return "MSSurfaceSettings";
        else if(tmpClassID == ApplicationSettings_ReadWriteGold_TextHelp_ID)
            return "ReadWriteGold_TextHelp";
        else if(tmpClassID == ApplicationSettings_SAToGoSettings_ID)
            return "SAToGoSettings";
        else if(tmpClassID == ApplicationSettings_SocialNetworkAppSettings_ID)
            return "SocialNetworkAppSettings";
        else if(tmpClassID == ApplicationSettings_SpeechStream_TextHelp_ID)
            return "SpeechStream_TextHelp";
        else if(tmpClassID == ApplicationSettings_WebAnywhereSettings_ID)
            return "WebAnywhereSettings";

        else if(tmpClassID == GNOMEDesktopAccessibilitySettings_ID)
            return "GNOMEDesktopAccessibilitySettings";

        else if(tmpClassID == BrowserSettings_Firefox10_0_1Settings_ID)
            return "Firefox10_0_1Settings";
        else if(tmpClassID == BrowserSettings_IE8Settings_ID)
            return "IE8Settings";

        else if(tmpClassID == ScreenMagnifierSettings_ISO24751ScreenMagnifierSettings_ID)
            return "ISO24751ScreenMagnifierSettings";
        else if(tmpClassID == ScreenMagnifierSettings_LinuxBuiltInScreenMagnifierSettings_ID)
            return "LinuxBuiltInScreenMagnifierSettings";
        else if(tmpClassID == ScreenMagnifierSettings_WindowsBuiltInScreenMagnifierSettings_ID)
            return "WindowsBuiltInScreenMagnifierSettings";
        else if(tmpClassID == ScreenMagnifierSettings_ZoomTextSettings_ID)
            return "ZoomTextSettings";

        else if(tmpClassID == ScreenReaderSettings_ISO24751ScreenReaderSettings_ID)
            return "ISO24751ScreenReaderSettings";
        else if(tmpClassID == ScreenReaderSettings_JAWSSettings_ID)
            return "JAWSSettings";
        else if(tmpClassID == ScreenReaderSettings_NVDASettings_ID)
            return "NVDASettings";
        else if(tmpClassID == ScreenReaderSettings_OrcaSettings_ID)
            return "OrcaSettings";
        else if(tmpClassID == ScreenReaderSettings_WinSevenBuiltInNarratorSettings_ID)
            return "WinSevenBuiltInNarratorSettings";
        
        return "UNKNOWN CLASS ID!";
    }
    
    public String fillSolutionsArrayList()
    {
        String res = "";
        ExtendedIterator classes = model.listClasses();
        
        while(classes.hasNext())
        {
            OntClass tmpClass = (OntClass)classes.next();
            
            int tmpClassID = -1;
            if(tmpClass != null)
                tmpClassID = getClassIDByName(tmpClass.getLocalName());
            
            //---------
            //Solutions
            //---------
            if(tmpClassID == SystemsToTransformImagesIntoSoundOrVoice_ID
                    || tmpClassID == SatelliteNavigationSystem_ID
                    || tmpClassID == WordProcessingSoftware_ID
                    || tmpClassID == EasyOneCommunicator_ID
                    || tmpClassID == SocialNetworkApp_ID
                    || tmpClassID == SoftwareForSoundOrSpeechAmplification_ID
                    || tmpClassID == PaperDocumentsReadingSystemOCR_ID
                    || tmpClassID == SAToGo_ID
                    || tmpClassID == SpeechStreamTextHelp_ID
                    || tmpClassID == WebAnywhere_ID
                    || tmpClassID == VideoMagnifier_ID
                    || tmpClassID == DelayedCaptioningSystem_ID
                    || tmpClassID == RealTimeCaptioningSystem_ID
                    || tmpClassID == SoftwareInterfaceForComputer_ID
                    || tmpClassID == eKiosk_ID
                    || tmpClassID == AlternativeInputDeviceForComputer_ID
                    || tmpClassID == EyegazeSystem_ID
                    || tmpClassID == MsSurface_ID
                    || tmpClassID == VoiceRecognitionSystem_ID
                    || tmpClassID == PointingDevice_ID
                    || tmpClassID == SwitchInterface_ID
                    || tmpClassID == MouseControlSoftware_ID
                    || tmpClassID == OnScreenKeyboard_ID
                    || tmpClassID == SoftwareForAdjustingInoutDevicesResponse_ID
                    || tmpClassID == WordPredictionSoftware_ID
                    || tmpClassID == SpeechSynthesis_ID
                    || tmpClassID == MagnifyingSoftware_ID
                    || tmpClassID == ScreenReader_ID
                    || tmpClassID == SoftwareForAdjustingColorCombinationAndTextSize_ID
                    || tmpClassID == SoftwareToModifyThePointerAppearance_ID
                    || tmpClassID == SmartHouse_ID)
            {
                ExtendedIterator instances = tmpClass.listInstances();
                
                while(instances.hasNext())
                {
                    Individual tmpInstance = (Individual)instances.next();
                
                    Solution tmpSolution = new Solution();

                    tmpSolution.classID = tmpClassID;
                    tmpSolution.instanceName = tmpInstance.getURI();
                    tmpSolution.id = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "id")).asLiteral().getValue().toString();
                    tmpSolution.hasSolutionName = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "hasSolutionName")).asLiteral().getValue().toString();
                    /*tmpSolution.hasSolutionDescription = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "hasSolutionDescription")).asLiteral().getValue().toString();
                    String tmpFreeAllowedNrOfInvocations = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "freeAllowedNrOfInvocations")).asLiteral().getValue().toString();
                    if(tmpFreeAllowedNrOfInvocations.length() > 0)
                        tmpSolution.freeAllowedNrOfInvocations = Integer.parseInt(tmpFreeAllowedNrOfInvocations);
                    String tmpHasCost = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "hasCost")).asLiteral().getValue().toString();
                    if(tmpHasCost.length() > 0)
                        tmpSolution.hasCost = Double.parseDouble(tmpHasCost);
                    tmpSolution.preferredLang = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "preferredLang")).asLiteral().getValue().toString();
                    tmpSolution.speechRate = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "speechRate")).asLiteral().getValue().toString();
                    tmpSolution.hasSolutionSpecificSetting = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "hasSolutionSpecificSetting")).asLiteral().getValue().toString();
                    tmpSolution.hasSolutionVendor = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "hasSolutionVendor")).asLiteral().getValue().toString();
                    tmpSolution.runsOnDevice = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "runsOnDevice")).asLiteral().getValue().toString();
                    tmpSolution.runsOnPlatform = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "runsOnPlatform")).asLiteral().getValue().toString();
                    tmpSolution.hasCostCurrency = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "hasCostCurrency")).asLiteral().getValue().toString();
                    tmpSolution.hasSolutionVersion = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "hasSolutionVersion")).asLiteral().getValue().toString();
                    */
                    allInstances_Solution.add(tmpSolution);
                    
                    res = res + "\n\n" + tmpSolution.toString();
                }
            }
        }
        return res;
    }
    
    public String getInstancesAfterRulesExecution()
    {
        OntologyManager.getInstance().allInstances_TempHandicapSituation.clear();
        OntologyManager.getInstance().allInstances_TempPossibleSolution.clear();
        OntologyManager.getInstance().allInstances_TempSolutionsToBeLaunched.clear();
        
        String res = "";
        ExtendedIterator classes = model.listClasses();
        
        while(classes.hasNext())
        {
            OntClass tmpClass = (OntClass)classes.next();
            
            int tmpClassID = -1;
            if(tmpClass != null)
                tmpClassID = getClassIDByName(tmpClass.getLocalName());
            
            if(tmpClassID == TempHandicapSituations_ID
                    || tmpClassID == TempPossibleSolutions_ID
                    || tmpClassID == TempSolutionsToBeLaunched_ID)
            {
                ExtendedIterator instances = tmpClass.listInstances();
                
                while(instances.hasNext())
                {
                    Individual tmpInstance = (Individual)instances.next();
                    
                    //----------------------
                    //TempHandicapSituations
                    //----------------------
                    if(tmpClassID == TempHandicapSituations_ID)
                    {
                        TempHandicapSituation tmpTempHandicapSituation = new TempHandicapSituation();

                        if(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempHandicapSituations_problemWithFontSize")) != null)
                            tmpTempHandicapSituation.problemWithFontSize = Boolean.parseBoolean(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempHandicapSituations_problemWithFontSize")).asLiteral().getValue().toString());
                        if(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempHandicapSituations_problemWithMagnification")) != null)
                            tmpTempHandicapSituation.problemWithMagnification = Boolean.parseBoolean(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempHandicapSituations_problemWithMagnification")).asLiteral().getValue().toString());
                        if(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempHandicapSituations_problemWithForegroundAndBackgroundColor")) != null)
                            tmpTempHandicapSituation.problemWithForegroundAndBackgroundColor = Boolean.parseBoolean(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempHandicapSituations_problemWithForegroundAndBackgroundColor")).asLiteral().getValue().toString());
                        if(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempHandicapSituations_problemWithScreenReaderAndGnome")) != null)
                            tmpTempHandicapSituation.problemWithScreenReaderAndGnome = Boolean.parseBoolean(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempHandicapSituations_problemWithScreenReaderAndGnome")).asLiteral().getValue().toString());
                        if(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempHandicapSituations_problemWithHighContrast")) != null)
                            tmpTempHandicapSituation.problemWithHighContrast = Boolean.parseBoolean(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempHandicapSituations_problemWithHighContrast")).asLiteral().getValue().toString());
                        if(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempHandicapSituations_problemWithMagnifierFullScreen")) != null)
                            tmpTempHandicapSituation.problemWithMagnifierFullScreen = Boolean.parseBoolean(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempHandicapSituations_problemWithMagnifierFullScreen")).asLiteral().getValue().toString());

                        allInstances_TempHandicapSituation.add(tmpTempHandicapSituation);
                    }
                    //---------------------
                    //TempPossibleSolutions
                    //---------------------
                    else if(tmpClassID == TempPossibleSolutions_ID)
                    {
                        TempPossibleSolution tmpTempPossibleSolution = new TempPossibleSolution();

                        if(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempPossibleSolutions_text")) != null)
                            tmpTempPossibleSolution.text = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempPossibleSolutions_text")).asLiteral().getValue().toString();
                        if(tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempPossibleSolutions_comment")) != null)
                            tmpTempPossibleSolution.comment = tmpInstance.getPropertyValue(model.getProperty(InstantiationManager.NS, "TempPossibleSolutions_comment")).asLiteral().getValue().toString();

                        allInstances_TempPossibleSolution.add(tmpTempPossibleSolution);
                    }
                    //---------------------
                    //TempSolutionsToBeLaunched
                    //---------------------
                    else if(tmpClassID == TempSolutionsToBeLaunched_ID)
                    {
                        TempSolutionsToBeLaunched tmpTempSolutionsToBeLaunched = new TempSolutionsToBeLaunched();
                        String IDsToBeLaunched = "";
                        StmtIterator it = tmpInstance.listProperties(model.getProperty(InstantiationManager.NS, "TempSolutionsToBeLaunched_IDs"));
                        while(it.hasNext())
                        {
                            Statement stmt = it.nextStatement();
                            IDsToBeLaunched = IDsToBeLaunched + getSolutionIDFromInstanceName(stmt.getObject().toString()) + " ";
                        }
                        tmpTempSolutionsToBeLaunched.IDs = IDsToBeLaunched;
                        allInstances_TempSolutionsToBeLaunched.add(tmpTempSolutionsToBeLaunched);
                    }
                }
            }
        }
        return res;
    }
    
    public String getInstanceNameBySolutionID(String tmpID)
    {
        String res = "not found!";
        
        if(allInstances_Solution != null)
        {
            for(int i=0; i<allInstances_Solution.size(); i++)
            {
                Solution tmpSolution = allInstances_Solution.get(i);
                if(tmpSolution.id!=null && tmpSolution.id.length()>0
                        && tmpSolution.id.toLowerCase().equals(tmpID.toLowerCase()))
                {
                    return tmpSolution.instanceName;
                }
            }
        }
        return res;
    }
    
    public String getSolutionIDFromInstanceName(String tmpInstanceName)
    {
        String res = "not found!";
        
        if(allInstances_Solution != null)
        {
            for(int i=0; i<allInstances_Solution.size(); i++)
            {
                Solution tmpSolution = allInstances_Solution.get(i);
                if(tmpSolution.instanceName!=null && tmpSolution.instanceName.length()>0
                        && tmpSolution.instanceName.equals(tmpInstanceName))
                {
                    return tmpSolution.id;
                }
            }
        }
        return res;
    }
}