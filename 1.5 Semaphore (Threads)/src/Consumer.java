/**
 * Created by admin on 10.06.2017.
 */
// Класс семафора

public class Consumer {
    private long xCube;
    private long ySquare;
    private long zSingle;
    private static long sum;

    public Consumer(){
        this.xCube = 0;
        this.ySquare = 0;
        this.zSingle = 0;
        this.sum = 0;
    }

    // должен вывести общий результат
    public void save(long x, long y, long z){
        if(x != 0){
            synchronized (Cubator.class){
                xCube += x * x * x;
                sum += xCube;
            }
        }
        else if (y != 0){
            synchronized (Kvadrator.class){
                ySquare += y * y;
                sum += ySquare;
            }
        }
        else if (z != 0){
            synchronized (Singulator.class){
                zSingle += z;
                sum += zSingle;
            }
        }
        System.out.println("Сумма = " + sum);
    }
    
}
