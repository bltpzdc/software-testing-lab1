package statements;

import creatures.Creature;

public class IntelligenceStatement implements StatementObject{
    private Creature creature1;
    private Creature creature2;
    private boolean is_smarter;

    public IntelligenceStatement(Creature creature1, Creature creature2, boolean is_smarter) {
        this.creature1 = creature1;
        this.creature2 = creature2;
        this.is_smarter = is_smarter;
    }
    @Override
    public Object getContent() {
        return is_smarter ? creature1 : creature2;
    }
}
