#!/bin/bash
javac -cp .:../build/classes/main TicTacToeKeywords.java
java -cp .:../build/classes/main:/Users/katiewood/Documents/CS310Programs/robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeTests.txt

