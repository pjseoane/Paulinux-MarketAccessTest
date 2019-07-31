# Paulinux-MarketAccessTest
About the Project:
Some examples in JAVA about accessing primary's API for ROFEX Exchange.
Author: paulino seoane/ paulinux/ pseoane@balanz.com/ pjseoane@gmail.com
Developing same project in parallel in Python.

Objectives:

1. To give a complete implementation of all the functions provided by the API to access and trade ROFEX markets.
2. Complement REST access with WebSocket protocol in order to get marketdata subscription with real time prices and some bot examples.
3. QuickFix implementation.


This project is developed in JAVA/Maven.
IDE: IntelliJ Community Edition for Linux /Also tested in W10.
Also tested in Netbeans Apache 10.0 for Linux and W10, full compatible in both OS.
JDK Version: 11.0
First time implementation could take some time downloading Maven dependencies.

Project consist of the following packages:
-configuration
-paulinux

1. Package: configuration.
Has a text file in it with some parameters like some urls to connect to, usr and pswd provided by primary, and some example ticker you can play with or change for testing pourposes.
This is done this way in this example just no to play with the code and introduce unwanted errors.

Of course there are several ways to do this in a real implementation.
For example ask for keyboard input to the user on some parameters, this is just an example just to reduce input errors.

2. Package: paulinux
This package contains the code with classes and methods.
MainAccess is the main access point to the system, just select it and play Run.
This Main Class reads the configuration file, initialize fields and execute the methods defined in this example 
RESTSession is the class where all the hard stuff is defined and coded.
This is the file to be completed in the future with all the API functions.

All the information is exchanged between the API and the Application in JSON format.
In MainAccess there are some examples about processing and parsing JSONs and extracting data from it.
Surely this can be improved with some special library, my first goal was to get data parsed out of JSONs 

To Summarize.
The application logs-in to the API and gets the token and displays it.
Then it implements the method that gets all the contracts traded at the exchange
Then it gets specific information about the "ticker" defined in the configuration file.
Finally it gets the last market data available to this ticker, and gets the data Parsed from the JSON in fields defined as double just to be able to use them in any bot.


