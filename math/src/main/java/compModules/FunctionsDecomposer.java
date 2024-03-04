package compModules;

public class FunctionsDecomposer {
    public static long fact(int n) throws IllegalArgumentException {
        if (n < 0 || n > 16)
            throw new IllegalArgumentException("Factorial only for n (- [0; 16]");
        if (n <= 1)
            return 1;
        else
            return n * fact(n - 1);
    }

    public static int combination(int n, int k) throws IllegalArgumentException {
        return (int)(fact(n) / (fact(n - k) * fact(k)));
    }

    public static int getEulerNumber(int n) throws IllegalArgumentException {
        if (n == 0)
            return 1;
        int res = 0;
        for (int k = 1; k <= n; ++k) {
            long tmp = 0;
            for (int l = 0; l <= 2 * k; ++l) {
                tmp += Math.pow(-1, l) * combination(2 * k, l) * Math.pow(k - l, n);
            }
            res += tmp * Math.pow(-1, k) * (1/Math.pow(2, k));
        }
        return res;
    }

    public static double getTerm(double x, int k) {
        return (Math.pow(-1, k) * Math.pow(x, 2 * k) * (double) getEulerNumber(2 * k)) / (double)fact(2 * k);
    }

    public static double computeSec(double x, double eps) {
        if ( ( x * 2 ) % Math.PI == 0 )
            throw new ArithmeticException();
        double prev, res;
        int k = 1;
        res = getTerm(x, 0);
        do {
            prev = res;
            res += getTerm(x, k++);
        } while (Math.abs(res - prev) > eps);
        return res;
    }
}
