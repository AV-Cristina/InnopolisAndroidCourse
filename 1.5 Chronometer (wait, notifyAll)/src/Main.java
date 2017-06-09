/**
 * Created by Cristina on 09.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        Time tm = new Time(0, 0);

        Waiter waiter5s = new Waiter(tm, 5);
        new Thread(waiter5s).start();

        Waiter waiter7s = new Waiter(tm, 7);
        new Thread(waiter7s).start();

        Chronometer chronometer = new Chronometer(tm);
        new Thread(chronometer).start();
    }
}
