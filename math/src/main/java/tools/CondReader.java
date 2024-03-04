package tools;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

@NoArgsConstructor
@AllArgsConstructor
public class CondReader {
    private Scanner scanner;

    public double readPrecision() throws InputMismatchException, IllegalStateException, NoSuchElementException {
        double i = scanner.nextDouble();
        if ( i < 0) {
            throw new IllegalArgumentException("Precision should be not less than 0");
        }
        return i;
    }

    public double readArgForSec() throws InputMismatchException, NoSuchElementException {
        return scanner.nextDouble();
    }
}
