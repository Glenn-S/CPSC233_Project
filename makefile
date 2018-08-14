# Makefile for the 233 project
#authors: Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton


JCC = javac
RUN = java
SRC = *.java
OBJ = *.class
JFLAGS = -g -Xlint
ECHO = echo
RESPONSE = Building the dependency
JUNIT = javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java
RUNTEST = java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore

#Build rules

# ------------------------------ Build Main
Main.class: Main.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) Main.java

Main: Main.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) Main
	make clean
# ------------------------------ Build MainTerminal
MainTerminal: Main.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) Main terminal
	make clean

# ------------------------------ Build and Run Testing
Tests:
	$(ECHO) Running tests
	$(JUNIT)
	$(RUNTEST) AvatarTest
	$(RUNTEST) BattleLoopTest
	$(RUNTEST) DefenseTest
	$(RUNTEST) EnemyTest
	$(RUNTEST) GameLoopTest
	$(RUNTEST) LocationTest
	$(RUNTEST) PlayerTest
	$(RUNTEST) PotionTest
	$(RUNTEST) SpriteTest
	$(RUNTEST) WeaponTest
	$(ECHO) ******************* TEST COMPLETE *******************m
	make clean

clean:
	$(ECHO) Destroying $(OBJ)
	rm $(OBJ) */$(OBJ)

.PHONY: depend clean
