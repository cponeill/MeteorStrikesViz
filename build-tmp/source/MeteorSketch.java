import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class MeteorSketch extends PApplet {


// LIBRARIES


// GLOBAL VARIABLES
PShape baseMap;
String csv[];
String myData[][];

// SETUP
public void setup() {
  size(1800, 900);
  noLoop();
  baseMap = loadShape("WorldMap.svg");
  csv = loadStrings("Meteor.csv");
  myData = new String[csv.length][6];
  for (int i = 0; i < csv.length; i++) {
    myData[i] = csv[i].split(",");
  }
}

// DRAW
public void draw() {
  shape(baseMap, 0, 0, width, height);
  noStroke();
  fill(255, 0, 0, 50);
  
  for (int i = 0; i < myData.length; i++) {
    float graphLong = map(PApplet.parseFloat(myData[i][3]), -180, 180, 0, width);
    float graphLat = map(PApplet.parseFloat(myData[i][4]), 90, -90, 0, height);
    float markerSize = 0.05f * sqrt(PApplet.parseFloat(myData[i][2])) / PI;
    ellipse(graphLong, graphLat, markerSize, markerSize);
    //println(graphLong + " , " + graphLat);
  }
  
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "MeteorSketch" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
