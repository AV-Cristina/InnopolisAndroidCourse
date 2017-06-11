import java.util.ArrayList;

/**
 * Created by Cristina on 11.06.2017.
 */
public class Message {

    private ArrayList wordList = new ArrayList<>();
    private boolean isCorrect = true;

    public Message(ArrayList wordList, boolean isCorrect) {
        this.wordList = wordList;
        this.isCorrect = isCorrect;
    }

    public boolean addWord(String word) {
        if ((!wordList.contains(word)) && isCorrect == true) {
            wordList.add(word);
            return true;
        }
        else {
            this.isCorrect = false;
            return false;
        }
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}

