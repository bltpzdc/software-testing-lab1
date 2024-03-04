package creatures.dolphin;

import creatures.human.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import creatures.Territory;
import statements.IntelligenceStatement;
import statements.Statement;

import java.util.ArrayList;

class DolphinTest {

    @Test
    void createInvention() {
        Dolphin dolphin = new Dolphin(1, 4, new ArrayList<>(), Territory.WATER);
        dolphin.createInvention("War", 4);
        dolphin.createInvention("Wheel", 7);
        dolphin.createInvention("New-York", 10);

        Assertions.assertEquals(dolphin.getInventions().size(), 1);
    }

    @Test
    void splash() {
        Dolphin dolphin = new Dolphin(1, 4, new ArrayList<>(), Territory.WATER);
        int prev = dolphin.enjoy;
        dolphin.splash();
        Assertions.assertEquals(prev, dolphin.enjoy);
    }

    @Test
    void haveFun() {
        Dolphin dolphin = new Dolphin(1, 4, new ArrayList<>(), Territory.WATER);
        int prev = dolphin.enjoy;
        dolphin.haveFun();
        Assertions.assertEquals(prev + 1, dolphin.enjoy);
    }

    @Test
    void createStatement() {
        Dolphin dolphin = new Dolphin(1, 4, new ArrayList<>(), Territory.WATER);
        Human human = new Human(32, 10, new ArrayList<>(), Territory.LAND);
        Statement statement = dolphin.createStatement(12, 52, new IntelligenceStatement(dolphin, human, true));
        Assertions.assertEquals(statement.getCreator(), dolphin);
    }
}