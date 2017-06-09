import java.util.Date;

/**
 * Created by admin on 09.06.2017.
 */

public class Timer implements Runnable{
    public void run()
    {
        Date startSession = new Date();

        synchronized (startSession) {
            try {
                System.out.println("Ждем вызов метода notify: ");
                startSession.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Прошло 5 секунд");
        }
    }
}