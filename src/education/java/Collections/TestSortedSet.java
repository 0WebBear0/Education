package education.java.Collections;


import java.util.HashSet;
import java.util.Set;

public class TestSortedSet {
    public static void main(String[] args) {
        HashSet<String> getterList = new HashSet<String>();

        getterList.add("1");
        getterList.add("2");
        getterList.add("3");
        getterList.add("4");

        System.out.println("_----------------_");
        for (String i: getterList.toArray(new String[0])) {
            System.out.println(i);
        }
    }
}
