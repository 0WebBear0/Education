package education.java.Univursity.Vigenere;

public class Algorithm {

    public String getVigenere(String vigenere, String key) {

        char [] helperChar = vigenere.toCharArray();
        char [] helperCharKey = key.toCharArray();
        int helperInt;

        for (int i = 0; i < helperChar.length; i++) {
            System.out.println("real " + (int) helperChar[i]);
            helperInt = helperChar[i] + helperCharKey[i % helperCharKey.length];
            // this I'm use ASCII (A-Z){65-90}
            helperInt = helperInt/2;
            System.out.println(helperInt);
            if (helperInt > 90){
                helperInt -= 26;
            }
            helperChar[i] = (char) helperInt;
        }
        return new String(helperChar);
    }

    public String decryptionVigenere(String vigenere, String key) {

        char [] helperChar = vigenere.toCharArray();
        char [] helperCharKey = key.toCharArray();
        int helperInt;

        for (int i = 0; i < helperChar.length; i++) {
            System.out.println("real " + (int) helperChar[i]);
            if (helperChar[i] > helperCharKey[i % helperCharKey.length]){
                helperInt = helperChar[i] - helperCharKey[i % helperCharKey.length];
            }
            else {
                System.out.println(helperChar[i]);
                System.out.println(helperCharKey[i % helperCharKey.length]);
                helperInt = helperChar[i] + helperChar.length - helperCharKey[i % helperCharKey.length] + 28;
            }
//             this I'm use ASCII (A-Z){65-90}
            helperInt = helperInt + 65;
            if (helperInt > 90){
                helperInt += 26;
            }
//            System.out.println(helperInt);
            helperChar[i] = (char) helperInt;
        }
        return new String(helperChar);
    }

}
