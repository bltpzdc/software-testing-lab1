package creatures.dolphin;

import creatures.Creature;
import creatures.EnjoyWater;
import inventions.Invention;
import creatures.Territory;
import statements.Statement;
import statements.StatementObject;

import java.util.ArrayList;

public class Dolphin extends Creature implements EnjoyWater {
    int enjoy = 0;
    public Dolphin(int age, int intelligence, ArrayList<Invention> inventions, Territory habitat) {
        super(age, intelligence, inventions, habitat);
    }
    @Override
    public boolean createInvention(String name, int difficulty) {
        Invention invention = new Invention(name, difficulty, this);
        if (invention.getDifficulty() <= this.getIntelligence() ) {
            inventions.add(invention);
            return true;
        }
        return false;
    }
    @Override
    public ArrayList<Invention> getInventions() {
        return super.inventions;
    }
    public Statement createStatement(int fame, int importance, StatementObject statementObject) {
        return new Statement(fame, importance, this, statementObject);
    }

    @Override
    public void splash() {
    }

    @Override
    public void haveFun() {
        ++enjoy;
    }
}
