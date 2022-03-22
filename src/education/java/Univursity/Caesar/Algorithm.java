package education.java.Univursity.Caesar;

public class Algorithm {

    private String caesar;
    private int shift;


    public Algorithm(String caesar, int shift ) {
        this.caesar = caesar;
        this.shift = shift;
    }

    public String getCaesar() {

        char [] helperChar = this.caesar.toCharArray();
        int helperInt;

        for (int i = 0; i < helperChar.length; i++) {
            helperInt = helperChar[i];
            helperInt += this.shift;
            // this I'm use ASCII (A-Z){65-90}
            if (helperInt > 90){
                helperInt -= 26;
            }
            helperChar[i] = (char) helperInt;
        }
        return new String(helperChar);
    }
}
