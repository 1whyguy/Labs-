package lab6;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class Product {
    private String id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return name + " (" + price + " руб.)";
    }
}

public class SalesTrackerHashSet {
    private HashSet<Product> soldProducts = new HashSet<>();

    public void addProduct(Product product) {
        soldProducts.add(product);
    }

    public void printSoldProducts() {
        System.out.println("Список проданных товаров:");
        for (Product p : soldProducts) {
            System.out.println("- " + p.toString());
        }
    }

    public double getTotalSales() {
        double total = 0;
        for (Product p : soldProducts) {
            total += p.getPrice();
        }
        return total;
    }

    public String getMostPopularProduct() {
        if (soldProducts.isEmpty()) {
            return "Нет данных о продажах";
        }

        Map<String, Integer> popularityMap = new HashMap<>();
        for (Product p : soldProducts) {
            popularityMap.put(p.getName(), popularityMap.getOrDefault(p.getName(), 0) + 1);
        }

        String mostPopular = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : popularityMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        return mostPopular;
    }

    public static void main(String[] args) {
        SalesTrackerHashSet tracker = new SalesTrackerHashSet();

        tracker.addProduct(new Product("Клавиатура механическая", 4500));
        tracker.addProduct(new Product("Мышь игровая", 2500));
        tracker.addProduct(new Product("Клавиатура механическая", 4500));
        tracker.addProduct(new Product("Коврик для мыши", 800));

        tracker.printSoldProducts();

        System.out.println("\nОбщая сумма продаж: " + tracker.getTotalSales() + " руб.");
        System.out.println("Наиболее популярный товар: " + tracker.getMostPopularProduct());
    }
}