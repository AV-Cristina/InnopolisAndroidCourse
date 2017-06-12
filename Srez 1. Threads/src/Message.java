import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * Created by Cristina on 12.06.2017.
 */
public class Message {
    HashMap<Integer, Integer> numbers;
    boolean isFiveTimes;
    Integer number;

    public Message(HashMap<Integer, Integer> numbers, boolean isFiveTimes, Integer number) {
        this.numbers = numbers;
        this.isFiveTimes = isFiveTimes;
        this.number = number;
    }


    public boolean setNumders(Integer number) {
        boolean isCon = false;
        for (Map.Entry<Integer, Integer> pair : numbers.entrySet()) {
            if (number.equals(pair.getKey())){
                Integer Val = pair.getValue();
                if (Val < 5)
                {
                    ++Val;
                    pair.setValue(Val);
                    System.out.println(System.currentTimeMillis() + " " + pair.getKey() + " добавлено " + pair.getValue());
                    isCon = true;
                    break;
                }
                else {this.isFiveTimes = true;
                    System.out.println("5 раз");
                    return false;}
            }
        }
        if (!isCon) {numbers.put(number, 1);}
        return true;
    }

    public boolean isFiveTimes() {
        return isFiveTimes;
    }

    public void setFiveTimes(boolean fiveTimes) {
        isFiveTimes = fiveTimes;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
