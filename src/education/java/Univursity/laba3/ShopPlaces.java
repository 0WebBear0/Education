package education.java.Univursity.laba3;

public class ShopPlaces {
    public static void main(String[] args) {
        Item item1 = new Item("1",55,22);
        Item item2 = new Item("2",44,11);
        Item item3 = new Item("3",33,0);

        Shop shop1 = new Shop();

        shop1.insertFirst(item1);
        shop1.insertFirst(item2);
        shop1.insertFirst(item3);

        shop1.deleteById("2");
        System.out.println(shop1.findByName("1").getPrise()*0.73);
//        shop1.printAll();

    }
}
