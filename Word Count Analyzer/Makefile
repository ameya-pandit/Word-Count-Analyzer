#Ameya Pandit
#CruzID: apandit
#This file is the Makefile for Bard.java, a program reads the input file with word length and frequency and finds the appropriate word in shakespeare.txt

# A simple Makefile
Bard: Bard.class
	echo Main-class: Bard > Manifest
	jar cvfm Bard.jar Manifest Bard.class storeValue.class
	rm Manifest

Bard.class: Bard.java
	javac -Xlint Bard.java

clean:
	rm -f Bard.jar Bard.class storeValue.class