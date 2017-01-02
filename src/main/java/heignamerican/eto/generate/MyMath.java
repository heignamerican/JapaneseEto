package heignamerican.eto.generate;

public class MyMath {
    /**
     * 最小公倍数
     */
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /**
     * 最大公約数
     */
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        if (a < b)
            return gcd(b, a);
        return gcd(b, a % b);
    }
}