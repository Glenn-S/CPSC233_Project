
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Scanner;
import java.io.Console;
import gameMechanics.BattleLoop;
import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import sprite.*;
import javafx.scene.image.Image;

/**
 * @author Nathan Bhandari, Chris Yan, Zachary Udoumoren, Glenn Skelton
 */
public class BattleLoopTest {

    @Test
    public void testEuseParry() {
        BattleLoop b = new BattleLoop();
        b.setEnemyUsedParry(true);
        assertEquals(true, b.getEnemyUsedParry());
    }

    @Test
    public void testENotuseParry() {
        BattleLoop b = new BattleLoop();
        b.setEnemyUsedParry(false);
        assertEquals(false, b.getEnemyUsedParry());
    }

    @Test
    public void testPuseParry() {
        BattleLoop b = new BattleLoop();
        b.setUsedParry(true);
        assertEquals(true, b.getUsedParry());
    }

    @Test
    public void testPNotuseParry() {
        BattleLoop b = new BattleLoop();
        b.setUsedParry(false);
        assertEquals(false, b.getUsedParry());
    }

    @Test
    public void testWinstateF() {
        BattleLoop b = new BattleLoop();
        Enemy e = new Enemy();
        e.setHealth(20);
        assertEquals(false, b.checkWinState(e));
    }

    @Test
    public void testWinstateT() {
        BattleLoop b = new BattleLoop();
        Enemy e = new Enemy();
        e.setHealth(0);
        assertEquals(true, b.checkWinState(e));
    }

    @Test
    public void testLoseStateF() {
        BattleLoop b = new BattleLoop();
        Player p = new Player();
        p.setHealth(20);
        assertEquals(false, b.checkLoseState(p));
    }

    @Test
    public void testLoseStateT() {
        BattleLoop b = new BattleLoop();
        Player p = new Player();
        p.setHealth(0);
        assertEquals(true, b.checkLoseState(p));
    }
// Need to figure out how to test valid input
//    @Test
//    public void testPlayerinputInvalid() {
//        BattleLoop b = new BattleLoop();
//        Player p = new Player();
//        Scanner sc = new Scanner(System.in);
//        b.playerInput(p);
//        sc = "w";
//        assertEquals(null, b.playerInput());
//    }
//
//    @Test
//    public void testPlayerinputLarge() {
//        BattleLoop b = new BattleLoop();
//        Player p = new Player();
//        Scanner sc = new Scanner(System.in);
//        b.playerInput(p);
//        sc = "5";
//        assertEquals(null, b.playerInput());
//    }
//
//    @Test
//    public void testPlayerinputSmall() {
//        BattleLoop b = new BattleLoop();
//        Player p = new Player();
//        Scanner sc = new Scanner(System.in);
//        b.playerInput(p);
//        sc = "-1";
//        assertEquals(null, b.playerInput());
//    }
//
//    @Test
//    public void testPlayerinputOtherSmall() {
//        BattleLoop b = new BattleLoop();
//        Player p = new Player();
//        Scanner sc = new Scanner(System.in);
//        b.playerInput(p);
//        sc = "3";
//        assertEquals(moves[2], b.playerInput());
//    }

    @Test
    public void testHealth() {
        BattleLoop b = new BattleLoop();
        Player p = new Player();
        Enemy e = new Enemy();
        p.setAttack(100);
        p.setDefence(100);
        e.setAttack(100);
        e.setDefence(100);
        p.setHealth(100);
        e.setHealth(50);
        b.damageCalc(20, e, p);
        b.damageCalc(10, p, e);
        assertEquals(30, e.getHealth());
        assertEquals(90, p.getHealth());
    }
// Can't test javafx stuff
//    @Test
//    public void enemyRemoved() {
//        Canvas c = new Canvas();
//        ArrayList<Enemy> enemies = new ArrayList();
//        ArrayList<Sprite> terrain = new ArrayList();
//        BattleLoop b = new BattleLoop();
//        Enemy e = new Enemy();
//        enemies.add(e);
//        b.removeEnemy(e, enemies, terrain);
//        assertEquals(0, enemies.size());
//    }
//
//    @Test
//    public void tombstoneAdded() {
//        Canvas c = new Canvas();
//        ArrayList<Enemy> enemies = new ArrayList();
//        ArrayList<Sprite> terrain = new ArrayList();
//        BattleLoop b = new BattleLoop();
//        Enemy e = new Enemy();
//        enemies.add(e);
//        b.removeEnemy(e, enemies, terrain);
//        assertEquals(1, terrain.size());
//    }

    @Test
    public void testEAttackExecute() {
        BattleLoop b = new BattleLoop();
        Player p = new Player();
        Enemy e = new Enemy();
        ArrayList<Potion> pot = new ArrayList();
        Potion po = new Potion();
        po.setHealthBoost(25);
        pot.add(po);
        e.setPotions(pot);
        p.setHealth(100);
        e.setHealth(50);
        p.setAttack(100);
        p.setDefence(100);
        e.setAttack(100);
        e.setDefence(100);
        p.setHealth(100);
        b.eAttackExecute("Slash", p, e);
        b.eAttackExecute("Margarine Missile", p, e);
        b.eAttackExecute("Parry", p, e);
        b.eAttackExecute("Potion", p, e);
        assertEquals(85, p.getHealth());
        assertEquals(1, b.getMMCounter());
        assertEquals(true, b.getEnemyUsedParry());
        assertEquals(75, e.getHealth());
    }

    @Test
    public void testAttackExecute() {
        BattleLoop b = new BattleLoop();
        Player p = new Player();
        Enemy e = new Enemy();
        ArrayList<Sprite> pot = new ArrayList();
        Potion po = new Potion();
        po.setHealthBoost(25);
        pot.add(po);
        p.setItems(pot);
        p.setHealth(50);
        e.setHealth(50);
        p.setAttack(100);
        p.setDefence(100);
        e.setAttack(100);
        e.setDefence(100);
        b.attackExecute("Slash", p, e);
        b.attackExecute("Butter Boomerang", p, e);
        b.attackExecute("Parry", p, e);
        b.attackExecute("Potion", p, e);
        assertEquals(35, e.getHealth());
        assertEquals(1, b.getBBCounter());
        assertEquals(true, b.getUsedParry());
        assertEquals(75, p.getHealth());
    }

    @Test
    public void playerHasPotionTrue() {
        BattleLoop b = new BattleLoop();
        Player p = new Player();
        ArrayList<Sprite> pot = new ArrayList();
        Potion po = new Potion();
        po.setHealthBoost(25);
        pot.add(new Enemy());
        pot.add(po);
        p.setItems(pot);
        assertEquals(true, b.playerHasPotion(p));
    }

    @Test
    public void playerHasPotionFalse() {
        BattleLoop b = new BattleLoop();
        Player p = new Player();
        ArrayList<Sprite> pot = new ArrayList();
        pot.add(new Enemy());
        p.setItems(pot);
        assertEquals(false, b.playerHasPotion(p));
    }

    @Test
    public void playerHasValidPotionTrue() {
        BattleLoop b = new BattleLoop();
        Player p = new Player();
        ArrayList<Sprite> pot = new ArrayList();
        Potion po = new Potion();
        po.setHealthBoost(25);
        pot.add(new Enemy());
        pot.add(po);
        p.setItems(pot);
        p.setHealth(75);
        assertEquals(true, po.toString().equals(b.validPotion(p).toString()));
    }

    @Test
    public void playerHasValidPotionFalse() {
        BattleLoop b = new BattleLoop();
        Player p = new Player();
        ArrayList<Sprite> pot = new ArrayList();
        Potion po = new Potion();
        po.setHealthBoost(25);
        pot.add(new Enemy());
        pot.add(po);
        p.setItems(pot);
        p.setHealth(76);
        assertEquals(null, b.validPotion(p));
    }
}
