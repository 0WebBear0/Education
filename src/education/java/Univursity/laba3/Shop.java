package education.java.Univursity.laba3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Shop {
    private class ShopItem {
        public String Item;
        public double Price;
        public Calendar ArrivingDate;
        public int Count;
        public int Id;

        private ShopItem prev;

        public ShopItem(String item, double price, Calendar arrivingDate, int count, int id) {
            prev = null;
            Item = item;
            Price = price;
            ArrivingDate = arrivingDate;
            Count = count;
            Id = id;
        }
        //overriding built-in toString() method
        @Override
        public String toString() {
            return Id + " | " + Item + " | " + Price + " | " + ArrivingDate.getTime().toString() + " | " + Count;
        }
    }

    //deque implementation via linked list
    public ShopItem first;
    public ShopItem last;

    public void AddItemFirst(String item, double price, Calendar arrivingDate, int count) {
        ShopItem newItem = new ShopItem(item, price, arrivingDate, count, first == null ? 0 : (last == null ? 1 : Math.max(first.Id, last.Id) + 1));
        if(first != null) {
            first.prev = newItem;
            first = newItem;
        } else {
            first = newItem;
            last = first;
        }
    }

    public void AddItemLast(String item, double price, Calendar arrivingDate, int count) {
        ShopItem newItem = new ShopItem(item, price, arrivingDate, count, first == null ? 0 : (last == null ? 1 : Math.max(first.Id, last.Id) + 1));
        if(last != null) {
            newItem.prev = last;
            last = newItem;
        } else {
            last = newItem;
            first = last;
        }
    }

    public void DeleteItem(int id) {
        if(last == null) return;
        ShopItem current = last;
        //we need to keep track of previous item to make sure to link them
        ShopItem prev = null;
        while(current.Id != id) {
            if(current.prev == null) {
                System.out.println("No matches found");
                return;
            }
            prev = current;
            current = current.prev;
        }
        if(current == last)
            last = last.prev;
        else //oh yeah definitive variable names xD
            prev.prev = current.prev;
    }

    public void DisplayList() {
        if(last == null) return;
        ShopItem current = last;
        String output = "";
        while(current.prev != null) {
            output = current.toString() + "\r\n" + output;
            current = current.prev;
        }
        output = current.toString() + "\r\n" + output;
        System.out.println(output);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Shop instance = new Shop();
        int input = 69420;
        while(input != 0) {
            System.out.println("Enter 1 to add new item to the beginning of list.\r\nEnter 2 to add new item to the end of list.\r\nEnter 3 to remove an item from the list.\r\nEnter 4 to display current list.\r\nEnter 0 to exit.");
            input = Integer.parseInt(in.readLine());
            if(input == 1) {
                System.out.println("Enter item name");
                String item = in.readLine();
                System.out.println("Enter item price");
                double price = Double.parseDouble(in.readLine());
                System.out.println("Retrieving current time");
                Calendar arrivingDate = Calendar.getInstance();
                System.out.println("Enter item count");
                int count = Integer.parseInt(in.readLine());
                instance.AddItemFirst(item, price, arrivingDate, count);
            }
            else if(input == 2) {
                System.out.println("Enter item name");
                String item = in.readLine();
                System.out.println("Enter item price");
                double price = Double.parseDouble(in.readLine());
                //no i won't make you go through mental breakdown while inputting all data fields
                System.out.println("Retrieving current time");
                Calendar arrivingDate = Calendar.getInstance();
                System.out.println("Enter item count");
                int count = Integer.parseInt(in.readLine());
                instance.AddItemLast(item, price, arrivingDate, count);
            }
            else if(input == 3) {
                System.out.println("Enter item ID");
                int id = Integer.parseInt(in.readLine());
                instance.DeleteItem(id);
            } else if(input == 4) {
                instance.DisplayList();
            }
        }
    }
}
