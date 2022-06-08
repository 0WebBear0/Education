//package education.java.YandexContext;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String first = in.nextLine();
        String second = in.nextLine();

        int counter = 0;
        char ar [] = first.toCharArray();

        ar = idetify(ar);

        for (int i = 0; i < ar.length; i++) {
            if ("".equals(ar[i]) != true){
                counter += count(second, ar[i]);
            }
        }

        System.out.println(counter);
    }
    public static int count(String str, char target) {

        int counter = 0;

        char [] ar = str.toCharArray();

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == target){
                counter++;
            }
        }

        return counter;
    }

    public static char [] idetify(char[] array){

        Set <Character> last = new HashSet<>();


        for (int i = 0; i < array.length; i++) {
            last.add(array[i]);
        }

        String out = "";
        for (int i = 0; i < last.size(); i++) out += last.toArray()[i].toString();

        return out.toCharArray();
    }
}
