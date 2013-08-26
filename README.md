Rule-based Matchmaker
================

A server app built to be deployed with node.js server based on Kettle that
matches solution records to user needs and preferences.

The Rule-based Matchmaker operates by executing [Kettle](http://wiki.fluidproject.org/display/fluid/Kettle).

### Dependencies

[universal](https://github.com/GPII/universal)

Installation instructions:
-

Firstly, install node and npm.

Run the following command in your newly checked out Rule-based Matchmaker
repository. This will install all dependencies that are required by the Rule-based
Matchmaker.

    npm install
	
Then build the RuleBasedMatchMaker:

1) Download Apache Maven from http://maven.apache.org/ and install it

2) In "lib" directory run "mvn clean install"

### Rule-based Matchmaker API

The Rule-based Matchmaker currently supports the following urls:

    {url_to_a_sample_matchmaker_server}/match // POST

To run the rule-based matchmaker, simply type:

    [NODE_ENV={environment}] bin/ruleBasedMatchMaker [path/to/ruleBasedMatchMaker/configs/folder]

- Default environment is development.
- Path to configs folder can be absolute or relative to the current user directory.

For example:

    bin/ruleBasedMatchMaker
    bin/ruleBasedMatchMaker /Users/{userName}/ruleBasedMatchMaker/configs/
    NODE_ENV=production bin/ruleBasedMatchMaker configs/
