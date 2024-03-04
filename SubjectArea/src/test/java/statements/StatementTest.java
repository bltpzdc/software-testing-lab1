package statements;

import creatures.dolphin.Dolphin;
import creatures.human.Human;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import creatures.Territory;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StatementTest {

    @Test
    void compareStatements() {
        Human human = new Human(12, 10, new ArrayList<>(), Territory.LAND);
        Dolphin dolphin = new Dolphin(12, 4, new ArrayList<>(), Territory.WATER);

        Statement humanStatement = human.createStatement(7, 3, new IntelligenceStatement(human, dolphin, true));
        Statement dolphinStatement = dolphin.createStatement(7, 1, new IntelligenceStatement(dolphin, human, true));
        Assertions.assertTrue(humanStatement.compareTo(dolphinStatement) > 0);

        assertAll(
                () -> Assertions.assertEquals(human, humanStatement.getContent().getContent()),
                () -> Assertions.assertEquals(dolphin, dolphinStatement.getContent().getContent())
        );
//        Assertions.assertEquals(human, humanStatement.getContent().getContent());
//        Assertions.assertEquals(dolphin, dolphinStatement.getContent().getContent());

    }


}