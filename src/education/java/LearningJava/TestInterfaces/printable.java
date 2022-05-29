package education.java.LearningJava.TestInterfaces;

public interface printable {

    String test = "test";

    default void print(){
        System.out.println("Old " + test);
    }
}
