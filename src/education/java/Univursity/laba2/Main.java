package education.java.Univursity.laba2;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();

        int max = 300;
        int min = 180;

        Integer checker;
        int middleTime100 = 0;
        int middleTimeFull [] = new int [10];


        for (int i = 1; i <= 1000; i++) {
            int input_time = (int) (Math.random()*((max-min)+1))+min;
            queue.offer(input_time);
        }
        int i = 0;

        while ((checker = queue.poll()) != null){
            i++;
            int work_time = (int) (Math.random()*((max-min)+1))+min;
            middleTime100 += checker + work_time;

            if (i % 100 == 0){
                System.out.println("Длинна очереди --- " + (1000 - i));
                System.out.println(middleTime100/100 + "sec --- Среднее время ожидания");
                middleTimeFull[i/100 - 1] = middleTime100 / 100;
                middleTime100 = 0;
            }
        }
        System.out.println("______---------_______");
        int answer = 0;
        for (int j = 0; j < 10; j++) {
            answer+= middleTimeFull[j];
        }
        System.out.println(answer/10 + "sec --- Общее среднее время ожидания в очереди");
    }
}
