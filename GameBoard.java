import java.util.ArrayList;

public class GameBoard extends GameLoop  {
    /**
     * Purpose: This function is used to create/set up the enemy array ArrayList
     * every enemy has to be instantiated, and set up individually, then added to
     * the item array ArrayList
     *
     * @param  enemy  This is the enemy array list. It is passed, which means it is being
     * refrenced. Any changes made to the array list in this function will change the
     * array list outside as well
     */
    public void createEnemyArray(ArrayList<Enemy> enemy) {
        String[] moves = {"up", "down", "left", "right"};
        Potion smallPotion = new Potion("Small Potion", new Location(0, 0, 0, 0), null, ' ', null, true, false, 50);
        Potion mediumPotion = new Potion("Medium Potion", new Location(0, 0, 0, 0), null, ' ', null, true, false, 100);
        ArrayList<Potion> gruntPotions = new ArrayList<Potion>();
        ArrayList<Potion> bossPotions = new ArrayList<Potion>();
        gruntPotions.add(smallPotion);
        bossPotions.add(smallPotion);
        bossPotions.add(mediumPotion);

        enemy.add(new Enemy("Grunt", new Location(6,5,0,0), null, '+', null, true, false, 100, 100, 100, moves, true, gruntPotions));
        enemy.add(new Enemy("Grunt", new Location(40,2,0,0), null, '+', null, true, false, 100, 100, 100, moves, true, gruntPotions));
        enemy.add(new Enemy("Grunt", new Location(54,37,0,0), null, '+', null, true, false, 100, 100, 100, moves, true, gruntPotions));
        enemy.add(new Enemy("Boss", new Location(196,6,0,0), null, '+', null, true, false, 200, 200, 200, moves, true, bossPotions));
    }

    public void createTerrainArray(ArrayList<Sprite> terrain) {

        // somehow the coordinate system go backwards, need to fix
        // eventually come up with a better system for defining this

        /*------------------------ROW 0-------------------------------------------*/

        for(int index = 0; index < 200; index++) {
            terrain.add(new Sprite("border", new Location(index, 0, 0, 0), null, '-', null, true, false));
        }

        /*-----------------------ROW 1--------------------------------------------*/
        terrain.add(new Sprite("border",new Location(0, 1, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water",new Location(28, 1, 0, 0), null, '/', null, true, false));

        for(int index = 29; index < 38; index++) {
            terrain.add(new Sprite("water",new Location(index, 1, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water",new Location(38, 1, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("mountain",new Location(184, 1, 0, 0), null, '|', null, true, false));

        for(int index = 185; index < 195; index++) {
            terrain.add(new Sprite("mountain",new Location(index, 1, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain",new Location(195, 1, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("border",new Location(199, 1, 0, 0), null, '|', null, true, false));

        /*-------------------------ROW 2--------------------------------------*/

        terrain.add(new Sprite("border",new Location(0, 2, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water",new Location(27, 2, 0, 0), null, '/', null, true, false));

        for(int index = 28; index < 37; index++) {
            terrain.add(new Sprite("water",new Location(index, 2, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water",new Location(37, 2, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("mountain",new Location(184, 2, 0, 0), null, '|', null, true, false));

        for(int index = 185; index < 195; index++) {
            terrain.add(new Sprite("mountain",new Location(index, 2, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain",new Location(195, 2, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border",new Location(199, 2, 0, 0), null, '|', null, true, false));

        /*-------------------------ROW 3--------------------------------------*/
        terrain.add(new Sprite("border",new Location(0, 3, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water",new Location(26, 3, 0, 0), null, '/', null, true, false));

        for(int index = 27; index < 36; index++) {
            terrain.add(new Sprite("water",new Location(index, 3, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water",new Location(36, 3, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("mountain",new Location(184, 3, 0, 0), null, '|', null, true, false));

        for(int index = 185; index < 194; index++) {
            terrain.add(new Sprite("mountain",new Location(index, 3, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain",new Location(194, 3, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border",new Location(199, 3, 0, 0), null, '|', null, true, false));

        /*-------------------------------ROW 4--------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 4, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(25, 4, 0, 0), null, '/', null, true, false));

        for(int index = 26; index < 35; index++) {
            terrain.add(new Sprite("water", new Location(index, 4, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(35, 4, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("mountain", new Location(184, 4, 0, 0), null, '|', null, true, false));

        for(int index = 185; index < 193; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 4, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(193, 4, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border",new Location(199, 4, 0, 0),null,'|',null,true,false));

        /*---------------------------ROW 5------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 5, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(24, 5, 0, 0), null, '/', null, true, false));

        for(int index = 25; index < 34; index++) {
            terrain.add(new Sprite("water", new Location(index, 5, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(34, 5, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("mountain", new Location(184, 5, 0, 0), null, '|', null, true, false));

        for(int index = 185; index < 192; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 5, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(192, 5, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 5, 0, 0), null, '|', null, true, false));

        /*----------------------------ROW 6-----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 6, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(23, 6, 0, 0), null, '/', null, true, false));

        for(int index = 24; index < 33; index++) {
            terrain.add(new Sprite("water", new Location(index, 6, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(33, 6, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("mountain", new Location(184, 6, 0, 0), null, '|', null, true, false));

        for(int index = 185; index < 191; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 6, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(191, 6, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 6, 0, 0), null, '|', null, true, false));

        /*----------------------Row 7-----------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 7, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(22, 7, 0, 0), null, '/', null, true, false));

        for(int index = 23; index < 32; index++) {
            terrain.add(new Sprite("water", new Location(index, 7, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(32, 7, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("mountain", new Location(184, 7, 0, 0), null, '|', null, true, false));

        for(int index = 185; index < 190; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 7, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(190, 7, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 7, 0, 0), null, '|', null, true, false));

        /*--------------------------------Row 8-------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 8, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(21, 8, 0, 0), null, '/', null, true, false));

        for(int index = 22; index < 31; index++) {
            terrain.add(new Sprite("water", new Location(index, 8, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(31, 8, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("mountain", new Location(184, 8, 0, 0), null, '|', null, true, false));

        for(int index = 185; index < 189; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 8, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(189, 8, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 8, 0, 0), null, '|', null, true, false));

        /*------------------------------Row 9---------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 9, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(20, 9, 0, 0), null, '/', null, true, false));

        for(int index = 21; index < 30; index++) {
            terrain.add(new Sprite("water", new Location(index, 9, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(30, 9, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("mountain", new Location(184, 9, 0, 0), null, '|', null, true, false));

        for(int index = 185; index < 188; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 9, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(188, 9, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 9, 0, 0), null, '|', null, true, false));

        /*----------------------------------Row 10----------------------------*/

        terrain.add(new Sprite("border", new Location(0, 10, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(19, 10, 0, 0), null, '/', null, true, false));

        for(int index = 20; index < 29; index++) {
            terrain.add(new Sprite("water", new Location(index, 10, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(29, 10, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 10, 0, 0), null, '|', null, true, false));

        /*-----------------------------Row 11---------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 11, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(18, 11, 0, 0), null, '/', null, true, false));

        for(int index = 19; index < 28; index++) {
            terrain.add(new Sprite("water", new Location(index, 11, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(28, 11, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 11, 0, 0), null, '|', null, true, false));

        /*-------------------------------Row 12-----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 12, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(17, 12, 0, 0), null, '/', null, true, false));

        for(int index = 18; index < 27; index++) {
            terrain.add(new Sprite("water", new Location(index, 12, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(27, 12, 0, 0), null, '/', null, true, false));

        for(int index = 194; index < 199; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 12, 0, 0), null, '-', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(199, 12, 0, 0), null, '|', null, true, false));

        /*------------------------------Row 13------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 13, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(16, 13, 0, 0), null, '/', null, true, false));

        for(int index = 17; index < 26; index++) {
            terrain.add(new Sprite("water", new Location(index, 13, 0, 0), null, '-', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(26, 13, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("mountain", new Location(193, 13, 0, 0), null, '/', null, true, false));

        for(int index = 194; index < 199; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 13, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(199, 13, 0, 0), null, '|', null, true, false));

        /*-------------------------------Row 14-----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 14, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("mountain", new Location(192, 14, 0, 0), null, '/', null, true, false));

        for(int index = 193; index < 199; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 14, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(199, 14, 0, 0), null, '|', null, true, false));

        /*----------------------------------Row 15--------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 15, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("mountain", new Location(191, 15, 0, 0), null, '/', null, true, false));

        for(int index = 192; index < 199; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 15, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(199, 15, 0, 0), null, '|', null, true, false));

        /*-----------------------------------Row 16-------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 16, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("mountain", new Location(190, 16, 0, 0), null, '/', null, true, false));

        for(int index = 191; index < 199; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 16, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(199, 16, 0, 0), null, '|', null, true, false));

        /*----------------------------Row 17--------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 17, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("mountain", new Location(190, 17, 0, 0), null, '|', null, true, false));

        for(int index = 191; index < 199; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 17, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(199, 17, 0, 0), null, '|', null, true, false));

        /*-----------------------------Row 18-------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 18, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("mountain", new Location(190, 18, 0, 0), null, '|', null, true, false));

        for(int index = 191; index < 199; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 18, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(199, 18, 0, 0), null, '|', null, true, false));

        /*-------------------------------Row 19-----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 19, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("mountain", new Location(190, 19, 0, 0), null, '|', null, true, false));

        for(int index = 191; index < 199; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 19, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(199, 19, 0, 0), null, '|', null, true, false));

        /*--------------------------------Row 20----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 20, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("mountain", new Location(190, 20, 0, 0), null, '|', null, true, false));

        for(int index = 191; index < 199; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 20, 0, 0), null, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(199, 20, 0, 0), null, '|', null, true, false));

        /*--------------------------------Row 21----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 21, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(2, 21, 0, 0), null, '/', null, true, false));

        for(int index = 3; index < 18; index++) {
            terrain.add(new Sprite("water", new Location(index, 21, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(18, 21, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("mountain", new Location(190, 21, 0, 0), null, '|', null, true, false));

        for(int index = 191; index < 199; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 21, 0, 0), null, '-', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(199, 21, 0, 0), null, '|', null, true, false));

        /*---------------------------Row 22---------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 22, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(1, 22, 0, 0), null, '/', null, true, false));

        for(int index = 2; index < 17; index++) {
            terrain.add(new Sprite("water", new Location(index, 22, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(17, 22, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 22, 0, 0), null, '|', null, true, false));

        /*---------------------------Row 23---------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 23, 0, 0), null, '|', null, true, false));

        for(int index = 1; index < 16; index++) {
            terrain.add(new Sprite("water", new Location(index, 23, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(16, 23, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 23, 0, 0), null, '|', null, true, false));

        /*-------------------------Row 24-----------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 24, 0, 0), null, '|', null, true, false));

        for(int index = 1; index < 15; index++) {
            terrain.add(new Sprite("water", new Location(index, 24, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(15, 24, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 24, 0, 0), null, '|', null, true, false));

        /*-----------------------------Row 25-------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 25, 0, 0), null, '|', null, true, false));

        for(int index = 1; index < 14; index++) {
            terrain.add(new Sprite("water", new Location(index, 25, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(14, 25, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 25, 0, 0), null, '|', null, true, false));

        /*------------------------------Row 26------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 26, 0, 0), null, '|', null, true, false));

        for(int index = 1; index < 13; index++) {
            terrain.add(new Sprite("water", new Location(index, 26, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(13, 26, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 26, 0, 0), null, '|', null, true, false));

        /*---------------------------Row 27---------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 27, 0, 0), null, '|', null, true, false));

        for(int index = 1; index < 12; index++) {
            terrain.add(new Sprite("water", new Location(index, 27, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(12, 27, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 27, 0, 0), null, '|', null, true, false));

        /*----------------------------------Row 28--------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 28, 0, 0), null, '|', null, true, false));

        for(int index = 1; index < 11; index++) {
            terrain.add(new Sprite("water", new Location(index, 28, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(11, 28, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 28, 0, 0), null, '|', null, true, false));

        /*-------------------------------Row 29-----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 29, 0, 0), null, '|', null, true, false));

        for(int index = 1; index < 10; index++) {
            terrain.add(new Sprite("water", new Location(index, 29, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(10, 29, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 29, 0, 0), null, '|', null, true, false));

        /*--------------------------Row 30----------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 30, 0, 0), null, '|', null, true, false));

        for(int index = 1; index< 9; index++) {
            terrain.add(new Sprite("water", new Location(index, 30, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(9, 30, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 30, 0, 0), null, '|', null, true, false));

        /*-----------------------------Row 31-------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 31, 0, 0), null, '|', null, true, false));

        for(int index =1; index < 8; index++) {
            terrain.add(new Sprite("water", new Location(index, 31, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(8, 31, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 31, 0, 0), null, '|', null, true, false));

        /*----------------------------Row 32--------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 32, 0, 0), null, '|', null, true, false));

        for(int index = 1; index < 7; index++) {
            terrain.add(new Sprite("water", new Location(index, 32, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(7, 32, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 32, 0, 0), null, '|', null, true, false));

        /*-------------------------------Row 33-----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 33, 0, 0), null, '|', null, true, false));

        for(int index = 1; index < 6; index++) {
            terrain.add(new Sprite("water", new Location(index, 33, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(6, 33, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 33, 0, 0), null, '|', null, true, false));

        /*------------------------------------Row 34------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 34, 0, 0), null, '|', null, true, false));

        for(int index = 1; index < 5; index++) {
            terrain.add(new Sprite("water", new Location(index, 34, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(5, 34, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 34, 0, 0), null, '|', null, true, false));

        /*------------------------------Row 35------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 35, 0, 0), null, '|', null, true, false));

        for(int index = 1; index < 4; index++) {
            terrain.add(new Sprite("border", new Location(index, 35, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(4, 35, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 35, 0, 0), null, '|', null, true, false));

        /*------------------------------Row 36------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 36, 0, 0), null, '|', null, true, false));

        for(int index = 1; index < 3; index++) {
            terrain.add(new Sprite("water", new Location(index, 36, 0, 0), null, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(3, 36, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 36, 0, 0), null, '|', null, true, false));

        /*----------------------------------Row 37--------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 37, 0, 0), null, '|', null, true, false));

        terrain.add(new Sprite("water", new Location(1, 37, 0, 0), null, '~', null, true, false));

        terrain.add(new Sprite("water", new Location(2, 37, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 37, 0, 0), null, '|', null, true, false));

        /*--------------------------Row 38----------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 38, 0, 0), null, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(1, 38, 0, 0), null, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(199, 38, 0, 0), null, '|', null, true, false));

        /*--------------------------Row 39----------------------------------------*/

        for(int index = 0; index < 200; index ++) {
            terrain.add(new Sprite("border", new Location(index, 39, 0, 0), null, '-', null, true, false));
        }
    }

    public void createItemArray(ArrayList<Sprite> items) {
        items.add(new Sprite("chest",new Location(5,4,0,0),null, '#',null,true,true));
        items.add(new Potion("small", new Location(5,4,0,0), null,' ', null, true, true, 25));
        items.add(new Sprite("chest",new Location(196,24,0,0),null, '#',null,true,true));
        items.add(new Potion("medium", new Location(196,24,0,0), null,' ', null, true, true, 50));
    }

    /**
     * Purpose: This function creates the 2-D array of characters, that will then be printed out onto
     * the screen. It finds the column and row of each point in the terrain, enemy, and item array
     * lists. Then puts the correct character into the the corresponding column, and row in the
     * 2-D array. The 2-D array will not be filled completely because there is parts of the map that
     * is empty.
     *
     * @param  items  This is the item arraylist
     * @param  enemy  This is the enemy arrayList
     * @param  terrain  This is the enemy ArrayList
     */
/*    public void createPrintArray (char[][] printArray, ArrayList<Sprite> items,
            ArrayList<Sprite> terrain, ArrayList<Enemy> enemy) {
        int rowTemp;
        int columnTemp;

        // empty the array
        for (int i = 0; i < printArray.length; i++) {
            for (int j = 0; j < printArray[0].length; j++) {
                printArray[i][j] = ' ';
            }
        }

        for (int index = 0; index < items.size(); index++) {
            columnTemp = items.get(index).getCoord().getxCoord();
            rowTemp = items.get(index).getCoord().getyCoord();
            if (items.get(index).getSpriteChar() != ' ') {
                printArray[columnTemp][rowTemp] = items.get(index).getSpriteChar();
            }
        }

        for (int index = 0; index < terrain.size(); index++) {
            columnTemp = terrain.get(index).getCoord().getxCoord();
            rowTemp = terrain.get(index).getCoord().getyCoord();
            if (terrain.get(index).getSpriteChar() != ' ') {
                printArray[columnTemp][rowTemp] = terrain.get(index).getSpriteChar();
            }
        }

        for (int index = 0; index < 4; index++) {
            columnTemp = enemy.get(index).getCoord().getxCoord();
            rowTemp = enemy.get(index).getCoord().getyCoord();
            if (enemy.get(index).getSpriteChar() != ' ') {
                printArray[columnTemp][rowTemp] = enemy.get(index).getSpriteChar();
            }
        }
    }
*/
    public static void main(String[] args) {
        GameLoop gl = new GameLoop();
        GameBoard gb = new GameBoard();
        char[][] charArray = new char[40][200]; // initialize the array (200, 40)
        String[] moves = {"Weak attack", "Strong attack", "Parry", "Potion"};
        Player player =  new Player("Montequilla", new Location(5, 38, 0, 0), null, 'x',
                                null, true, false, 100, 50, 50, null);

        ArrayList<Sprite> items = new ArrayList<Sprite>();
        ArrayList<Sprite> terrain = new ArrayList<Sprite>();
        ArrayList<Enemy> enemy = new ArrayList<Enemy>();

        gb.createItemArray(items);
        gb.createTerrainArray(terrain);
        gb.createEnemyArray(enemy);

        System.out.println("Items array size: " + items.size()); // expect 4
        System.out.println("Terrain array size: " + terrain.size()); // expect lots (949)
        System.out.println("Enemy array size: " + enemy.size()); // expect 4

        System.out.println("\nComposite array size: " + charArray.length * charArray[0].length); // expect 8000

        //gl.createPrintArray(charArray, items, terrain, enemy);
        gl.drawState(player, charArray);
        System.out.println();
    }
}
