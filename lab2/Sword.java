    public class Sword extends MeleeWeapon {
    private String material;

    public Sword(String name, int damage, double weight, int durability, String material) {
        super(name, damage, weight, durability);
        this.material = material;
    }

    public Sword() {
        this("Меч", 50, 3.5, 100, "Сталь");
    }

    @Override
    public void attack() {
        System.out.println("Меч наносит рубящий удар!");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Материал: " + material);
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}