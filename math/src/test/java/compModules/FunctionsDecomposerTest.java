package compModules;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsDecomposerTest {
    @Test
    @DisplayName("Factorial test #1")
    void facTest1() {
        Assertions.assertEquals(120, FunctionsDecomposer.fact(5));
    }

    @Test
    @DisplayName("Factorial test #2")
    void facTest2() {
        Assertions.assertEquals(1, FunctionsDecomposer.fact(0));
    }

    @Test
    @DisplayName("Factorial test #3")
    void facTest3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FunctionsDecomposer.fact(-1);
        });
    }

    @Test
    @DisplayName("Factorial test #4")
    void facTest4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FunctionsDecomposer.fact(26);
        });
    }

    @Test
    @DisplayName("Factorial test #5")
    void facTest5() {
        Assertions.assertEquals(Long.parseLong("20922789888000"), FunctionsDecomposer.fact(16));
    }

    @Test
    @DisplayName("Combination test #1")
    void combTest1 () {
        int rc = FunctionsDecomposer.combination(5, 3);
        Assertions.assertEquals(rc, 10);
    }

    @Test
    @DisplayName("Combination test #2")
    void combTest2 () {
        int rc = FunctionsDecomposer.combination(6, 2);
        Assertions.assertEquals(rc, 15);
    }

    @Test
    @DisplayName("Combination test #3")
    void combTest3 () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FunctionsDecomposer.combination(52, 42);
        });
    }

    @Test
    @DisplayName("Euler number test #1")
    void eulerNumberTest1() {
        Assertions.assertEquals(1, FunctionsDecomposer.getEulerNumber(0));
    }

    @Test
    @DisplayName("Euler number test #2")
    void eulerNumberTest2() {
        Assertions.assertEquals(-61, FunctionsDecomposer.getEulerNumber(6));
    }

    @Test
    @DisplayName("Euler number test #3")
    void eulerNumberTest3() {
        for (int i = 1; i < 5; i += 2) {
            Assertions.assertEquals(0, FunctionsDecomposer.getEulerNumber(i));
        }
    }

    @Test
    @DisplayName("Term test #1")
    void getTermTest1() {
        Assertions.assertEquals(0.5d, FunctionsDecomposer.getTerm(1, 1));
    }

    @Test
    @DisplayName("Term test #2")
    void getTermTest2() {
        Assertions.assertEquals(0.208d, FunctionsDecomposer.getTerm(1, 2), 0.001);
    }

    @Test
    @DisplayName("Sec test #1")
    void secTest1() {
        double x = 1d, eps = 0.1d;
        double expected = 1 / Math.cos(x);
        double got = FunctionsDecomposer.computeSec(x, eps);
        Assertions.assertEquals(expected, got, eps);
    }

    @Test
    @DisplayName("Sec test #2")
    void secTest2() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            FunctionsDecomposer.computeSec(Math.PI * 3 / 2, 0.1);
        });
    }

    @Test
    void secTest3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FunctionsDecomposer.computeSec(1, 0.01);
        });
    }
}