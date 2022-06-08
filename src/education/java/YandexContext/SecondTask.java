package education.java.YandexContext;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SecondTask {
    public static void main(String[] args) {

        try(FileReader reader = new FileReader("input.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


        try(FileWriter writer = new FileWriter("output.txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
