import compModules.FunctionsDecomposer;
import tools.CondReader;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CondReader reader = new CondReader(scanner);
        double precision = 0, argument = 0;
        try {
            precision = reader.readPrecision();
            argument = reader.readArgForSec();
        } catch (InputMismatchException e) {
            System.err.println("Input value should be fractional number");
            return;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return;
        } catch (NoSuchElementException e) {
            System.err.println("You should enter a fractional number");
            return;
        }

        FunctionsDecomposer decomposer = new FunctionsDecomposer();
        System.out.println(decomposer.computeSec(argument, precision));
        System.out.println(1/Math.cos(1));
    }
}
