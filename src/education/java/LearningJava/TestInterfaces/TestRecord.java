package education.java.LearningJava.TestInterfaces;

public class TestRecord {

    public static void main(String[] args) {
        TestRec test = new TestRec("test",5,false,new LOl("sqwe"));

        System.out.print(test.test().st());
    }
}


record TestRec(String name, int Age, boolean leave, LOl test ){}

class LOl{
    private String st;
    LOl(){
        this.st = "s";
    }
    LOl(String string){
        this.st = string;
    }
    String st(){
        return this.st;
    }
}