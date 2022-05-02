package education.java.Univursity.Caesar;

public class Algorithm {

    public String getCaesar(String caesar, int shift ) {

        char [] helperChar = caesar.toCharArray();
        int helperInt;

        for (int i = 0; i < helperChar.length; i++) {
            helperInt = helperChar[i];
            helperInt += shift;
            // this I'm use ASCII (A-Z){65-90}
            if (helperInt > 90){
                helperInt -= 26;
            }
            helperChar[i] = (char) helperInt;
        }
        return new String(helperChar);
    }

    public String decryptionCaesar(String caesar, int shift) {

        char [] helperChar = caesar.toCharArray();
        int helperInt;

        for (int i = 0; i < helperChar.length; i++) {
            helperInt = helperChar[i];
            helperInt -= shift;
            // this I'm use ASCII (A-Z){65-90}
            if (helperInt > 90){
                helperInt += 26;
            }
            helperChar[i] = (char) helperInt;
        }
        return new String(helperChar);
    }
}
