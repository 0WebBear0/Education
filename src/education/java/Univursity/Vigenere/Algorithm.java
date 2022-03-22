package education.java.Univursity.Vigenere;

public class Algorithm {

    private int shift;
    private String vigenere;
    private String key;

    public Algorithm(String vigenere, String key, int shift ) {
        this.vigenere = vigenere;
        this.shift = shift;
        this.key = key;
    }

    public String getVigenere() {

        char [] helperChar = this.vigenere.toCharArray();
        char [] helperCharKey = this.key.toCharArray();
        int helperInt;

        for (int i = 0; i < helperChar.length; i++) {
            helperInt = helperChar[i] + helperCharKey[i % helperCharKey.length] ;
            // this I'm use ASCII (A-Z){65-90}
            helperInt = helperInt/2;
            if (helperInt > 90){
                helperInt -= 26;
            }
            helperChar[i] = (char) helperInt;
        }
        return new String(helperChar);
    }
}
