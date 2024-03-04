package creatures;

import statements.Statement;
import statements.StatementObject;

public interface Supposable {
    public Statement createStatement(int fame, int importance, StatementObject statementObject);
}
