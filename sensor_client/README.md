# LevelHeightSensorClient
This programm is written to run on a NodeMCU and is meant to send the data of two HC-SR04 distance sensors to a server.

At the startup it connects to the wlan.
Then it gets the location of the 'sensor'-server throught the configuration server.
And then sends all ... seconds a messurement to the sensor server. 

## Configuration
It reads a configuration file which has information about
* Wlan SSID and password
* the location of a configuration server
