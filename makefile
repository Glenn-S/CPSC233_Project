# Makefile for the 233 project
#authors: Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton


JCC = javac
RUN = java
SRC = *.java
OBJ = *.class
JFLAGS = -g -Xlint
ECHO = echo
RESPONSE = Building the dependency

#Build rules

# ------------------------------ Build Main
Main.class: Main.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) Main.java

Main: Main.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@
	make clean
# ------------------------------ Build MainTerminal
MainTerminal: Main.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) Main terminal
	make clean

clean:
	$(ECHO) Destroying $(OBJ)
	rm $(OBJ) */$(OBJ)

.PHONY: depend clean
