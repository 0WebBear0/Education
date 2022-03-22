package education.java.InformaticsMsk.SearchAndSort;

import java.util.Scanner;

public class LinerSearch {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int massLength = scan.nextInt();
        int [] mass = new int [massLength];


        for (int i = 0; i < massLength; i++) {
            mass[i] = scan.nextInt();
        }

        int whatIs = scan.nextInt();

        int counter = 0;

        for (int i = 0; i < massLength; i++) {
            if (mass[i] == whatIs){
                counter+=1;
            }
        }
        System.out.println(counter);
    }
}
