package education.java.Univursity.laba3;

import java.time.LocalDate;
import java.time.ZoneId;


public class Item {

    private int Id;
    private String ItemName;
    private int Prise;
    private LocalDate ArrivingDate;
    private int Count;

    Item next;

    Item(String item_name, int prise, int count){

        LocalDate date = LocalDate.now(ZoneId.of("Europe/Paris"));

        Id = hashCode();
        ItemName = item_name;
        Prise = prise;
        Count = count;
        ArrivingDate = date;
        next = null;
    }

    public void printEl(){
        System.out.println(Id + "  Id");
        System.out.println(ItemName + "  ItemName");
        System.out.println(Prise + "  Prise");
        System.out.println(Count + "  Count");
        System.out.println(ArrivingDate + "  ArrivingDate");
    }







    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getPrise() {
        return Prise;
    }

    public void setPrise(int prise) {
        Prise = prise;
    }

    public LocalDate getArrivingDate() {
        return ArrivingDate;
    }

    public void setArrivingDate(LocalDate arrivingDate) {
        ArrivingDate = arrivingDate;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item next) {
        this.next = next;
    }
}
