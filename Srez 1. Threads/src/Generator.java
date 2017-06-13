import java.util.Random;

/**
 * Created by Cristina on 12.06.2017.
 */
public class Generator implements Runnable{

    private Message msg;

    public Generator(Message msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        System.out.println("Генератор запустился");
        long startSession = System.currentTimeMillis();
        Random random = new Random();

        while (!msg.isFiveTimes()) {
            try {
                Thread.sleep(1000);
                synchronized (msg) {
                    long timeAfterStart = System.currentTimeMillis() - startSession;
                    Integer  randomNumber = random.nextInt(99);
                    msg.setNumber(randomNumber);
                    msg.setTime(timeAfterStart);
                    msg.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
