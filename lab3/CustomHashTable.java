package lab3;

import java.util.LinkedList;

public class CustomHashTable<K, V> {
    // Внутренний класс для хранения пар "ключ-значение"
    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
        public void setValue(V value) { this.value = value; }
    }

    // Массив связных списков (метод цепочек)
    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public CustomHashTable(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
    }

    // Конструктор по умолчанию
    public CustomHashTable() {
        this(16);
    }

    // Хэш-функция для вычисления индекса массива
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Добавление или обновление значения по ключу
    public void put(K key, V value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        // Если ключ уже существует, обновляем значение
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        // Иначе добавляем новую пару в конец списка
        table[index].add(new Entry<>(key, value));
        size++;
    }

    // Получение значения по ключу
    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null; // Если ключ не найден
    }

    // Удаление значения по ключу
    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // Метод main для проверки работы класса
    public static void main(String[] args) {
        CustomHashTable<String, Integer> ht = new CustomHashTable<>();

        ht.put("apple", 5);
        ht.put("banana", 3);
        ht.put("orange", 7);

        System.out.println("Количество элементов (size): " + ht.size());
        System.out.println("Значение по ключу 'banana': " + ht.get("banana"));

        ht.remove("banana");
        System.out.println("Удалили 'banana'. Новое количество элементов: " + ht.size());
        System.out.println("Пытаемся получить 'banana' после удаления: " + ht.get("banana"));
    }
}