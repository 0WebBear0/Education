package education.java.LearningJava.TestInterfaces;

public class TestEnum{

    public static void main(String[] args) {

        Book b1 = new Book("War and Peace", "L. Tolstoy", Type.SCIENCE_FICTION);
        System.out.printf("Book '%s' has a type %s", b1.name, b1.bookType);
        System.out.println();
        switch(b1.bookType){
            case BELLETRE:
                System.out.println("Belletre");
                break;
            case SCIENCE:
                System.out.println("Science");
                break;
            case SCIENCE_FICTION:
                System.out.println("Science fiction");
                break;
            case PHANTASY:
                System.out.println("Phantasy");
                break;
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
class Book{

    String name;
    Type bookType;
    String author;

    Book(String name, String author, Type type){

        bookType = type;
        this.name = name;
        this.author = author;
    }
}

enum Type
{
    SCIENCE,
    BELLETRE,
    PHANTASY,
    SCIENCE_FICTION
}