import java.util.Date;

/**
 * Created by admin on 09.06.2017.
 */
public class Main
{
    public static void main(String[] args) {

        Chronometer chronometer = new Chronometer();
        Thread thread1 = new Thread(chronometer);

        Timer timer = new Timer();
        Thread thread2 = new Thread(timer);

        thread1.start();
        thread2.start();

    }

}
