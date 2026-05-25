package lab7.task3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Warehouse {
    private int currentLoad = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition notOverloaded = lock.newCondition();

    public void takeItem(Item item, String loaderName) throws InterruptedException {
        lock.lock();
        try {
            while (currentLoad + item.weight > 150) {
                notOverloaded.await();
            }

            currentLoad += item.weight;
            System.out.println(loaderName + " взял товар " + item.weight + " кг. Общий вес: " + currentLoad + " кг.");

            if (currentLoad >= 150) {
                System.out.println(">>> Собрано 150 кг! Разгружаем на другом складе...");
                Thread.sleep(800);
                System.out.println(">>> Товары разгружены. Можно брать новые.");
                currentLoad = 0;
                notOverloaded.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }
}