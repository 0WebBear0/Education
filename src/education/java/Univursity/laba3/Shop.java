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
        while (item != null){
            if (item.getItemName().equals(name)){
                return item;
            }
            else item = item.next;
            currentName = item.getItemName();
        }
        return item;
    }

    public String deleteById(String name){
        Item item = head;

        String currentName = item.getItemName();
        while (item != null){
            if (item.getItemName().equals(name)){
                if (item.next != null){
                    item = item.next;
                }
                else item = null;

                return "Nice";
            }
            else item = item.next;
            currentName = item.getItemName();
        }
        return "Element is not founded";
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
