public abstract class Weapon {
    private String name;
    private int damage;
    private double weight;

    protected static int weaponCount = 0;
    // Конструктор
    public Weapon(String name, int damage, double weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        weaponCount++;
    }

    // Конструктор по умолчанию
    public Weapon() {
        this("Unknown", 0, 0.0);
    }

    // Абстрактный метод (абстракция)
    public abstract void attack();

    // Обычный метод
    public void showInfo() {
        System.out.println("Оружие: " + name + ", Урон: " + damage + ", Вес: " + weight);
    }

    // Перегрузка метода
    public void attack(String target) {
        System.out.println(name + " атакует " + target);
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Статический метод
    public static int getWeaponCount() {
        return weaponCount;
    }
}