package education.java.Univursity.Caesar;

public class Output {

    public static void main(String[] args) {

        Algorithm algorithm = new Algorithm();

        System.out.println(algorithm.getCaesar("HABRAHABR",7));
        System.out.println(algorithm.decryptionCaesar("OHIYHOHIY", 7));
    }
}
