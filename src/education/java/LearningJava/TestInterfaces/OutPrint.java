package education.java.LearningJava.TestInterfaces;

public class OutPrint {
    public static void main(String[] args) {
//
//        Vasya vasya = new Vasya("Oleg");
//
//        vasya.displayInfo();
//
//        vasya.print();

        TestBaseCollection test = new TestBaseCollection();

        test.add("string");
        test.add("string1");
        test.add("string2");
        test.add("string1");
        System.out.println(test.toArray().length);
    }
}
