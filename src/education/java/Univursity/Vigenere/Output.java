package education.java.Univursity.Vigenere;

public class Output {

    public static void main(String[] args) {

        Algorithm algorithm = new Algorithm();
        System.out.println(algorithm.getVigenere("abcd", "ba"));
        System.out.println(algorithm.decryptionVigenere("GGHH", "ba"));

    }
}
