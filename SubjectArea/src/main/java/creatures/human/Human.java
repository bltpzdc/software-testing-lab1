package creatures.human;

import creatures.Creature;
import creatures.EnjoyWater;
import inventions.Invention;
import creatures.Territory;
import statements.Statement;
import statements.StatementObject;

import java.util.ArrayList;

public class Human extends Creature implements EnjoyWater {
    public int enjoy = 0;

    public Human(int age, int intelligence, ArrayList<Invention> inventions, Territory habitat) {
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
    public int getAge() {
        return super.age;
    }

    @Override
    public int getIntelligence() {
        return super.intelligence;
    }

    @Override
    public Territory getHabitat() {
        return super.habitat;
    }


    @Override
    public void splash() {
        if (super.habitat == Territory.LAND) {
            setHabitat(Territory.WATER);
        } else {
            ++enjoy;
        }
        ++enjoy;
    }

    @Override
    public void haveFun() {
        ++enjoy;
    }



}
