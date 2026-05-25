package lab3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreOrders {
    public static void main(String[] args) {
        // Создаем HashMap: Ключ - номер заказа (Integer), Значение - объект Order
        Map<Integer, Order> ordersTable = new HashMap<>();

        // 1. Операция вставки (добавления) заказов
        ordersTable.put(1001, new Order("2026-05-10", List.of("Ноутбук ASUS", "Коврик"), "В обработке"));
        ordersTable.put(1002, new Order("2026-05-11", List.of("Клавиатура механическая"), "Отправлен"));
        ordersTable.put(1003, new Order("2026-05-12", List.of("Монитор", "Кабель HDMI"), "Доставлен"));

        System.out.println("--- Список всех заказов ---");
        for (Map.Entry<Integer, Order> entry : ordersTable.entrySet()) {
            System.out.println("Заказ №" + entry.getKey() + " -> " + entry.getValue());
        }

        // 2. Операция поиска заказа по номеру
        int searchId = 1001;
        System.out.println("\n--- Поиск заказа №" + searchId + " ---");
        if (ordersTable.containsKey(searchId)) {
            System.out.println("Найден: " + ordersTable.get(searchId));
        } else {
            System.out.println("Заказ не найден.");
        }

        // 3. Изменение статуса заказа
        System.out.println("\n--- Изменение статуса заказа №1001 ---");
        Order orderToUpdate = ordersTable.get(1001);
        if (orderToUpdate != null) {
            orderToUpdate.setStatus("Отправлен");
            System.out.println("Статус успешно обновлен: " + orderToUpdate);
        }

        // 4. Операция удаления заказа
        int deleteId = 1002;
        System.out.println("\n--- Удаление заказа №" + deleteId + " ---");
        ordersTable.remove(deleteId);
        System.out.println("Заказ №" + deleteId + " удален. Оставшиеся заказы:");
        for (Map.Entry<Integer, Order> entry : ordersTable.entrySet()) {
            System.out.println("Заказ №" + entry.getKey() + " -> " + entry.getValue());
        }
    }
}