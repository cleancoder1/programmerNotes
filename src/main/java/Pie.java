public class Pie {


    public static void main(String[] args) {
        leibnizSeries();
    }

    // pie/4 = 1-1/3+1/5-1/7+...
    private static void leibnizSeries() {
        double pi = 0;
        for (int i = 1; i < 1000000; i++) {
            if (i % 2 == 1) {
                pi = pi + 1.0 / (2 * i - 1);
            } else {
                pi = pi - 1.0 / (2 * i - 1);
            }
        }
        System.out.println(pi * 4);
    }
}
