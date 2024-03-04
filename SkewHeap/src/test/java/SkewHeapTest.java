import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SkewHeapTest {
    @Test
    @DisplayName("Check positive values")
    void checkPositive() {
        assertAll(
                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{1}), new Integer[]{1}),

                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{2, 1}), new Integer[]{1, 2, null}),

                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{12, 5, 10, 3, 7, 8, 14}),
                        new Integer[]{3, 7, 5, 14, null, 8, 10, null, null, null, null, 12, null, null, null}),

                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{9, 2, 6, 3, 1, 0, 8}),
                        new Integer[]{0, 8, 1, null, null, 2 ,null, null, null, null, null, 3, 6, null, null, null, null, null, null, null, null ,null ,null, 9, null, null, null, null, null, null ,null}),

                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{9, 2, 6, 3, 1, 0, 8, 12, 5, 10, 3, 7, 8, 14, 4, 55, 6}),
                        new Integer[]{0, 3, 1, 6, 4, 7, 2, 8, null, 5, null, 55, 12, 3, 6, null, null, null, null, 8, null, null, null, null, null, null, null, 14, 9, 10, null})
        );
    }
    @Test
    @DisplayName("Check negative values")
    void checkNegative() {
        assertAll(
                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{-1}), new Integer[]{-1}),

                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{-2, -1}), new Integer[]{-2, -1, null}),

                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{-5, -4, -3, -2, -1}),
                        new Integer[]{-5, -3, -4, -1, null, -2, null}),

                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{-9, -2, -6, -3, -1, -0, -8}),
                        new Integer[]{-9, -8, -3, -6, null, 0, -2, -1, null, null, null, null, null, null, null}),

                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{-5, -4, -3, -2, -1, -10, -9, -4, -15, -100, -6}),
                        new Integer[]{-100, -6, -15, null, null, -10, null, null, null, null, null, -5, -9, null, null, null, null, null, null, null, null, null, null, -4, -3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -4, null, -1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null})
        );
    }

    @Test
    @DisplayName("Check zeros")
    void checkZeros() {
        assertAll(
                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{0}), new Integer[]{0}),
                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{0, 0}), new Integer[]{0, 0, null}),
                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{0, 0, 0}), new Integer[]{0, 0, 0}),
                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{0, 0, 0, 0}), new Integer[]{0, 0, 0, 0, null, null, null}),
                () -> assertArrayEquals(SkewHeap.buildHeapArr(new int[]{0, 0, 0, 0, 0}), new Integer[]{0, 0, 0, 0, null, 0, null})
        );
    }

    @Test
    @DisplayName("Check empty")
    void checkEmpty() {
        assertArrayEquals(SkewHeap.buildHeapArr(new int[]{}), new Integer[]{null});
    }

    @Test
    @DisplayName("Check null")
    void checkNull() {
        assertThrows(NullPointerException.class, () -> SkewHeap.buildHeapArr(null));
    }

    @Test
    @DisplayName("Check pop")
    void checkPop() {
        assertAll(
                () -> assertArrayEquals(SkewHeap.getPoppedHeap(new int[]{1}), new Integer[]{null}),
                () -> assertArrayEquals(SkewHeap.getPoppedHeap(new int[]{1, 2}), new Integer[]{2}),
                () -> assertArrayEquals(SkewHeap.getPoppedHeap(new int[]{12, 5, 10, 3, 7, 8, 14}), new Integer[]{5, 7, 8, 10, 14, 12, null}),
                () -> assertArrayEquals(SkewHeap.getPoppedHeap(new int[]{9, 2, 6, 3, 1, 0, 8}), new Integer[]{1, 8, 2, null, null, 3, 6, null, null, null, null, 9, null, null, null})

        );
    }

    @Test
    @DisplayName("Check pop empty")
    void checkPopEmpty() {
        assertThrows(NullPointerException.class, () -> SkewHeap.getPoppedHeap(new int[]{}));
    }

    @Test
    @DisplayName("Check pop null")
    void checkPopNull() {
        assertThrows(NullPointerException.class, () -> SkewHeap.getPoppedHeap(null));
    }
}
