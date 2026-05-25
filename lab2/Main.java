public class Main {
    public static void main(String[] args) {

        Sword sword = new Sword();
        Bow bow = new Bow();
        MagicWand wand = new MagicWand();

        sword.showInfo();
        sword.attack();
        sword.attack("врага");

        System.out.println();

        bow.showInfo();
        bow.attack();

        System.out.println();

        wand.showInfo();
        wand.attack();

        System.out.println("\nВсего создано оружия: " + Weapon.getWeaponCount());
    }
}