package com.iti.cloud4all.inference;
/**
 *
 * @author nkak
 */

import com.hp.hpl.jena.rdf.model.InfModel;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.reasoner.rulesys.GenericRuleReasoner;
import com.hp.hpl.jena.reasoner.rulesys.Rule;
import com.iti.cloud4all.ontology.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class RulesManager 
{
    public Model m;
    public BufferedReader br;
    
    String uri_MatchMaker_rules;
    
    private static RulesManager instance = null;
    
    private RulesManager() 
    {
        m = ModelFactory.createDefaultModel();
        
        String currentDir = System.getProperty("user.dir");
        //uri_MatchMaker_rules = currentDir + "/../node_modules/universal/gpii/node_modules/matchMaker/src/RB_MM/extra-resources/MatchMakerRules.rules";
        uri_MatchMaker_rules = currentDir + "/lib/RB_MM/extra-resources/MatchMakerRules.rules";
    }
    
    public static RulesManager getInstance() 
    {
        if(instance == null) 
            instance = new RulesManager();
        return instance;
    }
    
    public String executeMyCloudRulesForFindingHandicapSituations()
    {
        String res = "";
        String resultForNodeJs = "";

//DEBUG        
        res = res + "\n\nINSTANCES BEFORE RULES EXECUTION:";
        
        //get TempUsers
        ArrayList<TempUser> allInstances_TempUsers = OntologyManager.getInstance().getInstances(OntologyManager.TempUsers_ID);
        if(allInstances_TempUsers != null)
        {
            for(int i=0; i<allInstances_TempUsers.size(); i++)
                res = res + allInstances_TempUsers.get(i).toString();
        }
        else
            res = res + "\tThere are no User instances!";
        //get TempEnvironment
        ArrayList<TempEnvironment> allInstances_TempEnvironment = OntologyManager.getInstance().getInstances(OntologyManager.TempEnvironment_ID);
        if(allInstances_TempEnvironment != null)
        {
            for(int i=0; i<allInstances_TempEnvironment.size(); i++)
                res = res + allInstances_TempEnvironment.get(i).toString();
        }
        else
            res = res + "\tThere are no Environment instances!";
        
        //get TempHandicapSituations
        ArrayList<TempHandicapSituation> allInstances_TempHandicapSituations = OntologyManager.getInstance().getInstances(OntologyManager.TempHandicapSituations_ID);
        if(allInstances_TempHandicapSituations != null)
        {
            for(int i=0; i<allInstances_TempHandicapSituations.size(); i++)
                res = res + allInstances_TempHandicapSituations.get(i).toString();
        }
        else
            res = res + "\tThere are no HandicapSituation instances!";
        
        //get TempPossibleSolutions
        ArrayList<TempPossibleSolution> allInstances_TempPossibleSolutions = OntologyManager.getInstance().getInstances(OntologyManager.TempPossibleSolutions_ID);
        if(allInstances_TempPossibleSolutions != null)
        {
            for(int i=0; i<allInstances_TempPossibleSolutions.size(); i++)
                res = res + allInstances_TempPossibleSolutions.get(i).toString();
        }
        else
            res = res + "\tThere are no PossibleSolution instances!";
//-DEBUG       
        res = res + "\nRULES EXECUTION - START";
        List<Rule> rules = Rule.rulesFromURL(uri_MatchMaker_rules);
        GenericRuleReasoner r = new GenericRuleReasoner(rules);
        r.setOWLTranslation(true);           
        r.setTransitiveClosureCaching(true);
        InfModel infmodel = ModelFactory.createInfModel(r, OntologyManager.getInstance().model);
        OntologyManager.getInstance().model.add(infmodel.getDeductionsModel());
        res = res + "RULES EXECUTION - END";
      
        res = res + "\nINSTANCES AFTER RULES EXECUTION:";
        
//DEBUG       
        //get TempUsers
        allInstances_TempUsers = OntologyManager.getInstance().getInstances(OntologyManager.TempUsers_ID);
        if(allInstances_TempUsers != null)
        {
            for(int i=0; i<allInstances_TempUsers.size(); i++)
                res = res + allInstances_TempUsers.get(i).toString();
        }
        else
            res = res + "\tThere are no User instances!";
        
        //get TempEnvironment
        allInstances_TempEnvironment = OntologyManager.getInstance().getInstances(OntologyManager.TempEnvironment_ID);
        if(allInstances_TempEnvironment != null)
        {
            for(int i=0; i<allInstances_TempEnvironment.size(); i++)
                res = res + allInstances_TempEnvironment.get(i).toString();
        }
        else
            res = res + "\tThere are no Environment instances!";
        
        //get TempHandicapSituations
        allInstances_TempHandicapSituations = OntologyManager.getInstance().getInstances(OntologyManager.TempHandicapSituations_ID);
        if(allInstances_TempHandicapSituations != null)
        {
            for(int i=0; i<allInstances_TempHandicapSituations.size(); i++)
                res = res + allInstances_TempHandicapSituations.get(i).toString();
        }
        else
            res = res + "\tThere are no HandicapSituation instances!";
        
        //get TempPossibleSolutions
        allInstances_TempPossibleSolutions = OntologyManager.getInstance().getInstances(OntologyManager.TempPossibleSolutions_ID);
        if(allInstances_TempPossibleSolutions != null)
        {
            for(int i=0; i<allInstances_TempPossibleSolutions.size(); i++)
                res = res + allInstances_TempPossibleSolutions.get(i).toString();
        }
        else
            res = res + "\tThere are no PossibleSolution instances!";
//-DEBUG     
        
        //get TempHandicapSituations
        if(allInstances_TempHandicapSituations != null)
        {
            for(int i=0; i<allInstances_TempHandicapSituations.size(); i++)
            {
                if(allInstances_TempHandicapSituations.get(i).problemWithMagnifierFullScreen)
                {
                    resultForNodeJs = "ENABLE_DEFAULT_THEME ENABLE_MAGNIFIER_WITH_INVERSE_COLOURS";
                    break;
                }
                else if(allInstances_TempHandicapSituations.get(i).problemWithHighContrast)
                {
                    resultForNodeJs = "ENABLE_DEFAULT_THEME ENABLE_MAGNIFIER_WITH_INVERSE_COLOURS";
                    break;
                }
            }
        }

        return resultForNodeJs;
    }
}