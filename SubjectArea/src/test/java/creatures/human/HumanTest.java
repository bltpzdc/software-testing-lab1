package creatures.human;

import creatures.Creature;
import creatures.dolphin.Dolphin;
import inventions.Invention;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import creatures.Territory;
import statements.IntelligenceStatement;
import statements.Statement;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {

    @Test
    void inventionDifficultySmallerTest(){
        Creature human = new Human(20, 10, new ArrayList<>(), Territory.LAND);
        human.createInvention("War", 4);
        human.createInvention("Wheel", 7);
        human.createInvention("New-York", 10);

        ArrayList<Invention> inventions = human.getInventions();
        for(int i = 0; i < inventions.size(); i++){
            Assertions.assertTrue(inventions.get(i).getDifficulty() <= human.getIntelligence());
        }
    }

    @Test
    void inventionDifficultyBiggerTest(){
        Creature human = new Human(20, 10, new ArrayList<>(), Territory.LAND);
        human.createInvention("Mars Expedition", 20);
        human.createInvention("Blaster", 15);

        assertEquals(0, human.getInventions().size());
    }

    @Test
    void getAge() {
        Creature human = new Human(12, 10, new ArrayList<>(), Territory.LAND);
        Assertions.assertEquals(human.getAge(), 12);
    }

    @Test
    void getIntelligence() {
        Creature human = new Human(12, 10, new ArrayList<>(), Territory.LAND);
        Assertions.assertEquals(human.getIntelligence(), 10);
    }

    @Test
    void getHabitat() {
        Creature human = new Human(12, 10, new ArrayList<>(), Territory.LAND);
        Assertions.assertEquals(human.getHabitat(), Territory.LAND);
    }

    @Test
    void splash1() {
        Human human = new Human(12, 10, new ArrayList<>(), Territory.LAND);
        Assertions.assertEquals(human.enjoy, 0);
        human.splash();
        Assertions.assertEquals(human.enjoy, 1);
        Assertions.assertEquals(human.getHabitat(), Territory.WATER);
    }

    @Test
    void splash2() {
        Human human = new Human(12, 10, new ArrayList<>(), Territory.WATER);
        Assertions.assertEquals(human.enjoy, 0);
        human.splash();
        Assertions.assertEquals(human.enjoy, 2);
        Assertions.assertEquals(human.getHabitat(), Territory.WATER);
    }

    @Test
    void haveFun() {
        Human human = new Human(12, 10, new ArrayList<>(), Territory.LAND);
        int prev = human.enjoy;
        human.haveFun();
        Assertions.assertEquals(prev + 1, human.enjoy);
    }

    @Test
    void createStatement() {
        Human human = new Human(12, 10, new ArrayList<>(), Territory.LAND);
        Dolphin dolphin = new Dolphin(1, 4, new ArrayList<>(), Territory.WATER);
        Statement statement = human.createStatement(12, 42, new IntelligenceStatement(human, dolphin, true));
        Assertions.assertEquals(statement.getCreator(), human);
    }
}