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

# ------------------------------ Build Avatar
Avatar.class: Avatar.java Potion.java Defence.java Weapon.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) Avatar.java

Avatar: Avatar.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build BattleLoop
BattleLoop.class: BattleLoop.java GameLoop.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) BattleLoop.java

BattleLoop: BattleLoop.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build Defence
Defence.class: Defence.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) Defence.java

Defence: Defence.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build Enemy
Enemy.class: Enemy.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) Enemy.java

Enemy: Enemy.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build GameLoop
GameLoop.class: GameLoop.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) GameLoop.java

GameLoop: GameLoop.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build GameBoard
GameBoard.class: GameBoard.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) GameBoard.java

GameBoard: GameBoard.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build Location
Location.class: Location.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) Location.java

Location: Location.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build MainMenu
MainMenu.class: MainMenu.java GameLoop.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) MainMenu.java

MainMenu: MainMenu.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build Player
Player.class: Player.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) Player.java

Player: Player.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build Potion
Potion.class: Potion.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) Potion.java

Potion: Potion.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build PrintLegend
PrintLegend.class: PrintLegend.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) PrintLegend.java

PrintLegend: PrintLegend.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build Sprite
Sprite.class: Sprite.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) Sprite.java

Sprite: Sprite.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build Weapon
Weapon.class: Weapon.java
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) Weapon.java

Weapon: Weapon.class
	$(ECHO) $(RESPONSE) $@
	$(RUN) $@

# ------------------------------ Build All
all.class: $(SRC)
	$(ECHO) $(RESPONSE) $@
	$(JCC) $(JFLAGS) $(SRC)

all: $(OBJ)
	$(ECHO) $(RESPONSE) $@
	$(RUN) MainMenu

clean:
	$(ECHO) Destroying $(OBJ)
	rm $(OBJ)

.PHONY: depend clean
