package lab7.task3;

import java.util.List;

public class Task3Variant3 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        List<Item> items1 = List.of(new Item(50), new Item(40), new Item(60));
        List<Item> items2 = List.of(new Item(70), new Item(30), new Item(50));
        List<Item> items3 = List.of(new Item(80), new Item(20), new Item(50));

        Loader loader1 = new Loader("Грузчик 1", warehouse, items1);
        Loader loader2 = new Loader("Грузчик 2", warehouse, items2);
        Loader loader3 = new Loader("Грузчик 3", warehouse, items3);

        loader1.start();
        loader2.start();
        loader3.start();
    }
}