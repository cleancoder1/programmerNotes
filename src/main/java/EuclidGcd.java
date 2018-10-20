
/* Euclid alogirthm to find GCD of two numbers */
public class EuclidGcd {

    int gcd(int p, int q) {

        if (q == 0) {
            return p;
        }

        int r = p % q;
        System.out.println("p " + p + " q " + q);
        return gcd(q, r);

    }

    public static void main(String args[]) {

        System.out.println(new EuclidGcd().gcd(4, 24));
        System.out.println(new EuclidGcd().gcd(24, 4));
    }
}
