package Tests;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Scanner;
import java.io.Console;
import gameMechanics.BattleLoop;
import sprite.*;

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
}
