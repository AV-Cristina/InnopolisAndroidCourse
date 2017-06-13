import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cristina on 12.06.2017.
 */
public class Message {
    private HashMap<Integer, Integer> numbers;  // значение, количество сгенерированных чисел
    private Integer number;                     // случайное число, отправляемое генератором
    private boolean isFiveTimes;                // встретилось ли какое-либо число 5 раз
    private long time;                          // время, прошедшее с момента запуска генератора

    public Message(HashMap<Integer, Integer> numbers, boolean isFiveTimes, Integer number, Integer time) {
        this.numbers = numbers;
        this.number = number;
        this.isFiveTimes = isFiveTimes;
        this.time = time;
    }

    public void setNumbers(Integer number) {
        if (numbers.containsKey(number)){
            // поиск элемента с ключом, равным number
            for (Map.Entry<Integer, Integer> pair : numbers.entrySet()) {
                if (number.equals(pair.getKey())) {
                    if (pair.getValue() == 4) {
                        System.out.println("Завершение работы: число " + number + " было добавлено 5 раз");
                        isFiveTimes = true;
                    }
                    pair.setValue(pair.getValue() + 1);
                    break;
                }
            }
        }
        else {
            // добавляем новое значение
            numbers.put(number, 1);
        }
    }

    public boolean isFiveTimes() {
        return isFiveTimes;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public HashMap<Integer, Integer> getNumbers() {
        return numbers;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
