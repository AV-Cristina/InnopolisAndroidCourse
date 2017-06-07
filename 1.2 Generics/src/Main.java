/**
 * Created by admin on 07.06.2017.
 */
public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> list1 = new MyArrayList<>();

        for (int i = 0; i < 10; i++) {
            list1.addLast(i);
        }

        list1.addLast(10);

        System.out.println("list 1:");
        for (Integer i : list1)
        {
            System.out.println(i);
        }

        list1.remove(5);

        System.out.println("list 1:");
        for (Integer i : list1)
        {
            System.out.println(i);
        }


        MyArrayList<Integer> list2 = new MyArrayList<>(3);

        for (int i = 0; i < 3; i++) {
            list2.addLast(i);
        }

        list2.addLast(3);

        System.out.println("list 2:");
        for (Integer i : list2)
        {
            System.out.println(i);
        }

    }

}
