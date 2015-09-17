#!/bin/bash
#java -cp .:../build/classes/main:/Users/katiewood/Documents/CS310Programs/swinglibrary-1.9.4.jar
#java -cp .:swinglibrary-1.9.4.jar:../build/classes/main:/Users/katiewood/Documents/CS310Programs/robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeGUITests.txt
java -cp .:robotframework-2.9.jar:swinglibrary-1.9.4.jar org.robotframework.RobotFramework TicTacToeGUITests.txt