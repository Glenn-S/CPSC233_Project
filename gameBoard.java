public class gameBoard
{
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
      String[] moves = {"up", "down", "left", "right"};
      enemy.add(new Enemy("grunt",new Location(5,6,0,0),null, '+', null,true,false,100,100,100, null,false,false,null));

      enemy.add(new Enemy("grunt",new Location(2,40,0,0),null, '+', null,true,false,100,100,100, null,false,false,null));

      enemy.add(new Enemy("grunt",new Location(37,54,0,0),null, '+', null,true,false,100,100,100, null,false,false,null));

      enemy.add(new Enemy("boss",new Location(6,196,0,0),null, '+', null,true,false,200,200,200, null,false,false,null));
  }

  public void createTerrainArray(ArrayList<Sprite> terrain)
  {
  /*------------------------ROW 0----------------------------------------------*/

    for(int index = 0; index < 200; index++)
    {
      terrain.add(newSprite("border", newLocation(0, index, 0, 0), null, '-', null, true, false));
    }

  /**-----------------------ROW 1----------------------------------------------*/
  terrain.add(new Sprite("border",new Location(1,0,0,0), null, '|', null, true, false));

  terrain.add(new Sprite("water",new Location(1,28,0,0), null, '/', null, true, false));

  for(index = 29; index < 38; index++)
  {
  terrain.add(new Sprite("water",new Location(1,index,0,0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water",new Location(1,38,0,0), null, '/', null, true, false));

  terrain.add(new Sprite("mountain",new Location(1,184,0,0), null, '|', null, true, false));

  for(index = 185; index < 195; index++)
  {
  terrain.add(new Sprite("mountain",new Location(1, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("mountain",new Location(1,195,0,0), null, '|', null, true, false));

  terrain.add(new Sprite("border",new Location(1,199,0,0), null, '|', null, true, false));

  /*-------------------------ROW 2---------------------------------------------*/

  terrain.add(new Sprite("border",new Location(2, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water",new Location(2,27,0,0), null, '/', null, true, false));

  for(index = 28; index < 37; index++)
  {
  terrain.add(new Sprite("water",new Location(2, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water",new Location(2,37,0,0), null, '/', null, true, false));

  terrain.add(new Sprite("mountain",new Location(2,184,0,0), null, '|', null, true, false));

  for(index = 185; index < 195; index++)
  {
  terrain.add(new Sprite("mountain",new Location(2, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("mountain",new Location(2,195,0,0), null, '/', null, true, false));

  terrain.add(new Sprite("border",new Location(2,199,0,0), null, '|', null, true, false));

  /*-------------------------ROW 3---------------------------------------------*/

  terrain.add(new Sprite("border",new Location(3,0,0,0), null, '|', null, true, false));

  terrain.add(new Sprite("water",new Location(3,26,0,0), null, '/', null, true, false));

  for(index = 27; index < 36; index++)
  {
  terrain.add(new Sprite("water",new Location(3, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water",new Location(3, 36, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("mountain",new Location(3, 184, 0, 0), null, '|', null, true, false));

  for(index = 185; index < 194; index++)
  {
  terrain.add(new Sprite("mountain",new Location(3, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("mountain",new Location(3, 194, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border",new Location(3, 199, 0, 0), null, '|', null, true, false));

  /*-------------------------------ROW 4----------------------------------------*/

  terrain.add(new Sprite("border", new Location(4, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water", new Location(4, 25, 0, 0), null, '/', null, true, false));

  for(index = 26; index < 35; index++)
  {
  terrain.add(new Sprite("water", new Location(4, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(4, 35, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("mountain", new Location(4, 184, 0, 0), null, '|', null, true, false));

  for(index = 184; index < 193; index++)
  {
  terrain.add(new Sprite("mountain", new Location(4, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("mountain", new Location(4, 193, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border",new Location(4,199,0,0),null,'|',null,true,false));

  /**---------------------------ROW 5-------------------------------------------*/

  terrain.add(new Sprite("border", new Location(5, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water", new Location(5, 24, 0, 0), null, '/', null, true, false));

  for(index = 25; index < 34; index++)
  {
  terrain.add(new Sprite("water", new Location(5, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(5, 34, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("mountain", new Location(5, 184, 0, 0), null, '|', null, true, false));

  for(index = 185; index < 192; index++)
  {
    terrain.add(new Sprite("mountain", new Location(5, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("mountain", new Location(5, 192, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(5, 199, 0, 0), null, '|', null, true, false));

  /*----------------------------ROW 6-------------------------------------------*/

  terrain.add(new Sprite("border", new Location(6, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water", new Location(6, 23, 0, 0), null, '/', null, true, false));

  for(index = 24; index < 33; index++)
  {
  terrain.add(new Sprite("water", new Location(6, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(6, 33, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("mountain", new Location(6, 184, 0, 0), null, '|', null, true, false));

  for(index = 185; index < 191; index++)
  {
    terrain.add(new Sprite("mountain", new Location(6, index, 0, 0), null, 'm', null, true, false));
  }
  terrain.add(new Sprite("mountain", new Location(6, 191, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(6, 199, 0, 0), null, '|', null, true, false));

  /*----------------------Row 7-------------------------------------------------*/

  terrain.add(new Sprite("border", new Location(7, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water", new Location(7, 22, 0, 0), null, '/', null, true, false));

  for(index = 23; index < 32; index++)
  {
    terrain.add(new Sprite("water", new Location(7, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(7, 32, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("mountain", new Location(7, 184, 0, 0), null, '|', null, true, false));

  for(index = 185; index < 190; index++)
  {
    terrain.add(new Sprite("mountain", new Location(7, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("mountain", new Location(7, 190, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(7, 199, 0, 0), null, '|', null, true, false));

  /*--------------------------------Row 8---------------------------------------*/

  terrain.add(new Sprite("border", new Location(8, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water", new Location(8, 21, 0, 0), null, '/', null, true, false));

  for(index = 22; index < 31; index++)
  {
    terrain.add(new Sprite("water", new Location(8, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(8, 31, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("mountain", new Location(8, 184, 0, 0), null, '|', null, true, false));

  for(index = 185; index < 189; index++)
  {
    terrain.add(new Sprite("mountain", new Location(8, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("mountain", new Location(8, 189, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(8, 199, 0, 0), null, '|', null, true, false));

  /*------------------------------Row 9-----------------------------------------*/

  terrain.add(new Sprite("border", new Location(9, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water", new Location(9, 20, 0, 0), null, '/', null, true, false));

  for(index = 21; index < 30; index++)
  {
    terrain.add(new Sprite("water", new Location(9, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(9, 30, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("mountain", new Location(9, 184, 0, 0), null, '|', null, true, false));

  for(index = 185; index < 188; index++)
  {
    terrain.add(new Sprite("mountain", new Location(9, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("mountain", new Location(9, 188, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(9, 199, 0, 0), null, '|', null, true, false));

  /*----------------------------------------Row 10------------------------------*/

  terrain.add(new Sprite("border", new Location(10, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water", new Location(10, 19, 0, 0), null, '/', null, true, false));

  for(index = 20; index < 29; index++)
  {
    terrain.add(new Sprite("water", new Location(10, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(10, 29, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(10, 199, 0, 0), null, '|', null, true, false));

  /*-----------------------------Row 11-----------------------------------------*/

  terrain.add(new Sprite("border", new Location(11, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water", new Location(11, 18, 0, 0), null, '/', null, true, false));

  for(index = 19; index < 28; index++)
  {
    terrain.add(new Sprite("water", new Location(11, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(11, 28, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(11, 199, 0, 0), null, '|', null, true, false));

  /*-------------------------------Row 12---------------------------------------*/

  terrain.add(new Sprite("border", new Location(12, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water", new Location(12, 17, 0, 0), null, '/', null, true, false));

  for(index = 18; index < 27; index++)
  {
    terrain.add(new Sprite("water", new Location(12, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(12, 27, 0, 0), null, '/', null, true, false));

  for(index = 194; index < 199; index++)
  {
    terrain.add(new Sprite("mountain", new Location(12, index, 0, 0), null, '-', null, true, false));
  }

  terrain.add(new Sprite("border", new Location(12, 199, 0, 0), null, '|', null, true, false));

  /*------------------------------Row 13----------------------------------------*/

  terrain.add(new Sprite("border", new Location(13, 0, 0, 0), null, '|', null, true, false));

  for(index = 17; index < 26; index++)
  {
  terrain.add(new Sprite("water", new Location(13, index, 0, 0), null, '-', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(13, 26, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("mountain", new Location(13, 193, 0, 0), null, '/', null, true, false));

  for(index = 194; index < 199; index++)
  {
    terrain.add(new Sprite("mountain", new Location(13, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("mountain", new Location(13, 199, 0, 0), null, '|', null, true, false));

  /*-------------------------------Row 14---------------------------------------*/

  terrain.add(new Sprite("border", new Location(14, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("mountain", new Location(14, 192, 0, 0), null, '/', null, true, false));

  for(index = 193; index < 199; index++)
  {
    terrain.add(new Sprite("mountain", new Location(14, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("border", new Location(14, 199, 0, 0), null, '|', null, true, false));

  /*----------------------------------Row 15------------------------------------*/

  terrain.add(new Sprite("border", new Location(15, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("mountain", new Location(15, 191, 0, 0), null, '/', null, true, false));

  for(index = 192; index < 199; index++)
  {
    terrain.add(new Sprite("mountain", new Location(15, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("border", new Location(15, 199, 0, 0), null, '|', null, true, false));

  /*-----------------------------------Row 16-----------------------------------*/

  terrain.add(new Sprite("border", new Location(16, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("mountain", new Location(16, 190, 0, 0), null, '/', null, true, false));

  for(index = 191; index < 199; index++)
  {
    terrain.add(new Sprite("mountain", new Location(16, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("border", new Location(16, 199, 0, 0), null, '|', null, true, false));

  /*----------------------------Row 17------------------------------------------*/

  terrain.add(new Sprite("border", new Location(17, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("mountain", new Location(17, 190, 0, 0), null, '|', null, true, false));

  for(index = 191; index < 199; index++)
  {
    terrain.add(new Sprite("mountain", new Location(17, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("border", new Location(17, 199, 0, 0), null, '|', null, true, false));

  /*-----------------------------Row 18-----------------------------------------*/

  terrain.add(new Sprite("border", new Location(18, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("mountain", new Location(18, 190, 0, 0), null, '|', null, true, false));

  for(index = 191; index < 199; index++)
  {
    terrain.add(new Sprite("mountain", new Location(18, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("border", new Location(18, 199, 0, 0), null, '|', null, true, false));

  /*-------------------------------Row 19---------------------------------------*/

  terrain.add(new Sprite("border", new Location(19, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("mountain", new Location(19, 190, 0, 0), null, '|', null, true, false));

  for(index = 191; index < 199; index++)
  {
    terrain.add(new Sprite("mountain", new Location(19, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("border", new Location(19, 199, 0, 0), null, '|', null, true, false));

  /*--------------------------------Row 20--------------------------------------*/

  terrain.add(new Sprite("border", new Location(20, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("mountain", new Location(20, 190, 0, 0), null, '|', null, true, false));

  for(index = 191; index < 199; index++)
  {
    terrain.add(new Sprite("mountain", new Location(20, index, 0, 0), null, 'm', null, true, false));
  }

  terrain.add(new Sprite("border", new Location(20, 199, 0, 0), null, '|', null, true, false));

  /*--------------------------------Row 21--------------------------------------*/

  terrain.add(new Sprite("border", new Location(21, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water", new Location(21, 2, 0, 0), null, '/', null, true, false));

  for(index = 3; index < 18; index++)
  {
    terrain.add(new Sprite("water", new Location(21, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(21, 18, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("mountain", new Location(21, 190, 0, 0), null, '|', null, true, false));

  for(index = 191; index < 199; index++)
  {
    terrain.add(new Sprite("mountain", new Location(21, index, 0, 0), null, '-', null, true, false));
  }

  terrain.add(new Sprite("border", new Location(21, 199, 0, 0), null, '|', null, true, false));

  /*---------------------------Row 22-------------------------------------------*/

  terrain.add(new Sprite("border", new Location(22, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water", new Location(0, 1, 0, 0), null, '/', null, true, false));

  for(index = 2; index < 17; index++)
  {
    terrain.add(new Sprite("water", new Location(22, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(22, 17, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(22, 199, 0, 0), null, '|', null, true, false));

  /*---------------------------Row 23-------------------------------------------*/

  terrain.add(new Sprite("border", new Location(23, 0, 0, 0), null, '|', null, true, false));

  for(index = 1; index < 16; index++)
  {
    terrain.add(new Sprite("water", new Location(23, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(23, 16, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(23, 199, 0, 0), null, '|', null, true, false));

  /*-------------------------Row 24---------------------------------------------*/

  terrain.add(new Sprite("border", new Location(24, 0, 0, 0), null, '|', null, true, false));

  for(index = 1; index < 15; index++)
  {
    terrain.add(new Sprite("water", new Location(24, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(24, 15, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(24, 199, 0, 0), null, '|', null, true, false));

  /*-----------------------------Row 25-----------------------------------------*/

  terrain.add(new Sprite("border", new Location(25, 0, 0, 0), null, '|', null, true, false));

  for(index = 1; index < 14; index++)
  {
  terrain.add(new Sprite("water", new Location(25, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(25, 14, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(25, 199, 0, 0), null, '|', null, true, false));

  /*------------------------------Row 26----------------------------------------*/

  terrain.add(new Sprite("border", new Location(26, 0, 0, 0), null, '|', null, true, false));

  for(index = 1; index < 13; index++)
  {
    terrain.add(new Sprite("water", new Location(26, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(26,13, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(26, 199, 0, 0), null, '|', null, true, false));

  /*---------------------------Row 27-------------------------------------------*/

  terrain.add(new Sprite("border", new Location(27, 0, 0, 0), null, '|', null, true, false));

  for(index = 1; index < 12; index++)
  {
  terrain.add(new Sprite("water", new Location(27, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(27, index, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(27, 199, 0, 0), null, '|', null, true, false));

  /*----------------------------------Row 28------------------------------------*/

  terrain.add(new Sprite("border", new Location(28, 0, 0, 0), null, '|', null, true, false));

  for(index = 1; index < 11; index++)
  {
  terrain.add(new Sprite("water", new Location(28, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(28, 11, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(28, 199, 0, 0), null, '|', null, true, false));

  /*-------------------------------Row 29---------------------------------------*/

  terrain.add(new Sprite("border", new Location(29, 0, 0, 0), null, '|', null, true, false));

  for(index = 1; index < 10; index++)
  {
    terrain.add(new Sprite("water", new Location(29, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(29, 10, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(29, 199, 0, 0), null, '|', null, true, false));

  /*--------------------------Row 30--------------------------------------------*/

  terrain.add(new Sprite("border", new Location(30, 0, 0, 0), null, '|', null, true, false));

  for(index = 1; index< 9; index++)
  {
  terrain.add(new Sprite("water", new Location(30, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(30, 9, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(30, 199, 0, 0), null, '|', null, true, false));

  /*-----------------------------Row 31-----------------------------------------*/

  terrain.add(new Sprite("border", new Location(31, 0, 0, 0), null, '|', null, true, false));

  for(index =1; index < 8; index++)
  {
    terrain.add(new Sprite("water", new Location(31, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(31, 8, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(31, 199, 0, 0), null, '|', null, true, false));

  /*----------------------------Row 32------------------------------------------*/

  terrain.add(new Sprite("border", new Location(32, 0, 0, 0), null, '|', null, true, false));

  for(index = 1; index < 7; index++)
  {
    terrain.add(new Sprite("water", new Location(32, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(32, 7, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(32, 199, 0, 0), null, '|', null, true, false));

  /*-------------------------------Row 33---------------------------------------*/

  terrain.add(new Sprite("border", new Location(33, 0, 0, 0), null, '|', null, true, false));

  for(index = 1; index < 6; index++)
  {
    terrain.add(new Sprite("water", new Location(33, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(33, 6, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(33, 199, 0, 0), null, '|', null, true, false));

  /*----------------------------------------Row 34------------------------------*/

  terrain.add(new Sprite("border", new Location(34, 0, 0, 0), null, '|', null, true, false));

  for(index =1; index < 5; index++)
  {
    terrain.add(new Sprite("water", new Location(34, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(34, 5, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(34, 199, 0, 0), null, '|', null, true, false));

  /*------------------------------Row 35----------------------------------------*/

  terrain.add(new Sprite("border", new Location(35, 0, 0, 0), null, '|', null, true, false));

  for(index = 1; index < 4; index++)
  {
    terrain.add(new Sprite("border", new Location(35, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(35, 4, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(35, 199, 0, 0), null, '|', null, true, false));

  /*------------------------------Row 36----------------------------------------*/

  terrain.add(new Sprite("border", new Location(36, 0, 0, 0), null, '|', null, true, false));

  for(index =1; index < 3; index++)
  {
    terrain.add(new Sprite("water", new Location(36, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(36, 3, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(36, 199, 0, 0), null, '|', null, true, false));

  /*----------------------------------Row 37------------------------------------*/

  terrain.add(new Sprite("border", new Location(37, 0, 0, 0), null, '|', null, true, false));

  for(index = 1; index < 2; index++)
  {
    terrain.add(new Sprite("water", new Location(37, index, 0, 0), null, '~', null, true, false));
  }

  terrain.add(new Sprite("water", new Location(37, 2, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(37, 199, 0, 0), null, '|', null, true, false));

  /*--------------------------Row 38--------------------------------------------*/

  terrain.add(new Sprite("border", new Location(37, 0, 0, 0), null, '|', null, true, false));

  terrain.add(new Sprite("water", new Location(37, 1, 0, 0), null, '/', null, true, false));

  terrain.add(new Sprite("border", new Location(37, 199, 0, 0), null, '|', null, true, false));

  /*--------------------------Row 39--------------------------------------------*/

  for(index = 0; index < 200; index ++)
  {
    terrain.add(new Sprite("border", new Location(39, index, 0, 0), null, '-', null, true, false));
  }

  }

  public void createItemArray(ArrayList<Sprite> items)
  {
    items.add(new Sprite("chest",new Location(4,5,0,0),null, '#',null,true,true));
    items.add(new Potion("small", new Location(4,5,0,0), null,"", null, true, true, 25));

    items.add(new Sprite("chest",new Location(24,196,0,0),null, '#',null,true,true));
    items.add(new Potion("medium", new Location(24,196,0,0), null,"", null, true, true, 50));
  }

}
