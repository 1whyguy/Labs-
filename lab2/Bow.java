public class Bow extends Weapon {
    private int range;

    public Bow(String name, int damage, double weight, int range) {
        super(name, damage, weight);
        this.range = range;
    }

    public Bow() {
        this("Лук", 30, 2.0, 100);
    }

    @Override
    public void attack() {
        System.out.println("Лук стреляет стрелой!");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Дальность: " + range);
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}