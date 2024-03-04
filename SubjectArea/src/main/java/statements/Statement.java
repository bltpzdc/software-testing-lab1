package statements;

import creatures.Creature;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Statement implements Comparable<Statement> {
    private int fame;
    private int importance;

    private Creature creator;

    private StatementObject content;

    public Creature getCreator(){
        return creator;
    }
    public StatementObject getContent(){
        return content;
    }
    @Override
    public int compareTo(Statement o) {
        return this.creator.getIntelligence() - o.creator.getIntelligence();
        /*
        * if (this.creator.getIntelligence != o.creator.getIntelligence)
        *       return this.creator.getIntelligence - o.creator.getIntelligence;
        * return this.creator.inventions.size() - this.creator.inventions.size();
        * */
    }
}
