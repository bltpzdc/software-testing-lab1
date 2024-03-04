package creatures;

import inventions.Invention;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class Creature implements Supposable, AbleToInvent {
    protected int age;
    protected int intelligence;
    protected ArrayList<Invention> inventions;
    protected Territory habitat;
}
