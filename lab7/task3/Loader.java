package lab7.task3;

import java.util.List;

public class Loader extends Thread {
    private Warehouse warehouse;
    private List<Item> itemsToMove;

    public Loader(String name, Warehouse warehouse, List<Item> itemsToMove) {
        super(name);
        this.warehouse = warehouse;
        this.itemsToMove = itemsToMove;
    }

    @Override
    public void run() {
        try {
            for (Item item : itemsToMove) {
                warehouse.takeItem(item, getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}