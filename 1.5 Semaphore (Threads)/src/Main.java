/**
 * Created by admin on 10.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        long[] masX = {1, 2, 3};
        long[] masY = {4, 5, 6};
        long[] masZ = {7, 8, 9};

        Consumer consumer = new Consumer();

        for (long x : masX) {
            Cubator cubator = new Cubator(consumer, x);
            new Thread(cubator).start();
        }

        for (long y : masY) {
            Kvadrator kvadrator = new Kvadrator(consumer, y);
            new Thread(kvadrator).start();
        }

        for (long z : masZ) {
            Singulator singulator = new Singulator(consumer, z);
            new Thread(singulator).start();
        }

    }
}
