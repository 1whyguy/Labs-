public class MagicWand extends Weapon {
    private int manaCost;

    public MagicWand(String name, int damage, double weight, int manaCost) {
        super(name, damage, weight);
        this.manaCost = manaCost;
    }

    public MagicWand() {
        this("Волшебная палочка", 70, 1.0, 20);
    }

    @Override
    public void attack() {
        System.out.println("Палочка выпускает магический заряд!");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Затраты маны: " + manaCost);
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }
}