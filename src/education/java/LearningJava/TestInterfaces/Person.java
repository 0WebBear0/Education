package education.java.LearningJava.TestInterfaces;

abstract class Person{

    private String name;    // имя
    private int age;        // возраст

    Person(){
        this("srwe",18);
    }
    Person(String name){
        this(name,20);
    }
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    abstract void displayInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}