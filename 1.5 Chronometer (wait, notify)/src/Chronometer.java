import java.util.Date;

/**
 * Created by admin on 09.06.2017.
 */
public class Chronometer implements Runnable{
    public void run()
    {
        long startSession = System.currentTimeMillis();

        for (int i=0; i<10; i++)
        {
            try {
                Thread.sleep(1000);
                long timeAfteStart = System.currentTimeMillis() - startSession;
                System.out.println("С начала сессии прошло: " + timeAfteStart);
                notify();
            }
            catch (InterruptedException e)
            {
                System.out.println("Sorry, something going wrong");
                e.printStackTrace();
            }
        }

    }
}
