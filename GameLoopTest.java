import static org.junit.Assert.*;
import org.junit.Test;
import gameMechanics.*;
import sprite.*;
import java.util.ArrayList;

public class GameLoopTest {

    @Test
    public void testInitializer() {
        // can't test because it has a graphics component attached to it
    }

    @Test
    public void testCheckCollisions() {
    	GameLoop g = new GameLoop();
        ArrayList<Enemy> eList = g.getEnemy();
        ArrayList<Sprite> tList = g.getTerrain();

        Player p = new Player("player", new Location(19, 20, 0, 0), null, ' ', null, true, false, 0, 0, 0, null);

        assertEquals(0, g.getEnemy().size());
        assertEquals(0, g.getTerrain().size());
        assertEquals(0, g.getItem().size());

        assertEquals(false, g.checkCollisions(p, "right"));
        assertEquals(false, g.checkCollisions(p, "left"));
        assertEquals(false, g.checkCollisions(p, "up"));
        assertEquals(false, g.checkCollisions(p, "down"));

        eList.add(new Enemy("enemy", new Location(20, 20, 0, 0), null, ' ', null, true, false, 0, 0, 0, null, false, null));
        g.setEnemy(eList);

        tList.add(new Sprite("terrain", new Location(18, 20, 0, 0), null, ' ', null, true, false));
        tList.add(new Sprite("terrain", new Location(19, 21, 0, 0), null, ' ', null, true, false));
        tList.add(new Sprite("terrain", new Location(19, 19, 0, 0), null, ' ', null, true, false));
        g.setTerrain(tList);

		assertEquals(1, g.getEnemy().size());
        assertEquals(3, g.getTerrain().size());
        assertEquals(true, g.checkCollisions(p, "right"));
        assertEquals(true, g.checkCollisions(p, "left"));
        assertEquals(true, g.checkCollisions(p, "up"));
        assertEquals(true, g.checkCollisions(p, "down"));
    }

    @Test
    public void testGateCheck(){
        GameLoop g = new GameLoop();
        assertEquals(4, g.getTotalKeys());

        Player p = new Player("player", new Location(19, 20, 0, 0), null, ' ', null, true, false, 0, 0, 0, null);
        p.setKeyCount(0);
        assertEquals(false, g.checkGate(p));

        p.setKeyCount(2);
        assertEquals(false, g.checkGate(p));

        p.setKeyCount(3);
        assertEquals(true, g.checkGate(p));

        p.setKeyCount(-1);
        assertEquals(0, p.getKeyCount());
    }

    @Test
    public void testKeyRandomizer() { // can't test initialize because it requires graphics to be initialized
        GameLoop g = new GameLoop();
        ArrayList<Enemy> eList = g.getEnemy();

        eList.add(new Enemy("enemy", new Location(10, 10, 0, 0), null, ' ', null, false, false, 0, 0, 0, null, false, null));
        eList.add(new Enemy("enemy", new Location(20, 20, 0, 0), null, ' ', null, false, false, 0, 0, 0, null, false, null));
        eList.add(new Enemy("enemy", new Location(30, 30, 0, 0), null, ' ', null, false, false, 0, 0, 0, null, false, null));
        eList.add(new Enemy("enemy", new Location(40, 40, 0, 0), null, ' ', null, false, false, 0, 0, 0, null, false, null));
        eList.add(new Enemy("enemy", new Location(50, 50, 0, 0), null, ' ', null, false, false, 0, 0, 0, null, false, null));
        eList.add(new Enemy("enemy", new Location(60, 60, 0, 0), null, ' ', null, false, false, 0, 0, 0, null, false, null));
        eList.add(new Enemy("enemy", new Location(70, 70, 0, 0), null, ' ', null, false, false, 0, 0, 0, null, false, null));
        eList.add(new Enemy("boss", new Location(79, 79, 0, 0), null, ' ', null, false, false, 0, 0, 0, null, false, null));
        g.setEnemy(eList);

        assertEquals(8, g.getEnemy().size());

        g.randomizeKeys();

        int totalFound = 0;
        for (Enemy i : g.getEnemy()) {
            if (i.getKey() == true) totalFound++;
        }
        assertEquals(3, totalFound);
    }

    @Test
    public void testCheckItemType() {
        // can't properly test because of graphics component
        
        GameLoop g = new GameLoop();
        ArrayList<Sprite> iList = g.getItem();

        iList.add(new Potion("Medium Potion", new Location(76,28,0,0), null,' ', null, true, true, 50));
        iList.add(new Defence("Ceramic Plate Shield", new Location(27,1,0,0), null, ' ', null, true, false, 75));
        iList.add(new Weapon("Gold Butterknife", new Location(78,8,0,0), null, ' ', null, true, false, 100));
        g.setItem(iList);

        assertEquals(3, g.getItem().size());

        /*g.checkItemType(iList, 0);
        assertEquals(2, g.getItem().size());
        assertEquals(2, g.getPlayer().getItems().size());
        */
    }

    @Test
    public void testCheckEdges() {
        GameLoop g = new GameLoop();
        Player p = new Player("player", new Location(1, 1, 0, 0), null, ' ', null, true, false, 0, 0, 0, null);
        assertEquals(true, g.checkEdges(p, "left"));
        assertEquals(true, g.checkEdges(p, "up"));
        assertEquals(false, g.checkEdges(p, "right"));
        assertEquals(false, g.checkEdges(p, "down"));

        p.setCoord(new Location(1, 38, 0, 0));
        assertEquals(true, g.checkEdges(p, "left"));
        assertEquals(false, g.checkEdges(p, "up"));
        assertEquals(false, g.checkEdges(p, "right"));
        assertEquals(true, g.checkEdges(p, "down"));

        p.setCoord(new Location(78, 38, 0, 0));
        assertEquals(false, g.checkEdges(p, "left"));
        assertEquals(false, g.checkEdges(p, "up"));
        assertEquals(true, g.checkEdges(p, "right"));
        assertEquals(true, g.checkEdges(p, "down"));

        p.setCoord(new Location(78, 1, 0, 0));
        assertEquals(false, g.checkEdges(p, "left"));
        assertEquals(true, g.checkEdges(p, "up"));
        assertEquals(true, g.checkEdges(p, "right"));
        assertEquals(false, g.checkEdges(p, "down"));
    }

    @Test
    public void testUpdateGate() {
        GameLoop g = new GameLoop();
        ArrayList<Sprite> tList = g.getTerrain();

        tList.add(new Sprite("gate", new Location(18, 20, 0, 0), null, ' ', null, true, false));
        tList.add(new Sprite("gate", new Location(19, 21, 0, 0), null, ' ', null, true, false));
        tList.add(new Sprite("gate", new Location(19, 19, 0, 0), null, ' ', null, true, false));
        g.setTerrain(tList);

        Player p = new Player("player", new Location(19, 20, 0, 0), null, ' ', null, true, false, 0, 0, 0, null);

        p.setKeyCount(3);
        assertEquals(3, g.getTerrain().size());
        assertEquals(true, g.checkGate(p));
        assertEquals(0, g.getTerrain().size());
    }

    @Test
    public void testUpdatePostion() {
        GameLoop g = new GameLoop();
        Player p = new Player("player", new Location(20, 20, 0, 0), null, ' ', null, true, false, 0, 0, 0, null);

        g.updatePosition(p, "up");
        Location newCoord = new Location(20, 19, 0, 0);
        assertEquals(newCoord.getxCoord(), p.getCoord().getxCoord());
        assertEquals(newCoord.getyCoord(), p.getCoord().getyCoord());

        g.updatePosition(p, "left");
        newCoord = new Location(19, 19, 0, 0);
        assertEquals(newCoord.getxCoord(), p.getCoord().getxCoord());
        assertEquals(newCoord.getyCoord(), p.getCoord().getyCoord());

        g.updatePosition(p, "down");
        newCoord = new Location(19, 20, 0, 0);
        assertEquals(newCoord.getxCoord(), p.getCoord().getxCoord());
        assertEquals(newCoord.getyCoord(), p.getCoord().getyCoord());

        g.updatePosition(p, "right");
        newCoord = new Location(20, 20, 0, 0);
        assertEquals(newCoord.getxCoord(), p.getCoord().getxCoord());
        assertEquals(newCoord.getyCoord(), p.getCoord().getyCoord());
    }

    @Test
    public void testPickUpItem() {
        GameLoop g = new GameLoop();
        Player p = new Player("player", new Location(20, 20, 0, 0), null, ' ', null, true, false, 0, 0, 0, null);
        Potion newItem = null;

        g.pickUpItem(p, newItem);
        assertEquals(0, p.getItems().size());

        newItem = new Potion("Medium Potion", new Location(76, 28, 0, 0), null,' ', null, true, true, 50);
        g.pickUpItem(p, newItem);
        assertEquals(1, p.getItems().size());

        g.pickUpItem(p, new Defence("Ceramic Plate Shield", new Location(27,1,0,0), null, ' ', null, true, false, 75));
        assertEquals(2, p.getItems().size());

        g.pickUpItem(p, new Weapon("Gold Butterknife", new Location(78,8,0,0), null, ' ', null, true, false, 100));
        assertEquals(3, p.getItems().size());
    }

    @Test
    public void testPlayerInput() {
        // is there much point in testing this?
    }

    @Test
    public void testDrawStateTerminal() {
        // is there much point in testing this?
    }

}
