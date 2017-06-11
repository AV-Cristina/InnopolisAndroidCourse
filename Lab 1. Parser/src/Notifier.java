import java.util.ArrayList;

/**
 * Created by Cristina on 11.06.2017.
 */
public class Notifier implements Runnable {

    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (msg) {
                if (msg.isCorrect()) {
                    msg.notifyAll();
                }
            }
        }
    }

}