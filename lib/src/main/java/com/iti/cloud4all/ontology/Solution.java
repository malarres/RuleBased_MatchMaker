package com.iti.cloud4all.ontology;

/**
 *
 * @author nkak
 */
public class Solution 
{
    //int classID;

    public String instanceName;
    public String hasSolutionName;
    public String id;
    //String hasSolutionDescription;
    //int freeAllowedNrOfInvocations;
    //double hasCost;
    //String preferredLang;
    //String speechRate;
    //String hasSolutionSpecificSetting;
    //String hasSolutionVendor;
    //String runsOnDevice;
    //String runsOnPlatform;
    //String hasCostCurrency;
    //String hasSolutionVersion;

    public Solution()
    {
        //classID = -1;

        instanceName = "";
        hasSolutionName = "";
        id = "";
        //hasSolutionDescription = "";
        //freeAllowedNrOfInvocations = 0;
        //hasCost = 0.0;
        //preferredLang = "";
        //speechRate = "";
        //hasSolutionSpecificSetting = "";
        //hasSolutionVendor = "";
        //runsOnDevice = "";
        //runsOnPlatform = "";
        //hasCostCurrency = "";
        //hasSolutionVersion = "";
    }
    
    public Solution(Solution tmpSolution)
    {
        instanceName = new String(tmpSolution.instanceName);
        hasSolutionName = new String(tmpSolution.hasSolutionName);
        id = new String(tmpSolution.id);
        //hasSolutionDescription = new String(tmpSolution.hasSolutionDescription);
        //freeAllowedNrOfInvocations = new Integer(tmpSolution.freeAllowedNrOfInvocations);
        //hasCost = new Double(tmpSolution.hasCost);
        //preferredLang = new String(tmpSolution.preferredLang);
        //speechRate = new String(tmpSolution.speechRate);
        //hasSolutionSpecificSetting = new String(tmpSolution.hasSolutionSpecificSetting);
        //hasSolutionVendor = new String(tmpSolution.hasSolutionVendor);
        //runsOnDevice = new String(tmpSolution.runsOnDevice);
        //runsOnPlatform = new String(tmpSolution.runsOnPlatform);
        //hasCostCurrency = new String(tmpSolution.hasCostCurrency);
        //hasSolutionVersion = new String(tmpSolution.hasSolutionVendor);
    }

    @Override
    public String toString()
    {
        String result = "";//OntologyManager.getInstance().classNamesAndIDs.get(classID);

        result = result + "\n\tinstanceName: " + instanceName;
        result = result + "\n\thasSolutionName: " + hasSolutionName;
        result = result + "\n\tid: " + id;
        //result = result + "\n\thasSolutionDescription: " + hasSolutionDescription;
        //result = result + "\n\tfreeAllowedNrOfInvocations: " + Integer.toString(freeAllowedNrOfInvocations);
        //result = result + "\n\thasCost: " + Double.toString(hasCost);
        //result = result + "\n\tpreferredLang: " + preferredLang;
        //result = result + "\n\tspeechRate: " + speechRate;
        //result = result + "\n\thasSolutionSpecificSetting: " + hasSolutionSpecificSetting;
        //result = result + "\n\thasSolutionVendor: " + hasSolutionVendor;
        //result = result + "\n\trunsOnDevice: " + runsOnDevice;
        //result = result + "\n\trunsOnPlatform: " + runsOnPlatform;
        //result = result + "\n\thasCostCurrency: " + hasCostCurrency;
        //result = result + "\n\thasSolutionVersion: " + hasSolutionVersion;

        return result;
    }
}
