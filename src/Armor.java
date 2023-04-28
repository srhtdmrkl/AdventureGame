import java.util.Scanner;

public class Armor {
    private int id;
    private String name;
    private int protection;
    private int price;

    private static Scanner input = new Scanner(System.in);

    public Armor(int id, String name, int protection, int price) {
        this.name = name;
        this.protection = protection;
        this.price = price;
        this.id = id;
    }

    public static Armor[] armors() {
        Armor[] armors = new Armor[3];
        armors[0] = new Armor(1, "Light", 2, 1);
        armors[1] = new Armor(2, "Medium", 3, 2);
        armors[2] = new Armor(3, "Heavy", 7, 4);
        return armors;
    }

    public static void listArmors() {
        Armor[] armors = armors();
        System.out.println("Armors list:");
        for (Armor armor : armors) {
            System.out.println(armor.id + ". " + armor.name + ": protection=" + armor.protection + ", price=" + armor.price);
        }
    }

    public int getProtection(){
        return protection;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public static Armor buyArmor(Player player) {
        Armor[] armors = armors();
    
        System.out.println("Enter the ID of the armor you want to buy:");
        int selectedArmorID = input.nextInt();
    
        if (selectedArmorID < 1 || selectedArmorID > armors.length) {
            System.out.println("Invalid input. Please select a valid armor ID.");
            return null;
        }
    
        Armor selectedArmor = armors[selectedArmorID - 1];
    
        System.out.println("You selected: " + selectedArmor.name);
        System.out.println("Price: " + selectedArmor.price);
    
        System.out.println("Confirm purchase? (Y/N)");
        String confirmation = input.next();
    
        if (confirmation.equalsIgnoreCase("Y")) {
            if (player.inventory.getBalance() < selectedArmor.price) {
                System.out.println("Insufficient balance. Purchase canceled.");
                return null;
            } else {
                System.out.println("Purchase confirmed. You bought " + selectedArmor.name + ".");
                player.inventory.addArmor(selectedArmor);
                player.inventory.setBalance(player.inventory.getBalance()-selectedArmor.price);
                return selectedArmor;
            }
        } else {
            System.out.println("Purchase canceled.");
            return null;
        }
    }

    
}
