package lab3;

import java.util.List;

public class Order {
    private String orderDate;
    private List<String> items;
    private String status;

    public Order(String orderDate, List<String> items, String status) {
        this.orderDate = orderDate;
        this.items = items;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Переопределяем метод toString() для красивого вывода в консоль
    @Override
    public String toString() {
        return "{Дата: '" + orderDate + "', Товары: " + items + ", Статус: '" + status + "'}";
    }
}