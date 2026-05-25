public class MeleeWeapon extends Weapon {
    private int durability;

    public MeleeWeapon(String name, int damage, double weight, int durability) {
        super(name, damage, weight);
        this.durability = durability;
    }

    public MeleeWeapon() {
        super();
        this.durability = 100;
    }

    @Override
    public void attack() {
        System.out.println("Ближняя атака оружием: " + getName());
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}