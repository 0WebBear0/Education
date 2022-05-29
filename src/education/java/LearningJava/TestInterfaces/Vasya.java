package education.java.LearningJava.TestInterfaces;

public class Vasya extends Person implements printable {

    private String name;

    public Vasya(String name){
        super(name + " test");
        this.name = name;
    }

    @Override
    void displayInfo() {
        System.out.println("Old " + getName() + " New " + this.name);
    }

    @Override
    public void print() {
        System.out.println("Print " + this.test + "ssssss");
    }
}
