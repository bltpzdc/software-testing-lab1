package creatures;

import inventions.Invention;

import java.util.ArrayList;

public interface AbleToInvent {
    boolean createInvention(String name, int difficulty);
    ArrayList<Invention> getInventions();
}
