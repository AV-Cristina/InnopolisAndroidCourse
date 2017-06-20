import java.util.concurrent.Callable;

/**
 * Created by admin on 10.06.2017.
 */
public class Cubator implements Runnable {
    private long x;
    private Consumer consumer;

    public Cubator(Consumer consumer, long x) {
        this.x = x;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        consumer.save(x, 0, 0);
    }
}
