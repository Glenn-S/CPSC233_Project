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

    private void initialize() {
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


    /**
     * Purpose: This function is used to create/set up the enemy array ArrayList
     * every enemy has to be instantiated, and set up individually, then added to
     * the item array ArrayList
     *
     * @param  enemy  This is the enemy array list. It is passed, which means it is being
     * refrenced. Any changes made to the array list in this function will change the
     * array list outside as well
     */
public void createEnemyArray(ArrayList<Enemy> enemy)
{
  String[] moves = {"up", "down","left","right"};

  Enemy grunt65 = new Enemy(100,100,100,moves,false,true);
  enemy.add(grunt65);

  Enemy grunt5437 = new Enemy(100,100,100,moves,false,true);
  enemy.add(grunt5437);

  Enemy grunt402 = new Enemy(100,100,100,moves,false,true);
  enemy.add(grunt402);

  Enemy boss1966 = new Enemy(200,200,200,moves,false,true);
  enemy.add(boss1966);
}
public void createTerrainArray(ArrayList<Sprite> terrain)
{
/*------------------------ROW 0----------------------------------------------*/

  Location b00 = new Location(0,0,0,0);
  Sprite border00 = new Sprite("border", b00, null,'-', null, true, false);
  terrain.add(border00);

  Location b01 = new Location(0,1,0,0);
  Sprite border01 = new Sprite("border", b01, null, '-', null, true, false);
  terrain.add(border01);

  Location b02 = new Location(0,2,0,0);
  Sprite border02 = new Sprite("border",b02, null, '-', null, true, false);
  terrain.add(border02);

  Location b03 = new Location(0,3,0,0);
  Sprite border03 = new Sprite("border",b03, null, '-', null, true, false);
  terrain.add(border03);

  Location b04 = new Location(0,4,0,0);
  Sprite border04 = new Sprite("border",b04, null, '-', null, true, false);
  terrain.add(border04);

  Location b05 = new Location(0,5,0,0);
  Sprite border05 = new Sprite("border",b05, null, '-', null, true, false);
  terrain.add(border05);

  Location b06 = new Location(0,6,0,0);
  Sprite border06 = new Sprite("border",b06, null, '-', null, true, false);
  terrain.add(border06);

  Location b07 = new Location(0,7,0,0);
  Sprite border07 = new Sprite("border",b07, null, '-', null, true, false);
  terrain.add(border07);

  Location b08 = new Location(0,8,0,0);
  Sprite border08 = new Sprite("border",b08, null, '-', null, true, false);
  terrain.add(border08);

  Location b09 = new Location(0,9,0,0);
  Sprite border09 = new Sprite("border",b09, null, '-', null, true, false);
  terrain.add(border09);

  Location b010 = new Location(0,10,0,0);
  Sprite border010 = new Sprite("border",b010, null, '-', null, true, false);
  terrain.add(border010);

  Location b011 = new Location(0,11,0,0);
  Sprite border011 = new Sprite("border",b011, null, '-', null, true, false);
  terrain.add(border011);

  Location b012 = new Location(0,12,0,0);
  Sprite border012 = new Sprite("border",b012, null, '-', null, true, false);
  terrain.add(border012);

  Location b013 = new Location(0,13,0,0);
  Sprite border013 = new Sprite("border",b013, null, '-', null, true, false);
  terrain.add(border013);

  Location b014 = new Location(0,14,0,0);
  Sprite border014 = new Sprite("border",b014, null, '-', null, true, false);
  terrain.add(border014);

  Location b015 = new Location(0,15,0,0);
  Sprite border015 = new Sprite("border",b015, null, '-', null, true, false);
  terrain.add(border015);

  Location b016 = new Location(0,16,0,0);
  Sprite border016 = new Sprite("border",b016, null, '-', null, true, false);
  terrain.add(border016);


  Location b017 = new Location(0,17,0,0);
  Sprite border017 = new Sprite("border",b017, null, '-', null, true, false);
  terrain.add(border017);

  Location b018 = new Location(0,18,0,0);
  Sprite border018 = new Sprite("border",b018, null, '-', null, true, false);
  terrain.add(border018);

  Location b019 = new Location(0,19,0,0);
  Sprite border019 = new Sprite("border",b019, null, '-', null, true, false);
  terrain.add(border019);

  Location b020 = new Location(0,20,0,0);
  Sprite border020 = new Sprite("border",b020, null, '-', null, true, false);
  terrain.add(border020);

  Location b021 = new Location(0,21,0,0);
  Sprite border021 = new Sprite("border",b021, null, '-', null, true, false);
  terrain.add(border021);

  Location b022 = new Location(0,22,0,0);
  Sprite border022 = new Sprite("border",b022, null, '-', null, true, false);
  terrain.add(border022);

  Location b023 = new Location(0,23,0,0);
  Sprite border023 = new Sprite("border",b023, null, '-', null, true, false);
  terrain.add(border023);

  Location b024 = new Location(0,24,0,0);
  Sprite border024 = new Sprite("border",b024, null, '-', null, true, false);
  terrain.add(border024);

  Location b025 = new Location(0,25,0,0);
  Sprite border025 = new Sprite("border",b025, null, '-', null, true, false);
  terrain.add(border025);

  Location b026 = new Location(0,26,0,0);
  Sprite border026 = new Sprite("border",b026, null, '-', null, true, false);
  terrain.add(border026);

  Location b027 = new Location(0,27,0,0);
  Sprite border027 = new Sprite("border",b027, null, '-', null, true, false);
  terrain.add(border027);

  Location b028 = new Location(0,28,0,0);
  Sprite border028 = new Sprite("border",b028, null, '-', null, true, false);
  terrain.add(border028);

  Location b029 = new Location(0,29,0,0);
  Sprite border029 = new Sprite("border",b029, null, '-', null, true, false);
  terrain.add(border029);

  Location b030 = new Location(0,30,0,0);
  Sprite border030 = new Sprite("border",b030, null, '-', null, true, false);
  terrain.add(border030);

  Location b031 = new Location(0,31,0,0);
  Sprite border031 = new Sprite("border",b031, null, '-', null, true, false);
  terrain.add(border031);

  Location b032 = new Location(0,32,0,0);
  Sprite border032 = new Sprite("border",b032, null, '-', null, true, false);
  terrain.add(border032);

  Location b033 = new Location(0,33,0,0);
  Sprite border033 = new Sprite("border",b033, null, '-', null, true, false);
  terrain.add(border033);

  Location b034 = new Location(0,34,0,0);
  Sprite border034 = new Sprite("border",b034, null, '-', null, true, false);
  terrain.add(border034);

  Location b035 = new Location(0,35,0,0);
  Sprite border035 = new Sprite("border",b035, null, '-', null, true, false);
  terrain.add(border035);

  Location b036 = new Location(0,36,0,0);
  Sprite border036 = new Sprite("border",b036, null, '-', null, true, false);
  terrain.add(border036);

  Location b037 = new Location(0,37,0,0);
  Sprite border037 = new Sprite("border",b037, null, '-', null, true, false);
  terrain.add(border037);

  Location b038 = new Location(0,38,0,0);
  Sprite border038 = new Sprite("border",b038, null, '-', null, true, false);
  terrain.add(border038);

  Location b039 = new Location(0,39,0,0);
  Sprite border039 = new Sprite("border",b039, null, '-', null, true, false);
  terrain.add(border039);

  Location b040 = new Location(0,40,0,0);
  Sprite border040 = new Sprite("border",b040, null, '-', null, true, false);
  terrain.add(border040);

  Location b041 = new Location(0,41,0,0);
  Sprite border041 = new Sprite("border",b041, null, '-', null, true, false);
  terrain.add(border041);

  Location b042 = new Location(0,42,0,0);
  Sprite border042 = new Sprite("border",b042, null, '-', null, true, false);
  terrain.add(border042);

  Location b043 = new Location(0,43,0,0);
  Sprite border043 = new Sprite("border",b043, null, '-', null, true, false);
  terrain.add(border043);

  Location b044 = new Location(0,44,0,0);
  Sprite border044 = new Sprite("border",b044, null, '-', null, true, false);
  terrain.add(border044);

  Location b045 = new Location(0,45,0,0);
  Sprite border045 = new Sprite("border",b045, null, '-', null, true, false);
  terrain.add(border045);

  Location b046 = new Location(0,46,0,0);
  Sprite border046 = new Sprite("border",b046, null, '-', null, true, false);
  terrain.add(border046);

  Location b047 = new Location(0,47,0,0);
  Sprite border047 = new Sprite("border",b047, null, '-', null, true, false);
  terrain.add(border047);

  Location b048 = new Location(0,48,0,0);
  Sprite border048 = new Sprite("border",b048, null, '-', null, true, false);
  terrain.add(border048);

  Location b049 = new Location(0,49,0,0);
  Sprite border049 = new Sprite("border",b049, null, '-', null, true, false);
  terrain.add(border049);

  Location b050 = new Location(0,50,0,0);
  Sprite border050 = new Sprite("border",b050, null, '-', null, true, false);
  terrain.add(border0350);

  Location b051 = new Location(0,51,0,0);
  Sprite border051 = new Sprite("border",b051, null, '-', null, true, false);
  terrain.add(border051);

  Location b052 = new Location(0,52,0,0);
  Sprite border052 = new Sprite("border",b052, null, '-', null, true, false);
  terrain.add(border052);

  Location b053 = new Location(0,53,0,0);
  Sprite border053 = new Sprite("border",b053, null, '-', null, true, false);
  terrain.add(border053);

  Location b054 = new Location(0,54,0,0);
  Sprite border054 = new Sprite("border",b054, null, '-', null, true, false);
  terrain.add(border054);

  Location b055 = new Location(0,55,0,0);
  Sprite border055 = new Sprite("border",b055, null, '-', null, true, false);
  terrain.add(border055);

  Location b057 = new Location(0,57,0,0);
  Sprite border057 = new Sprite("border",b057, null, '-', null, true, false);
  terrain.add(border056);

  Location b058 = new Location(0,58,0,0);
  Sprite border058= new Sprite("border",b058, null, '-', null, true, false);
  terrain.add(border058);

  Location b059 = new Location(0,59,0,0);
  Sprite border059 = new Sprite("border",b059, null, '-', null, true, false);
  terrain.add(border059);

  Location b060 = new Location(0,60,0,0);
  Sprite border060 = new Sprite("border",b060, null, '-', null, true, false);
  terrain.add(border060);

  Location b061 = new Location(0,61,0,0);
  Sprite border061 = new Sprite("border",b061, null, '-', null, true, false);
  terrain.add(border061);

  Location b062 = new Location(0,62,0,0);
  Sprite border062 = new Sprite("border",b062, null, '-', null, true, false);
  terrain.add(border062);

  Location b063 = new Location(0,63,0,0);
  Sprite border063 = new Sprite("border",b063, null, '-', null, true, false);
  terrain.add(border063);

  Location b064 = new Location(0,64,0,0);
  Sprite border064 = new Sprite("border",b064, null, '-', null, true, false);
  terrain.add(border064);

  Location b065 = new Location(0,65,0,0);
  Sprite border65 = new Sprite("border",b065, null, '-', null, true, false);
  terrain.add(border065);

  Location b066 = new Location(0,66,0,0);
  Sprite border066 = new Sprite("border",b066, null, '-', null, true, false);
  terrain.add(border066);

  Location b067 = new Location(0,67,0,0);
  Sprite border067 = new Sprite("border",b067, null, '-', null, true, false);
  terrain.add(border067);

  Location b068 = new Location(0,68,0,0);
  Sprite border068 = new Sprite("border",b068, null, '-', null, true, false);
  terrain.add(border068);

  Location b069 = new Location(0,69,0,0);
  Sprite border069 = new Sprite("border",b069, null, '-', null, true, false);
  terrain.add(border069);

  Location b070 = new Location(0,70,0,0);
  Sprite border070 = new Sprite("border",b070, null, '-', null, true, false);
  terrain.add(border070);

  Location b071 = new Location(0,71,0,0);
  Sprite border071 = new Sprite("border",b071, null, '-', null, true, false);
  terrain.add(border071);

  Location b072 = new Location(0,72,0,0);
  Sprite border072 = new Sprite("border",b072, null, '-', null, true, false);
  terrain.add(border072);

  Location b073 = new Location(0,73,0,0);
  Sprite border073 = new Sprite("border",b073, null, '-', null, true, false);
  terrain.add(border073);

  Location b074 = new Location(0,74,0,0);
  Sprite border074 = new Sprite("border",b074, null, '-', null, true, false);
  terrain.add(border074);

  Location b075 = new Location(0,75,0,0);
  Sprite border075 = new Sprite("border",b075, null, '-', null, true, false);
  terrain.add(border075);

  Location b076 = new Location(0,76,0,0);
  Sprite border076 = new Sprite("border",b076, null, '-', null, true, false);
  terrain.add(border076);

  Location b077 = new Location(0,77,0,0);
  Sprite border077 = new Sprite("border",b077, null, '-', null, true, false);
  terrain.add(border077);

  Location b078 = new Location(0,78,0,0);
  Sprite border078 = new Sprite("border",b078, null, '-', null, true, false);
  terrain.add(border078);

  Location b079 = new Location(0,79,0,0);
  Sprite border079 = new Sprite("border",b079, null, '-', null, true, false);
  terrain.add(border079);

  Location b080 = new Location(0,80,0,0);
  Sprite border080 = new Sprite("border",b080, null, '-', null, true, false);
  terrain.add(border080);

  Location b081 = new Location(0,81,0,0);
  Sprite border081 = new Sprite("border",b081, null, '-', null, true, false);
  terrain.add(border081);

  Location b082 = new Location(0,82,0,0);
  Sprite border082 = new Sprite("border",b082, null, '-', null, true, false);
  terrain.add(border082);

  Location b083 = new Location(0,83,0,0);
  Sprite border083 = new Sprite("border",b083, null, '-', null, true, false);
  terrain.add(border083);

  Location b084 = new Location(0,84,0,0);
  Sprite border084 = new Sprite("border",b084, null, '-', null, true, false);
  terrain.add(border084);

  Location b085 = new Location(0,85,0,0);
  Sprite border085 = new Sprite("border",b085, null, '-', null, true, false);
  terrain.add(border085);

  Location b086 = new Location(0,86,0,0);
  Sprite border086 = new Sprite("border",b086, null, '-', null, true, false);
  terrain.add(border086);

  Location b087 = new Location(0,87,0,0);
  Sprite border087 = new Sprite("border",b087, null, '-', null, true, false);
  terrain.add(border087);

  Location b088 = new Location(0,88,0,0);
  Sprite border088 = new Sprite("border",b088, null, '-', null, true, false);
  terrain.add(border088);

  Location b089 = new Location(0,89,0,0);
  Sprite border089 = new Sprite("border",b089, null, '-', null, true, false);
  terrain.add(border089);

  Location b090 = new Location(0,90,0,0);
  Sprite border090 = new Sprite("border",b090, null, '-', null, true, false);
  terrain.add(border090);

  Location b091 = new Location(0,91,0,0);
  Sprite border091 = new Sprite("border",b091, null, '-', null, true, false);
  terrain.add(border091);

  Location b092 = new Location(0,92,0,0);
  Sprite border092 = new Sprite("border",b092, null, '-', null, true, false);
  terrain.add(border092);

  Location b093 = new Location(0,93,0,0);
  Sprite border093 = new Sprite("border",b093, null, '-', null, true, false);
  terrain.add(border093);

  Location b094 = new Location(0,94,0,0);
  Sprite border094 = new Sprite("border",b094, null, '-', null, true, false);
  terrain.add(border094);

  Location b095 = new Location(0,95,0,0);
  Sprite border095 = new Sprite("border",b095, null, '-', null, true, false);
  terrain.add(border095);

  Location b096 = new Location(0,96,0,0);
  Sprite border096 = new Sprite("border",b096, null, '-', null, true, false);
  terrain.add(border096);

  Location b097 = new Location(0,97,0,0);
  Sprite border097 = new Sprite("border",b097, null, '-', null, true, false);
  terrain.add(border097);

  Location b098 = new Location(0,98,0,0);
  Sprite border098 = new Sprite("border",b098, null, '-', null, true, false);
  terrain.add(border098);

  Location b099 = new Location(0,99,0,0);
  Sprite border099 = new Sprite("border",b099, null, '-', null, true, false);
  terrain.add(border099);

  Location b0100 = new Location(0,100,0,0);
  Sprite border0100 = new Sprite("border",b0100, null, '-', null, true, false);
  terrain.add(border0100);

  Location b0101 = new Location(0,101,0,0);
  Sprite border0101 = new Sprite("border",b0101, null, '-', null, true, false);
  terrain.add(border0101);

  Location b0102 = new Location(0,102,0,0);
  Sprite border0102 = new Sprite("border",b0102, null, '-', null, true, false);
  terrain.add(border0102);

  Location b0103 = new Location(0,103,0,0);
  Sprite border0103 = new Sprite("border",b0103, null, '-', null, true, false);
  terrain.add(border0103);

  Location b0104 = new Location(0,104,0,0);
  Sprite border0104 = new Sprite("border",b0104, null, '-', null, true, false);
  terrain.add(border0104);

  Location b0105 = new Location(0,105,0,0);
  Sprite border0105 = new Sprite("border",b0105, null, '-', null, true, false);
  terrain.add(border0105);

  Location b0106 = new Location(0,106,0,0);
  Sprite border0106 = new Sprite("border",b0106, null, '-', null, true, false);
  terrain.add(border0106);

  Location b0107 = new Location(0,107,0,0);
  Sprite border0107 = new Sprite("border",b0107, null, '-', null, true, false);
  terrain.add(border0107);

  Location b0108 = new Location(0,108,0,0);
  Sprite border0108 = new Sprite("border",b0108, null, '-', null, true, false);
  terrain.add(border0108);

  Location b0109 = new Location(0,109,0,0);
  Sprite border0109 = new Sprite("border",b0109, null, '-', null, true, false);
  terrain.add(border0109);

  Location b0110 = new Location(0,110,0,0);
  Sprite border0110 = new Sprite("border",b0110, null, '-', null, true, false);
  terrain.add(border0110);

  Location b0111 = new Location(0,111,0,0);
  Sprite border0111 = new Sprite("border",b0111, null, '-', null, true, false);
  terrain.add(border0111);

  Location b0112 = new Location(0,112,0,0);
  Sprite border0112 = new Sprite("border",b0112, null, '-', null, true, false);
  terrain.add(border0112);

  Location b0113 = new Location(0,113,0,0);
  Sprite border0113 = new Sprite("border",b0113, null, '-', null, true, false);
  terrain.add(border0113);

  Location b0114 = new Location(0,114,0,0);
  Sprite border0114 = new Sprite("border",b0114, null, '-', null, true, false);
  terrain.add(border0114);

  Location b0115 = new Location(0,115,0,0);
  Sprite border0115 = new Sprite("border",b0115, null, '-', null, true, false);
  terrain.add(border0115);

  Location b0116 = new Location(0,116,0,0);
  Sprite border0116 = new Sprite("border",b0116, null, '-', null, true, false);
  terrain.add(border0116);

  Location b0117 = new Location(0,117,0,0);
  Sprite border0117 = new Sprite("border",b0117, null, '-', null, true, false);
  terrain.add(border0117);

  Location b0118 = new Location(0,118,0,0);
  Sprite border0118 = new Sprite("border",b0118, null, '-', null, true, false);
  terrain.add(border0118);

  Location b0119 = new Location(0,119,0,0);
  Sprite border0119 = new Sprite("border",b0119, null, '-', null, true, false);
  terrain.add(border0119);

  Location b0120 = new Location(0,120,0,0);
  Sprite border0120 = new Sprite("border",b0120, null, '-', null, true, false);
  terrain.add(border0120);

  Location b0121 = new Location(0,121,0,0);
  Sprite border0121 = new Sprite("border",b0121, null, '-', null, true, false);
  terrain.add(border0121);

  Location b0122 = new Location(0,122,0,0);
  Sprite border0122 = new Sprite("border",b0122, null, '-', null, true, false);
  terrain.add(border0122);

  Location b0123 = new Location(0,123,0,0);
  Sprite border0123 = new Sprite("border",b0123, null, '-', null, true, false);
  terrain.add(border0123);

  Location b0124 = new Location(0,124,0,0);
  Sprite border0124 = new Sprite("border",b0124, null, '-', null, true, false);
  terrain.add(border0124);

  Location b0125 = new Location(0,125,0,0);
  Sprite border0125 = new Sprite("border",b0125, null, '-', null, true, false);
  terrain.add(border0125);

  Location b0126 = new Location(0,126,0,0);
  Sprite border0126 = new Sprite("border",b0126, null, '-', null, true, false);
  terrain.add(border0126);

  Location b0127 = new Location(0,127,0,0);
  Sprite border0127 = new Sprite("border",b0127, null, '-', null, true, false);
  terrain.add(border0127);

  Location b0128 = new Location(0,128,0,0);
  Sprite border0128 = new Sprite("border",b0128, null, '-', null, true, false);
  terrain.add(border0128);

  Location b0129 = new Location(0,129,0,0);
  Sprite border0129 = new Sprite("border",b0129, null, '-', null, true, false);
  terrain.add(border0129);

  Location b0130 = new Location(0,130,0,0);
  Sprite border0130 = new Sprite("border",b0130, null, '-', null, true, false);
  terrain.add(border0130);

  Location b0131 = new Location(0,131,0,0);
  Sprite border0131 = new Sprite("border",b0131, null, '-', null, true, false);
  terrain.add(border0131);

  Location b0132 = new Location(0,132,0,0);
  Sprite border0132 = new Sprite("border",b0132, null, '-', null, true, false);
  terrain.add(border0132);

  Location b0133 = new Location(0,133,0,0);
  Sprite border0133 = new Sprite("border",b0133, null, '-', null, true, false);
  terrain.add(border0133);

  Location b0134 = new Location(0,134,0,0);
  Sprite border0134 = new Sprite("border",b0134, null, '-', null, true, false);
  terrain.add(border0134);

  Location b0135 = new Location(0,135,0,0);
  Sprite border0135 = new Sprite("border",b0135, null, '-', null, true, false);
  terrain.add(border0135);

  Location b0136 = new Location(0,136,0,0);
  Sprite border0136 = new Sprite("border",b0136, null, '-', null, true, false);
  terrain.add(border0136);

  Location b0137 = new Location(0,137,0,0);
  Sprite border0137 = new Sprite("border",b0137, null, '-', null, true, false);
  terrain.add(border0137);

  Location b0138 = new Location(0,138,0,0);
  Sprite border0138 = new Sprite("border",b0138, null, '-', null, true, false);
  terrain.add(border0138);

  Location b0139 = new Location(0,139,0,0);
  Sprite border0139 = new Sprite("border",b0139, null, '-', null, true, false);
  terrain.add(border0139);

  Location b0140 = new Location(0,140,0,0);
  Sprite border0140 = new Sprite("border",b0140, null, '-', null, true, false);
  terrain.add(border0140);

  Location b0141 = new Location(0,141,0,0);
  Sprite border0141 = new Sprite("border",b0141, null, '-', null, true, false);
  terrain.add(border0141);

  Location b0142 = new Location(0,142,0,0);
  Sprite border0142 = new Sprite("border",b0142, null, '-', null, true, false);
  terrain.add(border0142);

  Location b0143 = new Location(0,143,0,0);
  Sprite border0143 = new Sprite("border",b0143, null, '-', null, true, false);
  terrain.add(border0143);

  Location b0144 = new Location(0,144,0,0);
  Sprite border0144 = new Sprite("border",b0144, null, '-', null, true, false);
  terrain.add(border0144);

  Location b0145 = new Location(0,145,0,0);
  Sprite border0145 = new Sprite("border",b0145, null, '-', null, true, false);
  terrain.add(border0145);

  Location b0146 = new Location(0,146,0,0);
  Sprite border0146 = new Sprite("border",b0146, null, '-', null, true, false);
  terrain.add(border0146);

  Location b0147 = new Location(0,147,0,0);
  Sprite border0147 = new Sprite("border",b0147, null, '-', null, true, false);
  terrain.add(border0147);

  Location b0148 = new Location(0,148,0,0);
  Sprite border0148 = new Sprite("border",b0148, null, '-', null, true, false);
  terrain.add(border0148);

  Location b0149 = new Location(0,149,0,0);
  Sprite border0149 = new Sprite("border",b0149, null, '-', null, true, false);
  terrain.add(border0149);

  Location b0150 = new Location(0,150,0,0);
  Sprite border0150 = new Sprite("border",b0150, null, '-', null, true, false);
  terrain.add(border0150);

  Location b0151 = new Location(0,151,0,0);
  Sprite border0151 = new Sprite("border",b0151, null, '-', null, true, false);
  terrain.add(border0151);

  Location b0152 = new Location(0,152,0,0);
  Sprite border0152 = new Sprite("border",b0152, null, '-', null, true, false);
  terrain.add(border0152);

  Location b0153 = new Location(0,153,0,0);
  Sprite border0153 = new Sprite("border",b0153, null, '-', null, true, false);
  terrain.add(border0153);

  Location b0154 = new Location(0,154,0,0);
  Sprite border0154 = new Sprite("border",b0154, null, '-', null, true, false);
  terrain.add(border0154);

  Location b0155 = new Location(0,155,0,0);
  Sprite border0155 = new Sprite("border",b0155, null, '-', null, true, false);
  terrain.add(border0155);

  Location b0156 = new Location(0,156,0,0);
  Sprite border0156 = new Sprite("border",b0156, null, '-', null, true, false);
  terrain.add(border0156);

  Location b0157 = new Location(0,157,0,0);
  Sprite border0157 = new Sprite("border",b0157, null, '-', null, true, false);
  terrain.add(border0157);

  Location b0158 = new Location(0,158,0,0);
  Sprite border0158 = new Sprite("border",b0158, null, '-', null, true, false);
  terrain.add(border0158);

  Location b0159 = new Location(0,159,0,0);
  Sprite border0159 = new Sprite("border",b0159, null, '-', null, true, false);
  terrain.add(border0159);

  Location b0160 = new Location(0,160,0,0);
  Sprite border0160 = new Sprite("border",b0160, null, '-', null, true, false);
  terrain.add(border0160);

  Location b0161 = new Location(0,161,0,0);
  Sprite border0161 = new Sprite("border",b0161, null, '-', null, true, false);
  terrain.add(border0161);

  Location b0162 = new Location(0,162,0,0);
  Sprite border0162 = new Sprite("border",b0162, null, '-', null, true, false);
  terrain.add(border0162);

  Location b0163 = new Location(0,163,0,0);
  Sprite border0163 = new Sprite("border",b0163, null, '-', null, true, false);
  terrain.add(border0163);

  Location b0164 = new Location(0,164,0,0);
  Sprite border0164 = new Sprite("border",b0164, null, '-', null, true, false);
  terrain.add(border0164);

  Location b0165 = new Location(0,165,0,0);
  Sprite border0165 = new Sprite("border",b0165, null, '-', null, true, false);
  terrain.add(border0165);

  Location b0166 = new Location(0,166,0,0);
  Sprite border0166 = new Sprite("border",b0166, null, '-', null, true, false);
  terrain.add(border0166);

  Location b0167 = new Location(0,167,0,0);
  Sprite border0167 = new Sprite("border",b0167, null, '-', null, true, false);
  terrain.add(border0167);

  Location b0168 = new Location(0,168,0,0);
  Sprite border0168 = new Sprite("border",b0168, null, '-', null, true, false);
  terrain.add(border0168);

  Location b0169 = new Location(0,169,0,0);
  Sprite border0169 = new Sprite("border",b0169, null, '-', null, true, false);
  terrain.add(border0169);

  Location b0170 = new Location(0,170,0,0);
  Sprite border0170 = new Sprite("border",b0170, null, '-', null, true, false);
  terrain.add(border0170);

  Location b0171 = new Location(0,171,0,0);
  Sprite border0171 = new Sprite("border",b0171, null, '-', null, true, false);
  terrain.add(border0171);

  Location b0172 = new Location(0,172,0,0);
  Sprite border0172 = new Sprite("border",b0172, null, '-', null, true, false);
  terrain.add(border0172);

  Location b0173 = new Location(0,173,0,0);
  Sprite border0173 = new Sprite("border",b0173, null, '-', null, true, false);
  terrain.add(border0173);

  Location b0174 = new Location(0,174,0,0);
  Sprite border0174 = new Sprite("border",b0174, null, '-', null, true, false);
  terrain.add(border0174);

  Location b0175 = new Location(0,175,0,0);
  Sprite border0175 = new Sprite("border",b0175, null, '-', null, true, false);
  terrain.add(border0175);

  Location b0176 = new Location(0,176,0,0);
  Sprite border0176 = new Sprite("border",b0176, null, '-', null, true, false);
  terrain.add(border0176);

  Location b0177 = new Location(0,177,0,0);
  Sprite border0177 = new Sprite("border",b0177, null, '-', null, true, false);
  terrain.add(border0177);

  Location b0178 = new Location(0,178,0,0);
  Sprite border0178 = new Sprite("border",b0178, null, '-', null, true, false);
  terrain.add(border0178);

  Location b0179 = new Location(0,179,0,0);
  Sprite border0179 = new Sprite("border",b0179, null, '-', null, true, false);
  terrain.add(border0179);

  Location b0180 = new Location(0,180,0,0);
  Sprite border0180 = new Sprite("border",b0180, null, '-', null, true, false);
  terrain.add(border0180);

  Location b0181 = new Location(0,181,0,0);
  Sprite border0181 = new Sprite("border",b0181, null, '-', null, true, false);
  terrain.add(border0181);

  Location b0182 = new Location(0,182,0,0);
  Sprite border0182 = new Sprite("border",b0182, null, '-', null, true, false);
  terrain.add(border0182);

  Location b0183 = new Location(0,183,0,0);
  Sprite border0183 = new Sprite("border",b0183, null, '-', null, true, false);
  terrain.add(border0183);

  Location b0184 = new Location(0,184,0,0);
  Sprite border0184 = new Sprite("border",b0184, null, '-', null, true, false);
  terrain.add(border0184);

  Location b0185 = new Location(0,185,0,0);
  Sprite border0185 = new Sprite("border",b0185, null, '-', null, true, false);
  terrain.add(border0185);

  Location b0186 = new Location(0,186,0,0);
  Sprite border0186 = new Sprite("border",b0186, null, '-', null, true, false);
  terrain.add(border0186);

  Location b0187 = new Location(0,187,0,0);
  Sprite border0187 = new Sprite("border",b0187, null, '-', null, true, false);
  terrain.add(border0187);

  Location b0188 = new Location(0,188,0,0);
  Sprite border0188 = new Sprite("border",b0188, null, '-', null, true, false);
  terrain.add(border0188);

  Location b0189 = new Location(0,189,0,0);
  Sprite border0189 = new Sprite("border",b0189, null, '-', null, true, false);
  terrain.add(border0189);

  Location b0190 = new Location(0,190,0,0);
  Sprite border0190 = new Sprite("border",b0190, null, '-', null, true, false);
  terrain.add(border0190);

  Location b0191 = new Location(0,191,0,0);
  Sprite border0191 = new Sprite("border",b0191, null, '-', null, true, false);
  terrain.add(border0191);

  Location b0192 = new Location(0,192,0,0);
  Sprite border0192 = new Sprite("border",b0192, null, '-', null, true, false);
  terrain.add(border0192);

  Location b0193 = new Location(0,193,0,0);
  Sprite border0193 = new Sprite("border",b0193, null, '-', null, true, false);
  terrain.add(border0193);

  Location b0194 = new Location(0,194,0,0);
  Sprite border0194 = new Sprite("border",b0194, null, '-', null, true, false);
  terrain.add(border0194);

  Location b0195 = new Location(0,195,0,0);
  Sprite border0195 = new Sprite("border",b0195, null, '-', null, true, false);
  terrain.add(border0195);

  Location b0196 = new Location(0,196,0,0);
  Sprite border0196 = new Sprite("border",b0196, null, '-', null, true, false);
  terrain.add(border0196);

  Location b0197 = new Location(0,197,0,0);
  Sprite border0197 = new Sprite("border",b0197, null, '-', null, true, false);
  terrain.add(border0197);

  Location b0198 = new Location(0,198,0,0);
  Sprite border0198 = new Sprite("border",b0198, null, '-', null, true, false);
  terrain.add(border0198);

  Location b0199 = new Location(0,199,0,0);
  Sprite border0199 = new Sprite("border",b0199, null, '-', null, true, false);
  terrain.add(border0199);

/**-----------------------ROW 1----------------------------------------------*/





}


public void createItemArray(ArrayList<Sprite> items)
{
  String[] =
items chest19624 = new items(coord, "chest", image, true, )





}
    /**
     * Purpose: To check and see if the players move will collide with an enemy
     * on the map.
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
     * @param player an instance of the player in the current game
     * @param move the desired direction that the player would like to move
     * @return true if there is a collision with a terrain tile that is un-crossable
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
     * @param player an instance of the player class in the current game
     * @return a boolean value for if the player meets the condition to unlock
     */
    private boolean checkGate(Player player) {
        // also update images
        return (player.getKeyCount() == totalKeys-1) ? true : false;
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
     *@param e - Enemy who is battling the player. should be found by the collision
     * detection
     */
/*    private boolean engageBattle(Enemy e) {
        // calls an instance of the BattleLoop class to engage in combat
<<<<<<< HEAD
        BattleLoop b = new BattleLoop();
        b.initialize();
        int bbCounter = 0;  // keeps track of turns for Butter boomerang attack
        int mmCounter = 0;  // keeps track of turns for Margarine missile attack
        boolean usedParry = false; // keeps track if Parry was the attack
        boolean enemyUsedParry = false; // keeps track if Parry was the attack
        while (!true) {
            if (bbCounter == 0) {
                String attack = b.playerInput();
                if (b.checkMove(attack) == true) {
                    switch (attack) {
                        case "Slash":
                            if (enemyUsedParry) {
                                if (Math.random() >= 0.5) {
                                    e.setHealth(e.getHealth() - 8);
                                }
                                enemyUsedParry = false;
                            } else {
                                e.setHealth(e.getHealth() - 15);
                                enemyUsedParry = false;
                            }
                            break;
                        case "Butter Boomerang":
                            bbCounter = 1;
                            if (enemyUsedParry) {
                                enemyUsedParry = false;
                            }
                            break;
                        case "Parry":
                            usedParry = true;
                            if (enemyUsedParry) {
                                enemyUsedParry = false;
                            }
                            break;
                        case "Potion":
                            player.setHealth(player.getHealth() + 25);
                            if (enemyUsedParry) {
                                enemyUsedParry = false;
                            }
                            break;
                    }
                } else if (bbCounter == 2) {
                    if (enemyUsedParry) {
                        if (Math.random() >= 0.5) {
                            e.setHealth(e.getHealth() - 20);
                            bbCounter = 0;
                            enemyUsedParry = false;
                        } else {
                            e.setHealth(e.getHealth() - 40);
                            bbCounter = 0;
                            enemyUsedParry = false;
                        }
                    }
                }
                if (b.checkWinState() == true) {
                    break;
                }
                if (mmCounter == 1) {
                    mmCounter = 2;
                    if (usedParry) {
                        usedParry = false;
                    }
                }
                b.drawState();
                if (mmCounter == 0) {
                    String eAttack = e.attackLogic();
                    switch (eAttack) {
                        case "Slash":
                            if (usedParry) {
                                if (Math.random() >= 0.5) {
                                    player.setHealth(player.getHealth() - 8);
                                }
                                usedParry = false;
                            } else {
                                player.setHealth(player.getHealth() - 15);
                                usedParry = false;
                            }
                            break;
                        case "Margarine Missile":
                            mmCounter = 1;
                            if (usedParry) {
                                usedParry = false;
                            }
                            break;
                        case "Parry":
                            enemyUsedParry = true;
                            if (usedParry) {
                                usedParry = false;
                            }
                            break;
                        case "Potion":
                            e.setHealth(e.getHealth() + 25);
                            if (usedParry) {
                                usedParry = false;
                            }
                            break;
                    }
                } else if (mmCounter == 2) {
                    if (usedParry) {
                        if (Math.random() >= 0.5) {
                            player.setHealth(player.getHealth() - 20);
                            mmCounter = 0;
                            usedParry = false;
                        } else {
                            Player.setHealth(player.getHealth() - 40);
                            mmCounter = 0;
                            usedParry = false;
                        }
                    }
                }
                if (b.checkLoseState() == true) {
                    break;
                }
                if (bbCounter == 1) {
                    if (enemyUsedParry) {
                        enemyUsedParry = false;
                    }
                    bbCounter = 2;
                }
                b.drawState();
            }
=======
	BattleLoop b = new BattleLoop();
	b.initialize();
	int bbCounter = 0;  // keeps track of turns for Butter boomerang attack
	int mmCounter = 0;  // keeps track of turns for Margarine missile attack
	boolean usedParry = false; // keeps track if Parry was the attack
	boolean enemyUsedParry = false; // keeps track if Parry was the attack
	while(!true){
	if(bbCounter ==0){
		String attack = b.playerInput();
		if(b.checkMove(attack)==true){
        		switch(attack){
			case "Slash":
                	if(enemyUsedParry) {
			if(Math.random() >=0.5)
                	e.setHealth(e.getHealth()-8);
			enemyUsedParry = false;
			} else {
			e.setHealth(e.getHealth()-15);
			enemyUsedParry = false;
			}
			break;
                	case "Butter Boomerang":
			bbCounter =1;
			if(enemyUsedParry)
			enemyUsedParry = false;
			break;
                	case "Parry":
			usedParry = true;
			if(enemyUsedParry)
			enemyUsedParry = false;
			break;
                	case "Potion":
			player.setHealth(player.getHealth() + 25);
			if(enemyUsedParry)
			enemyUsedParry = false;
			break;
		}
	} else if(bbCounter ==2){
	if(enemyUsedParry){
	if(Math.random()>=0.5){
	e.setHealth(e.getHealth()-20);
	bbCounter = 0;
	enemyUsedParry = false;
	} else {
	e.setHealth(e.getHealth()-40);
	bbCounter = 0;
	enemyUsedParry = false;
	}
	}
	}
	if(b.checkWinState()==true)
	break;
	if(mmCounter ==1){
	mmCounter = 2;
	if(usedParry)
	usedParry = false;
	}
	b.drawState();
	if(mmCounter ==0){
		String eAttack = e.attackLogic();
        	switch(eAttack){
		case "Slash":
		if(usedParry) {
		if(Math.random() >=0.5)
                player.setHealth(player.getHealth()-8);
		usedParry = false;
		} else {
		player.setHealth(player.getHealth()-15);
		usedParry = false;
		}
		break;
                case "Margarine Missile":
		mmCounter = 1;
		if(usedParry)
		usedParry = false;
		break;
                case "Parry":
		enemyUsedParry = true;
		if(usedParry)
		usedParry = false;
		break;
                case "Potion":
		e.setHealth(e.getHealth()+25);
		if(usedParry)
		usedParry = false;
		break;
		}
	} else if(mmCounter ==2){
	if(usedParry){
	if(Math.random()>=0.5){
	player.setHealth(player.getHealth()-20);
	mmCounter = 0;
	usedParry = false;
	} else {
	Player.setHealth(player.getHealth()-40);
	mmCounter = 0;
	usedParry = false;
	}
	}
	}
	if(b.checkLoseState()==true)
	break;
	if(bbCounter ==1){
	if(enemyUsedParry)
	enemyUsedParry = false;
	bbCounter =2;
	}
	b.drawState();
	}

	}

        // *** need to finish ***

>>>>>>> 966d6f1c069fb5787bdee04f0b668c29c108890a

        }

        // *** need to finish ***
        return true;
    }
*/
    /*--------------------------- GETTER/SETTERS -----------------------------*/

    /**
     * Purpose: To retrieve the array list for the terrain objects
     * @return an array list containing the terrain objects
     */
    public ArrayList<Sprite> getTerrain() {
        return new ArrayList<Sprite>(this.terrain); //create copy of the list
    }

    /**
     * Purpose: To retrieve the array list for the item objects
     * @return an array list containing the item objects
     */
    public ArrayList<Sprite> getItem() {
        return new ArrayList<Sprite>(this.items); //create copy of the list
    }

    /**
     * Purpose: To retrieve the array list for the enemy objects
     * @return an array list containing the enemy objects
     */
    public ArrayList<Enemy> getEnemy() {
        return new ArrayList<Enemy>(this.enemy); //create copy of the list
    }

    /**
     * Purpose: To retrieve the number of keys in the game
     * @return the totalKeys
     */
    public int getTotalKeys() {
    	return totalKeys;
    }

    /**
     * Purpose: To get the value of the win state variable
     * @return the win state condition flag
     */
    public boolean checkWinState() {
        return winState; // returns true if true else false
    }

    /**
     * Purpose: To get the value of the lose state variable
     * @return the lose state condition flag
     */
    public boolean checkLoseState() {
        return loseState; // returns true if true else false
    }

    /**
     * Purpose: To set a new terrain objects list for the current game
     * @param newTerrainList an array list of terrain objects
     */
    public void setTerrain(ArrayList<Sprite> newTerrainList) {
        if (newTerrainList != null) {
            this.terrain = newTerrainList;
        }
    }

    /**
     * Purpose: To set a new item objects list for the current game
     * @param newItemList an array list of item objects
     */
    public void setItem(ArrayList<Sprite> newItemList) {
        if (newItemList != null) {
            this.items = newItemList;
        }
    }

    /**
     * Purpose: To set a new enemy list for the current game
     * @param newEnemyList an array list of enemy objects
     */
    public void setEnemy(ArrayList<Enemy> newEnemyList) {
        if (newEnemyList != null) {
            this.enemy = newEnemyList;
        }
    }

    /**
     * Purpose: To change the win state boolean value
     * @param value the new boolean value to set winState to
     */
    public void setWinState(boolean value) {
        this.winState = value;
    }

    /**
     * Purpose: To change the lose state boolean value
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
     * @return a string representation of the users directional choice
     */
    public String playerInput() {
        Console console = System.console();
        String input;
        String userPrompt = "Please make a move (wasd): ";
        String error = "Invalid input";
        boolean valid = false;

        if (console == null) return null;
        do {
            input = console.readLine(userPrompt);
            if (input.toLowerCase().equals("w") || input.toLowerCase().equals("a") ||
                    input.toLowerCase().equals("s") || input.toLowerCase().equals("d")) {
                valid = true;
            }
            else System.out.println(error);
        } while (!valid);
        // convert characters into representative symbols
        switch (input) {
            case "w": input = "up"; break;
            case "a": input = "left"; break;
            case "s": input = "down"; break;
            case "d": input = "right"; break;
        }
        return input;
    }

    /**
     * Purpose: To check all possible collisions in the game and return true or
     * false depending.
     * @param player an instance of the player class
     * @param move a string representation of the users input
     * @return false if a collision was detected else true
     */
    public boolean checkCollisions(Player player, String move) {
        boolean collision = true;

        // check all collisions and if any are false
        if (!checkEdges(player, move) || !checkTerrain(player, move, terrain) ||
                !checkEnemy(player, move, enemy) || !checkItems(player, move, items)) {
            collision = (collision == true) ? false : collision; // if its false make it true else keep it what it was
        }
        return collision;
    }


    /**
     * Purpose: To allow the ability to test methods
     */
    public static void main(String[] args) {
        // for testing methods
        GameLoop gl = new GameLoop();
        Player p1 =  new Player("Montequilla", new Location(0, 0, 0, 0), null, 'x',
                                null, true, false, 100, 50, 50, null);
        System.out.println(p1);
    }
}
