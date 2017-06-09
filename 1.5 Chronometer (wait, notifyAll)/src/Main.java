/**
 * Created by Cristina on 09.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        Time tm = new Time(0);

        Waiter waiter = new Waiter(tm);
        new Thread(waiter).start();

        Chronometer chronometer = new Chronometer(tm);
        new Thread(chronometer).start();
    }
}
