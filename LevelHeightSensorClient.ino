#include <ESP8266WiFi.h>
#include "configurations/configKornburg.h"

const char* ssid = wLanSsid;
const char* password = wLanPasswort;

// IPAddress ip(192, 168, 2, 115); //set static ip
 
WiFiServer server(80);

const int trigPin2 = 15;  // D8
const int echoPin2 = 13;  // D7

const int trigPin1 = 5;  // D1
const int echoPin1 = 4;  // D2

void setup() {
  
  pinMode(trigPin1, OUTPUT); // Sets the trigPin1 as an Output
  pinMode(echoPin1, INPUT); // Sets the echoPin1 as an Input
  
  pinMode(trigPin2, OUTPUT); // Sets the trigPin2 as an Output
  pinMode(echoPin2, INPUT); // Sets the echoPin2 as an Input
  
  Serial.begin(9600); // Starts the serial communication

   delay(10);
  
  // Connect to WiFi network
  Serial.println();
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);
 
  WiFi.begin(ssid, password);
 
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected");
 
  // Start the server
  server.begin();
  Serial.println("Server started");
 
  // Print the IP address
  Serial.print("Use this URL to connect: ");
  Serial.print("http://");
  Serial.print(WiFi.localIP());
  Serial.println("/");

}

void loop() {

   // Check if a client has connected
  WiFiClient client = server.available();
  if (!client) {
    return;
  }
 
  // Wait until the client sends some data
  // Serial.println("new client");
  while(!client.available()){
    delay(1);
  }
  client.flush();
 
  // Set ledPin according to the request
  // digitalWrite(ledPin, value);
 
  // Return the response
  client.println("HTTP/1.1 200 OK");
  client.println("Content-Type: text/html");
  client.println(""); //  do not forget this one
  client.println("<!DOCTYPE HTML>");
  client.println("<html>");  
   
  client.print("Distance1 is now ");
  client.print(getDistance(trigPin1, echoPin1));
  client.print(" cm<br>");
 
  client.print("Distance2 is now ");
  client.print(getDistance(trigPin2, echoPin2));
  client.print(" cm<br>");
  
  client.println("</html>");
 
  delay(1);
  Serial.println("Client disonnected");
  Serial.println("");

}

int getDistance(const int trigPin, const int echoPin) {      
  // Clears the trigPin1
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  
  // Sets the trigPin1 on HIGH state for 10 micro seconds
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  
  // Reads the echoPin1, returns the sound wave travel time in microseconds
  // Calculating the distance
  return pulseIn(echoPin, HIGH)*0.034/2;
}

