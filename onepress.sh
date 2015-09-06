cd /Users/katiewood/Documents/TicTacToe_KW/acceptance/
chmod a+x runacceptance.sh
./runacceptance.sh
cd /Users/katiewood/Documents/TicTacToe_KW/
gradle clean build jacocoTestReport
gradle build
