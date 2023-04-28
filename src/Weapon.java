import java.util.Scanner;

public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int price;

    private static Scanner input = new Scanner(System.in);

    public Weapon(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }

    public static Weapon[] weapons() {
        Weapon[] weapons = new Weapon[2];
        weapons[0] = new Weapon(1, "Crossbow", 2, 2);
        weapons[1] = new Weapon(2, "Sword", 4, 3);
        return weapons;
    }

    public static void listWeapons() {
        Weapon[] weapons = weapons();
        System.out.println("Weapons list:");
        for (Weapon weapon : weapons) {
            System.out.println(weapon.id + ". " + weapon.name + " (Damage: " + weapon.damage + ", Price: " + weapon.price);
        }
    }

    public static Weapon buyWeapon(Player player) {
        Weapon[] weapons = weapons();
    
        System.out.println("Enter the ID of the weapon you want to buy:");
        int selectedWeaponID = input.nextInt();
    
        if (selectedWeaponID < 1 || selectedWeaponID > weapons.length) {
            System.out.println("Invalid input. Please select a valid weapon ID.");
            return null;
        }
    
        Weapon selectedWeapon = weapons[selectedWeaponID - 1];
    
        System.out.println("You selected: " + selectedWeapon.name);
        System.out.println("Price: " + selectedWeapon.price);
    
        System.out.println("Confirm purchase? (Y/N)");
        String confirmation = input.next();
    
        if (confirmation.equalsIgnoreCase("Y")) {
            if (player.inventory.getBalance() < selectedWeapon.price) {
                System.out.println("Insufficient balance. Purchase canceled.");
                return null;
            } else {
                System.out.println("Purchase confirmed. You bought " + selectedWeapon.name + ".");
                player.inventory.addWeapon(selectedWeapon);
                player.inventory.setBalance(player.inventory.getBalance()-selectedWeapon.price);
                return selectedWeapon;
            }
        } else {
            System.out.println("Purchase canceled.");
            return null;
        }
    }
    
    
}
