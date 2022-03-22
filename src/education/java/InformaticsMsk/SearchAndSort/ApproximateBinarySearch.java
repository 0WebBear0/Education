package education.java.InformaticsMsk.SearchAndSort;

import java.util.Scanner;

public class ApproximateBinarySearch {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int massLength1 = scan.nextInt();
        int massLength2 = scan.nextInt();
        int [] mass1 = new int [massLength1];
        int [] mass2 = new int [massLength2];
        int [] mass3 = new int [massLength2];


        for (int i = 0; i < massLength1; i++) {
            mass1[i] = scan.nextInt();
        }

        for (int i = 0; i < massLength2; i++) {
            mass2[i] = scan.nextInt();
        }

        int counter = 1;

        for (int i = 0; i < massLength2; i++) {
            while (true){

                if(mass2[i] < mass1[massLength1 / (2 * counter)]){

                }
                else if(mass2[i] > mass1[massLength1 / (2 * counter)]){

                }
                counter+=1;
            }
        }
    }
}
