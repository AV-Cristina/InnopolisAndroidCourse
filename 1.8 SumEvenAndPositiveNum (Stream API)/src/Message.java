/**
 * Created by Cristina on 16.06.2017.
 */
public class Message {
    Integer sum;
    private boolean isCorrect = true;

    public Message(Integer sum) {
        this.sum = sum;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}

