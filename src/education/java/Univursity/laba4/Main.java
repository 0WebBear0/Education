package education.java.Univursity.laba4;

public class Main {
    public static void main(String[] args) {
        System.out.println("Count operation in task" +calculateCountOperation(6, 3));
    }

    public static int calculateCountOperation(int lengthArray, int sizeHelpSquire) {
        int mainArray[][] = new int[lengthArray][lengthArray];
        int helperCount = 0;

        int count = 0;

        for (int i = 0; i < lengthArray; i++) {
            for (int j = 0; j < lengthArray; j++) {
                mainArray[i][j] = (int) (Math.random() * 100);
            }
        }

        int maxCountInLine = lengthArray - sizeHelpSquire + 1;

        for (int i = 0; i < (maxCountInLine) * (maxCountInLine) ; i++) {

            int row = i % maxCountInLine;
            int column = i / maxCountInLine;

            for (int j = column; j < sizeHelpSquire + column; j++) {

                for (int k = row; k < sizeHelpSquire + row; k++) {

                    helperCount += mainArray[j][k];

                    System.out.print(mainArray[j][k] + " ");

                    count++;
                }

                System.out.println();
            }
            System.out.println();
            System.out.println("Sum block = "+helperCount);
            System.out.println("---------------------------------");
            helperCount = 0;
        }

        return count;
    }
}
