/*!
GPII Rule Based Matchmaker

Copyright 2013 OCAD University

Licensed under the New BSD license. You may not use this file except in
compliance with this License.

You may obtain a copy of the License at
https://github.com/gpii/universal/LICENSE.txt
*/

var RULES_RESULT;

var client = require('./RBMM_JavaRpcClient');

var instance = new client();

instance.on('message', function(msg){
    "use strict";

    fluid.log('Received a message...');
    fluid.log(msg);
    fluid.log("");
});

instance.on('sent', function(msg){
    "use strict";

    fluid.log('Sent a message...');
    fluid.log(msg);
    fluid.log("");
});

instance.on('Error', function(msg){
    "use strict";

    fluid.log("An error was received!");
    fluid.log(msg.errorMessage);
    fluid.log(msg.stackTrace);
    fluid.log('');

    instance.sendGoodbye();
});

instance.on('Info', function(msg){
    "use strict";

    RULES_RESULT = msg.message;
    fluid.log(msg.message);
    fluid.log("");
});


var fluid = fluid || require("universal");

var matchMaker = fluid.registerNamespace("gpii.matchMaker");
var ruleBased = fluid.registerNamespace("gpii.matchMaker.ruleBased");

fluid.require("./Log.js", require);

var path = require("path");
var when = require("when");
var fs = require('fs');
var $ = fluid.registerNamespace("jQuery");
var gpii = fluid.registerNamespace("gpii");


ruleBased.match = function (callbackWrapper, preferences, solutions, originalModel, strategy) {
    "use strict";

    fluid.log("RULE BASED MATCH MAKER MATCH IS USED");						//debug
	//fluid.log("preferences: ");
	//fluid.log(preferences);
	//fluid.log("solutions: ");
	//fluid.log(solutions);
	//fluid.log("originalModel: ");
	//fluid.log(originalModel);

	// Logging
	gpii.matchMaker.log.inAutoFile(preferences, "RuleMM_ante");

    var inverseTransformations = JSON.parse(fs.readFileSync(path.resolve(__dirname, "inverseRules.json"), "utf8"));
    fluid.each(preferences.applications, function (val, id) {
		var trans = inverseTransformations[id];
		if (trans !== undefined) {
			var new_pref = fluid.model.transformWithRules(val.parameters, trans);
			console.log(JSON.stringify(new_pref));
			$.extend(true, preferences, new_pref);
		}
    });

	return when(CALL_RB_MM(preferences, originalModel.device, callbackWrapper.wrap), function () {
		// Logging
		gpii.matchMaker.log.inAutoFile(preferences, "RuleMM_intermediate");

        return when(gpii.matchMaker.disposeSolutions(preferences, solutions, strategy), function (disposed) {
            var togo = [];
            fluid.each(disposed, function(solrec) {
                if (solrec.disposition === "accept") {
                    togo.push(solrec.solution);
                }
            });
            return togo;
        });
    });
};

function CALL_RB_MM (preferences, device, wrap) {
	"use strict";

	var deferred = when.defer(),
        resolver = deferred.resolver,
        promise = deferred.promise;
	
	// Start communication with Java (the RB-MM)
	// As a first step, Java sends a "hello" message to Node.js
	instance.run();
	
	//Receive acknowledgement of hello
	instance.once('Info', wrap(function()
	{
		//Node.js send user prefs to Java
		instance.sendUserProfile(preferences);
		
		//Node.js gets confirmation message from Java for getting user prefs
		instance.once('Info', wrap(function()
		{
			//Node.js send device reporter payload to Java
			instance.sendDeviceReporterPayload(device);
			//Node.js receives confirmation from Java that device reporter payload has been received
			instance.once('Info', wrap(function()
			{
				//Node.js tells java to run the rules
				instance.sendRunRules("ready for calculations...");
        
				//Node.js receives the final output of the RB-MM
				instance.once('Info', wrap(function()
				{
					//Close connection between Node.js and Java
					instance.sendGoodbye();

					var newPrefsWords=RULES_RESULT.split(" ");
					var i=0;
					for(i=0; i<newPrefsWords.length;i++)
					{
						if(newPrefsWords[i] === "ENABLE_DEFAULT_THEME")
						{
							if(preferences != null && preferences.display != null && preferences.display.screenEnhancement != null)
							{
								preferences.display.screenEnhancement.highContrast = false;
								preferences.display.screenEnhancement["-provisional-magnifierPosition"] = "FullScreen";
							}
							//REMOVE APPLICATION-UNIQUE SETTINGS - WINDOWS
							//if(preferences != null && preferences.applications != null && preferences.applications["com.microsoft.windows.highContrast"] != null)
							//{
							//	delete preferences.applications["com.microsoft.windows.highContrast"];
							//}
							
							//REMOVE APPLICATION-UNIQUE SETTINGS - LINUX							
							//if(preferences != null && preferences.applications != null && preferences.applications["org.gnome.desktop.interface"] != null && preferences.applications["org.gnome.desktop.interface"].parameters != null && preferences.applications["org.gnome.desktop.interface"].parameters["gtk-theme"] != null && preferences.applications["org.gnome.desktop.interface"].parameters["gtk-theme"] == "HighContrast")
							//{
							//	delete preferences.applications["org.gnome.desktop.interface"].parameters["gtk-theme"];
							//}
						}
						else if(newPrefsWords[i] === "ENABLE_MAGNIFIER_WITH_INVERSE_COLOURS")
						{
							if(preferences != null && preferences.display != null && preferences.display.screenEnhancement != null)
							{
								preferences.display.screenEnhancement.invertImages = true;
								if(preferences.display.screenEnhancement.magnification == null)
									preferences.display.screenEnhancement.magnification = 1.0;
							}
							//REMOVE APPLICATION-UNIQUE SETTINGS - WINDOWS
							//if(preferences != null && preferences.applications != null && preferences.applications["com.microsoft.windows.magnifier"] != null && preferences.applications["com.microsoft.windows.magnifier"].parameters != null && preferences.applications["com.microsoft.windows.magnifier"].parameters.MagnificationMode != null)
							//{
							//	delete preferences.applications["com.microsoft.windows.magnifier"].parameters.MagnificationMode;
							//}
							//if(preferences != null && preferences.applications != null && preferences.applications["com.microsoft.windows.magnifier"] != null && preferences.applications["com.microsoft.windows.magnifier"].parameters != null && preferences.applications["com.microsoft.windows.magnifier"].parameters.Invert != null)
							//{
							//	delete preferences.applications["com.microsoft.windows.magnifier"].parameters.Invert;
							//}
							//if(preferences != null && preferences.applications != null && preferences.applications["com.microsoft.windows.magnifier"] != null && preferences.applications["com.microsoft.windows.magnifier"].parameters != null && preferences.applications["com.microsoft.windows.magnifier"].parameters.Magnification != null)
							//{
							//	delete preferences.applications["com.microsoft.windows.magnifier"].parameters.Magnification;
							//}
							
							//REMOVE APPLICATION-UNIQUE SETTINGS - LINUX
							//if(preferences != null && preferences.applications != null && preferences.applications["org.gnome.desktop.a11y.magnifier"] != null && preferences.applications["org.gnome.desktop.a11y.magnifier"].parameters != null && preferences.applications["org.gnome.desktop.a11y.magnifier"].parameters["mag-factor"] != null)							{
							//	delete preferences.applications["org.gnome.desktop.a11y.magnifier"].parameters["mag-factor"];
							//}
							//if(preferences != null && preferences.applications != null && preferences.applications["org.gnome.desktop.a11y.magnifier"] != null && preferences.applications["org.gnome.desktop.a11y.magnifier"].parameters != null && preferences.applications["org.gnome.desktop.a11y.magnifier"].parameters["screen-position"] != null)
							//{
							//	delete preferences.applications["org.gnome.desktop.a11y.magnifier"].parameters["screen-position"];
							//}
						}
					}

					resolver.resolve();
				}));
			}));
		}));
	}));

    return promise;
}
