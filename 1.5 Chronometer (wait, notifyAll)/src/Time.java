/**
 * Created by Cristina on 09.06.2017.
 */
public class Time {
    private long tm;
    private int timeout;

    public Time(long tm, int timeout) {
        this.tm = tm;
        this.timeout = timeout;
    }

    public long getTm() {
        return tm;
    }

    public void setTm(long tm) {
        this.tm = tm;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
