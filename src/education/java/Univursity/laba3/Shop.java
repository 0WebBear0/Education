package education.java.Univursity.laba3;

public class Shop {

    private Item head;

    Shop(){
        head = null;
    }

    public void insertFirst(Item item){

        Item item1 = new Item(item.getItemName(), item.getPrise(), item.getCount());

        item1.next = head;
        head = item1;
    }

    public Item findByName(String name){

        Item item = head;

        String currentName = item.getItemName();

        while (currentName != name){
            if (item.next == null){
                return null;
            }
            else item = item.next;
        }
        return item;
    }

    public void printAll(){
        Item current = head;

        while (current != null){
            current.printEl();
            current = current.next;
            System.out.println("__________---------------____________");
        }
    }
}
