/**
 * Created by admin on 10.06.2017.
 */
public class Singulator implements Runnable {
    private long z;
    private Consumer consumer;


    public Singulator(Consumer consumer, long z) {
        this.z = z;
        this.consumer = consumer;
    }

    public void run(){
        consumer.save(0, 0, z);
    }
}
