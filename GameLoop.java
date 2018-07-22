
import java.util.Scanner;
import java.io.Console;
import java.util.ArrayList;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class GameLoop {

    private ArrayList<Sprite> terrain;
    private ArrayList<Sprite> items;
    private ArrayList<Enemy> enemy;
    private int totalKeys; // total number of keys in the game
    private boolean winState;
    private boolean loseState;

    /*---------------------------- CONSTRUCTORS ------------------------------*/
    public GameLoop() {
        this.terrain = new ArrayList<Sprite>();
        this.items = new ArrayList<Sprite>();
        this.enemy = new ArrayList<Enemy>();
        this.totalKeys = 4; // default value
        this.winState = false;
        this.loseState = false;
    }

    public GameLoop(ArrayList<Sprite> terrain, ArrayList<Sprite> items,
            ArrayList<Enemy> enemy, int totalKeys) {
        this.terrain = (terrain != null) ? terrain : new ArrayList<Sprite>();
        this.items = (items != null) ? items : new ArrayList<Sprite>();
        this.enemy = (enemy != null) ? enemy : new ArrayList<Enemy>();
        this.totalKeys = (totalKeys > 0) ? totalKeys : 4;
        this.winState = false;
        this.loseState = false;
    }

    /*------------------------------- METHODS --------------------------------*/
    /**
     * Purpose: To initialize all of the instance variables for the current game
     * and set the arrays with the Sprites initialized.
     */
    private void initialize() { // get rid of
        //this might not even be necessary?
        // not sure if this is the correct syntax
        //this.terrain.addAll(); // list of objects eg this.terrain.addAll(Sprite(definitions for constructor, etc))
        //this.items.addAll();
        //this.enemy.addAll();
        this.totalKeys = 4;
        this.winState = false;
        this.loseState = false;
        //this.player = new Player(); // maybe need to pass in the users choice for name or not?
    }

<<<<<<< HEAD
    /**
     * Purpose: This function is used to create/set up the enemy array ArrayList
     * every enemy has to be instantiated, and set up individually, then added
     * to the item array ArrayList
     *
     * @param enemy This is the enemy array list. It is passed, which means it
     * is being refrenced. Any changes made to the array list in this function
     * will change the array list outside as well
     */
    public void createEnemyArray(ArrayList<Enemy> enemy) {
        String[] moves = {"up", "down", "left", "right"};

//  Enemy grunt65 = new Enemy(1String name, Location coord, Image spriteImage, char spriteChar, String[] dialogue, boolean exists, boolean overlapsWith, int health, int defence, int attack, String[] moves, boolean key, boolean hasPotion, Potion[] potions);
//  enemy.add(grunt65);
//
//  Enemy grunt5437 = new Enemy(100,100,100,moves,false,true);
//  enemy.add(grunt5437);
//
//  Enemy grunt402 = new Enemy(100,100,100,moves,false,true);
//  enemy.add(grunt402);
//
//  Enemy boss1966 = new Enemy(200,200,200,moves,false,true);
//  enemy.add(boss1966);
    }

    public void createTerrainArray(ArrayList<Sprite> terrain) {
        /*------------------------ROW 0----------------------------------------------*/

        Location b00 = new Location(0, 0, 0, 0);
        Sprite border00 = new Sprite("border", b00, null, '-', null, true, false);
        terrain.add(border00);

        Location b01 = new Location(0, 1, 0, 0);
        Sprite border01 = new Sprite("border", b01, null, '-', null, true, false);
        terrain.add(border01);

        Location b02 = new Location(0, 2, 0, 0);
        Sprite border02 = new Sprite("border", b02, null, '-', null, true, false);
        terrain.add(border02);

        Location b03 = new Location(0, 3, 0, 0);
        Sprite border03 = new Sprite("border", b03, null, '-', null, true, false);
        terrain.add(border03);

        Location b04 = new Location(0, 4, 0, 0);
        Sprite border04 = new Sprite("border", b04, null, '-', null, true, false);
        terrain.add(border04);

        Location b05 = new Location(0, 5, 0, 0);
        Sprite border05 = new Sprite("border", b05, null, '-', null, true, false);
        terrain.add(border05);

        Location b06 = new Location(0, 6, 0, 0);
        Sprite border06 = new Sprite("border", b06, null, '-', null, true, false);
        terrain.add(border06);

        Location b07 = new Location(0, 7, 0, 0);
        Sprite border07 = new Sprite("border", b07, null, '-', null, true, false);
        terrain.add(border07);

        Location b08 = new Location(0, 8, 0, 0);
        Sprite border08 = new Sprite("border", b08, null, '-', null, true, false);
        terrain.add(border08);

        Location b09 = new Location(0, 9, 0, 0);
        Sprite border09 = new Sprite("border", b09, null, '-', null, true, false);
        terrain.add(border09);

        Location b010 = new Location(0, 10, 0, 0);
        Sprite border010 = new Sprite("border", b010, null, '-', null, true, false);
        terrain.add(border010);

        Location b011 = new Location(0, 11, 0, 0);
        Sprite border011 = new Sprite("border", b011, null, '-', null, true, false);
        terrain.add(border011);

        Location b012 = new Location(0, 12, 0, 0);
        Sprite border012 = new Sprite("border", b012, null, '-', null, true, false);
        terrain.add(border012);

        Location b013 = new Location(0, 13, 0, 0);
        Sprite border013 = new Sprite("border", b013, null, '-', null, true, false);
        terrain.add(border013);

        Location b014 = new Location(0, 14, 0, 0);
        Sprite border014 = new Sprite("border", b014, null, '-', null, true, false);
        terrain.add(border014);

        Location b015 = new Location(0, 15, 0, 0);
        Sprite border015 = new Sprite("border", b015, null, '-', null, true, false);
        terrain.add(border015);

        Location b016 = new Location(0, 16, 0, 0);
        Sprite border016 = new Sprite("border", b016, null, '-', null, true, false);
        terrain.add(border016);

        Location b017 = new Location(0, 17, 0, 0);
        Sprite border017 = new Sprite("border", b017, null, '-', null, true, false);
        terrain.add(border017);

        Location b018 = new Location(0, 18, 0, 0);
        Sprite border018 = new Sprite("border", b018, null, '-', null, true, false);
        terrain.add(border018);

        Location b019 = new Location(0, 19, 0, 0);
        Sprite border019 = new Sprite("border", b019, null, '-', null, true, false);
        terrain.add(border019);

        Location b020 = new Location(0, 20, 0, 0);
        Sprite border020 = new Sprite("border", b020, null, '-', null, true, false);
        terrain.add(border020);

        Location b021 = new Location(0, 21, 0, 0);
        Sprite border021 = new Sprite("border", b021, null, '-', null, true, false);
        terrain.add(border021);

        Location b022 = new Location(0, 22, 0, 0);
        Sprite border022 = new Sprite("border", b022, null, '-', null, true, false);
        terrain.add(border022);

        Location b023 = new Location(0, 23, 0, 0);
        Sprite border023 = new Sprite("border", b023, null, '-', null, true, false);
        terrain.add(border023);

        Location b024 = new Location(0, 24, 0, 0);
        Sprite border024 = new Sprite("border", b024, null, '-', null, true, false);
        terrain.add(border024);

        Location b025 = new Location(0, 25, 0, 0);
        Sprite border025 = new Sprite("border", b025, null, '-', null, true, false);
        terrain.add(border025);

        Location b026 = new Location(0, 26, 0, 0);
        Sprite border026 = new Sprite("border", b026, null, '-', null, true, false);
        terrain.add(border026);

        Location b027 = new Location(0, 27, 0, 0);
        Sprite border027 = new Sprite("border", b027, null, '-', null, true, false);
        terrain.add(border027);

        Location b028 = new Location(0, 28, 0, 0);
        Sprite border028 = new Sprite("border", b028, null, '-', null, true, false);
        terrain.add(border028);

        Location b029 = new Location(0, 29, 0, 0);
        Sprite border029 = new Sprite("border", b029, null, '-', null, true, false);
        terrain.add(border029);

        Location b030 = new Location(0, 30, 0, 0);
        Sprite border030 = new Sprite("border", b030, null, '-', null, true, false);
        terrain.add(border030);

        Location b031 = new Location(0, 31, 0, 0);
        Sprite border031 = new Sprite("border", b031, null, '-', null, true, false);
        terrain.add(border031);

        Location b032 = new Location(0, 32, 0, 0);
        Sprite border032 = new Sprite("border", b032, null, '-', null, true, false);
        terrain.add(border032);

        Location b033 = new Location(0, 33, 0, 0);
        Sprite border033 = new Sprite("border", b033, null, '-', null, true, false);
        terrain.add(border033);

        Location b034 = new Location(0, 34, 0, 0);
        Sprite border034 = new Sprite("border", b034, null, '-', null, true, false);
        terrain.add(border034);

        Location b035 = new Location(0, 35, 0, 0);
        Sprite border035 = new Sprite("border", b035, null, '-', null, true, false);
        terrain.add(border035);

        Location b036 = new Location(0, 36, 0, 0);
        Sprite border036 = new Sprite("border", b036, null, '-', null, true, false);
        terrain.add(border036);

        Location b037 = new Location(0, 37, 0, 0);
        Sprite border037 = new Sprite("border", b037, null, '-', null, true, false);
        terrain.add(border037);

        Location b038 = new Location(0, 38, 0, 0);
        Sprite border038 = new Sprite("border", b038, null, '-', null, true, false);
        terrain.add(border038);

        Location b039 = new Location(0, 39, 0, 0);
        Sprite border039 = new Sprite("border", b039, null, '-', null, true, false);
        terrain.add(border039);

        Location b040 = new Location(0, 40, 0, 0);
        Sprite border040 = new Sprite("border", b040, null, '-', null, true, false);
        terrain.add(border040);

        Location b041 = new Location(0, 41, 0, 0);
        Sprite border041 = new Sprite("border", b041, null, '-', null, true, false);
        terrain.add(border041);

        Location b042 = new Location(0, 42, 0, 0);
        Sprite border042 = new Sprite("border", b042, null, '-', null, true, false);
        terrain.add(border042);

        Location b043 = new Location(0, 43, 0, 0);
        Sprite border043 = new Sprite("border", b043, null, '-', null, true, false);
        terrain.add(border043);

        Location b044 = new Location(0, 44, 0, 0);
        Sprite border044 = new Sprite("border", b044, null, '-', null, true, false);
        terrain.add(border044);

        Location b045 = new Location(0, 45, 0, 0);
        Sprite border045 = new Sprite("border", b045, null, '-', null, true, false);
        terrain.add(border045);

        Location b046 = new Location(0, 46, 0, 0);
        Sprite border046 = new Sprite("border", b046, null, '-', null, true, false);
        terrain.add(border046);

        Location b047 = new Location(0, 47, 0, 0);
        Sprite border047 = new Sprite("border", b047, null, '-', null, true, false);
        terrain.add(border047);

        Location b048 = new Location(0, 48, 0, 0);
        Sprite border048 = new Sprite("border", b048, null, '-', null, true, false);
        terrain.add(border048);

        Location b049 = new Location(0, 49, 0, 0);
        Sprite border049 = new Sprite("border", b049, null, '-', null, true, false);
        terrain.add(border049);

        Location b050 = new Location(0, 50, 0, 0);
        Sprite border050 = new Sprite("border", b050, null, '-', null, true, false);
        terrain.add(border050);

        Location b051 = new Location(0, 51, 0, 0);
        Sprite border051 = new Sprite("border", b051, null, '-', null, true, false);
        terrain.add(border051);

        Location b052 = new Location(0, 52, 0, 0);
        Sprite border052 = new Sprite("border", b052, null, '-', null, true, false);
        terrain.add(border052);

        Location b053 = new Location(0, 53, 0, 0);
        Sprite border053 = new Sprite("border", b053, null, '-', null, true, false);
        terrain.add(border053);

        Location b054 = new Location(0, 54, 0, 0);
        Sprite border054 = new Sprite("border", b054, null, '-', null, true, false);
        terrain.add(border054);

        Location b055 = new Location(0, 55, 0, 0);
        Sprite border055 = new Sprite("border", b055, null, '-', null, true, false);
        terrain.add(border055);

        Location b057 = new Location(0, 57, 0, 0);
        Sprite border057 = new Sprite("border", b057, null, '-', null, true, false);
        terrain.add(border057);

        Location b058 = new Location(0, 58, 0, 0);
        Sprite border058 = new Sprite("border", b058, null, '-', null, true, false);
        terrain.add(border058);

        Location b059 = new Location(0, 59, 0, 0);
        Sprite border059 = new Sprite("border", b059, null, '-', null, true, false);
        terrain.add(border059);

        Location b060 = new Location(0, 60, 0, 0);
        Sprite border060 = new Sprite("border", b060, null, '-', null, true, false);
        terrain.add(border060);

        Location b061 = new Location(0, 61, 0, 0);
        Sprite border061 = new Sprite("border", b061, null, '-', null, true, false);
        terrain.add(border061);

        Location b062 = new Location(0, 62, 0, 0);
        Sprite border062 = new Sprite("border", b062, null, '-', null, true, false);
        terrain.add(border062);

        Location b063 = new Location(0, 63, 0, 0);
        Sprite border063 = new Sprite("border", b063, null, '-', null, true, false);
        terrain.add(border063);

        Location b064 = new Location(0, 64, 0, 0);
        Sprite border064 = new Sprite("border", b064, null, '-', null, true, false);
        terrain.add(border064);

        Location b065 = new Location(0, 65, 0, 0);
        Sprite border065 = new Sprite("border", b065, null, '-', null, true, false);
        terrain.add(border065);

        Location b066 = new Location(0, 66, 0, 0);
        Sprite border066 = new Sprite("border", b066, null, '-', null, true, false);
        terrain.add(border066);

        Location b067 = new Location(0, 67, 0, 0);
        Sprite border067 = new Sprite("border", b067, null, '-', null, true, false);
        terrain.add(border067);

        Location b068 = new Location(0, 68, 0, 0);
        Sprite border068 = new Sprite("border", b068, null, '-', null, true, false);
        terrain.add(border068);

        Location b069 = new Location(0, 69, 0, 0);
        Sprite border069 = new Sprite("border", b069, null, '-', null, true, false);
        terrain.add(border069);

        Location b070 = new Location(0, 70, 0, 0);
        Sprite border070 = new Sprite("border", b070, null, '-', null, true, false);
        terrain.add(border070);

        Location b071 = new Location(0, 71, 0, 0);
        Sprite border071 = new Sprite("border", b071, null, '-', null, true, false);
        terrain.add(border071);

        Location b072 = new Location(0, 72, 0, 0);
        Sprite border072 = new Sprite("border", b072, null, '-', null, true, false);
        terrain.add(border072);

        Location b073 = new Location(0, 73, 0, 0);
        Sprite border073 = new Sprite("border", b073, null, '-', null, true, false);
        terrain.add(border073);

        Location b074 = new Location(0, 74, 0, 0);
        Sprite border074 = new Sprite("border", b074, null, '-', null, true, false);
        terrain.add(border074);

        Location b075 = new Location(0, 75, 0, 0);
        Sprite border075 = new Sprite("border", b075, null, '-', null, true, false);
        terrain.add(border075);

        Location b076 = new Location(0, 76, 0, 0);
        Sprite border076 = new Sprite("border", b076, null, '-', null, true, false);
        terrain.add(border076);

        Location b077 = new Location(0, 77, 0, 0);
        Sprite border077 = new Sprite("border", b077, null, '-', null, true, false);
        terrain.add(border077);

        Location b078 = new Location(0, 78, 0, 0);
        Sprite border078 = new Sprite("border", b078, null, '-', null, true, false);
        terrain.add(border078);

        Location b079 = new Location(0, 79, 0, 0);
        Sprite border079 = new Sprite("border", b079, null, '-', null, true, false);
        terrain.add(border079);

        Location b080 = new Location(0, 80, 0, 0);
        Sprite border080 = new Sprite("border", b080, null, '-', null, true, false);
        terrain.add(border080);

        Location b081 = new Location(0, 81, 0, 0);
        Sprite border081 = new Sprite("border", b081, null, '-', null, true, false);
        terrain.add(border081);

        Location b082 = new Location(0, 82, 0, 0);
        Sprite border082 = new Sprite("border", b082, null, '-', null, true, false);
        terrain.add(border082);

        Location b083 = new Location(0, 83, 0, 0);
        Sprite border083 = new Sprite("border", b083, null, '-', null, true, false);
        terrain.add(border083);

        Location b084 = new Location(0, 84, 0, 0);
        Sprite border084 = new Sprite("border", b084, null, '-', null, true, false);
        terrain.add(border084);

        Location b085 = new Location(0, 85, 0, 0);
        Sprite border085 = new Sprite("border", b085, null, '-', null, true, false);
        terrain.add(border085);

        Location b086 = new Location(0, 86, 0, 0);
        Sprite border086 = new Sprite("border", b086, null, '-', null, true, false);
        terrain.add(border086);

        Location b087 = new Location(0, 87, 0, 0);
        Sprite border087 = new Sprite("border", b087, null, '-', null, true, false);
        terrain.add(border087);

        Location b088 = new Location(0, 88, 0, 0);
        Sprite border088 = new Sprite("border", b088, null, '-', null, true, false);
        terrain.add(border088);

        Location b089 = new Location(0, 89, 0, 0);
        Sprite border089 = new Sprite("border", b089, null, '-', null, true, false);
        terrain.add(border089);

        Location b090 = new Location(0, 90, 0, 0);
        Sprite border090 = new Sprite("border", b090, null, '-', null, true, false);
        terrain.add(border090);

        Location b091 = new Location(0, 91, 0, 0);
        Sprite border091 = new Sprite("border", b091, null, '-', null, true, false);
        terrain.add(border091);

        Location b092 = new Location(0, 92, 0, 0);
        Sprite border092 = new Sprite("border", b092, null, '-', null, true, false);
        terrain.add(border092);

        Location b093 = new Location(0, 93, 0, 0);
        Sprite border093 = new Sprite("border", b093, null, '-', null, true, false);
        terrain.add(border093);

        Location b094 = new Location(0, 94, 0, 0);
        Sprite border094 = new Sprite("border", b094, null, '-', null, true, false);
        terrain.add(border094);

        Location b095 = new Location(0, 95, 0, 0);
        Sprite border095 = new Sprite("border", b095, null, '-', null, true, false);
        terrain.add(border095);

        Location b096 = new Location(0, 96, 0, 0);
        Sprite border096 = new Sprite("border", b096, null, '-', null, true, false);
        terrain.add(border096);

        Location b097 = new Location(0, 97, 0, 0);
        Sprite border097 = new Sprite("border", b097, null, '-', null, true, false);
        terrain.add(border097);

        Location b098 = new Location(0, 98, 0, 0);
        Sprite border098 = new Sprite("border", b098, null, '-', null, true, false);
        terrain.add(border098);

        Location b099 = new Location(0, 99, 0, 0);
        Sprite border099 = new Sprite("border", b099, null, '-', null, true, false);
        terrain.add(border099);

        Location b0100 = new Location(0, 100, 0, 0);
        Sprite border0100 = new Sprite("border", b0100, null, '-', null, true, false);
        terrain.add(border0100);

        Location b0101 = new Location(0, 101, 0, 0);
        Sprite border0101 = new Sprite("border", b0101, null, '-', null, true, false);
        terrain.add(border0101);

        Location b0102 = new Location(0, 102, 0, 0);
        Sprite border0102 = new Sprite("border", b0102, null, '-', null, true, false);
        terrain.add(border0102);

        Location b0103 = new Location(0, 103, 0, 0);
        Sprite border0103 = new Sprite("border", b0103, null, '-', null, true, false);
        terrain.add(border0103);

        Location b0104 = new Location(0, 104, 0, 0);
        Sprite border0104 = new Sprite("border", b0104, null, '-', null, true, false);
        terrain.add(border0104);

        Location b0105 = new Location(0, 105, 0, 0);
        Sprite border0105 = new Sprite("border", b0105, null, '-', null, true, false);
        terrain.add(border0105);

        Location b0106 = new Location(0, 106, 0, 0);
        Sprite border0106 = new Sprite("border", b0106, null, '-', null, true, false);
        terrain.add(border0106);

        Location b0107 = new Location(0, 107, 0, 0);
        Sprite border0107 = new Sprite("border", b0107, null, '-', null, true, false);
        terrain.add(border0107);

        Location b0108 = new Location(0, 108, 0, 0);
        Sprite border0108 = new Sprite("border", b0108, null, '-', null, true, false);
        terrain.add(border0108);

        Location b0109 = new Location(0, 109, 0, 0);
        Sprite border0109 = new Sprite("border", b0109, null, '-', null, true, false);
        terrain.add(border0109);

        Location b0110 = new Location(0, 110, 0, 0);
        Sprite border0110 = new Sprite("border", b0110, null, '-', null, true, false);
        terrain.add(border0110);

        Location b0111 = new Location(0, 111, 0, 0);
        Sprite border0111 = new Sprite("border", b0111, null, '-', null, true, false);
        terrain.add(border0111);

        Location b0112 = new Location(0, 112, 0, 0);
        Sprite border0112 = new Sprite("border", b0112, null, '-', null, true, false);
        terrain.add(border0112);

        Location b0113 = new Location(0, 113, 0, 0);
        Sprite border0113 = new Sprite("border", b0113, null, '-', null, true, false);
        terrain.add(border0113);

        Location b0114 = new Location(0, 114, 0, 0);
        Sprite border0114 = new Sprite("border", b0114, null, '-', null, true, false);
        terrain.add(border0114);

        Location b0115 = new Location(0, 115, 0, 0);
        Sprite border0115 = new Sprite("border", b0115, null, '-', null, true, false);
        terrain.add(border0115);

        Location b0116 = new Location(0, 116, 0, 0);
        Sprite border0116 = new Sprite("border", b0116, null, '-', null, true, false);
        terrain.add(border0116);

        Location b0117 = new Location(0, 117, 0, 0);
        Sprite border0117 = new Sprite("border", b0117, null, '-', null, true, false);
        terrain.add(border0117);

        Location b0118 = new Location(0, 118, 0, 0);
        Sprite border0118 = new Sprite("border", b0118, null, '-', null, true, false);
        terrain.add(border0118);

        Location b0119 = new Location(0, 119, 0, 0);
        Sprite border0119 = new Sprite("border", b0119, null, '-', null, true, false);
        terrain.add(border0119);

        Location b0120 = new Location(0, 120, 0, 0);
        Sprite border0120 = new Sprite("border", b0120, null, '-', null, true, false);
        terrain.add(border0120);

        Location b0121 = new Location(0, 121, 0, 0);
        Sprite border0121 = new Sprite("border", b0121, null, '-', null, true, false);
        terrain.add(border0121);

        Location b0122 = new Location(0, 122, 0, 0);
        Sprite border0122 = new Sprite("border", b0122, null, '-', null, true, false);
        terrain.add(border0122);

        Location b0123 = new Location(0, 123, 0, 0);
        Sprite border0123 = new Sprite("border", b0123, null, '-', null, true, false);
        terrain.add(border0123);

        Location b0124 = new Location(0, 124, 0, 0);
        Sprite border0124 = new Sprite("border", b0124, null, '-', null, true, false);
        terrain.add(border0124);

        Location b0125 = new Location(0, 125, 0, 0);
        Sprite border0125 = new Sprite("border", b0125, null, '-', null, true, false);
        terrain.add(border0125);

        Location b0126 = new Location(0, 126, 0, 0);
        Sprite border0126 = new Sprite("border", b0126, null, '-', null, true, false);
        terrain.add(border0126);

        Location b0127 = new Location(0, 127, 0, 0);
        Sprite border0127 = new Sprite("border", b0127, null, '-', null, true, false);
        terrain.add(border0127);

        Location b0128 = new Location(0, 128, 0, 0);
        Sprite border0128 = new Sprite("border", b0128, null, '-', null, true, false);
        terrain.add(border0128);

        Location b0129 = new Location(0, 129, 0, 0);
        Sprite border0129 = new Sprite("border", b0129, null, '-', null, true, false);
        terrain.add(border0129);

        Location b0130 = new Location(0, 130, 0, 0);
        Sprite border0130 = new Sprite("border", b0130, null, '-', null, true, false);
        terrain.add(border0130);

        Location b0131 = new Location(0, 131, 0, 0);
        Sprite border0131 = new Sprite("border", b0131, null, '-', null, true, false);
        terrain.add(border0131);

        Location b0132 = new Location(0, 132, 0, 0);
        Sprite border0132 = new Sprite("border", b0132, null, '-', null, true, false);
        terrain.add(border0132);

        Location b0133 = new Location(0, 133, 0, 0);
        Sprite border0133 = new Sprite("border", b0133, null, '-', null, true, false);
        terrain.add(border0133);

        Location b0134 = new Location(0, 134, 0, 0);
        Sprite border0134 = new Sprite("border", b0134, null, '-', null, true, false);
        terrain.add(border0134);

        Location b0135 = new Location(0, 135, 0, 0);
        Sprite border0135 = new Sprite("border", b0135, null, '-', null, true, false);
        terrain.add(border0135);

        Location b0136 = new Location(0, 136, 0, 0);
        Sprite border0136 = new Sprite("border", b0136, null, '-', null, true, false);
        terrain.add(border0136);

        Location b0137 = new Location(0, 137, 0, 0);
        Sprite border0137 = new Sprite("border", b0137, null, '-', null, true, false);
        terrain.add(border0137);

        Location b0138 = new Location(0, 138, 0, 0);
        Sprite border0138 = new Sprite("border", b0138, null, '-', null, true, false);
        terrain.add(border0138);

        Location b0139 = new Location(0, 139, 0, 0);
        Sprite border0139 = new Sprite("border", b0139, null, '-', null, true, false);
        terrain.add(border0139);

        Location b0140 = new Location(0, 140, 0, 0);
        Sprite border0140 = new Sprite("border", b0140, null, '-', null, true, false);
        terrain.add(border0140);

        Location b0141 = new Location(0, 141, 0, 0);
        Sprite border0141 = new Sprite("border", b0141, null, '-', null, true, false);
        terrain.add(border0141);

        Location b0142 = new Location(0, 142, 0, 0);
        Sprite border0142 = new Sprite("border", b0142, null, '-', null, true, false);
        terrain.add(border0142);

        Location b0143 = new Location(0, 143, 0, 0);
        Sprite border0143 = new Sprite("border", b0143, null, '-', null, true, false);
        terrain.add(border0143);

        Location b0144 = new Location(0, 144, 0, 0);
        Sprite border0144 = new Sprite("border", b0144, null, '-', null, true, false);
        terrain.add(border0144);

        Location b0145 = new Location(0, 145, 0, 0);
        Sprite border0145 = new Sprite("border", b0145, null, '-', null, true, false);
        terrain.add(border0145);

        Location b0146 = new Location(0, 146, 0, 0);
        Sprite border0146 = new Sprite("border", b0146, null, '-', null, true, false);
        terrain.add(border0146);

        Location b0147 = new Location(0, 147, 0, 0);
        Sprite border0147 = new Sprite("border", b0147, null, '-', null, true, false);
        terrain.add(border0147);

        Location b0148 = new Location(0, 148, 0, 0);
        Sprite border0148 = new Sprite("border", b0148, null, '-', null, true, false);
        terrain.add(border0148);

        Location b0149 = new Location(0, 149, 0, 0);
        Sprite border0149 = new Sprite("border", b0149, null, '-', null, true, false);
        terrain.add(border0149);

        Location b0150 = new Location(0, 150, 0, 0);
        Sprite border0150 = new Sprite("border", b0150, null, '-', null, true, false);
        terrain.add(border0150);

        Location b0151 = new Location(0, 151, 0, 0);
        Sprite border0151 = new Sprite("border", b0151, null, '-', null, true, false);
        terrain.add(border0151);

        Location b0152 = new Location(0, 152, 0, 0);
        Sprite border0152 = new Sprite("border", b0152, null, '-', null, true, false);
        terrain.add(border0152);

        Location b0153 = new Location(0, 153, 0, 0);
        Sprite border0153 = new Sprite("border", b0153, null, '-', null, true, false);
        terrain.add(border0153);

        Location b0154 = new Location(0, 154, 0, 0);
        Sprite border0154 = new Sprite("border", b0154, null, '-', null, true, false);
        terrain.add(border0154);

        Location b0155 = new Location(0, 155, 0, 0);
        Sprite border0155 = new Sprite("border", b0155, null, '-', null, true, false);
        terrain.add(border0155);

        Location b0156 = new Location(0, 156, 0, 0);
        Sprite border0156 = new Sprite("border", b0156, null, '-', null, true, false);
        terrain.add(border0156);

        Location b0157 = new Location(0, 157, 0, 0);
        Sprite border0157 = new Sprite("border", b0157, null, '-', null, true, false);
        terrain.add(border0157);

        Location b0158 = new Location(0, 158, 0, 0);
        Sprite border0158 = new Sprite("border", b0158, null, '-', null, true, false);
        terrain.add(border0158);

        Location b0159 = new Location(0, 159, 0, 0);
        Sprite border0159 = new Sprite("border", b0159, null, '-', null, true, false);
        terrain.add(border0159);

        Location b0160 = new Location(0, 160, 0, 0);
        Sprite border0160 = new Sprite("border", b0160, null, '-', null, true, false);
        terrain.add(border0160);

        Location b0161 = new Location(0, 161, 0, 0);
        Sprite border0161 = new Sprite("border", b0161, null, '-', null, true, false);
        terrain.add(border0161);

        Location b0162 = new Location(0, 162, 0, 0);
        Sprite border0162 = new Sprite("border", b0162, null, '-', null, true, false);
        terrain.add(border0162);

        Location b0163 = new Location(0, 163, 0, 0);
        Sprite border0163 = new Sprite("border", b0163, null, '-', null, true, false);
        terrain.add(border0163);

        Location b0164 = new Location(0, 164, 0, 0);
        Sprite border0164 = new Sprite("border", b0164, null, '-', null, true, false);
        terrain.add(border0164);

        Location b0165 = new Location(0, 165, 0, 0);
        Sprite border0165 = new Sprite("border", b0165, null, '-', null, true, false);
        terrain.add(border0165);

        Location b0166 = new Location(0, 166, 0, 0);
        Sprite border0166 = new Sprite("border", b0166, null, '-', null, true, false);
        terrain.add(border0166);

        Location b0167 = new Location(0, 167, 0, 0);
        Sprite border0167 = new Sprite("border", b0167, null, '-', null, true, false);
        terrain.add(border0167);

        Location b0168 = new Location(0, 168, 0, 0);
        Sprite border0168 = new Sprite("border", b0168, null, '-', null, true, false);
        terrain.add(border0168);

        Location b0169 = new Location(0, 169, 0, 0);
        Sprite border0169 = new Sprite("border", b0169, null, '-', null, true, false);
        terrain.add(border0169);

        Location b0170 = new Location(0, 170, 0, 0);
        Sprite border0170 = new Sprite("border", b0170, null, '-', null, true, false);
        terrain.add(border0170);

        Location b0171 = new Location(0, 171, 0, 0);
        Sprite border0171 = new Sprite("border", b0171, null, '-', null, true, false);
        terrain.add(border0171);

        Location b0172 = new Location(0, 172, 0, 0);
        Sprite border0172 = new Sprite("border", b0172, null, '-', null, true, false);
        terrain.add(border0172);

        Location b0173 = new Location(0, 173, 0, 0);
        Sprite border0173 = new Sprite("border", b0173, null, '-', null, true, false);
        terrain.add(border0173);

        Location b0174 = new Location(0, 174, 0, 0);
        Sprite border0174 = new Sprite("border", b0174, null, '-', null, true, false);
        terrain.add(border0174);

        Location b0175 = new Location(0, 175, 0, 0);
        Sprite border0175 = new Sprite("border", b0175, null, '-', null, true, false);
        terrain.add(border0175);

        Location b0176 = new Location(0, 176, 0, 0);
        Sprite border0176 = new Sprite("border", b0176, null, '-', null, true, false);
        terrain.add(border0176);

        Location b0177 = new Location(0, 177, 0, 0);
        Sprite border0177 = new Sprite("border", b0177, null, '-', null, true, false);
        terrain.add(border0177);

        Location b0178 = new Location(0, 178, 0, 0);
        Sprite border0178 = new Sprite("border", b0178, null, '-', null, true, false);
        terrain.add(border0178);

        Location b0179 = new Location(0, 179, 0, 0);
        Sprite border0179 = new Sprite("border", b0179, null, '-', null, true, false);
        terrain.add(border0179);

        Location b0180 = new Location(0, 180, 0, 0);
        Sprite border0180 = new Sprite("border", b0180, null, '-', null, true, false);
        terrain.add(border0180);

        Location b0181 = new Location(0, 181, 0, 0);
        Sprite border0181 = new Sprite("border", b0181, null, '-', null, true, false);
        terrain.add(border0181);

        Location b0182 = new Location(0, 182, 0, 0);
        Sprite border0182 = new Sprite("border", b0182, null, '-', null, true, false);
        terrain.add(border0182);

        Location b0183 = new Location(0, 183, 0, 0);
        Sprite border0183 = new Sprite("border", b0183, null, '-', null, true, false);
        terrain.add(border0183);

        Location b0184 = new Location(0, 184, 0, 0);
        Sprite border0184 = new Sprite("border", b0184, null, '-', null, true, false);
        terrain.add(border0184);

        Location b0185 = new Location(0, 185, 0, 0);
        Sprite border0185 = new Sprite("border", b0185, null, '-', null, true, false);
        terrain.add(border0185);

        Location b0186 = new Location(0, 186, 0, 0);
        Sprite border0186 = new Sprite("border", b0186, null, '-', null, true, false);
        terrain.add(border0186);

        Location b0187 = new Location(0, 187, 0, 0);
        Sprite border0187 = new Sprite("border", b0187, null, '-', null, true, false);
        terrain.add(border0187);

        Location b0188 = new Location(0, 188, 0, 0);
        Sprite border0188 = new Sprite("border", b0188, null, '-', null, true, false);
        terrain.add(border0188);

        Location b0189 = new Location(0, 189, 0, 0);
        Sprite border0189 = new Sprite("border", b0189, null, '-', null, true, false);
        terrain.add(border0189);

        Location b0190 = new Location(0, 190, 0, 0);
        Sprite border0190 = new Sprite("border", b0190, null, '-', null, true, false);
        terrain.add(border0190);

        Location b0191 = new Location(0, 191, 0, 0);
        Sprite border0191 = new Sprite("border", b0191, null, '-', null, true, false);
        terrain.add(border0191);

        Location b0192 = new Location(0, 192, 0, 0);
        Sprite border0192 = new Sprite("border", b0192, null, '-', null, true, false);
        terrain.add(border0192);

        Location b0193 = new Location(0, 193, 0, 0);
        Sprite border0193 = new Sprite("border", b0193, null, '-', null, true, false);
        terrain.add(border0193);

        Location b0194 = new Location(0, 194, 0, 0);
        Sprite border0194 = new Sprite("border", b0194, null, '-', null, true, false);
        terrain.add(border0194);

        Location b0195 = new Location(0, 195, 0, 0);
        Sprite border0195 = new Sprite("border", b0195, null, '-', null, true, false);
        terrain.add(border0195);

        Location b0196 = new Location(0, 196, 0, 0);
        Sprite border0196 = new Sprite("border", b0196, null, '-', null, true, false);
        terrain.add(border0196);

        Location b0197 = new Location(0, 197, 0, 0);
        Sprite border0197 = new Sprite("border", b0197, null, '-', null, true, false);
        terrain.add(border0197);

        Location b0198 = new Location(0, 198, 0, 0);
        Sprite border0198 = new Sprite("border", b0198, null, '-', null, true, false);
        terrain.add(border0198);

        Location b0199 = new Location(0, 199, 0, 0);
        Sprite border0199 = new Sprite("border", b0199, null, '-', null, true, false);
        terrain.add(border0199);

        /**
         * -----------------------ROW 1----------------------------------------------
         */
        Location b10 = new Location(1, 0, 0, 0);
        Sprite border10 = new Sprite("border", b10, null, '|', null, true, false);
        terrain.add(border10);

        Location g11 = new Location(1, 1, 0, 0);
        Sprite grass11 = new Sprite("grass", g11, null, ' ', null, true, false);
        terrain.add(grass11);

        Location g12 = new Location(1, 2, 0, 0);
        Sprite grass12 = new Sprite("grass", g12, null, ' ', null, true, false);
        terrain.add(grass12);

        Location g13 = new Location(1, 3, 0, 0);
        Sprite grass13 = new Sprite("grass", g13, null, ' ', null, true, false);
        terrain.add(grass13);

        Location g14 = new Location(1, 4, 0, 0);
        Sprite grass14 = new Sprite("grass", g14, null, ' ', null, true, false);
        terrain.add(grass14);

        Location g15 = new Location(1, 5, 0, 0);
        Sprite grass15 = new Sprite("grass", g15, null, ' ', null, true, false);
        terrain.add(grass15);

        Location g16 = new Location(1, 6, 0, 0);
        Sprite grass16 = new Sprite("grass", g16, null, ' ', null, true, false);
        terrain.add(grass16);

        Location g17 = new Location(1, 7, 0, 0);
        Sprite grass17 = new Sprite("grass", g17, null, ' ', null, true, false);
        terrain.add(grass17);

        Location g18 = new Location(1, 8, 0, 0);
        Sprite grass18 = new Sprite("grass", g18, null, ' ', null, true, false);
        terrain.add(grass18);

        Location g19 = new Location(1, 9, 0, 0);
        Sprite grass19 = new Sprite("grass", g19, null, ' ', null, true, false);
        terrain.add(grass19);

        Location g110 = new Location(1, 10, 0, 0);
        Sprite grass110 = new Sprite("grass", g110, null, ' ', null, true, false);
        terrain.add(grass110);

        Location g111 = new Location(1, 11, 0, 0);
        Sprite grass111 = new Sprite("grass", g111, null, ' ', null, true, false);
        terrain.add(grass111);

        Location g112 = new Location(1, 12, 0, 0);
        Sprite grass112 = new Sprite("grass", g112, null, ' ', null, true, false);
        terrain.add(grass112);

        Location g113 = new Location(1, 13, 0, 0);
        Sprite grass113 = new Sprite("grass", g113, null, ' ', null, true, false);
        terrain.add(grass113);

        Location g114 = new Location(1, 14, 0, 0);
        Sprite grass114 = new Sprite("grass", g114, null, ' ', null, true, false);
        terrain.add(grass114);

        Location g115 = new Location(1, 15, 0, 0);
        Sprite grass115 = new Sprite("grass", g115, null, ' ', null, true, false);
        terrain.add(grass115);

        Location g116 = new Location(1, 16, 0, 0);
        Sprite grass116 = new Sprite("grass", g116, null, ' ', null, true, false);
        terrain.add(grass116);

        Location g117 = new Location(1, 17, 0, 0);
        Sprite grass117 = new Sprite("grass", g117, null, ' ', null, true, false);
        terrain.add(grass117);

        Location g118 = new Location(1, 18, 0, 0);
        Sprite grass118 = new Sprite("grass", g118, null, ' ', null, true, false);
        terrain.add(grass118);

        Location g119 = new Location(1, 19, 0, 0);
        Sprite grass119 = new Sprite("grass", g119, null, ' ', null, true, false);
        terrain.add(grass119);

        Location g120 = new Location(1, 120, 0, 0);
        Sprite grass120 = new Sprite("grass", g120, null, ' ', null, true, false);
        terrain.add(grass120);

        Location g121 = new Location(1, 121, 0, 0);
        Sprite grass121 = new Sprite("grass", g121, null, ' ', null, true, false);
        terrain.add(grass121);

        Location g122 = new Location(1, 22, 0, 0);
        Sprite grass122 = new Sprite("grass", g122, null, ' ', null, true, false);
        terrain.add(grass122);

        Location g123 = new Location(1, 23, 0, 0);
        Sprite grass123 = new Sprite("grass", g123, null, ' ', null, true, false);
        terrain.add(grass123);

        Location g124 = new Location(1, 24, 0, 0);
        Sprite grass124 = new Sprite("grass", g124, null, ' ', null, true, false);
        terrain.add(grass124);

        Location g125 = new Location(1, 25, 0, 0);
        Sprite grass125 = new Sprite("grass", g125, null, ' ', null, true, false);
        terrain.add(grass125);

        Location g126 = new Location(1, 26, 0, 0);
        Sprite grass126 = new Sprite("grass", g126, null, ' ', null, true, false);
        terrain.add(grass126);

        Location g127 = new Location(1, 27, 0, 0);
        Sprite grass127 = new Sprite("grass", g127, null, ' ', null, true, false);
        terrain.add(grass127);

        Location w128 = new Location(1, 28, 0, 0);
        Sprite water128 = new Sprite("water", w128, null, '/', null, true, false);
        terrain.add(water128);

        Location w129 = new Location(1, 29, 0, 0);
        Sprite water129 = new Sprite("water", w129, null, '~', null, true, false);
        terrain.add(water129);

        Location w130 = new Location(1, 30, 0, 0);
        Sprite water130 = new Sprite("water", w130, null, '~', null, true, false);
        terrain.add(water130);

        Location w131 = new Location(1, 31, 0, 0);
        Sprite water131 = new Sprite("water", w131, null, '~', null, true, false);
        terrain.add(water131);

        Location w132 = new Location(1, 32, 0, 0);
        Sprite water132 = new Sprite("water", w132, null, '~', null, true, false);
        terrain.add(water132);

        Location w133 = new Location(1, 33, 0, 0);
        Sprite water133 = new Sprite("water", w133, null, '~', null, true, false);
        terrain.add(water133);

        Location w134 = new Location(1, 34, 0, 0);
        Sprite water134 = new Sprite("water", w134, null, '~', null, true, false);
        terrain.add(water134);

        Location w135 = new Location(1, 35, 0, 0);
        Sprite water135 = new Sprite("water", w135, null, '~', null, true, false);
        terrain.add(water135);

        Location w136 = new Location(1, 36, 0, 0);
        Sprite water136 = new Sprite("water", w136, null, '~', null, true, false);
        terrain.add(water136);

        Location w137 = new Location(1, 37, 0, 0);
        Sprite water137 = new Sprite("water", g12, null, '~', null, true, false);
        terrain.add(water137);

        Location w138 = new Location(1, 38, 0, 0);
        Sprite water138 = new Sprite("water", w138, null, '/', null, true, false);
        terrain.add(water138);

        Location g139 = new Location(1, 39, 0, 0);
        Sprite grass139 = new Sprite("grass", g139, null, ' ', null, true, false);
        terrain.add(grass139);

        Location g140 = new Location(1, 40, 0, 0);
        Sprite grass140 = new Sprite("grass", g140, null, ' ', null, true, false);
        terrain.add(grass140);

        Location g141 = new Location(1, 41, 0, 0);
        Sprite grass141 = new Sprite("grass", g141, null, ' ', null, true, false);
        terrain.add(grass141);

        Location g142 = new Location(1, 42, 0, 0);
        Sprite grass142 = new Sprite("grass", g142, null, ' ', null, true, false);
        terrain.add(grass142);

        Location g143 = new Location(1, 43, 0, 0);
        Sprite grass143 = new Sprite("grass", g143, null, ' ', null, true, false);
        terrain.add(grass143);

        Location g144 = new Location(1, 44, 0, 0);
        Sprite grass144 = new Sprite("grass", g144, null, ' ', null, true, false);
        terrain.add(grass144);

        Location g145 = new Location(1, 45, 0, 0);
        Sprite grass145 = new Sprite("grass", g145, null, ' ', null, true, false);
        terrain.add(grass145);

        Location g146 = new Location(1, 46, 0, 0);
        Sprite grass146 = new Sprite("grass", g146, null, ' ', null, true, false);
        terrain.add(grass146);

        Location g147 = new Location(1, 47, 0, 0);
        Sprite grass147 = new Sprite("grass", g147, null, ' ', null, true, false);
        terrain.add(grass147);

        Location g148 = new Location(1, 48, 0, 0);
        Sprite grass148 = new Sprite("grass", g148, null, ' ', null, true, false);
        terrain.add(grass148);

        Location g149 = new Location(1, 49, 0, 0);
        Sprite grass149 = new Sprite("grass", g149, null, ' ', null, true, false);
        terrain.add(grass149);

        Location g150 = new Location(1, 50, 0, 0);
        Sprite grass150 = new Sprite("grass", g150, null, ' ', null, true, false);
        terrain.add(grass150);

        Location g151 = new Location(1, 51, 0, 0);
        Sprite grass151 = new Sprite("grass", g151, null, ' ', null, true, false);
        terrain.add(grass151);

        Location g152 = new Location(1, 52, 0, 0);
        Sprite grass152 = new Sprite("grass", g152, null, ' ', null, true, false);
        terrain.add(grass152);

        Location g153 = new Location(1, 53, 0, 0);
        Sprite grass153 = new Sprite("grass", g153, null, ' ', null, true, false);
        terrain.add(grass153);

        Location g154 = new Location(1, 54, 0, 0);
        Sprite grass154 = new Sprite("grass", g154, null, ' ', null, true, false);
        terrain.add(grass154);

        Location g155 = new Location(1, 55, 0, 0);
        Sprite grass155 = new Sprite("grass", g155, null, ' ', null, true, false);
        terrain.add(grass155);

        Location g156 = new Location(1, 56, 0, 0);
        Sprite grass156 = new Sprite("grass", g156, null, ' ', null, true, false);
        terrain.add(grass156);

        Location g157 = new Location(1, 57, 0, 0);
        Sprite grass157 = new Sprite("grass", g157, null, ' ', null, true, false);
        terrain.add(grass157);

        Location g158 = new Location(1, 58, 0, 0);
        Sprite grass158 = new Sprite("grass", g158, null, ' ', null, true, false);
        terrain.add(grass158);

        Location g159 = new Location(1, 59, 0, 0);
        Sprite grass159 = new Sprite("grass", g159, null, ' ', null, true, false);
        terrain.add(grass159);

        Location g160 = new Location(1, 60, 0, 0);
        Sprite grass160 = new Sprite("grass", g160, null, ' ', null, true, false);
        terrain.add(grass160);

        Location g161 = new Location(1, 61, 0, 0);
        Sprite grass161 = new Sprite("grass", g161, null, ' ', null, true, false);
        terrain.add(grass161);

        Location g162 = new Location(1, 62, 0, 0);
        Sprite grass162 = new Sprite("grass", g162, null, ' ', null, true, false);
        terrain.add(grass162);

        Location g163 = new Location(1, 63, 0, 0);
        Sprite grass163 = new Sprite("grass", g163, null, ' ', null, true, false);
        terrain.add(grass163);

        Location g164 = new Location(1, 64, 0, 0);
        Sprite grass164 = new Sprite("grass", g164, null, ' ', null, true, false);
        terrain.add(grass164);

        Location g165 = new Location(1, 65, 0, 0);
        Sprite grass165 = new Sprite("grass", g165, null, ' ', null, true, false);
        terrain.add(grass165);

        Location g166 = new Location(1, 66, 0, 0);
        Sprite grass166 = new Sprite("grass", g166, null, ' ', null, true, false);
        terrain.add(grass166);

        Location g167 = new Location(1, 67, 0, 0);
        Sprite grass167 = new Sprite("grass", g167, null, ' ', null, true, false);
        terrain.add(grass167);

        Location g168 = new Location(1, 68, 0, 0);
        Sprite grass168 = new Sprite("grass", g168, null, ' ', null, true, false);
        terrain.add(grass168);

        Location g169 = new Location(1, 69, 0, 0);
        Sprite grass169 = new Sprite("grass", g169, null, ' ', null, true, false);
        terrain.add(grass169);

        Location g170 = new Location(1, 70, 0, 0);
        Sprite grass170 = new Sprite("grass", g170, null, ' ', null, true, false);
        terrain.add(grass170);

        Location g171 = new Location(1, 71, 0, 0);
        Sprite grass171 = new Sprite("grass", g171, null, ' ', null, true, false);
        terrain.add(grass171);

        Location g172 = new Location(1, 72, 0, 0);
        Sprite grass172 = new Sprite("grass", g172, null, ' ', null, true, false);
        terrain.add(grass172);

        Location g173 = new Location(1, 73, 0, 0);
        Sprite grass173 = new Sprite("grass", g173, null, ' ', null, true, false);
        terrain.add(grass173);

        Location g174 = new Location(1, 74, 0, 0);
        Sprite grass174 = new Sprite("grass", g174, null, ' ', null, true, false);
        terrain.add(grass174);

        Location g175 = new Location(1, 75, 0, 0);
        Sprite grass175 = new Sprite("grass", g175, null, ' ', null, true, false);
        terrain.add(grass175);

        Location g176 = new Location(1, 76, 0, 0);
        Sprite grass176 = new Sprite("grass", g176, null, ' ', null, true, false);
        terrain.add(grass176);

        Location g177 = new Location(1, 77, 0, 0);
        Sprite grass177 = new Sprite("grass", g177, null, ' ', null, true, false);
        terrain.add(grass177);

        Location g178 = new Location(1, 78, 0, 0);
        Sprite grass178 = new Sprite("grass", g178, null, ' ', null, true, false);
        terrain.add(grass178);

        Location g179 = new Location(1, 79, 0, 0);
        Sprite grass179 = new Sprite("grass", g179, null, ' ', null, true, false);
        terrain.add(grass179);

        Location g180 = new Location(1, 80, 0, 0);
        Sprite grass180 = new Sprite("grass", g180, null, ' ', null, true, false);
        terrain.add(grass180);

        Location g181 = new Location(1, 81, 0, 0);
        Sprite grass181 = new Sprite("grass", g181, null, ' ', null, true, false);
        terrain.add(grass181);

        Location g182 = new Location(1, 82, 0, 0);
        Sprite grass182 = new Sprite("grass", g182, null, ' ', null, true, false);
        terrain.add(grass182);

        Location g183 = new Location(1, 83, 0, 0);
        Sprite grass183 = new Sprite("grass", g183, null, ' ', null, true, false);
        terrain.add(grass183);

        Location g184 = new Location(1, 84, 0, 0);
        Sprite grass184 = new Sprite("grass", g184, null, ' ', null, true, false);
        terrain.add(grass184);

        Location g185 = new Location(1, 85, 0, 0);
        Sprite grass185 = new Sprite("grass", g185, null, ' ', null, true, false);
        terrain.add(grass185);

        Location g186 = new Location(1, 86, 0, 0);
        Sprite grass186 = new Sprite("grass", g186, null, ' ', null, true, false);
        terrain.add(grass186);

        Location g187 = new Location(1, 87, 0, 0);
        Sprite grass187 = new Sprite("grass", g187, null, ' ', null, true, false);
        terrain.add(grass187);

        Location g188 = new Location(1, 88, 0, 0);
        Sprite grass188 = new Sprite("grass", g188, null, ' ', null, true, false);
        terrain.add(grass188);

        Location g189 = new Location(1, 89, 0, 0);
        Sprite grass189 = new Sprite("grass", g189, null, ' ', null, true, false);
        terrain.add(grass189);

        Location g190 = new Location(1, 90, 0, 0);
        Sprite grass190 = new Sprite("grass", g190, null, ' ', null, true, false);
        terrain.add(grass190);

        Location g191 = new Location(1, 91, 0, 0);
        Sprite grass191 = new Sprite("grass", g191, null, ' ', null, true, false);
        terrain.add(grass191);

        Location g192 = new Location(1, 92, 0, 0);
        Sprite grass192 = new Sprite("grass", g192, null, ' ', null, true, false);
        terrain.add(grass192);

        Location g193 = new Location(1, 93, 0, 0);
        Sprite grass193 = new Sprite("grass", g193, null, ' ', null, true, false);
        terrain.add(grass193);

        Location g194 = new Location(1, 94, 0, 0);
        Sprite grass194 = new Sprite("grass", g194, null, ' ', null, true, false);
        terrain.add(grass194);

        Location g195 = new Location(1, 95, 0, 0);
        Sprite grass195 = new Sprite("grass", g195, null, ' ', null, true, false);
        terrain.add(grass195);

        Location g196 = new Location(1, 96, 0, 0);
        Sprite grass196 = new Sprite("grass", g196, null, ' ', null, true, false);
        terrain.add(grass196);

        Location g197 = new Location(1, 97, 0, 0);
        Sprite grass197 = new Sprite("grass", g197, null, ' ', null, true, false);
        terrain.add(grass197);

        Location g198 = new Location(1, 98, 0, 0);
        Sprite grass198 = new Sprite("grass", g198, null, ' ', null, true, false);
        terrain.add(grass198);

        Location g199 = new Location(1, 99, 0, 0);
        Sprite grass199 = new Sprite("grass", g199, null, ' ', null, true, false);
        terrain.add(grass199);

        Location g1100 = new Location(1, 100, 0, 0);
        Sprite grass1100 = new Sprite("grass", g1100, null, ' ', null, true, false);
        terrain.add(grass1100);

        Location g1101 = new Location(1, 101, 0, 0);
        Sprite grass1101 = new Sprite("grass", g1101, null, ' ', null, true, false);
        terrain.add(grass1101);

        Location g1102 = new Location(1, 1102, 0, 0);
        Sprite grass1102 = new Sprite("grass", g1102, null, ' ', null, true, false);
        terrain.add(grass1102);

        Location g1103 = new Location(1, 103, 0, 0);
        Sprite grass1103 = new Sprite("grass", g1103, null, ' ', null, true, false);
        terrain.add(grass1103);

        Location g1104 = new Location(1, 104, 0, 0);
        Sprite grass1104 = new Sprite("grass", g1104, null, ' ', null, true, false);
        terrain.add(grass1104);

        Location g1105 = new Location(1, 105, 0, 0);
        Sprite grass1105 = new Sprite("grass", g1105, null, ' ', null, true, false);
        terrain.add(grass1105);

        Location g1106 = new Location(1, 106, 0, 0);
        Sprite grass1106 = new Sprite("grass", g1106, null, ' ', null, true, false);
        terrain.add(grass1106);

        Location g1107 = new Location(1, 107, 0, 0);
        Sprite grass1107 = new Sprite("grass", g1107, null, ' ', null, true, false);
        terrain.add(grass1107);

        Location g1108 = new Location(1, 108, 0, 0);
        Sprite grass1108 = new Sprite("grass", g1108, null, ' ', null, true, false);
        terrain.add(grass1108);

        Location g1109 = new Location(1, 109, 0, 0);
        Sprite grass1109 = new Sprite("grass", g1109, null, ' ', null, true, false);
        terrain.add(grass1109);

        Location g1110 = new Location(1, 110, 0, 0);
        Sprite grass1110 = new Sprite("grass", g1110, null, ' ', null, true, false);
        terrain.add(grass1110);

        Location g1111 = new Location(1, 111, 0, 0);
        Sprite grass1111 = new Sprite("grass", g1111, null, ' ', null, true, false);
        terrain.add(grass1111);

        Location g1112 = new Location(1, 112, 0, 0);
        Sprite grass1112 = new Sprite("grass", g1112, null, ' ', null, true, false);
        terrain.add(grass1112);

        Location g1113 = new Location(1, 113, 0, 0);
        Sprite grass1113 = new Sprite("grass", g1113, null, ' ', null, true, false);
        terrain.add(grass1113);

        Location g1114 = new Location(1, 114, 0, 0);
        Sprite grass1114 = new Sprite("grass", g1114, null, ' ', null, true, false);
        terrain.add(grass1114);

        Location g1115 = new Location(1, 115, 0, 0);
        Sprite grass1115 = new Sprite("grass", g1115, null, ' ', null, true, false);
        terrain.add(grass1115);

        Location g1116 = new Location(1, 116, 0, 0);
        Sprite grass1116 = new Sprite("grass", g1116, null, ' ', null, true, false);
        terrain.add(grass1116);

        Location g1117 = new Location(1, 117, 0, 0);
        Sprite grass1117 = new Sprite("grass", g1117, null, ' ', null, true, false);
        terrain.add(grass1117);

        Location g1118 = new Location(1, 118, 0, 0);
        Sprite grass1118 = new Sprite("grass", g1118, null, ' ', null, true, false);
        terrain.add(grass1118);

        Location g1119 = new Location(1, 119, 0, 0);
        Sprite grass1119 = new Sprite("grass", g1119, null, ' ', null, true, false);
        terrain.add(grass1119);

        Location g1120 = new Location(1, 120, 0, 0);
        Sprite grass1120 = new Sprite("grass", g1120, null, ' ', null, true, false);
        terrain.add(grass1120);

        Location g1121 = new Location(1, 121, 0, 0);
        Sprite grass1121 = new Sprite("grass", g1121, null, ' ', null, true, false);
        terrain.add(grass1121);

        Location g1123 = new Location(1, 1123, 0, 0);
        Sprite grass1123 = new Sprite("grass", g1123, null, ' ', null, true, false);
        terrain.add(grass1123);

        Location g1124 = new Location(1, 124, 0, 0);
        Sprite grass1124 = new Sprite("grass", g1124, null, ' ', null, true, false);
        terrain.add(grass1124);

        Location g1125 = new Location(1, 125, 0, 0);
        Sprite grass1125 = new Sprite("grass", g1125, null, ' ', null, true, false);
        terrain.add(grass1125);

        Location g1126 = new Location(1, 126, 0, 0);
        Sprite grass1126 = new Sprite("grass", g1126, null, ' ', null, true, false);
        terrain.add(grass1126);

        Location g1127 = new Location(1, 127, 0, 0);
        Sprite grass1127 = new Sprite("grass", g1127, null, ' ', null, true, false);
        terrain.add(grass1127);

        Location g1128 = new Location(1, 128, 0, 0);
        Sprite grass1128 = new Sprite("grass", g1128, null, ' ', null, true, false);
        terrain.add(grass1128);

        Location g1129 = new Location(1, 129, 0, 0);
        Sprite grass1129 = new Sprite("grass", g1129, null, ' ', null, true, false);
        terrain.add(grass1129);

        Location g1130 = new Location(1, 130, 0, 0);
        Sprite grass1130 = new Sprite("grass", g1130, null, ' ', null, true, false);
        terrain.add(grass1130);

        Location g1131 = new Location(1, 131, 0, 0);
        Sprite grass1131 = new Sprite("grass", g1131, null, ' ', null, true, false);
        terrain.add(grass1131);

        Location g1132 = new Location(1, 132, 0, 0);
        Sprite grass1132 = new Sprite("grass", g1132, null, ' ', null, true, false);
        terrain.add(grass1132);

        Location g1133 = new Location(1, 133, 0, 0);
        Sprite grass1133 = new Sprite("grass", g1133, null, ' ', null, true, false);
        terrain.add(grass1133);

        Location g1134 = new Location(1, 134, 0, 0);
        Sprite grass1134 = new Sprite("grass", g1134, null, ' ', null, true, false);
        terrain.add(grass1134);

        Location g1135 = new Location(1, 135, 0, 0);
        Sprite grass1135 = new Sprite("grass", g1135, null, ' ', null, true, false);
        terrain.add(grass1135);

        Location g1136 = new Location(1, 136, 0, 0);
        Sprite grass1136 = new Sprite("grass", g1136, null, ' ', null, true, false);
        terrain.add(grass1136);

        Location g1137 = new Location(1, 137, 0, 0);
        Sprite grass1137 = new Sprite("grass", g1137, null, ' ', null, true, false);
        terrain.add(grass1137);

        Location g1138 = new Location(1, 138, 0, 0);
        Sprite grass1138 = new Sprite("grass", g1138, null, ' ', null, true, false);
        terrain.add(grass1138);

        Location g1139 = new Location(1, 139, 0, 0);
        Sprite grass1139 = new Sprite("grass", g1139, null, ' ', null, true, false);
        terrain.add(grass1139);

        Location g1140 = new Location(1, 140, 0, 0);
        Sprite grass1140 = new Sprite("grass", g1140, null, ' ', null, true, false);
        terrain.add(grass1140);

        Location g1141 = new Location(1, 141, 0, 0);
        Sprite grass1141 = new Sprite("grass", g1141, null, ' ', null, true, false);
        terrain.add(grass1141);

        Location g1142 = new Location(1, 142, 0, 0);
        Sprite grass1142 = new Sprite("grass", g1142, null, ' ', null, true, false);
        terrain.add(grass1142);

        Location g1143 = new Location(1, 143, 0, 0);
        Sprite grass1143 = new Sprite("grass", g1143, null, ' ', null, true, false);
        terrain.add(grass1143);

        Location g1144 = new Location(1, 144, 0, 0);
        Sprite grass1144 = new Sprite("grass", g1144, null, ' ', null, true, false);
        terrain.add(grass1144);

        Location g1145 = new Location(1, 145, 0, 0);
        Sprite grass1145 = new Sprite("grass", g1145, null, ' ', null, true, false);
        terrain.add(grass1145);

        Location g1146 = new Location(1, 146, 0, 0);
        Sprite grass1146 = new Sprite("grass", g1146, null, ' ', null, true, false);
        terrain.add(grass1146);

        Location g1147 = new Location(1, 147, 0, 0);
        Sprite grass1147 = new Sprite("grass", g1147, null, ' ', null, true, false);
        terrain.add(grass1147);

        Location g1148 = new Location(1, 148, 0, 0);
        Sprite grass1148 = new Sprite("grass", g1148, null, ' ', null, true, false);
        terrain.add(grass1148);

        Location g1149 = new Location(1, 149, 0, 0);
        Sprite grass1149 = new Sprite("grass", g1149, null, ' ', null, true, false);
        terrain.add(grass1149);

        Location g1150 = new Location(1, 150, 0, 0);
        Sprite grass1150 = new Sprite("grass", g1150, null, ' ', null, true, false);
        terrain.add(grass1150);

        Location g1151 = new Location(1, 151, 0, 0);
        Sprite grass1151 = new Sprite("grass", g1151, null, ' ', null, true, false);
        terrain.add(grass1151);

        Location g1152 = new Location(1, 152, 0, 0);
        Sprite grass1152 = new Sprite("grass", g1152, null, ' ', null, true, false);
        terrain.add(grass1152);

        Location g1153 = new Location(1, 153, 0, 0);
        Sprite grass1153 = new Sprite("grass", g1153, null, ' ', null, true, false);
        terrain.add(grass1153);

        Location g1154 = new Location(1, 154, 0, 0);
        Sprite grass1154 = new Sprite("grass", g1154, null, ' ', null, true, false);
        terrain.add(grass1154);

        Location g1155 = new Location(1, 155, 0, 0);
        Sprite grass1155 = new Sprite("grass", g1155, null, ' ', null, true, false);
        terrain.add(grass1155);

        Location g1156 = new Location(1, 156, 0, 0);
        Sprite grass1156 = new Sprite("grass", g1156, null, ' ', null, true, false);
        terrain.add(grass1156);

        Location g1157 = new Location(1, 157, 0, 0);
        Sprite grass1157 = new Sprite("grass", g1157, null, ' ', null, true, false);
        terrain.add(grass1157);

        Location g1158 = new Location(1, 158, 0, 0);
        Sprite grass1158 = new Sprite("grass", g1158, null, ' ', null, true, false);
        terrain.add(grass1158);

        Location g1159 = new Location(1, 159, 0, 0);
        Sprite grass1159 = new Sprite("grass", g1159, null, ' ', null, true, false);
        terrain.add(grass1159);

        Location g1160 = new Location(1, 160, 0, 0);
        Sprite grass1160 = new Sprite("grass", g1160, null, ' ', null, true, false);
        terrain.add(grass1160);

        Location g1161 = new Location(1, 161, 0, 0);
        Sprite grass1161 = new Sprite("grass", g1161, null, ' ', null, true, false);
        terrain.add(grass1161);

        Location g1162 = new Location(1, 162, 0, 0);
        Sprite grass1162 = new Sprite("grass", g1162, null, ' ', null, true, false);
        terrain.add(grass1162);

        Location g1163 = new Location(1, 163, 0, 0);
        Sprite grass1163 = new Sprite("grass", g1163, null, ' ', null, true, false);
        terrain.add(grass1163);

        Location g1164 = new Location(1, 164, 0, 0);
        Sprite grass1164 = new Sprite("grass", g1164, null, ' ', null, true, false);
        terrain.add(grass1164);

        Location g1165 = new Location(1, 165, 0, 0);
        Sprite grass1165 = new Sprite("grass", g1165, null, ' ', null, true, false);
        terrain.add(grass1165);

        Location g1166 = new Location(1, 166, 0, 0);
        Sprite grass1166 = new Sprite("grass", g1166, null, ' ', null, true, false);
        terrain.add(grass1166);

        Location g1167 = new Location(1, 167, 0, 0);
        Sprite grass1167 = new Sprite("grass", g1167, null, ' ', null, true, false);
        terrain.add(grass1167);

        Location g1168 = new Location(1, 168, 0, 0);
        Sprite grass1168 = new Sprite("grass", g1168, null, ' ', null, true, false);
        terrain.add(grass1168);

        Location g1169 = new Location(1, 169, 0, 0);
        Sprite grass1169 = new Sprite("grass", g1169, null, ' ', null, true, false);
        terrain.add(grass1169);

        Location g1170 = new Location(1, 170, 0, 0);
        Sprite grass1170 = new Sprite("grass", g1170, null, ' ', null, true, false);
        terrain.add(grass1170);

        Location g1171 = new Location(1, 171, 0, 0);
        Sprite grass1171 = new Sprite("grass", g1171, null, ' ', null, true, false);
        terrain.add(grass1171);

        Location g1172 = new Location(1, 172, 0, 0);
        Sprite grass1172 = new Sprite("grass", g1172, null, ' ', null, true, false);
        terrain.add(grass1172);

        Location g1173 = new Location(1, 173, 0, 0);
        Sprite grass1173 = new Sprite("grass", g1173, null, ' ', null, true, false);
        terrain.add(grass1173);

        Location g1174 = new Location(1, 174, 0, 0);
        Sprite grass1174 = new Sprite("grass", g1174, null, ' ', null, true, false);
        terrain.add(grass1174);

        Location g1175 = new Location(1, 175, 0, 0);
        Sprite grass1175 = new Sprite("grass", g1175, null, ' ', null, true, false);
        terrain.add(grass1175);

        Location g1176 = new Location(1, 176, 0, 0);
        Sprite grass1176 = new Sprite("grass", g1176, null, ' ', null, true, false);
        terrain.add(grass1176);

        Location g1177 = new Location(1, 177, 0, 0);
        Sprite grass1177 = new Sprite("grass", g1177, null, ' ', null, true, false);
        terrain.add(grass1177);

        Location g1178 = new Location(1, 178, 0, 0);
        Sprite grass1178 = new Sprite("grass", g1178, null, ' ', null, true, false);
        terrain.add(grass1178);

        Location g1179 = new Location(1, 179, 0, 0);
        Sprite grass1179 = new Sprite("grass", g1179, null, ' ', null, true, false);
        terrain.add(grass1179);

        Location g1180 = new Location(1, 180, 0, 0);
        Sprite grass1180 = new Sprite("grass", g1180, null, ' ', null, true, false);
        terrain.add(grass1180);

        Location g1181 = new Location(1, 181, 0, 0);
        Sprite grass1181 = new Sprite("grass", g1181, null, ' ', null, true, false);
        terrain.add(grass1181);

        Location g1182 = new Location(1, 182, 0, 0);
        Sprite grass1182 = new Sprite("grass", g1182, null, ' ', null, true, false);
        terrain.add(grass1182);

        Location g1183 = new Location(1, 183, 0, 0);
        Sprite grass1183 = new Sprite("grass", g1183, null, ' ', null, true, false);
        terrain.add(grass1183);

        Location m1184 = new Location(1, 184, 0, 0);
        Sprite mountain1184 = new Sprite("mountain", m1184, null, '|', null, true, false);
        terrain.add(mountain1184);

        Location m1185 = new Location(1, 185, 0, 0);
        Sprite mountain1185 = new Sprite("mountain", m1185, null, '|', null, true, false);
        terrain.add(mountain1185);

        Location m1186 = new Location(1, 186, 0, 0);
        Sprite mountain1186 = new Sprite("mountain", m1186, null, 'm', null, true, false);
        terrain.add(mountain1186);

        Location m1187 = new Location(1, 187, 0, 0);
        Sprite mountain1187 = new Sprite("mountain", m1187, null, 'm', null, true, false);
        terrain.add(mountain1187);

        Location m1188 = new Location(1, 188, 0, 0);
        Sprite mountain1188 = new Sprite("mountain", m1188, null, 'm', null, true, false);
        terrain.add(mountain1188);

        Location m1189 = new Location(1, 189, 0, 0);
        Sprite mountain1189 = new Sprite("mountain", m1189, null, 'm', null, true, false);
        terrain.add(mountain1189);

        Location m1190 = new Location(1, 190, 0, 0);
        Sprite mountain1190 = new Sprite("mountain", m1190, null, 'm', null, true, false);
        terrain.add(mountain1190);

        Location m1191 = new Location(1, 191, 0, 0);
        Sprite mountain1191 = new Sprite("mountain", m1191, null, 'm', null, true, false);
        terrain.add(mountain1191);

        Location m1192 = new Location(1, 192, 0, 0);
        Sprite mountain1192 = new Sprite("mountain", m1192, null, 'm', null, true, false);
        terrain.add(mountain1192);

        Location m1193 = new Location(1, 193, 0, 0);
        Sprite mountain1193 = new Sprite("mountain", m1193, null, 'm', null, true, false);
        terrain.add(mountain1193);

        Location m1194 = new Location(1, 194, 0, 0);
        Sprite mountain1194 = new Sprite("mountain", m1194, null, '|', null, true, false);
        terrain.add(mountain1194);

        Location m1195 = new Location(1, 195, 0, 0);
        Sprite mountain1195 = new Sprite("mountain", m1195, null, '|', null, true, false);
        terrain.add(mountain1195);

        Location g1196 = new Location(1, 196, 0, 0);
        Sprite grass1196 = new Sprite("grass", g1196, null, ' ', null, true, false);
        terrain.add(grass1196);

        Location g1197 = new Location(1, 197, 0, 0);
        Sprite grass1197 = new Sprite("grass", g1197, null, ' ', null, true, false);
        terrain.add(grass1197);

        Location g1198 = new Location(1, 198, 0, 0);
        Sprite grass1198 = new Sprite("grass", g1198, null, ' ', null, true, false);
        terrain.add(grass1198);

        Location b1199 = new Location(1, 199, 0, 0);
        Sprite border1199 = new Sprite("border", b1199, null, '|', null, true, false);
        terrain.add(border1199);

        /*-------------------------ROW 2---------------------------------------------*/
        Location b20 = new Location(2, 0, 0, 0);
        Sprite border20 = new Sprite("border", b20, null, '|', null, true, false);
        terrain.add(border20);

        Location g21 = new Location(2, 1, 0, 0);
        Sprite grass21 = new Sprite("grass", g21, null, ' ', null, true, false);
        terrain.add(grass21);

        Location g22 = new Location(2, 2, 0, 0);
        Sprite grass22 = new Sprite("grass", g22, null, ' ', null, true, false);
        terrain.add(grass22);

        Location g23 = new Location(2, 3, 0, 0);
        Sprite grass23 = new Sprite("grass", g23, null, ' ', null, true, false);
        terrain.add(grass23);

        Location g24 = new Location(2, 4, 0, 0);
        Sprite grass24 = new Sprite("grass", g24, null, ' ', null, true, false);
        terrain.add(grass24);

        Location g25 = new Location(2, 5, 0, 0);
        Sprite grass25 = new Sprite("grass", g25, null, ' ', null, true, false);
        terrain.add(grass25);

        Location g26 = new Location(2, 6, 0, 0);
        Sprite grass26 = new Sprite("grass", g26, null, ' ', null, true, false);
        terrain.add(grass26);

        Location g27 = new Location(2, 7, 0, 0);
        Sprite grass27 = new Sprite("grass", g27, null, ' ', null, true, false);
        terrain.add(grass27);

        Location g28 = new Location(2, 8, 0, 0);
        Sprite grass28 = new Sprite("grass", g28, null, ' ', null, true, false);
        terrain.add(grass28);

        Location g29 = new Location(2, 9, 0, 0);
        Sprite grass29 = new Sprite("grass", g29, null, ' ', null, true, false);
        terrain.add(grass29);

        Location g210 = new Location(2, 10, 0, 0);
        Sprite grass210 = new Sprite("grass", g210, null, ' ', null, true, false);
        terrain.add(grass210);

        Location g211 = new Location(2, 11, 0, 0);
        Sprite grass211 = new Sprite("grass", g211, null, ' ', null, true, false);
        terrain.add(grass211);

        Location g212 = new Location(2, 12, 0, 0);
        Sprite grass212 = new Sprite("grass", g212, null, ' ', null, true, false);
        terrain.add(grass212);

        Location g213 = new Location(2, 13, 0, 0);
        Sprite grass213 = new Sprite("grass", g213, null, ' ', null, true, false);
        terrain.add(grass213);

        Location g214 = new Location(2, 14, 0, 0);
        Sprite grass214 = new Sprite("grass", g214, null, ' ', null, true, false);
        terrain.add(grass214);

        Location g215 = new Location(2, 15, 0, 0);
        Sprite grass215 = new Sprite("grass", g215, null, ' ', null, true, false);
        terrain.add(grass215);

        Location g216 = new Location(2, 16, 0, 0);
        Sprite grass216 = new Sprite("grass", g216, null, ' ', null, true, false);
        terrain.add(grass216);

        Location g217 = new Location(2, 17, 0, 0);
        Sprite grass217 = new Sprite("grass", g217, null, ' ', null, true, false);
        terrain.add(grass217);

        Location g218 = new Location(2, 18, 0, 0);
        Sprite grass218 = new Sprite("grass", g218, null, ' ', null, true, false);
        terrain.add(grass218);

        Location g219 = new Location(2, 19, 0, 0);
        Sprite grass219 = new Sprite("grass", g219, null, ' ', null, true, false);
        terrain.add(grass219);

        Location g220 = new Location(2, 20, 0, 0);
        Sprite grass220 = new Sprite("grass", g220, null, ' ', null, true, false);
        terrain.add(grass220);

        Location g221 = new Location(2, 21, 0, 0);
        Sprite grass221 = new Sprite("grass", g221, null, ' ', null, true, false);
        terrain.add(grass221);

        Location g222 = new Location(2, 22, 0, 0);
        Sprite grass222 = new Sprite("grass", g222, null, ' ', null, true, false);
        terrain.add(grass222);

        Location g223 = new Location(2, 23, 0, 0);
        Sprite grass223 = new Sprite("grass", g223, null, ' ', null, true, false);
        terrain.add(grass223);

        Location g224 = new Location(4, 22, 0, 0);
        Sprite grass224 = new Sprite("grass", g224, null, ' ', null, true, false);
        terrain.add(grass224);

        Location g225 = new Location(2, 25, 0, 0);
        Sprite grass225 = new Sprite("grass", g225, null, ' ', null, true, false);
        terrain.add(grass225);

        Location g226 = new Location(2, 26, 0, 0);
        Sprite grass226 = new Sprite("grass", g226, null, ' ', null, true, false);
        terrain.add(grass226);

        Location w227 = new Location(2, 27, 0, 0);
        Sprite water227 = new Sprite("water", w227, null, '/', null, true, false);
        terrain.add(water227);

        Location w228 = new Location(2, 28, 0, 0);
        Sprite water228 = new Sprite("water", w228, null, '~', null, true, false);
        terrain.add(water228);

        Location w229 = new Location(2, 29, 0, 0);
        Sprite water229 = new Sprite("water", w229, null, '~', null, true, false);
        terrain.add(water229);

        Location w230 = new Location(2, 30, 0, 0);
        Sprite water230 = new Sprite("water", w230, null, '~', null, true, false);
        terrain.add(water230);

        Location w231 = new Location(2, 31, 0, 0);
        Sprite water231 = new Sprite("water", w231, null, '~', null, true, false);
        terrain.add(water231);

        Location w232 = new Location(2, 32, 0, 0);
        Sprite water232 = new Sprite("water", w232, null, '~', null, true, false);
        terrain.add(water232);

        Location w233 = new Location(2, 33, 0, 0);
        Sprite water233 = new Sprite("water", w233, null, '~', null, true, false);
        terrain.add(water233);

        Location w234 = new Location(2, 34, 0, 0);
        Sprite water234 = new Sprite("water", w234, null, '~', null, true, false);
        terrain.add(water234);

        Location w235 = new Location(2, 35, 0, 0);
        Sprite water235 = new Sprite("water", w235, null, '~', null, true, false);
        terrain.add(water235);

        Location w236 = new Location(2, 36, 0, 0);
        Sprite water236 = new Sprite("water", w236, null, '~', null, true, false);
        terrain.add(water236);

        Location w237 = new Location(2, 37, 0, 0);
        Sprite water237 = new Sprite("water", w237, null, '/', null, true, false);
        terrain.add(water237);

        Location g238 = new Location(2, 38, 0, 0);
        Sprite grass238 = new Sprite("grass", g238, null, ' ', null, true, false);
        terrain.add(grass238);

        Location g239 = new Location(2, 39, 0, 0);
        Sprite grass239 = new Sprite("grass", g239, null, ' ', null, true, false);
        terrain.add(grass239);

        Location g241 = new Location(2, 41, 0, 0);
        Sprite grass241 = new Sprite("grass", g241, null, ' ', null, true, false);
        terrain.add(grass241);

        Location g242 = new Location(2, 42, 0, 0);
        Sprite grass242 = new Sprite("grass", g242, null, ' ', null, true, false);
        terrain.add(grass242);

        Location g243 = new Location(2, 43, 0, 0);
        Sprite grass243 = new Sprite("grass", g243, null, ' ', null, true, false);
        terrain.add(grass243);

        Location g244 = new Location(2, 44, 0, 0);
        Sprite grass244 = new Sprite("grass", g244, null, ' ', null, true, false);
        terrain.add(grass244);

        Location g245 = new Location(2, 45, 0, 0);
        Sprite grass245 = new Sprite("grass", g245, null, ' ', null, true, false);
        terrain.add(grass245);

        Location g246 = new Location(2, 46, 0, 0);
        Sprite grass246 = new Sprite("grass", g246, null, ' ', null, true, false);
        terrain.add(grass246);

        Location g247 = new Location(2, 47, 0, 0);
        Sprite grass247 = new Sprite("grass", g247, null, ' ', null, true, false);
        terrain.add(grass247);

        Location g248 = new Location(2, 48, 0, 0);
        Sprite grass248 = new Sprite("grass", g248, null, ' ', null, true, false);
        terrain.add(grass248);

        Location g249 = new Location(2, 49, 0, 0);
        Sprite grass249 = new Sprite("grass", g249, null, ' ', null, true, false);
        terrain.add(grass249);

        Location g250 = new Location(2, 50, 0, 0);
        Sprite grass250 = new Sprite("grass", g250, null, ' ', null, true, false);
        terrain.add(grass250);

        Location g251 = new Location(2, 51, 0, 0);
        Sprite grass251 = new Sprite("grass", g251, null, ' ', null, true, false);
        terrain.add(grass251);

        Location g252 = new Location(2, 52, 0, 0);
        Sprite grass252 = new Sprite("grass", g252, null, ' ', null, true, false);
        terrain.add(grass252);

        Location g253 = new Location(2, 53, 0, 0);
        Sprite grass253 = new Sprite("grass", g253, null, ' ', null, true, false);
        terrain.add(grass253);

        Location g254 = new Location(2, 54, 0, 0);
        Sprite grass254 = new Sprite("grass", g254, null, ' ', null, true, false);
        terrain.add(grass254);

        Location g255 = new Location(2, 55, 0, 0);
        Sprite grass255 = new Sprite("grass", g255, null, ' ', null, true, false);
        terrain.add(grass255);

        Location g256 = new Location(2, 56, 0, 0);
        Sprite grass256 = new Sprite("grass", g256, null, ' ', null, true, false);
        terrain.add(grass256);

        Location g257 = new Location(2, 57, 0, 0);
        Sprite grass257 = new Sprite("grass", g257, null, ' ', null, true, false);
        terrain.add(grass257);

        Location g258 = new Location(2, 58, 0, 0);
        Sprite grass258 = new Sprite("grass", g258, null, ' ', null, true, false);
        terrain.add(grass258);

        Location g259 = new Location(2, 59, 0, 0);
        Sprite grass259 = new Sprite("grass", g259, null, ' ', null, true, false);
        terrain.add(grass259);

        Location g260 = new Location(2, 60, 0, 0);
        Sprite grass260 = new Sprite("grass", g260, null, ' ', null, true, false);
        terrain.add(grass260);

        Location g261 = new Location(2, 61, 0, 0);
        Sprite grass261 = new Sprite("grass", g261, null, ' ', null, true, false);
        terrain.add(grass261);

        Location g262 = new Location(2, 62, 0, 0);
        Sprite grass262 = new Sprite("grass", g262, null, ' ', null, true, false);
        terrain.add(grass262);

        Location g263 = new Location(2, 63, 0, 0);
        Sprite grass263 = new Sprite("grass", g263, null, ' ', null, true, false);
        terrain.add(grass263);

        Location g264 = new Location(2, 64, 0, 0);
        Sprite grass264 = new Sprite("grass", g264, null, ' ', null, true, false);
        terrain.add(grass264);

        Location g265 = new Location(2, 65, 0, 0);
        Sprite grass265 = new Sprite("grass", g265, null, ' ', null, true, false);
        terrain.add(grass265);

        Location g266 = new Location(2, 66, 0, 0);
        Sprite grass266 = new Sprite("grass", g266, null, ' ', null, true, false);
        terrain.add(grass266);

        Location g267 = new Location(2, 67, 0, 0);
        Sprite grass267 = new Sprite("grass", g267, null, ' ', null, true, false);
        terrain.add(grass267);

        Location g268 = new Location(2, 68, 0, 0);
        Sprite grass268 = new Sprite("grass", g268, null, ' ', null, true, false);
        terrain.add(grass268);

        Location g269 = new Location(2, 69, 0, 0);
        Sprite grass269 = new Sprite("grass", g269, null, ' ', null, true, false);
        terrain.add(grass269);

        Location g270 = new Location(2, 70, 0, 0);
        Sprite grass270 = new Sprite("grass", g270, null, ' ', null, true, false);
        terrain.add(grass270);

        Location g271 = new Location(2, 71, 0, 0);
        Sprite grass271 = new Sprite("grass", g271, null, ' ', null, true, false);
        terrain.add(grass271);

        Location g272 = new Location(2, 72, 0, 0);
        Sprite grass272 = new Sprite("grass", g272, null, ' ', null, true, false);
        terrain.add(grass272);

        Location g273 = new Location(2, 73, 0, 0);
        Sprite grass273 = new Sprite("grass", g273, null, ' ', null, true, false);
        terrain.add(grass273);

        Location g274 = new Location(2, 74, 0, 0);
        Sprite grass274 = new Sprite("grass", g274, null, ' ', null, true, false);
        terrain.add(grass274);

        Location g275 = new Location(2, 75, 0, 0);
        Sprite grass275 = new Sprite("grass", g275, null, ' ', null, true, false);
        terrain.add(grass275);

        Location g276 = new Location(2, 76, 0, 0);
        Sprite grass276 = new Sprite("grass", g276, null, ' ', null, true, false);
        terrain.add(grass276);

        Location g277 = new Location(2, 77, 0, 0);
        Sprite grass277 = new Sprite("grass", g277, null, ' ', null, true, false);
        terrain.add(grass277);

        Location g278 = new Location(2, 78, 0, 0);
        Sprite grass278 = new Sprite("grass", g278, null, ' ', null, true, false);
        terrain.add(grass278);

        Location g279 = new Location(2, 79, 0, 0);
        Sprite grass279 = new Sprite("grass", g279, null, ' ', null, true, false);
        terrain.add(grass279);

        Location g280 = new Location(2, 80, 0, 0);
        Sprite grass280 = new Sprite("grass", g280, null, ' ', null, true, false);
        terrain.add(grass280);

        Location g281 = new Location(2, 81, 0, 0);
        Sprite grass281 = new Sprite("grass", g281, null, ' ', null, true, false);
        terrain.add(grass281);

        Location g282 = new Location(2, 82, 0, 0);
        Sprite grass282 = new Sprite("grass", g282, null, ' ', null, true, false);
        terrain.add(grass282);

        Location g283 = new Location(2, 83, 0, 0);
        Sprite grass283 = new Sprite("grass", g283, null, ' ', null, true, false);
        terrain.add(grass283);

        Location g284 = new Location(2, 84, 0, 0);
        Sprite grass284 = new Sprite("grass", g284, null, ' ', null, true, false);
        terrain.add(grass284);

        Location g285 = new Location(2, 85, 0, 0);
        Sprite grass285 = new Sprite("grass", g285, null, ' ', null, true, false);
        terrain.add(grass285);

        Location g286 = new Location(2, 86, 0, 0);
        Sprite grass286 = new Sprite("grass", g286, null, ' ', null, true, false);
        terrain.add(grass286);

        Location g287 = new Location(2, 87, 0, 0);
        Sprite grass287 = new Sprite("grass", g287, null, ' ', null, true, false);
        terrain.add(grass287);

        Location g288 = new Location(2, 88, 0, 0);
        Sprite grass288 = new Sprite("grass", g288, null, ' ', null, true, false);
        terrain.add(grass288);

        Location g289 = new Location(2, 89, 0, 0);
        Sprite grass289 = new Sprite("grass", g289, null, ' ', null, true, false);
        terrain.add(grass289);

        Location g290 = new Location(2, 90, 0, 0);
        Sprite grass290 = new Sprite("grass", g290, null, ' ', null, true, false);
        terrain.add(grass290);

        Location g291 = new Location(2, 91, 0, 0);
        Sprite grass291 = new Sprite("grass", g291, null, ' ', null, true, false);
        terrain.add(grass291);

        Location g292 = new Location(2, 92, 0, 0);
        Sprite grass292 = new Sprite("grass", g292, null, ' ', null, true, false);
        terrain.add(grass292);

        Location g293 = new Location(2, 93, 0, 0);
        Sprite grass293 = new Sprite("grass", g293, null, ' ', null, true, false);
        terrain.add(grass293);

        Location g294 = new Location(2, 94, 0, 0);
        Sprite grass294 = new Sprite("grass", g294, null, ' ', null, true, false);
        terrain.add(grass294);

        Location g295 = new Location(2, 95, 0, 0);
        Sprite grass295 = new Sprite("grass", g295, null, ' ', null, true, false);
        terrain.add(grass295);

        Location g296 = new Location(2, 96, 0, 0);
        Sprite grass296 = new Sprite("grass", g296, null, ' ', null, true, false);
        terrain.add(grass296);

        Location g297 = new Location(2, 97, 0, 0);
        Sprite grass297 = new Sprite("grass", g297, null, ' ', null, true, false);
        terrain.add(grass297);

        Location g298 = new Location(2, 98, 0, 0);
        Sprite grass298 = new Sprite("grass", g298, null, ' ', null, true, false);
        terrain.add(grass298);

        Location g299 = new Location(2, 99, 0, 0);
        Sprite grass299 = new Sprite("grass", g299, null, ' ', null, true, false);
        terrain.add(grass299);

        Location g2100 = new Location(2, 100, 0, 0);
        Sprite grass2100 = new Sprite("grass", g2100, null, ' ', null, true, false);
        terrain.add(grass2100);

        Location g2101 = new Location(2, 101, 0, 0);
        Sprite grass2101 = new Sprite("grass", g2101, null, ' ', null, true, false);
        terrain.add(grass2101);

        Location g2102 = new Location(2, 102, 0, 0);
        Sprite grass2102 = new Sprite("grass", g2102, null, ' ', null, true, false);
        terrain.add(grass2102);

        Location g2103 = new Location(2, 103, 0, 0);
        Sprite grass2103 = new Sprite("grass", g2103, null, ' ', null, true, false);
        terrain.add(grass2103);

        Location g2104 = new Location(2, 104, 0, 0);
        Sprite grass2104 = new Sprite("grass", g2104, null, ' ', null, true, false);
        terrain.add(grass2104);

        Location g2105 = new Location(2, 105, 0, 0);
        Sprite grass2105 = new Sprite("grass", g2105, null, ' ', null, true, false);
        terrain.add(grass2105);

        Location g2106 = new Location(2, 106, 0, 0);
        Sprite grass2106 = new Sprite("grass", g2106, null, ' ', null, true, false);
        terrain.add(grass2106);

        Location g2107 = new Location(2, 107, 0, 0);
        Sprite grass2107 = new Sprite("grass", g2107, null, ' ', null, true, false);
        terrain.add(grass2107);

        Location g2108 = new Location(2, 108, 0, 0);
        Sprite grass2108 = new Sprite("grass", g2108, null, ' ', null, true, false);
        terrain.add(grass2108);

        Location g2109 = new Location(2, 109, 0, 0);
        Sprite grass2109 = new Sprite("grass", g2109, null, ' ', null, true, false);
        terrain.add(grass2109);

        Location g2110 = new Location(2, 110, 0, 0);
        Sprite grass2110 = new Sprite("grass", g2110, null, ' ', null, true, false);
        terrain.add(grass2110);

        Location g2111 = new Location(2, 111, 0, 0);
        Sprite grass2111 = new Sprite("grass", g2111, null, ' ', null, true, false);
        terrain.add(grass2111);

        Location g2112 = new Location(2, 112, 0, 0);
        Sprite grass2112 = new Sprite("grass", g2112, null, ' ', null, true, false);
        terrain.add(grass2112);

        Location g2113 = new Location(2, 113, 0, 0);
        Sprite grass2113 = new Sprite("grass", g2113, null, ' ', null, true, false);
        terrain.add(grass2113);

        Location g2114 = new Location(2, 114, 0, 0);
        Sprite grass2114 = new Sprite("grass", g2114, null, ' ', null, true, false);
        terrain.add(grass2114);

        Location g2115 = new Location(2, 115, 0, 0);
        Sprite grass2115 = new Sprite("grass", g2115, null, ' ', null, true, false);
        terrain.add(grass2115);

        Location g2116 = new Location(2, 116, 0, 0);
        Sprite grass2116 = new Sprite("grass", g2116, null, ' ', null, true, false);
        terrain.add(grass2116);

        Location g2117 = new Location(2, 117, 0, 0);
        Sprite grass2117 = new Sprite("grass", g2117, null, ' ', null, true, false);
        terrain.add(grass2117);

        Location g2118 = new Location(2, 118, 0, 0);
        Sprite grass2118 = new Sprite("grass", g2118, null, ' ', null, true, false);
        terrain.add(grass2118);

        Location g2119 = new Location(2, 119, 0, 0);
        Sprite grass2119 = new Sprite("grass", g2119, null, ' ', null, true, false);
        terrain.add(grass2119);

        Location g2120 = new Location(2, 120, 0, 0);
        Sprite grass2120 = new Sprite("grass", g2120, null, ' ', null, true, false);
        terrain.add(grass2120);

        Location g2121 = new Location(2, 121, 0, 0);
        Sprite grass2121 = new Sprite("grass", g2121, null, ' ', null, true, false);
        terrain.add(grass2121);

        Location g2122 = new Location(2, 122, 0, 0);
        Sprite grass2122 = new Sprite("grass", g2122, null, ' ', null, true, false);
        terrain.add(grass2122);

        Location g2123 = new Location(2, 123, 0, 0);
        Sprite grass2123 = new Sprite("grass", g2123, null, ' ', null, true, false);
        terrain.add(grass2123);

        Location g2124 = new Location(2, 124, 0, 0);
        Sprite grass2124 = new Sprite("grass", g2124, null, ' ', null, true, false);
        terrain.add(grass2124);

        Location g2125 = new Location(2, 125, 0, 0);
        Sprite grass2125 = new Sprite("grass", g2125, null, ' ', null, true, false);
        terrain.add(grass2125);

        Location g2126 = new Location(2, 126, 0, 0);
        Sprite grass2126 = new Sprite("grass", g2126, null, ' ', null, true, false);
        terrain.add(grass2126);

        Location g2127 = new Location(2, 127, 0, 0);
        Sprite grass2127 = new Sprite("grass", g2127, null, ' ', null, true, false);
        terrain.add(grass2127);

        Location g2128 = new Location(2, 128, 0, 0);
        Sprite grass2128 = new Sprite("grass", g2128, null, ' ', null, true, false);
        terrain.add(grass2128);

        Location g2129 = new Location(2, 129, 0, 0);
        Sprite grass2129 = new Sprite("grass", g2129, null, ' ', null, true, false);
        terrain.add(grass2129);

        Location g2130 = new Location(2, 130, 0, 0);
        Sprite grass2130 = new Sprite("grass", g2130, null, ' ', null, true, false);
        terrain.add(grass2130);

        Location g2131 = new Location(2, 131, 0, 0);
        Sprite grass2131 = new Sprite("grass", g2131, null, ' ', null, true, false);
        terrain.add(grass2131);

        Location g2132 = new Location(2, 132, 0, 0);
        Sprite grass2132 = new Sprite("grass", g2132, null, ' ', null, true, false);
        terrain.add(grass2132);

        Location g2133 = new Location(2, 133, 0, 0);
        Sprite grass2133 = new Sprite("grass", g2133, null, ' ', null, true, false);
        terrain.add(grass2133);

        Location g2134 = new Location(2, 134, 0, 0);
        Sprite grass2134 = new Sprite("grass", g2134, null, ' ', null, true, false);
        terrain.add(grass2134);

        Location g2135 = new Location(2, 135, 0, 0);
        Sprite grass2135 = new Sprite("grass", g2135, null, ' ', null, true, false);
        terrain.add(grass2135);

        Location g2136 = new Location(2, 136, 0, 0);
        Sprite grass2136 = new Sprite("grass", g2136, null, ' ', null, true, false);
        terrain.add(grass2136);

        Location g2137 = new Location(2, 137, 0, 0);
        Sprite grass2137 = new Sprite("grass", g2137, null, ' ', null, true, false);
        terrain.add(grass2137);

        Location g2138 = new Location(2, 138, 0, 0);
        Sprite grass2138 = new Sprite("grass", g2138, null, ' ', null, true, false);
        terrain.add(grass2138);

        Location g2139 = new Location(2, 139, 0, 0);
        Sprite grass2139 = new Sprite("grass", g2139, null, ' ', null, true, false);
        terrain.add(grass2139);

        Location g2140 = new Location(2, 140, 0, 0);
        Sprite grass2140 = new Sprite("grass", g2140, null, ' ', null, true, false);
        terrain.add(grass2140);

        Location g2141 = new Location(2, 141, 0, 0);
        Sprite grass2141 = new Sprite("grass", g2141, null, ' ', null, true, false);
        terrain.add(grass2141);

        Location g2142 = new Location(2, 142, 0, 0);
        Sprite grass2142 = new Sprite("grass", g2142, null, ' ', null, true, false);
        terrain.add(grass2142);

        Location g2143 = new Location(2, 143, 0, 0);
        Sprite grass2143 = new Sprite("grass", g2143, null, ' ', null, true, false);
        terrain.add(grass2143);

        Location g2144 = new Location(2, 144, 0, 0);
        Sprite grass2144 = new Sprite("grass", g2144, null, ' ', null, true, false);
        terrain.add(grass2144);

        Location g2145 = new Location(2, 145, 0, 0);
        Sprite grass2145 = new Sprite("grass", g2145, null, ' ', null, true, false);
        terrain.add(grass2145);

        Location g2146 = new Location(2, 146, 0, 0);
        Sprite grass2146 = new Sprite("grass", g2146, null, ' ', null, true, false);
        terrain.add(grass2146);

        Location g2147 = new Location(2, 147, 0, 0);
        Sprite grass2147 = new Sprite("grass", g2147, null, ' ', null, true, false);
        terrain.add(grass2147);

        Location g2148 = new Location(2, 148, 0, 0);
        Sprite grass2148 = new Sprite("grass", g2148, null, ' ', null, true, false);
        terrain.add(grass2148);

        Location g2149 = new Location(2, 149, 0, 0);
        Sprite grass2149 = new Sprite("grass", g2149, null, ' ', null, true, false);
        terrain.add(grass2149);

        Location g2150 = new Location(2, 150, 0, 0);
        Sprite grass2150 = new Sprite("grass", g2150, null, ' ', null, true, false);
        terrain.add(grass2150);

        Location g2151 = new Location(2, 151, 0, 0);
        Sprite grass2151 = new Sprite("grass", g2151, null, ' ', null, true, false);
        terrain.add(grass2151);

        Location g2152 = new Location(2, 152, 0, 0);
        Sprite grass2152 = new Sprite("grass", g2152, null, ' ', null, true, false);
        terrain.add(grass2152);

        Location g2153 = new Location(2, 153, 0, 0);
        Sprite grass2153 = new Sprite("grass", g2153, null, ' ', null, true, false);
        terrain.add(grass2153);

        Location g2154 = new Location(2, 154, 0, 0);
        Sprite grass2154 = new Sprite("grass", g2154, null, ' ', null, true, false);
        terrain.add(grass2154);

        Location g2155 = new Location(2, 155, 0, 0);
        Sprite grass2155 = new Sprite("grass", g2155, null, ' ', null, true, false);
        terrain.add(grass2155);

        Location g2156 = new Location(2, 156, 0, 0);
        Sprite grass2156 = new Sprite("grass", g2156, null, ' ', null, true, false);
        terrain.add(grass2156);

        Location g2157 = new Location(2, 157, 0, 0);
        Sprite grass2157 = new Sprite("grass", g2157, null, ' ', null, true, false);
        terrain.add(grass2157);

        Location g2158 = new Location(2, 158, 0, 0);
        Sprite grass2158 = new Sprite("grass", g2158, null, ' ', null, true, false);
        terrain.add(grass2158);

        Location g2159 = new Location(2, 159, 0, 0);
        Sprite grass2159 = new Sprite("grass", g2159, null, ' ', null, true, false);
        terrain.add(grass2159);

        Location g2160 = new Location(2, 160, 0, 0);
        Sprite grass2160 = new Sprite("grass", g2160, null, ' ', null, true, false);
        terrain.add(grass2160);

        Location g2161 = new Location(2, 161, 0, 0);
        Sprite grass2161 = new Sprite("grass", g2161, null, ' ', null, true, false);
        terrain.add(grass2161);

        Location g2162 = new Location(2, 162, 0, 0);
        Sprite grass2162 = new Sprite("grass", g2162, null, ' ', null, true, false);
        terrain.add(grass2162);

        Location g2163 = new Location(2, 163, 0, 0);
        Sprite grass2163 = new Sprite("grass", g2163, null, ' ', null, true, false);
        terrain.add(grass2163);

        Location g2164 = new Location(2, 164, 0, 0);
        Sprite grass2164 = new Sprite("grass", g2164, null, ' ', null, true, false);
        terrain.add(grass2164);

        Location g2165 = new Location(2, 165, 0, 0);
        Sprite grass2165 = new Sprite("grass", g2165, null, ' ', null, true, false);
        terrain.add(grass2165);

        Location g2166 = new Location(2, 166, 0, 0);
        Sprite grass2166 = new Sprite("grass", g2166, null, ' ', null, true, false);
        terrain.add(grass2166);

        Location g2167 = new Location(2, 167, 0, 0);
        Sprite grass2167 = new Sprite("grass", g2167, null, ' ', null, true, false);
        terrain.add(grass2167);

        Location g2168 = new Location(2, 168, 0, 0);
        Sprite grass2168 = new Sprite("grass", g2168, null, ' ', null, true, false);
        terrain.add(grass2168);

        Location g2169 = new Location(2, 169, 0, 0);
        Sprite grass2169 = new Sprite("grass", g2169, null, ' ', null, true, false);
        terrain.add(grass2169);

        Location g2170 = new Location(2, 170, 0, 0);
        Sprite grass2170 = new Sprite("grass", g2170, null, ' ', null, true, false);
        terrain.add(grass2170);

        Location g2171 = new Location(2, 171, 0, 0);
        Sprite grass2171 = new Sprite("grass", g2171, null, ' ', null, true, false);
        terrain.add(grass2171);

        Location g2172 = new Location(2, 172, 0, 0);
        Sprite grass2172 = new Sprite("grass", g2172, null, ' ', null, true, false);
        terrain.add(grass2172);

        Location g2173 = new Location(2, 173, 0, 0);
        Sprite grass2173 = new Sprite("grass", g2173, null, ' ', null, true, false);
        terrain.add(grass2173);

        Location g2174 = new Location(2, 174, 0, 0);
        Sprite grass2174 = new Sprite("grass", g2174, null, ' ', null, true, false);
        terrain.add(grass2174);

        Location g2175 = new Location(2, 175, 0, 0);
        Sprite grass2175 = new Sprite("grass", g2175, null, ' ', null, true, false);
        terrain.add(grass2175);

        Location g2176 = new Location(2, 176, 0, 0);
        Sprite grass2176 = new Sprite("grass", g2176, null, ' ', null, true, false);
        terrain.add(grass2176);

        Location g2177 = new Location(2, 177, 0, 0);
        Sprite grass2177 = new Sprite("grass", g2177, null, ' ', null, true, false);
        terrain.add(grass2177);

        Location g2178 = new Location(2, 178, 0, 0);
        Sprite grass2178 = new Sprite("grass", g2178, null, ' ', null, true, false);
        terrain.add(grass2178);

        Location g2179 = new Location(2, 179, 0, 0);
        Sprite grass2179 = new Sprite("grass", g2179, null, ' ', null, true, false);
        terrain.add(grass2179);

        Location g2180 = new Location(2, 180, 0, 0);
        Sprite grass2180 = new Sprite("grass", g2180, null, ' ', null, true, false);
        terrain.add(grass2180);

        Location g2181 = new Location(2, 181, 0, 0);
        Sprite grass2181 = new Sprite("grass", g2181, null, ' ', null, true, false);
        terrain.add(grass2181);

        Location g2182 = new Location(2, 182, 0, 0);
        Sprite grass2182 = new Sprite("grass", g2182, null, ' ', null, true, false);
        terrain.add(grass2182);

        Location g2183 = new Location(2, 183, 0, 0);
        Sprite grass2183 = new Sprite("grass", g2183, null, ' ', null, true, false);
        terrain.add(grass2183);

        Location m2184 = new Location(2, 184, 0, 0);
        Sprite mountain2184 = new Sprite("mountain", m2184, null, '|', null, true, false);
        terrain.add(mountain2184);

        Location m2185 = new Location(2, 185, 0, 0);
        Sprite mountain2185 = new Sprite("mountain", m2185, null, '|', null, true, false);
        terrain.add(mountain2185);

        Location m2186 = new Location(2, 186, 0, 0);
        Sprite mountain2186 = new Sprite("mountain", m2186, null, 'm', null, true, false);
        terrain.add(mountain2186);

        Location m2187 = new Location(2, 187, 0, 0);
        Sprite mountain2187 = new Sprite("mountain", m2187, null, 'm', null, true, false);
        terrain.add(mountain2187);

        Location m2188 = new Location(2, 188, 0, 0);
        Sprite mountain2188 = new Sprite("mountain", m2188, null, 'm', null, true, false);
        terrain.add(mountain2188);

        Location m2189 = new Location(2, 189, 0, 0);
        Sprite mountain2189 = new Sprite("mountain", m2189, null, 'm', null, true, false);
        terrain.add(mountain2189);

        Location m2190 = new Location(2, 190, 0, 0);
        Sprite mountain2190 = new Sprite("mountain", m2190, null, 'm', null, true, false);
        terrain.add(mountain2190);

        Location m2191 = new Location(2, 191, 0, 0);
        Sprite mountain2191 = new Sprite("mountain", m2191, null, 'm', null, true, false);
        terrain.add(mountain2191);

        Location m2192 = new Location(2, 192, 0, 0);
        Sprite mountain2192 = new Sprite("mountain", m2192, null, 'm', null, true, false);
        terrain.add(mountain2192);

        Location m2193 = new Location(2, 193, 0, 0);
        Sprite mountain2193 = new Sprite("mountain", m2193, null, 'm', null, true, false);
        terrain.add(mountain2193);

        Location m2194 = new Location(2, 194, 0, 0);
        Sprite mountain2194 = new Sprite("mountain", m2194, null, '/', null, true, false);
        terrain.add(mountain2194);

        Location m2195 = new Location(2, 195, 0, 0);
        Sprite mountain2195 = new Sprite("mountain", m2195, null, '/', null, true, false);
        terrain.add(mountain2195);

        Location g2196 = new Location(2, 196, 0, 0);
        Sprite grass2196 = new Sprite("grass", g2196, null, ' ', null, true, false);
        terrain.add(grass2196);

        Location g2197 = new Location(2, 197, 0, 0);
        Sprite grass2197 = new Sprite("grass", g2197, null, ' ', null, true, false);
        terrain.add(grass2197);

        Location g2198 = new Location(2, 198, 0, 0);
        Sprite grass2198 = new Sprite("grass", g2198, null, ' ', null, true, false);
        terrain.add(grass2198);

        Location b2199 = new Location(2, 199, 0, 0);
        Sprite border2199 = new Sprite("border", b2199, null, '|', null, true, false);
        terrain.add(border2199);

        /*-------------------------ROW 3---------------------------------------------*/
        Location b30 = new Location(3, 0, 0, 0);
        Sprite border30 = new Sprite("border", b30, null, '|', null, true, false);
        terrain.add(border30);

        Location g31 = new Location(3, 1, 0, 0);
        Sprite grass31 = new Sprite("grass", g31, null, ' ', null, true, false);
        terrain.add(grass31);

        Location g32 = new Location(3, 2, 0, 0);
        Sprite grass32 = new Sprite("grass", g32, null, ' ', null, true, false);
        terrain.add(grass32);

        Location g33 = new Location(3, 3, 0, 0);
        Sprite grass33 = new Sprite("grass", g33, null, ' ', null, true, false);
        terrain.add(grass33);

        Location g34 = new Location(3, 4, 0, 0);
        Sprite grass34 = new Sprite("grass", g34, null, ' ', null, true, false);
        terrain.add(grass34);

        Location g35 = new Location(3, 5, 0, 0);
        Sprite grass35 = new Sprite("grass", g35, null, ' ', null, true, false);
        terrain.add(grass35);

        Location g36 = new Location(3, 6, 0, 0);
        Sprite grass36 = new Sprite("grass", g36, null, ' ', null, true, false);
        terrain.add(grass36);

        Location g37 = new Location(3, 7, 0, 0);
        Sprite grass37 = new Sprite("grass", g37, null, ' ', null, true, false);
        terrain.add(grass37);

        Location g38 = new Location(3, 8, 0, 0);
        Sprite grass38 = new Sprite("grass", g38, null, ' ', null, true, false);
        terrain.add(grass38);

        Location g39 = new Location(3, 9, 0, 0);
        Sprite grass39 = new Sprite("grass", g39, null, ' ', null, true, false);
        terrain.add(grass39);

        Location g310 = new Location(3, 10, 0, 0);
        Sprite grass310 = new Sprite("grass", g310, null, ' ', null, true, false);
        terrain.add(grass310);

        Location g311 = new Location(3, 11, 0, 0);
        Sprite grass311 = new Sprite("grass", g311, null, ' ', null, true, false);
        terrain.add(grass311);

        Location g312 = new Location(3, 12, 0, 0);
        Sprite grass312 = new Sprite("grass", g312, null, ' ', null, true, false);
        terrain.add(grass312);

        Location g313 = new Location(3, 13, 0, 0);
        Sprite grass313 = new Sprite("grass", g313, null, ' ', null, true, false);
        terrain.add(grass313);

        Location g314 = new Location(3, 14, 0, 0);
        Sprite grass314 = new Sprite("grass", g314, null, ' ', null, true, false);
        terrain.add(grass314);

        Location g315 = new Location(3, 15, 0, 0);
        Sprite grass315 = new Sprite("grass", g315, null, ' ', null, true, false);
        terrain.add(grass315);

        Location g316 = new Location(3, 16, 0, 0);
        Sprite grass316 = new Sprite("grass", g316, null, ' ', null, true, false);
        terrain.add(grass316);

        Location g317 = new Location(3, 17, 0, 0);
        Sprite grass317 = new Sprite("grass", g317, null, ' ', null, true, false);
        terrain.add(grass317);

        Location g318 = new Location(3, 18, 0, 0);
        Sprite grass318 = new Sprite("grass", g318, null, ' ', null, true, false);
        terrain.add(grass318);

        Location g319 = new Location(3, 19, 0, 0);
        Sprite grass319 = new Sprite("grass", g319, null, ' ', null, true, false);
        terrain.add(grass319);

        Location g320 = new Location(3, 20, 0, 0);
        Sprite grass320 = new Sprite("grass", g320, null, ' ', null, true, false);
        terrain.add(grass320);

        Location g321 = new Location(3, 21, 0, 0);
        Sprite grass321 = new Sprite("grass", g321, null, ' ', null, true, false);
        terrain.add(grass321);

        Location g322 = new Location(3, 22, 0, 0);
        Sprite grass322 = new Sprite("grass", g322, null, ' ', null, true, false);
        terrain.add(grass322);

        Location g323 = new Location(3, 23, 0, 0);
        Sprite grass323 = new Sprite("grass", g323, null, ' ', null, true, false);
        terrain.add(grass323);

        Location g324 = new Location(3, 24, 0, 0);
        Sprite grass324 = new Sprite("grass", g324, null, ' ', null, true, false);
        terrain.add(grass324);

        Location g325 = new Location(3, 25, 0, 0);
        Sprite grass325 = new Sprite("grass", g325, null, ' ', null, true, false);
        terrain.add(grass325);

        Location w326 = new Location(3, 26, 0, 0);
        Sprite water326 = new Sprite("water", w326, null, '/', null, true, false);
        terrain.add(water326);

        Location w327 = new Location(3, 27, 0, 0);
        Sprite water327 = new Sprite("water", w327, null, '~', null, true, false);
        terrain.add(water327);

        Location w328 = new Location(3, 28, 0, 0);
        Sprite water328 = new Sprite("water", w328, null, '~', null, true, false);
        terrain.add(water328);

        Location w329 = new Location(3, 29, 0, 0);
        Sprite water329 = new Sprite("water", w329, null, '~', null, true, false);
        terrain.add(water329);

        Location w330 = new Location(3, 30, 0, 0);
        Sprite water330 = new Sprite("water", w330, null, '~', null, true, false);
        terrain.add(water330);

        Location w331 = new Location(3, 31, 0, 0);
        Sprite water331 = new Sprite("water", w331, null, '~', null, true, false);
        terrain.add(water331);

        Location w332 = new Location(3, 32, 0, 0);
        Sprite water332 = new Sprite("water", w332, null, '~', null, true, false);
        terrain.add(water332);

        Location w333 = new Location(3, 33, 0, 0);
        Sprite water333 = new Sprite("water", w333, null, '~', null, true, false);
        terrain.add(water333);

        Location w334 = new Location(3, 34, 0, 0);
        Sprite water334 = new Sprite("water", w334, null, '~', null, true, false);
        terrain.add(water334);

        Location w335 = new Location(3, 35, 0, 0);
        Sprite water335 = new Sprite("water", w335, null, '~', null, true, false);
        terrain.add(water335);

        Location w336 = new Location(3, 36, 0, 0);
        Sprite water336 = new Sprite("water", w236, null, '/', null, true, false);
        terrain.add(water336);

        Location g337 = new Location(3, 37, 0, 0);
        Sprite grass337 = new Sprite("grass", g337, null, ' ', null, true, false);
        terrain.add(grass337);

        Location g338 = new Location(3, 38, 0, 0);
        Sprite grass338 = new Sprite("grass", g338, null, ' ', null, true, false);
        terrain.add(grass338);

        Location g339 = new Location(3, 39, 0, 0);
        Sprite grass339 = new Sprite("grass", g339, null, ' ', null, true, false);
        terrain.add(grass339);

        Location g340 = new Location(3, 40, 0, 0);
        Sprite grass340 = new Sprite("grass", g340, null, ' ', null, true, false);
        terrain.add(grass340);

        Location g341 = new Location(3, 41, 0, 0);
        Sprite grass341 = new Sprite("grass", g341, null, ' ', null, true, false);
        terrain.add(grass341);

        Location g342 = new Location(3, 42, 0, 0);
        Sprite grass342 = new Sprite("grass", g342, null, ' ', null, true, false);
        terrain.add(grass342);

        Location g343 = new Location(3, 43, 0, 0);
        Sprite grass343 = new Sprite("grass", g343, null, ' ', null, true, false);
        terrain.add(grass343);

        Location g344 = new Location(3, 44, 0, 0);
        Sprite grass344 = new Sprite("grass", g344, null, ' ', null, true, false);
        terrain.add(grass344);

        Location g345 = new Location(3, 45, 0, 0);
        Sprite grass345 = new Sprite("grass", g345, null, ' ', null, true, false);
        terrain.add(grass345);

        Location g346 = new Location(3, 46, 0, 0);
        Sprite grass346 = new Sprite("grass", g346, null, ' ', null, true, false);
        terrain.add(grass346);

        Location g347 = new Location(3, 47, 0, 0);
        Sprite grass347 = new Sprite("grass", g347, null, ' ', null, true, false);
        terrain.add(grass347);

        Location g348 = new Location(3, 48, 0, 0);
        Sprite grass348 = new Sprite("grass", g348, null, ' ', null, true, false);
        terrain.add(grass348);

        Location g349 = new Location(3, 49, 0, 0);
        Sprite grass349 = new Sprite("grass", g349, null, ' ', null, true, false);
        terrain.add(grass349);

        Location g350 = new Location(3, 50, 0, 0);
        Sprite grass350 = new Sprite("grass", g350, null, ' ', null, true, false);
        terrain.add(grass350);

        Location g351 = new Location(3, 51, 0, 0);
        Sprite grass351 = new Sprite("grass", g351, null, ' ', null, true, false);
        terrain.add(grass351);

        Location g352 = new Location(3, 52, 0, 0);
        Sprite grass352 = new Sprite("grass", g352, null, ' ', null, true, false);
        terrain.add(grass352);

        Location g353 = new Location(3, 53, 0, 0);
        Sprite grass353 = new Sprite("grass", g353, null, ' ', null, true, false);
        terrain.add(grass353);

        Location g354 = new Location(3, 54, 0, 0);
        Sprite grass354 = new Sprite("grass", g354, null, ' ', null, true, false);
        terrain.add(grass354);

        Location g355 = new Location(3, 55, 0, 0);
        Sprite grass355 = new Sprite("grass", g355, null, ' ', null, true, false);
        terrain.add(grass355);

        Location g356 = new Location(3, 56, 0, 0);
        Sprite grass356 = new Sprite("grass", g356, null, ' ', null, true, false);
        terrain.add(grass356);

        Location g357 = new Location(3, 57, 0, 0);
        Sprite grass357 = new Sprite("grass", g357, null, ' ', null, true, false);
        terrain.add(grass357);

        Location g358 = new Location(3, 58, 0, 0);
        Sprite grass358 = new Sprite("grass", g358, null, ' ', null, true, false);
        terrain.add(grass358);

        Location g359 = new Location(3, 59, 0, 0);
        Sprite grass359 = new Sprite("grass", g359, null, ' ', null, true, false);
        terrain.add(grass359);

        Location g360 = new Location(3, 60, 0, 0);
        Sprite grass360 = new Sprite("grass", g360, null, ' ', null, true, false);
        terrain.add(grass360);

        Location g361 = new Location(3, 61, 0, 0);
        Sprite grass361 = new Sprite("grass", g361, null, ' ', null, true, false);
        terrain.add(grass361);

        Location g362 = new Location(3, 62, 0, 0);
        Sprite grass362 = new Sprite("grass", g362, null, ' ', null, true, false);
        terrain.add(grass362);

        Location g363 = new Location(3, 63, 0, 0);
        Sprite grass363 = new Sprite("grass", g363, null, ' ', null, true, false);
        terrain.add(grass363);

        Location g364 = new Location(3, 64, 0, 0);
        Sprite grass364 = new Sprite("grass", g364, null, ' ', null, true, false);
        terrain.add(grass364);

        Location g365 = new Location(3, 65, 0, 0);
        Sprite grass365 = new Sprite("grass", g365, null, ' ', null, true, false);
        terrain.add(grass365);

        Location g366 = new Location(3, 66, 0, 0);
        Sprite grass366 = new Sprite("grass", g366, null, ' ', null, true, false);
        terrain.add(grass366);

        Location g367 = new Location(3, 67, 0, 0);
        Sprite grass367 = new Sprite("grass", g367, null, ' ', null, true, false);
        terrain.add(grass367);

        Location g368 = new Location(3, 68, 0, 0);
        Sprite grass368 = new Sprite("grass", g368, null, ' ', null, true, false);
        terrain.add(grass368);

        Location g369 = new Location(3, 69, 0, 0);
        Sprite grass369 = new Sprite("grass", g369, null, ' ', null, true, false);
        terrain.add(grass369);

        Location g370 = new Location(3, 70, 0, 0);
        Sprite grass370 = new Sprite("grass", g370, null, ' ', null, true, false);
        terrain.add(grass370);

        Location g371 = new Location(3, 71, 0, 0);
        Sprite grass371 = new Sprite("grass", g371, null, ' ', null, true, false);
        terrain.add(grass371);

        Location g372 = new Location(3, 72, 0, 0);
        Sprite grass372 = new Sprite("grass", g372, null, ' ', null, true, false);
        terrain.add(grass372);

        Location g373 = new Location(3, 73, 0, 0);
        Sprite grass373 = new Sprite("grass", g373, null, ' ', null, true, false);
        terrain.add(grass373);

        Location g374 = new Location(3, 74, 0, 0);
        Sprite grass374 = new Sprite("grass", g374, null, ' ', null, true, false);
        terrain.add(grass374);

        Location g375 = new Location(3, 75, 0, 0);
        Sprite grass375 = new Sprite("grass", g375, null, ' ', null, true, false);
        terrain.add(grass375);

        Location g376 = new Location(3, 76, 0, 0);
        Sprite grass376 = new Sprite("grass", g376, null, ' ', null, true, false);
        terrain.add(grass376);

        Location g377 = new Location(3, 77, 0, 0);
        Sprite grass377 = new Sprite("grass", g377, null, ' ', null, true, false);
        terrain.add(grass377);

        Location g378 = new Location(3, 78, 0, 0);
        Sprite grass378 = new Sprite("grass", g378, null, ' ', null, true, false);
        terrain.add(grass378);

        Location g379 = new Location(3, 79, 0, 0);
        Sprite grass379 = new Sprite("grass", g379, null, ' ', null, true, false);
        terrain.add(grass379);

        Location g380 = new Location(3, 80, 0, 0);
        Sprite grass380 = new Sprite("grass", g380, null, ' ', null, true, false);
        terrain.add(grass380);

        Location g381 = new Location(3, 81, 0, 0);
        Sprite grass381 = new Sprite("grass", g381, null, ' ', null, true, false);
        terrain.add(grass381);

        Location g382 = new Location(3, 82, 0, 0);
        Sprite grass382 = new Sprite("grass", g382, null, ' ', null, true, false);
        terrain.add(grass382);

        Location g383 = new Location(3, 83, 0, 0);
        Sprite grass383 = new Sprite("grass", g383, null, ' ', null, true, false);
        terrain.add(grass383);

        Location g384 = new Location(3, 84, 0, 0);
        Sprite grass384 = new Sprite("grass", g384, null, ' ', null, true, false);
        terrain.add(grass384);

        Location g385 = new Location(3, 85, 0, 0);
        Sprite grass385 = new Sprite("grass", g385, null, ' ', null, true, false);
        terrain.add(grass385);

        Location g386 = new Location(3, 86, 0, 0);
        Sprite grass386 = new Sprite("grass", g386, null, ' ', null, true, false);
        terrain.add(grass386);

        Location g387 = new Location(3, 87, 0, 0);
        Sprite grass387 = new Sprite("grass", g387, null, ' ', null, true, false);
        terrain.add(grass387);

        Location g388 = new Location(3, 88, 0, 0);
        Sprite grass388 = new Sprite("grass", g388, null, ' ', null, true, false);
        terrain.add(grass388);

        Location g389 = new Location(3, 89, 0, 0);
        Sprite grass389 = new Sprite("grass", g389, null, ' ', null, true, false);
        terrain.add(grass389);

        Location g390 = new Location(3, 90, 0, 0);
        Sprite grass390 = new Sprite("grass", g390, null, ' ', null, true, false);
        terrain.add(grass390);

        Location g391 = new Location(3, 91, 0, 0);
        Sprite grass391 = new Sprite("grass", g391, null, ' ', null, true, false);
        terrain.add(grass391);

        Location g392 = new Location(3, 92, 0, 0);
        Sprite grass392 = new Sprite("grass", g392, null, ' ', null, true, false);
        terrain.add(grass392);

        Location g393 = new Location(3, 93, 0, 0);
        Sprite grass393 = new Sprite("grass", g393, null, ' ', null, true, false);
        terrain.add(grass393);

        Location g394 = new Location(3, 94, 0, 0);
        Sprite grass394 = new Sprite("grass", g394, null, ' ', null, true, false);
        terrain.add(grass394);

        Location g395 = new Location(3, 95, 0, 0);
        Sprite grass395 = new Sprite("grass", g395, null, ' ', null, true, false);
        terrain.add(grass395);

        Location g396 = new Location(3, 96, 0, 0);
        Sprite grass396 = new Sprite("grass", g396, null, ' ', null, true, false);
        terrain.add(grass396);

        Location g397 = new Location(3, 97, 0, 0);
        Sprite grass397 = new Sprite("grass", g397, null, ' ', null, true, false);
        terrain.add(grass397);

        Location g398 = new Location(3, 98, 0, 0);
        Sprite grass398 = new Sprite("grass", g398, null, ' ', null, true, false);
        terrain.add(grass398);

        Location g399 = new Location(3, 99, 0, 0);
        Sprite grass399 = new Sprite("grass", g399, null, ' ', null, true, false);
        terrain.add(grass399);

        Location g3100 = new Location(3, 100, 0, 0);
        Sprite grass3100 = new Sprite("grass", g3100, null, ' ', null, true, false);
        terrain.add(grass3100);

        Location g3101 = new Location(3, 101, 0, 0);
        Sprite grass3101 = new Sprite("grass", g3101, null, ' ', null, true, false);
        terrain.add(grass3101);

        Location g3102 = new Location(3, 102, 0, 0);
        Sprite grass3102 = new Sprite("grass", g3102, null, ' ', null, true, false);
        terrain.add(grass3102);

        Location g3103 = new Location(3, 103, 0, 0);
        Sprite grass3103 = new Sprite("grass", g3103, null, ' ', null, true, false);
        terrain.add(grass3103);

        Location g3104 = new Location(3, 104, 0, 0);
        Sprite grass3104 = new Sprite("grass", g3104, null, ' ', null, true, false);
        terrain.add(grass3104);

        Location g3105 = new Location(3, 105, 0, 0);
        Sprite grass3105 = new Sprite("grass", g3105, null, ' ', null, true, false);
        terrain.add(grass3105);

        Location g3106 = new Location(3, 106, 0, 0);
        Sprite grass3106 = new Sprite("grass", g3106, null, ' ', null, true, false);
        terrain.add(grass3106);

        Location g3107 = new Location(3, 107, 0, 0);
        Sprite grass3107 = new Sprite("grass", g3107, null, ' ', null, true, false);
        terrain.add(grass3107);

        Location g3108 = new Location(3, 108, 0, 0);
        Sprite grass3108 = new Sprite("grass", g3108, null, ' ', null, true, false);
        terrain.add(grass3108);

        Location g3109 = new Location(3, 109, 0, 0);
        Sprite grass3109 = new Sprite("grass", g3109, null, ' ', null, true, false);
        terrain.add(grass3109);

        Location g3110 = new Location(3, 110, 0, 0);
        Sprite grass3110 = new Sprite("grass", g3110, null, ' ', null, true, false);
        terrain.add(grass3110);

        Location g3111 = new Location(3, 111, 0, 0);
        Sprite grass3111 = new Sprite("grass", g3111, null, ' ', null, true, false);
        terrain.add(grass3111);

        Location g3112 = new Location(3, 112, 0, 0);
        Sprite grass3112 = new Sprite("grass", g3112, null, ' ', null, true, false);
        terrain.add(grass3112);

        Location g3113 = new Location(3, 113, 0, 0);
        Sprite grass3113 = new Sprite("grass", g3113, null, ' ', null, true, false);
        terrain.add(grass3113);

        Location g3114 = new Location(3, 114, 0, 0);
        Sprite grass3114 = new Sprite("grass", g3114, null, ' ', null, true, false);
        terrain.add(grass3114);

        Location g3115 = new Location(3, 115, 0, 0);
        Sprite grass3115 = new Sprite("grass", g3115, null, ' ', null, true, false);
        terrain.add(grass3115);

        Location g3116 = new Location(3, 116, 0, 0);
        Sprite grass3116 = new Sprite("grass", g3116, null, ' ', null, true, false);
        terrain.add(grass3116);

        Location g3117 = new Location(3, 117, 0, 0);
        Sprite grass3117 = new Sprite("grass", g3117, null, ' ', null, true, false);
        terrain.add(grass3117);

        Location g3118 = new Location(3, 118, 0, 0);
        Sprite grass3118 = new Sprite("grass", g3118, null, ' ', null, true, false);
        terrain.add(grass3118);

        Location g3119 = new Location(3, 119, 0, 0);
        Sprite grass3119 = new Sprite("grass", g3119, null, ' ', null, true, false);
        terrain.add(grass3119);

        Location g3120 = new Location(3, 120, 0, 0);
        Sprite grass3120 = new Sprite("grass", g3120, null, ' ', null, true, false);
        terrain.add(grass3120);

        Location g3121 = new Location(3, 121, 0, 0);
        Sprite grass3121 = new Sprite("grass", g3121, null, ' ', null, true, false);
        terrain.add(grass3121);

        Location g3122 = new Location(3, 122, 0, 0);
        Sprite grass3122 = new Sprite("grass", g3122, null, ' ', null, true, false);
        terrain.add(grass3122);

        Location g3123 = new Location(3, 123, 0, 0);
        Sprite grass3123 = new Sprite("grass", g3123, null, ' ', null, true, false);
        terrain.add(grass3123);

        Location g3124 = new Location(3, 124, 0, 0);
        Sprite grass3124 = new Sprite("grass", g3124, null, ' ', null, true, false);
        terrain.add(grass3124);

        Location g3125 = new Location(3, 125, 0, 0);
        Sprite grass3125 = new Sprite("grass", g3125, null, ' ', null, true, false);
        terrain.add(grass3125);

        Location g3126 = new Location(3, 126, 0, 0);
        Sprite grass3126 = new Sprite("grass", g3126, null, ' ', null, true, false);
        terrain.add(grass3126);

        Location g3127 = new Location(3, 127, 0, 0);
        Sprite grass3127 = new Sprite("grass", g3127, null, ' ', null, true, false);
        terrain.add(grass3127);

        Location g3128 = new Location(3, 128, 0, 0);
        Sprite grass3128 = new Sprite("grass", g3128, null, ' ', null, true, false);
        terrain.add(grass3128);

        Location g3129 = new Location(3, 129, 0, 0);
        Sprite grass3129 = new Sprite("grass", g3129, null, ' ', null, true, false);
        terrain.add(grass3129);

        Location g3130 = new Location(3, 130, 0, 0);
        Sprite grass3130 = new Sprite("grass", g3130, null, ' ', null, true, false);
        terrain.add(grass3130);

        Location g3131 = new Location(3, 131, 0, 0);
        Sprite grass3131 = new Sprite("grass", g3131, null, ' ', null, true, false);
        terrain.add(grass3131);

        Location g3132 = new Location(3, 132, 0, 0);
        Sprite grass3132 = new Sprite("grass", g3132, null, ' ', null, true, false);
        terrain.add(grass3132);

        Location g3133 = new Location(3, 133, 0, 0);
        Sprite grass3133 = new Sprite("grass", g3133, null, ' ', null, true, false);
        terrain.add(grass3133);

        Location g3134 = new Location(3, 134, 0, 0);
        Sprite grass3134 = new Sprite("grass", g3134, null, ' ', null, true, false);
        terrain.add(grass3134);

        Location g3135 = new Location(3, 135, 0, 0);
        Sprite grass3135 = new Sprite("grass", g3135, null, ' ', null, true, false);
        terrain.add(grass3135);

        Location g3136 = new Location(3, 136, 0, 0);
        Sprite grass3136 = new Sprite("grass", g3136, null, ' ', null, true, false);
        terrain.add(grass3136);

        Location g3137 = new Location(3, 137, 0, 0);
        Sprite grass3137 = new Sprite("grass", g3137, null, ' ', null, true, false);
        terrain.add(grass3137);

        Location g3138 = new Location(3, 138, 0, 0);
        Sprite grass3138 = new Sprite("grass", g3138, null, ' ', null, true, false);
        terrain.add(grass3138);

        Location g3139 = new Location(3, 139, 0, 0);
        Sprite grass3139 = new Sprite("grass", g3139, null, ' ', null, true, false);
        terrain.add(grass3139);

        Location g3140 = new Location(3, 140, 0, 0);
        Sprite grass3140 = new Sprite("grass", g3140, null, ' ', null, true, false);
        terrain.add(grass3140);

        Location g3141 = new Location(3, 141, 0, 0);
        Sprite grass3141 = new Sprite("grass", g3141, null, ' ', null, true, false);
        terrain.add(grass3141);

        Location g3142 = new Location(3, 142, 0, 0);
        Sprite grass3142 = new Sprite("grass", g3142, null, ' ', null, true, false);
        terrain.add(grass3142);

        Location g3143 = new Location(3, 143, 0, 0);
        Sprite grass3143 = new Sprite("grass", g3143, null, ' ', null, true, false);
        terrain.add(grass3143);

        Location g3144 = new Location(3, 144, 0, 0);
        Sprite grass3144 = new Sprite("grass", g3144, null, ' ', null, true, false);
        terrain.add(grass3144);

        Location g3145 = new Location(3, 145, 0, 0);
        Sprite grass3145 = new Sprite("grass", g3145, null, ' ', null, true, false);
        terrain.add(grass3145);

        Location g3146 = new Location(3, 146, 0, 0);
        Sprite grass3146 = new Sprite("grass", g3146, null, ' ', null, true, false);
        terrain.add(grass3146);

        Location g3147 = new Location(3, 147, 0, 0);
        Sprite grass3147 = new Sprite("grass", g3147, null, ' ', null, true, false);
        terrain.add(grass3147);

        Location g3148 = new Location(3, 148, 0, 0);
        Sprite grass3148 = new Sprite("grass", g3148, null, ' ', null, true, false);
        terrain.add(grass3148);

        Location g3149 = new Location(3, 149, 0, 0);
        Sprite grass3149 = new Sprite("grass", g3149, null, ' ', null, true, false);
        terrain.add(grass3149);

        Location g3150 = new Location(3, 150, 0, 0);
        Sprite grass3150 = new Sprite("grass", g3150, null, ' ', null, true, false);
        terrain.add(grass3150);

        Location g3151 = new Location(3, 151, 0, 0);
        Sprite grass3151 = new Sprite("grass", g3151, null, ' ', null, true, false);
        terrain.add(grass3151);

        Location g3152 = new Location(3, 152, 0, 0);
        Sprite grass3152 = new Sprite("grass", g3152, null, ' ', null, true, false);
        terrain.add(grass3152);

        Location g3153 = new Location(3, 153, 0, 0);
        Sprite grass3153 = new Sprite("grass", g3153, null, ' ', null, true, false);
        terrain.add(grass3153);

        Location g3154 = new Location(3, 154, 0, 0);
        Sprite grass3154 = new Sprite("grass", g3154, null, ' ', null, true, false);
        terrain.add(grass3154);

        Location g3155 = new Location(3, 155, 0, 0);
        Sprite grass3155 = new Sprite("grass", g3155, null, ' ', null, true, false);
        terrain.add(grass3155);

        Location g3156 = new Location(3, 156, 0, 0);
        Sprite grass3156 = new Sprite("grass", g3156, null, ' ', null, true, false);
        terrain.add(grass3156);

        Location g3157 = new Location(3, 157, 0, 0);
        Sprite grass3157 = new Sprite("grass", g3157, null, ' ', null, true, false);
        terrain.add(grass3157);

        Location g3158 = new Location(3, 158, 0, 0);
        Sprite grass3158 = new Sprite("grass", g3158, null, ' ', null, true, false);
        terrain.add(grass3158);

        Location g3159 = new Location(3, 159, 0, 0);
        Sprite grass3159 = new Sprite("grass", g3159, null, ' ', null, true, false);
        terrain.add(grass3159);

        Location g3160 = new Location(3, 160, 0, 0);
        Sprite grass3160 = new Sprite("grass", g3160, null, ' ', null, true, false);
        terrain.add(grass3160);

        Location g3161 = new Location(3, 161, 0, 0);
        Sprite grass3161 = new Sprite("grass", g3161, null, ' ', null, true, false);
        terrain.add(grass3161);

        Location g3162 = new Location(3, 162, 0, 0);
        Sprite grass3162 = new Sprite("grass", g3162, null, ' ', null, true, false);
        terrain.add(grass3162);

        Location g3163 = new Location(3, 163, 0, 0);
        Sprite grass3163 = new Sprite("grass", g3163, null, ' ', null, true, false);
        terrain.add(grass3163);

        Location g3164 = new Location(3, 164, 0, 0);
        Sprite grass3164 = new Sprite("grass", g3164, null, ' ', null, true, false);
        terrain.add(grass3164);

        Location g3165 = new Location(3, 165, 0, 0);
        Sprite grass3165 = new Sprite("grass", g3165, null, ' ', null, true, false);
        terrain.add(grass3165);

        Location g3166 = new Location(3, 166, 0, 0);
        Sprite grass3166 = new Sprite("grass", g3166, null, ' ', null, true, false);
        terrain.add(grass3166);

        Location g3167 = new Location(3, 167, 0, 0);
        Sprite grass3167 = new Sprite("grass", g3167, null, ' ', null, true, false);
        terrain.add(grass3167);

        Location g3168 = new Location(3, 168, 0, 0);
        Sprite grass3168 = new Sprite("grass", g3168, null, ' ', null, true, false);
        terrain.add(grass3168);

        Location g3169 = new Location(3, 169, 0, 0);
        Sprite grass3169 = new Sprite("grass", g3169, null, ' ', null, true, false);
        terrain.add(grass3169);

        Location g3170 = new Location(3, 170, 0, 0);
        Sprite grass3170 = new Sprite("grass", g3170, null, ' ', null, true, false);
        terrain.add(grass3170);

        Location g3171 = new Location(3, 171, 0, 0);
        Sprite grass3171 = new Sprite("grass", g3171, null, ' ', null, true, false);
        terrain.add(grass3171);

        Location g3172 = new Location(3, 172, 0, 0);
        Sprite grass3172 = new Sprite("grass", g3172, null, ' ', null, true, false);
        terrain.add(grass3172);

        Location g3173 = new Location(3, 173, 0, 0);
        Sprite grass3173 = new Sprite("grass", g3173, null, ' ', null, true, false);
        terrain.add(grass3173);

        Location g3174 = new Location(3, 174, 0, 0);
        Sprite grass3174 = new Sprite("grass", g3174, null, ' ', null, true, false);
        terrain.add(grass3174);

        Location g3175 = new Location(3, 175, 0, 0);
        Sprite grass3175 = new Sprite("grass", g3175, null, ' ', null, true, false);
        terrain.add(grass3175);

        Location g3176 = new Location(3, 176, 0, 0);
        Sprite grass3176 = new Sprite("grass", g3176, null, ' ', null, true, false);
        terrain.add(grass3176);

        Location g3177 = new Location(3, 177, 0, 0);
        Sprite grass3177 = new Sprite("grass", g3177, null, ' ', null, true, false);
        terrain.add(grass3177);

        Location g3178 = new Location(3, 178, 0, 0);
        Sprite grass3178 = new Sprite("grass", g3178, null, ' ', null, true, false);
        terrain.add(grass3178);

        Location g3179 = new Location(3, 179, 0, 0);
        Sprite grass3179 = new Sprite("grass", g3179, null, ' ', null, true, false);
        terrain.add(grass3179);

        Location g3180 = new Location(3, 180, 0, 0);
        Sprite grass3180 = new Sprite("grass", g3180, null, ' ', null, true, false);
        terrain.add(grass3180);

        Location g3181 = new Location(3, 181, 0, 0);
        Sprite grass3181 = new Sprite("grass", g3181, null, ' ', null, true, false);
        terrain.add(grass3181);

        Location g3182 = new Location(3, 182, 0, 0);
        Sprite grass3182 = new Sprite("grass", g3182, null, ' ', null, true, false);
        terrain.add(grass3182);

        Location g3183 = new Location(3, 183, 0, 0);
        Sprite grass3183 = new Sprite("grass", g3183, null, ' ', null, true, false);
        terrain.add(grass3183);

        Location m3184 = new Location(3, 184, 0, 0);
        Sprite mountain3184 = new Sprite("mountain", m3184, null, '|', null, true, false);
        terrain.add(mountain3184);

        Location m3185 = new Location(3, 185, 0, 0);
        Sprite mountain3185 = new Sprite("mountain", m3185, null, '|', null, true, false);
        terrain.add(mountain3185);

        Location m3186 = new Location(3, 186, 0, 0);
        Sprite mountain3186 = new Sprite("mountain", m3186, null, 'm', null, true, false);
        terrain.add(mountain3186);

        Location m3187 = new Location(3, 187, 0, 0);
        Sprite mountain3187 = new Sprite("mountain", m3187, null, 'm', null, true, false);
        terrain.add(mountain3187);

        Location m3188 = new Location(3, 188, 0, 0);
        Sprite mountain3188 = new Sprite("mountain", m3188, null, 'm', null, true, false);
        terrain.add(mountain3188);

        Location m3189 = new Location(3, 189, 0, 0);
        Sprite mountain3189 = new Sprite("mountain", m3189, null, 'm', null, true, false);
        terrain.add(mountain3189);

        Location m3190 = new Location(3, 190, 0, 0);
        Sprite mountain3190 = new Sprite("mountain", m3190, null, 'm', null, true, false);
        terrain.add(mountain3190);

        Location m3191 = new Location(3, 191, 0, 0);
        Sprite mountain3191 = new Sprite("mountain", m3191, null, 'm', null, true, false);
        terrain.add(mountain3191);

        Location m3192 = new Location(3, 192, 0, 0);
        Sprite mountain3192 = new Sprite("mountain", m3192, null, 'm', null, true, false);
        terrain.add(mountain3192);

        Location m3193 = new Location(3, 193, 0, 0);
        Sprite mountain3193 = new Sprite("mountain", m3193, null, '/', null, true, false);
        terrain.add(mountain3193);

        Location m3194 = new Location(3, 194, 0, 0);
        Sprite mountain3194 = new Sprite("mountain", m3194, null, '/', null, true, false);
        terrain.add(mountain3194);

        Location g3195 = new Location(3, 195, 0, 0);
        Sprite grass3195 = new Sprite("grass", g3195, null, ' ', null, true, false);
        terrain.add(grass3195);

        Location g3196 = new Location(3, 196, 0, 0);
        Sprite grass3196 = new Sprite("grass", g3196, null, ' ', null, true, false);
        terrain.add(grass3196);

        Location g3197 = new Location(3, 197, 0, 0);
        Sprite grass3197 = new Sprite("grass", g3197, null, ' ', null, true, false);
        terrain.add(grass3197);

        Location g3198 = new Location(3, 198, 0, 0);
        Sprite grass3198 = new Sprite("grass", g3198, null, ' ', null, true, false);
        terrain.add(grass3198);

        Location b3199 = new Location(3, 199, 0, 0);
        Sprite border3199 = new Sprite("border", b3199, null, '|', null, true, false);
        terrain.add(border3199);

        /*-------------------------------ROW 4----------------------------------------*/
    }

    public void createItemArray(ArrayList<Sprite> items) {
        //String[] items,chest19624 = new items(coord, "chest", image, true,);

    }

=======
>>>>>>> master
    /**
     * Purpose: To check and see if the players move will collide with an enemy
     * on the map.
     *
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with an enemy
     */
    /*
    private boolean check(Player player, String move, ArrayList<Enemy> enemy) {
        int playerLeft, playerRight, playerUp, playerDown;
        int objLeft, objRight, objUp, objDown;
        // this gets me the instance of the players location
        playerLeft = player.getCoord().getxCoord() - player.getCoord().getxSize();
        playerRight = player.getCoord().getxCoord() + player.getCoord().getxSize();
        playerUp = player.getCoord().getyCoord() - player.getCoord().getySize();
        playerDown = palyer.getCoord().getyCoord() + player.getCoord().getySize();

        if (!enemy.isEmpty() && (player != null)) { // check to make sure move is valid
            for (int i = 0; i < enemy.length(); i++) {
                objLeft = enemy.get(i).getCoord().getxCoord() - enemy.getCoord().getxSize();
                objRight = enemy.get(i).getCoord().getxCoord() + enemy.getCoord().getxSize();
                objUp = enemy.get(i).getCoord().getyCoord() - enemy.getCoord().getySize();
                objDown = enemy.get(i).getCoord().getyCoord() + enemy.getCoord().getySize();

                if ((playerRight == objLeft) || (playerLeft == objRight) ||
                        (playerUp == objDown) || (playerDown == objUp)) {
                    return true;
                }
            }
        }
        return false;
    }
     */
    /**
     * Purpose: To check and see if the players move will collide with a terrain
     * tile that cannot be crossed (ie. mountains).
     *
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with a terrain tile that is
     * un-crossable
     */
    /*
    private boolean check(Player player, String move, ArrayList<Sprite> obj) {
        int playerLeft, playerRight, playerUp, playerDown;
        int objLeft, objRight, objUp, objDown;
        // this gets me the instance of the players location
        // check if player is valid and not null
        playerLeft = player.getCoord().getxCoord() - player.getCoord().getxSize();
        playerRight = player.getCoord().getxCoord() + player.getCoord().getxSize();
        playerUp = player.getCoord().getyCoord() - player.getCoord().getySize();
        playerDown = palyer.getCoord().getyCoord() + player.getCoord().getySize();

        switch (move) {
            case "left":
                playerLeft -= 1;
                playerRight -= 1; // compensate for movement
                break;
            case "right":
                playerRight += 1;
                playerLeft += 1; // compensate for movement
                break;
            case "up":
                playerUp -= 1;
                playerDown -= 1; // compensate for movement
                break;
            case "down":
                playerDown += 1;
                playerUp += 1; // compensate for movement
                break;
            default:
                // need an error message of some kind
        }

        if (!obj.isEmpty()) { // check to make sure move is valid
            for (int i = 0; i < obj.length(); i++) {
                objLeft = obj.get(i).getCoord().getxCoord() - obj.getCoord().getxSize();
                objRight = obj.get(i).getCoord().getxCoord() + obj.getCoord().getxSize();
                objUp = obj.get(i).getCoord().getyCoord() - obj.getCoord().getySize();
                objDown = obj.get(i).getCoord().getyCoord() + obj.getCoord().getySize();

                if ((playerRight == objLeft) || (playerLeft == objRight) ||
                        (playerUp == objDown) || (playerDown == objUp)) {
                    return true;
                }
            }
        }
        return false;
    }
     */
    /**
     * Purpose: To check and see if the players move will collide with an edge
     * of the map.
     *
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with an edge of the map
     */
    /*    private boolean checkEdges(Player player, String move) {
        int playerLeft, playerRight, playerUp, playerDown;
        int objLeft, objRight, objUp, objDown;
        // this gets me the instance of the players location
        playerLeft = player.getCoord().getxCoord() - player.getCoord().getxSize();
        playerRight = player.getCoord().getxCoord() + player.getCoord().getxSize();
        playerUp = player.getCoord().getyCoord() - player.getCoord().getySize();
        playerDown = palyer.getCoord().getyCoord() + player.getCoord().getySize();

        if (!items.isEmpty() && (player != null) && ) { // check to make sure move is valid

        }
        return false;
    }
     */
    /**
     * Purpose: To check and see if the player has obtained tall of the keys
     * necessary to unlock the gate to the final boss.
     *
     * @param player an instance of the player class in the current game
     * @return a boolean value for if the player meets the condition to unlock
     */
    private boolean checkGate(Player player) {
        // also update images
        return (player.getKeyCount() == totalKeys - 1) ? true : false;
    }

    /**
     *
     */
    /*private void updatePosition(Player player, String move) {
        // move will only be up, down, left, and right
        int xCoord = player.

        player.updatePosition();
        return;
    }*/
    /**
     * @param e - Enemy who is battling the player. should be found by the
     * collision detection
     */
    private void engageBattle(Enemy enemy) {
        BattleLoop b = new BattleLoop();
        int i = 0;
        Player player = new Player();
        String attacks[] = {"Slash", "Butter Boomerang", "Parry", "Potion"};
        player.setMoves(attacks);
        player.setHealth(100);
        Enemy e = new Enemy();
        String eAttacks[] = {"Slash", "Margarine Missile", "Parry", "Potion"};
        e.setHealth(100);
        e.setMoves(eAttacks);
        ArrayList<Potion> arrayList = new ArrayList<>();
        Potion p = new Potion();
        Potion q = new Potion();
        q.setHealthBoost(25);
        ArrayList<Sprite> pl = new ArrayList<>();
        pl.add(q);
        player.setItems(pl);
        p.setHealthBoost(25);
        arrayList.add(p);
        e.setPotions(arrayList);
        int bbCounter = 0;  // keeps track of turns for Butter boomerang attack
        int mmCounter = 0;  // keeps track of turns for Margarine missile attack
        int damage;
        while (i == 0) {
            if (bbCounter == 0) {
                String attack = b.playerInput(player);
                switch (attack) {
                    case "Slash":
                        damage = 15;
                        b.damageCalc(damage, e);
                        break;
                    case "Butter Boomerang":
                        bbCounter = 1;
                        break;
                    case "Parry":
                        b.setUsedParry(true);
                        break;
                    case "Potion":
                        b.usePotion(player);
                        break;
                }
            } else if (bbCounter == 2) {
                damage = 40;
                b.damageCalc(damage, e);
                bbCounter = 0;
            }
            if (b.getEnemyUsedParry()) {
                b.setEnemyUsedParry(false);
            }
            if (b.checkWinState(e) == true) {
                b.drawState(player, e);
                System.out.println("You Win!");
                break;
            }
            if (mmCounter == 1) {
                mmCounter = 2;
//                if (b.getUsedParry()) {
//                    b.setUsedParry(false);
//                }
            }
            //  b.drawState(player, e);
            if (mmCounter == 0) {
                String eAttack = e.attackLogic(player);
                switch (eAttack) {
                    case "Slash":
                        damage = 15;
                        b.damageCalc(damage, player);
                        System.out.println("Enemy used " + eAttack);
                        break;
                    case "Margarine Missile":
                        mmCounter = 1;
                        System.out.println("Enemy used " + eAttack);
                        break;
                    case "Parry":
                        b.setEnemyUsedParry(true);
                        System.out.println("Enemy used " + eAttack);
                        break;
                    case "Potion":
                        b.usePotion(e);
                        System.out.println("Enemy used " + eAttack);
                        break;
                }
            } else if (mmCounter == 2) {
                damage = 40;
                b.damageCalc(damage, player);
                mmCounter = 0;
            }
            if (b.getUsedParry()) {
                b.setUsedParry(false);
            }
            if (b.checkLoseState(player) == true) {
                b.drawState(player, e);
                System.out.println("You lose");
                break;
            }
            if (bbCounter == 1) {
                bbCounter = 2;
//                if (b.getEnemyUsedParry()) {
//                    b.setEnemyUsedParry(false);
//                }
            }
            b.drawState(player, e);

        }

    }

    /*--------------------------- GETTER/SETTERS -----------------------------*/
    /**
     * Purpose: To retrieve the array list for the terrain objects
     *
     * @return an array list containing the terrain objects
     */
    public ArrayList<Sprite> getTerrain() {
        return new ArrayList<Sprite>(this.terrain); //create copy of the list
    }

    /**
     * Purpose: To retrieve the array list for the item objects
     *
     * @return an array list containing the item objects
     */
    public ArrayList<Sprite> getItem() {
        return new ArrayList<Sprite>(this.items); //create copy of the list
    }

    /**
     * Purpose: To retrieve the array list for the enemy objects
     *
     * @return an array list containing the enemy objects
     */
    public ArrayList<Enemy> getEnemy() {
        return new ArrayList<Enemy>(this.enemy); //create copy of the list
    }

    /**
     * Purpose: To retrieve the number of keys in the game
     *
     * @return the totalKeys
     */
    public int getTotalKeys() {
        return totalKeys;
    }

    /**
     * Purpose: To get the value of the win state variable
     *
     * @return the win state condition flag
     */
    public boolean checkWinState() {
        return winState; // returns true if true else false
    }

    /**
     * Purpose: To get the value of the lose state variable
     *
     * @return the lose state condition flag
     */
    public boolean checkLoseState() {
        return loseState; // returns true if true else false
    }

    /**
     * Purpose: To set a new terrain objects list for the current game
     *
     * @param newTerrainList an array list of terrain objects
     */
    public void setTerrain(ArrayList<Sprite> newTerrainList) {
        if (newTerrainList != null) {
            this.terrain = newTerrainList;
        }
    }

    /**
     * Purpose: To set a new item objects list for the current game
     *
     * @param newItemList an array list of item objects
     */
    public void setItem(ArrayList<Sprite> newItemList) {
        if (newItemList != null) {
            this.items = newItemList;
        }
    }

    /**
     * Purpose: To set a new enemy list for the current game
     *
     * @param newEnemyList an array list of enemy objects
     */
    public void setEnemy(ArrayList<Enemy> newEnemyList) {
        if (newEnemyList != null) {
            this.enemy = newEnemyList;
        }
    }

    /**
     * Purpose: To change the win state boolean value
     *
     * @param value the new boolean value to set winState to
     */
    public void setWinState(boolean value) {
        this.winState = value;
    }

    /**
     * Purpose: To change the lose state boolean value
     *
     * @param value the new boolean value to set loseState to
     */
    public void setLoseState(boolean value) {
        this.loseState = value;
    }

    /*--------------------------- PUBLIC METHODS -----------------------------*/
    /**
     * player is needed since it is not of this class
     */
    /*    public void drawState(Player player) {
        // this needs to print to standard out the map for the terminal version
        // perhaps a nested for loop to print out the array of arrays of locations
        return;
    }
     */
    /**
     * Purpose: To equip the player with an item when they come across one and
     * add it to their inventory.
     *
     * @param player an instance of the player class
     * @param item the item that the user will add to their inventory
     * @throws ? not sure yet
     */
    /*    public void pickUpItem(Player player, Sprite item) {
        if (((item instanceof Potion) || (item instanceof Weapon) ||
                (item instanceof Defence)) && (player != null)) {
            player.addItem(item); // can only take a poition, weapon or defensive item
        }
        else {
            // raise an error?
        }
        return;
    }
     */
    /**
     * Purpose: To obtain the users input for moving around the game board
     *
     * @return a string representation of the users directional choice
     */
    public String playerInput() {
        Console console = System.console();
        String input;
        String userPrompt = "Please make a move (wasd): ";
        String error = "Invalid input";
        boolean valid = false;

        if (console == null) {
            return null;
        }
        do {
            input = console.readLine(userPrompt);
            if (input.toLowerCase().equals("w") || input.toLowerCase().equals("a")
                    || input.toLowerCase().equals("s") || input.toLowerCase().equals("d")) {
                valid = true;
            } else {
                System.out.println(error);
            }
        } while (!valid);
        // convert characters into representative symbols
        switch (input) {
            case "w":
                input = "up";
                break;
            case "a":
                input = "left";
                break;
            case "s":
                input = "down";
                break;
            case "d":
                input = "right";
                break;
        }
        return input;
    }

    /**
     * Purpose: To check all possible collisions in the game and return true or
     * false depending.
     *
     * @param player an instance of the player class
     * @param move a string representation of the users input
     * @return false if a collision was detected else true
     */
    public boolean checkCollisions(Player player, String move) {
        boolean collision = true;

        // check all collisions and if any are false
//        if (!checkEdges(player, move) || !checkTerrain(player, move, terrain) ||
//                !checkEnemy(player, move, enemy) || !checkItems(player, move, items)) {
//            collision = (collision == true) ? false : collision; // if its false make it true else keep it what it was
//        }
        return collision;
    }

    /**
     * Purpose: To allow the ability to test methods
     */
    public static void main(String[] args) {
        // for testing methods
        GameLoop gl = new GameLoop();
        Player p1 = new Player("Montequilla", new Location(0, 0, 0, 0), null, 'x',
                null, true, false, 100, 50, 50, null);
        System.out.println(p1);
    }
}
