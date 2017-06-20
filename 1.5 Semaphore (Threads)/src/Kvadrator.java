/**
 * Created by admin on 10.06.2017.
 */
public class Kvadrator implements Runnable {
    private long y;
    private Consumer consumer;

    public Kvadrator(Consumer consumer, long y) {
        this.y = y;
        this.consumer = consumer;
    }

    public void run(){
        consumer.save(y, 0, 0);
    }
}
