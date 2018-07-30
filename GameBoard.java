import java.util.ArrayList;
import javafx.scene.image.image;
/**
 * Purpose: To create all of the map objects to be placed on the game board.
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
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
        String[] moves = {"Slash", "Margarine Missile", "Parry", "Potion"};
        Potion smallPotion = new Potion("Small Potion", new Location(0, 0, 0, 0), null, ' ', null, true, false, 25);
        Potion mediumPotion = new Potion("Medium Potion", new Location(0, 0, 0, 0), null, ' ', null, true, false, 50);
        ArrayList<Potion> gruntPotions = new ArrayList<Potion>();
        ArrayList<Potion> bossPotions = new ArrayList<Potion>();
        gruntPotions.add(smallPotion);
        bossPotions.add(smallPotion);
        bossPotions.add(mediumPotion);

        // maybe adjust the enemies range
        enemy.add(new Enemy("Grunt", new Location(6,10,0,0), null, '+', null, true, false, 100, 100, 100, moves, true, gruntPotions));
        enemy.add(new Enemy("Grunt", new Location(55,8,0,0), null, '+', null, true, false, 100, 100, 100, moves, true, gruntPotions));
        enemy.add(new Enemy("Grunt", new Location(50,30,0,0), null, '+', null, true, false, 100, 100, 100, moves, true, gruntPotions));
        enemy.add(new Enemy("Boss", new Location(77,3,0,0), null, '+', null, true, false, 200, 200, 200, moves, true, bossPotions));
    }

    /**
     * Purpose: To populate the terrain array with any object in the game that
     * represents a natural obsticle.
     * @param terrain a list to be populated with all of the terrain sprites in
     * the game.
     */
    public void createTerrainArray(ArrayList<Sprite> terrain) {
      /*-----------------Middle mountain--------------------------------*/
      Image rightMiddleMountain = new Image("file:rightMountainTile.png");
      Image leftMiddleMountain = new Image("file:leftMountainTile.png");
      Image middleMiddleMountain = new Image("file:centerMountainTile.png");
      /*-----------------Top mountain-----------------------------------*/
      Image rightTopMountain = new Image("file:rightTopMountainTile.png");
      Image leftTopMountain = new Image("file:leftTopMountainTile.png");
      Image middleTopMountain = new Image("file:topMountainTile.png");
      /*------------------Bottom mountain-------------------------------*/
      Image rightBottomMountain = new Image("file:bottomRightMountainTile.png");
      Image leftBottomMountain = new Image("file:bottomleftMountainTile.png");
      Image middleBottomMountain = new Image("file:bottomCenterMountainTile.png");
      /*--------------------- Middle water------------------------------*/
      Image rightMiddleWater = new Image("file:middleRightWaterTile.png");
      Image leftMiddleWater = new Image("file:leftMiddleWaterTile.png");
      Image middleMiddleWater = new Image("file:middleMiddleWaterTile.png");
      /*--------------------Top water-----------------------------------*/
      Image rightTopWater = new Image("file:topRightWaterTile.png");
      Image leftTopWater = new Image("file:topLeftWaterTile.png");
      Image middleTopWater = new Image("file:topMiddleWaterTile.png");
      /*-------------------Bottom water------------------------------*/
      Image rightBottomWater = new Image("file:bottomRightWaterTile.png");
      Image leftBottomWater = new Image("file:bottomLeftWaterTile.png");
      Image middleBottomWater = new Image("file:bottomMiddleWaterTile.png");
      /*--------------------------Top Gate-----------------------------------*/
      Image leftTopGate = new Image("file:Gate1.png");
      Image middleTopGate = new Image("file:Gate2.png");
      Image rightTopGate = new Image("file:Gate3.png");
      /*---------------------------Middle Gate-----------------------------*/
      Image leftMiddleGate = new Image("file:Gate4.png");
      Image rightMiddleGate = new Image("file:Gate5.png");
      /*------------------------- Bottom Gate----------------------------*/
      Image leftBottomGate = new Image("file:Gate6.png");
      Image middleBottomGate = new Image("file:Gate7.png");
      Image rightBottomGate = new Image("file:Gate8.png");
      /*-----------------------------Border-------------------------------*/
      Image border = new Image("file:borderGreen.png");




      /*------------------------ROW 0-------------------------------------------*/

        for(int index = 0; index < 80; index++) {
            terrain.add(new Sprite("border", new Location(index, 0, 0, 0), border, '-', null, true, false));
        }

        /*-----------------------ROW 1--------------------------------------------*/
        terrain.add(new Sprite("border",new Location(0, 1, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water",new Location(28, 1, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 29; index < 38; index++) {
            terrain.add(new Sprite("water",new Location(index, 1, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water",new Location(38, 1, 0, 0),rightBottomWater , '/', null, true, false));
        terrain.add(new Sprite("water",new Location(47, 1, 0, 0), leftMiddleWater, '|', null, true, false));

        for(int index = 48; index < 57; index++)
        {
          terrain.add(new Sprite("water",new Location(index, 1, 0, 0), middleMiddleWater, '~', null, true, false));
        }
        terrain.add(new Sprite("water",new Location(57, 1, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite("mountain",new Location(66, 1, 0, 0),leftMiddleMountain , '|', null, true, false));

        for(int index = 67; index < 79; index++) {
            terrain.add(new Sprite("mountain",new Location(index, 1, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

          terrain.add(new Sprite("border",new Location(79, 1, 0, 0), border, '|', null, true, false));

        /*-------------------------ROW 2--------------------------------------*/

        terrain.add(new Sprite("border",new Location(0, 2, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water",new Location(27, 2, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 28; index < 37; index++) {
            terrain.add(new Sprite("water",new Location(index, 2, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water",new Location(37, 2, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite("water",new Location(47, 2, 0, 0), leftMiddleWater, '|', null, true, false));

        for(int index = 48; index < 56; index++)
        {
          terrain.add(new Sprite("water",new Location(index, 2, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water",new Location(56, 2, 0, 0), rightBottomWater, '/', null, true, false));


        terrain.add(new Sprite("mountain",new Location(66, 2, 0, 0), leftMiddleMountain, '|', null, true, false));

        for(int index = 67; index < 76; index++) {
            terrain.add(new Sprite("mountain",new Location(index, 2, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }
        terrain.add(new Sprite("mountain",new Location(76, 2, 0, 0), middleBottomMountain, '-', null, true, false));
        terrain.add(new Sprite("mountain",new Location(77, 2, 0, 0), middleBottomMountain, '-', null, true, false));
        terrain.add(new Sprite("mountain",new Location(78, 2, 0, 0), middleBottomMountain, '-', null, true, false));
        terrain.add(new Sprite("border",new Location(79, 2, 0, 0), border, '|', null, true, false));

        /*-------------------------ROW 3--------------------------------------*/
        terrain.add(new Sprite("border",new Location(0, 3, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water",new Location(26, 3, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 27; index < 36; index++) {
            terrain.add(new Sprite("water",new Location(index, 3, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water",new Location(36, 3, 0, 0), rightBottomWater, '/', null, true, false));
        terrain.add(new Sprite("water",new Location(47, 3, 0, 0), leftMiddleWater, '|', null, true, false));
        for(int index = 48; index < 55; index++)
        {
          terrain.add(new Sprite("water",new Location(index, 3, 0, 0), middleMiddleWater, '~', null, true, false));
        }
        terrain.add(new Sprite("water",new Location(55, 3, 0, 0), rightBottomWater, '/', null, true, false));
        terrain.add(new Sprite("mountain",new Location(66, 3, 0, 0), leftMiddleMountain, '|', null, true, false));

        for(int index = 67; index < 76; index++) {
          terrain.add(new Sprite("mountain",new Location(index, 3, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

          terrain.add(new Sprite("mountain", new Location(76, 3, 0, 0), rightMiddleMountain, '|', null, true, false));
          terrain.add(new Sprite("border",new Location(79, 3, 0, 0), border, '|', null, true, false));

        /*-------------------------------ROW 4--------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 4, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(25, 4, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 26; index < 35; index++) {
            terrain.add(new Sprite("water", new Location(index, 4, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(35, 4, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite("water",new Location(47, 4, 0, 0), leftBottomWater, '|', null, true, false));
        for(int index = 48; index < 54; index++)
        {
          terrain.add(new Sprite("water",new Location(index, 4, 0, 0), middleBottomWater, '-', null, true, false));
        }

        terrain.add(new Sprite("water",new Location(54, 4, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(66, 4, 0, 0), leftMiddleMountain, '|', null, true, false));

          for(int index = 67; index < 76; index++) {
              terrain.add(new Sprite("mountain", new Location(index, 4, 0, 0), middleMiddleMountain, 'm', null, true, false));
            }

          terrain.add(new Sprite("mountain", new Location(76, 4, 0, 0), rightMiddleMountain, '|', null, true, false));
          terrain.add(new Sprite("border",new Location(79, 4, 0, 0),border,'|',null,true,false));

        /*---------------------------ROW 5------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 5, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(24, 5, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 25; index < 34; index++) {
            terrain.add(new Sprite("water", new Location(index, 5, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(34, 5, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(59, 5, 0, 0), leftTopMountain, '/', null, true, false));

        for(int index = 60; index < 63; index++)
        {
          terrain.add(new Sprite("mountain", new Location(index, 5, 0, 0), middleTopMountain, '-', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(66, 5, 0, 0), leftMiddleMountain, '|', null, true, false));

      for(int index = 67; index < 76; index++) {
          terrain.add(new Sprite("mountain", new Location(index, 5, 0, 0),middleMiddleMountain , 'm', null, true, false));
          }

        terrain.add(new Sprite("mountain", new Location(76, 5, 0, 0), rightBottomMountain, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(79, 5, 0, 0), border, '|', null, true, false));

        /*----------------------------ROW 6-----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 6, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(23, 6, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 24; index < 33; index++) {
            terrain.add(new Sprite("water", new Location(index, 6, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(33, 6, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(58, 6, 0, 0), leftTopMountain, '/', null, true, false));

        for(int index = 59; index < 62; index++)
        {
          terrain.add(new Sprite("mountain", new Location(index, 6, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }
        terrain.add(new Sprite("mountain", new Location(62, 6, 0, 0), rightBottomMountain, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(66, 6, 0, 0), leftMiddleMountain, '|', null, true, false));

        for(int index = 67; index < 72; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 6, 0, 0), middleMiddleMountain, 'm', null, true, false));
          }

        for(int index = 72; index < 77; index++)  {
          terrain.add(new Sprite("mountain", new Location(index, 6, 0, 0), middleTopMountain, '-', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(79, 6, 0, 0), border, '|', null, true, false));

        /*----------------------Row 7-----------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 7, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(22, 7, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 23; index < 32; index++) {
            terrain.add(new Sprite("water", new Location(index, 7, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(32, 7, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(57, 7, 0, 0), leftTopMountain, '/', null, true, false));

        for(int index = 58; index < 61; index++)
        {
          terrain.add(new Sprite("mountain", new Location(index, 7, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(61, 7, 0, 0), rightBottomMountain, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(66, 7, 0, 0), leftMiddleMountain, '|', null, true, false));

        for(int index = 67; index < 71; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 7, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(71, 7, 0, 0), rightBottomMountain, '/', null, true, false));
        terrain.add(new Sprite("border", new Location(79, 7, 0, 0), border, '|', null, true, false));

        /*--------------------------------Row 8-------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 8, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(21, 8, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 22; index < 31; index++) {
            terrain.add(new Sprite("water", new Location(index, 8, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(31, 8, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(57, 8, 0, 0), leftMiddleMountain, '|', null, true, false));

        for(int index = 57; index < 60; index++)
        {
          terrain.add(new Sprite("mountain", new Location(index, 8, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(61, 8, 0, 0), rightBottomMountain, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(66, 8, 0, 0), leftMiddleMountain, '|', null, true, false));
        for(int index = 67; index < 70; index++)
        {
          terrain.add(new Sprite("mountain", new Location(index, 8, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }


        terrain.add(new Sprite("mountain", new Location(70, 8, 0, 0), rightBottomMountain, '/', null, true, false));

        terrain.add(new Sprite("border", new Location(79, 8, 0, 0), border, '|', null, true, false));

        /*------------------------------Row 9---------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 9, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(20, 9, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 21; index < 30; index++) {
            terrain.add(new Sprite("water", new Location(index, 9, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(30, 9, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(57, 9, 0, 0), leftMiddleMountain, '|', null, true, false));

        for(int index = 58; index < 60; index++)
        {
          terrain.add(new Sprite("mountain", new Location(index, 9, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }
        terrain.add(new Sprite("mountain", new Location(60, 9, 0, 0),middleTopMountain, '|', null, true, false));
        for(int index = 62; index < 67; index++)
        {
          terrain.add(new Sprite("mountain", new Location(index, 9, 0, 0), middleTopMountain, '-', null, true, false));
        }

        for(int index = 67; index < 69; index++)
        {
          terrain.add(new Sprite("mountain", new Location(index, 9, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(69, 9, 0, 0), rightBottomMountain, '/', null, true, false));

        for(int index = 72; index < 79; index++) {
          terrain.add(new Sprite("mountain", new Location(index, 9, 0, 0), middleTopMountain, '-', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(79, 9, 0, 0), border, '|', null, true, false));

        /*----------------------------------Row 10----------------------------*/

        terrain.add(new Sprite("border", new Location(0, 10, 0, 0),border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(19, 10, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 20; index < 29; index++) {
            terrain.add(new Sprite("water", new Location(index, 10, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(29, 10, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(57, 10, 0, 0), leftMiddleMountain, '|', null, true, false));

        for(int index = 58; index < 68; index++)
        {
          terrain.add(new Sprite("mountain", new Location(index, 10, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(68, 10, 0, 0), rightBottomMountain, '/', null, true, false));
        terrain.add(new Sprite("mountain", new Location(71, 10, 0, 0), leftTopMountain, '/', null, true, false));


        for(int index = 72; index < 79;index++) {
          terrain.add(new Sprite("mountain", new Location(index, 10, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(79, 10, 0, 0), border, '|', null, true, false));

        /*-----------------------------Row 11---------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 11, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(18, 11, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 19; index < 28; index++) {
            terrain.add(new Sprite("water", new Location(index, 11, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(28, 11, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(57, 11, 0, 0), leftMiddleMountain, '|', null, true, false));

        for(int index = 58; index < 67; index++)
        {
          terrain.add(new Sprite("mountain", new Location(index, 11, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(70, 11, 0, 0), rightBottomMountain, '/', null, true, false));

        for(int index = 71; index < 79; index++)
        {
          terrain.add(new Sprite("mountain", new Location(index, 11, 0, 0), middleMiddleMountain, 'm', null, true, false));

        }
          terrain.add(new Sprite("border", new Location(79, 11, 0, 0), border, '|', null, true, false));

        /*-------------------------------Row 12-----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 12, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(17, 12, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 18; index < 27; index++) {
            terrain.add(new Sprite("water", new Location(index, 12, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(27, 12, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(57, 12, 0, 0), rightTopMountain, '|', null, true, false));

        for(int index = 58; index < 66; index++)
        {
          terrain.add(new Sprite("mountain", new Location(index, 12, 0, 0), middleTopMountain, '-', null, true, false));
        }

        terrain.add(new Sprite("mountain", new Location(66, 12, 0, 0), rightBottomMountain, '/', null, true, false));

        terrain.add(new Sprite("mountain", new Location(69, 12, 0, 0), leftTopMountain, '/', null, true, false));

        for(int index = 70; index < 79; index++) {
          terrain.add(new Sprite("mountain", new Location(index, 12, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(79, 12, 0, 0), border, '|', null, true, false));

        /*------------------------------Row 13------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 13, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(16, 13, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 17; index < 26; index++) {
            terrain.add(new Sprite("water", new Location(index, 13, 0, 0), middleBottomWater, '-', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(26, 13, 0, 0), rightBottomWater, '/', null, true, false));
        terrain.add(new Sprite ("gate", new Location(60,13,0,0),middleTopGate , '=', null, true,false));
        terrain.add(new Sprite ("gate", new Location(61,13,0,0), middleTopGate, '=', null, true,false));
      terrain.add(new Sprite("mountain", new Location(69, 13, 0, 0), leftMiddleMountain, '|', null, true, false));

        for(int index = 70; index < 79; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 13, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(79, 13, 0, 0), border, '|', null, true, false));

        /*-------------------------------Row 14-----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 14, 0, 0), border, '|', null, true, false));

        terrain.add(new Sprite ("gate", new Location(61,14,0,0), leftMiddleGate, '=', null, true,false));
        terrain.add(new Sprite ("gate", new Location(62,14,0,0), leftMiddleGate,'=', null, true,false));
        terrain.add(new Sprite("mountain", new Location(69, 14, 0, 0), leftMiddleMountain, '|', null, true, false));

          for(int index = 70; index < 79; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 14, 0, 0), middleMiddleMountain, 'm', null, true, false));
          }

          terrain.add(new Sprite("border", new Location(79, 14, 0, 0), border, '|', null, true, false));


        /*----------------------------------Row 15--------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 15, 0, 0), border, '|', null, true, false));

        terrain.add(new Sprite ("gate", new Location(62,15,0,0), leftMiddleGate, '=', null, true,false));
        terrain.add(new Sprite ("gate", new Location(63,15,0,0), leftMiddleGate, '=', null, true,false));
        terrain.add(new Sprite("mountain", new Location(69, 15, 0, 0), leftMiddleMountain, '|', null, true, false));

          for(int index = 70; index < 79; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 15, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(79, 15, 0, 0), border, '|', null, true, false));


        /*-----------------------------------Row 16-------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 16, 0, 0), border, '|', null, true, false));

        for(int index = 63; index < 69; index++)
        {
          terrain.add(new Sprite ("gate", new Location(index,16,0,0), middleBottomGate, '=', null, true,false));
        }
        terrain.add(new Sprite("mountain", new Location(69, 16, 0, 0), leftMiddleMountain, '|', null, true, false));

        for(int index = 70; index < 79; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 16, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(79, 16, 0, 0), border, '|', null, true, false));


        /*----------------------------Row 17--------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 17, 0, 0), border, '|', null, true, false));

        terrain.add(new Sprite("mountain", new Location(69, 17, 0, 0), leftMiddleMountain, '|', null, true, false));

        for(int index = 70; index < 79; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 17, 0, 0), middleMiddleMountain, 'm', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(79, 17, 0, 0), border, '|', null, true, false));


        /*-----------------------------Row 18-------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 18, 0, 0), border, '|', null, true, false));


        terrain.add(new Sprite("mountain", new Location(69, 18, 0, 0), leftMiddleMountain, '|', null, true, false));

      for(int index = 70; index < 79; index++) {
            terrain.add(new Sprite("mountain", new Location(index, 18, 0, 0), middleMiddleMountain, '-', null, true, false));
        }

        terrain.add(new Sprite("border", new Location(79, 18, 0, 0), border, '|', null, true, false));


        /*-------------------------------Row 19-----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 19, 0, 0), border, '|', null, true, false));

        terrain.add(new Sprite("border", new Location(79, 19, 0, 0), border, '|', null, true, false));

        /*--------------------------------Row 20----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 20, 0, 0), border, '|', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(61,20,0,0), leftTopMountain, '/', null, true,false));

        for(int index = 62; index < 67; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,20,0,0), middleTopMountain, '-', null, true,false));
        }

        terrain.add(new Sprite("border", new Location(79, 20, 0, 0), border, '|', null, true, false));

        /*--------------------------------Row 21----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 21, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(2, 21, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 3; index < 18; index++) {
            terrain.add(new Sprite("water", new Location(index, 21, 0, 0), middleTopWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(18, 21, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(60,21,0,0), leftTopMountain, '/', null, true,false));

        for(int index = 61; index < 66; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,21,0,0), middleMiddleMountain, 'm', null, true,false));
        }
        terrain.add(new Sprite ("mountain", new Location(66,21,0,0), rightMiddleMountain, '|', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 21, 0, 0), border, '|', null, true, false));

        /*---------------------------Row 22---------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 22, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(1, 22, 0, 0), leftTopWater, '/', null, true, false));

        for(int index = 2; index < 17; index++) {
            terrain.add(new Sprite("water", new Location(index, 22, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(17, 22, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(59,22,0,0), leftTopMountain, '/', null, true,false));

        for(int index = 60; index < 66; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,22,0,0), middleMiddleMountain, 'm', null, true,false));
        }
        terrain.add(new Sprite ("mountain", new Location(66,22,0,0), rightMiddleMountain, '|', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 22, 0, 0), border, '|', null, true, false));

        /*---------------------------Row 23---------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 23, 0, 0), border, '|', null, true, false));

        for(int index = 1; index < 16; index++) {
            terrain.add(new Sprite("water", new Location(index, 23, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(16, 23, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(58,23,0,0), leftTopMountain, '/', null, true,false));

        for(int index = 59; index < 66;)
        {
          terrain.add(new Sprite ("mountain", new Location(index,23,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        for(int index = 66; index < 73; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,23,0,0), middleTopMountain, '-', null, true,false));
        }

        terrain.add(new Sprite("border", new Location(79, 23, 0, 0), border, '|', null, true, false));

        /*-------------------------Row 24-----------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 24, 0, 0), border, '|', null, true, false));

        for(int index = 1; index < 15; index++) {
            terrain.add(new Sprite("water", new Location(index, 24, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(15, 24, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,24,0,0), leftTopMountain, '/', null, true,false));

        for(int index = 58; index < 72; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,24,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(72,24,0,0), rightBottomMountain, '/', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 24, 0, 0), border, '|', null, true, false));

        /*-----------------------------Row 25-------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 25, 0, 0), border, '|', null, true, false));

        for(int index = 1; index < 14; index++) {
            terrain.add(new Sprite("water", new Location(index, 25, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(14, 25, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,25,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 71; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,25,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(71,25,0,0), rightBottomMountain, '/', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 25, 0, 0), border, '|', null, true, false));

        /*------------------------------Row 26------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 26, 0, 0), border, '|', null, true, false));

        for(int index = 1; index < 13; index++) {
            terrain.add(new Sprite("water", new Location(index, 26, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(13, 26, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,26,0,0), leftMiddleWater, '|', null, true,false));

        for(int index = 58; index < 70; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,26,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(70,26,0,0), rightBottomMountain, '/', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 26, 0, 0), border, '|', null, true, false));

        /*---------------------------Row 27---------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 27, 0, 0), border, '|', null, true, false));

        for(int index = 1; index < 12; index++) {
            terrain.add(new Sprite("water", new Location(index, 27, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(12, 27, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,27,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 69; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,27,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(69,27,0,0), rightBottomMountain, '/', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 27, 0, 0), border, '|', null, true, false));

        /*----------------------------------Row 28--------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 28, 0, 0), border, '|', null, true, false));

        for(int index = 1; index < 11; index++) {
            terrain.add(new Sprite("water", new Location(index, 28, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(11, 28, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,28,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 68; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,28,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(68,28,0,0), rightBottomMountain, '/', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 28, 0, 0), border, '|', null, true, false));

        /*-------------------------------Row 29-----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 29, 0, 0), border, '|', null, true, false));

        for(int index = 1; index < 10; index++) {
            terrain.add(new Sprite("water", new Location(index, 29, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(10, 29, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,29,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 67; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,29,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(67,29,0,0), rightMiddleMountain, '|', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 29, 0, 0), border, '|', null, true, false));

        /*--------------------------Row 30----------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 30, 0, 0), border, '|', null, true, false));

        for(int index = 1; index< 9; index++) {
            terrain.add(new Sprite("water", new Location(index, 30, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(9, 30, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,30,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 67; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,30,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(67,30,0,0), rightMiddleMountain, '|', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 30, 0, 0), border, '|', null, true, false));

        /*-----------------------------Row 31-------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 31, 0, 0), border, '|', null, true, false));

        for(int index =1; index < 8; index++) {
          terrain.add(new Sprite("water", new Location(index, 31, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(8, 31, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,31,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 67; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,31,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(67,31,0,0), rightMiddleMountain, '|', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 31, 0, 0), border, '|', null, true, false));

        /*----------------------------Row 32--------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 32, 0, 0), border, '|', null, true, false));

        for(int index = 1; index < 7; index++) {
            terrain.add(new Sprite("water", new Location(index, 32, 0, 0), middleMiddleMountain, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(7, 32, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,32,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 67; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,32,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(67,32,0,0), rightMiddleMountain, '|', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 32, 0, 0), border, '|', null, true, false));

        /*-------------------------------Row 33-----------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 33, 0, 0), border, '|', null, true, false));

        for(int index = 1; index < 6; index++) {
            terrain.add(new Sprite("water", new Location(index, 33, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(6, 33, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,33,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 67; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,33,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(67,33,0,0), rightMiddleMountain, '|', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 33, 0, 0), border, '|', null, true, false));

        /*------------------------------------Row 34------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 34, 0, 0), border, '|', null, true, false));

        for(int index = 1; index < 5; index++) {
            terrain.add(new Sprite("water", new Location(index, 34, 0, 0), middleMiddleWater , '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(5, 34, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,34,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 67; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,34,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(67,34,0,0), rightMiddleMountain, '|', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 34, 0, 0), border, '|', null, true, false));

        /*------------------------------Row 35------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 35, 0, 0), border, '|', null, true, false));

        for(int index = 1; index < 4; index++) {
            terrain.add(new Sprite("water", new Location(index, 35, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(4, 35, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,35,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 67; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,35,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(67,35,0,0), rightMiddleMountain, '|', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 35, 0, 0), border, '|', null, true, false));

        /*------------------------------Row 36------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 36, 0, 0), border, '|', null, true, false));

        for(int index = 1; index < 3; index++) {
            terrain.add(new Sprite("water", new Location(index, 36, 0, 0), middleMiddleWater, '~', null, true, false));
        }

        terrain.add(new Sprite("water", new Location(3, 36, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,36,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 67; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,36,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(67,36,0,0), rightMiddleMountain, '|', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 36, 0, 0), border, '|', null, true, false));

        /*----------------------------------Row 37--------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 37, 0, 0), border, '|', null, true, false));

        terrain.add(new Sprite("water", new Location(1, 37, 0, 0), middleMiddleWater, '~', null, true, false));

        terrain.add(new Sprite("water", new Location(2, 37, 0, 0), rightBottomMountain, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,37,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 66; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,37,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(66,37,0,0), rightBottomMountain, '/', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 37, 0, 0), border, '|', null, true, false));

        /*--------------------------Row 38----------------------------------------*/

        terrain.add(new Sprite("border", new Location(0, 38, 0, 0), border, '|', null, true, false));
        terrain.add(new Sprite("water", new Location(1, 38, 0, 0), rightBottomWater, '/', null, true, false));

        terrain.add(new Sprite ("mountain", new Location(57,38,0,0), leftMiddleMountain, '|', null, true,false));

        for(int index = 58; index < 65; index++)
        {
          terrain.add(new Sprite ("mountain", new Location(index,38,0,0), middleMiddleMountain, 'm', null, true,false));
        }

        terrain.add(new Sprite ("mountain", new Location(65,38,0,0), rightBottomMountain, '/', null, true,false));

        terrain.add(new Sprite("border", new Location(79, 38, 0, 0), border, '|', null, true, false));

        /*--------------------------Row 39----------------------------------------*/

        for(int index = 0; index < 80; index ++) {
            terrain.add(new Sprite("border", new Location(index, 39, 0, 0), border, '-', null, true, false));
        }
    }

    /**
     * Purpose: To populate the items array with objects that the user can find
     * and obtain in the game as well as containing man made obsticles.
     * @param items an array list to be populated with items for in the game.
     */
    public void createItemArray(ArrayList<Sprite> items) {
        items.add(new Sprite("Chest", new Location(5,4,0,0), null, '#', null, true, true));
        items.add(new Potion("Small Potion", new Location(5,4,0,0), null,' ', null, true, true, 25));
        items.add(new Sprite("Chest", new Location(76,28,0,0), null, '#', null, true, true));
        items.add(new Potion("Medium Potion", new Location(76,28,0,0), null,' ', null, true, true, 50));
        items.add(new Sprite("Chest", new Location(38,38,0,0), null, '#', null, true, true));
        items.add(new Potion("Small Potion", new Location(38,38,0,0), null,' ', null, true, true, 25));
        items.add(new Sprite("Chest", new Location(45,30,0,0), null, '#', null, true, true));
        items.add(new Potion("Medium Potion", new Location(45,30,0,0), null,' ', null, true, true, 50));
        items.add(new Sprite("Chest", new Location(74,36,0,0), null, '#', null, true, true));
        items.add(new Potion("Small Potion", new Location(74,36,0,0), null,' ', null, true, true, 25));
        items.add(new Sprite("Chest", new Location(51,6,0,0), null, '#', null, true, true));
        items.add(new Potion("Medium Potion", new Location(51,6,0,0), null,' ', null, true, true, 50));
        items.add(new Sprite("Chest", new Location(37,10,0,0), null, '#', null, true, true));
        items.add(new Potion("Small Potion", new Location(37,10,0,0), null,' ', null, true, true, 25));
        items.add(new Sprite("Chest", new Location(44,21,0,0), null, '#', null, true, true));
        items.add(new Potion("Medium Potion", new Location(44,21,0,0), null,' ', null, true, true, 50));
        items.add(new Sprite("Chest", new Location(22,19,0,0), null, '#', null, true, true));
        items.add(new Potion("Small Potion", new Location(22,19,0,0), null,' ', null, true, true, 25));
        items.add(new Sprite("Chest", new Location(6,30,0,0), null, '#', null, true, true));
        items.add(new Potion("Medium Potion", new Location(6,30,0,0), null,' ', null, true, true, 50));
        items.add(new Sprite("Chest", new Location(25,25,0,0), null, '#', null, true, true));
        items.add(new Potion("Small Potion", new Location(25,25,0,0), null,' ', null, true, true, 25));
        items.add(new Sprite("Chest", new Location(13,9,0,0), null, '#', null, true, true));
        items.add(new Potion("Medium Potion", new Location(13,9,0,0), null,' ', null, true, true, 50));
    }

    /**
     * Purpose: To test out various methods of the GameBoard class
     */
    public static void main(String[] args) {
        GameLoop gl = new GameLoop();
        GameBoard gb = new GameBoard();
        char[][] charArray = new char[40][80]; // initialize the array (200, 40)
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
<<<<<<< HEAD
        g1.drawState(player);
=======
        //gl.drawState(player, charArray);
>>>>>>> Glenn2
        System.out.println();
    }
}
