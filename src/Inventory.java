public class Inventory {

    private Weapon weapon;
    private Armor armor;
    private int balance;

    public Inventory(int balance, Weapon weapon, Armor armor) {
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public void addWeapon(Weapon weapon) {
        if (this.weapon != null) {
            System.out.println("Replaced " + this.weapon.getName() + " with " + weapon.getName() + "!");
        } else {
            System.out.println("Added " + weapon.getName() + " to inventory!");
        }
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void addArmor(Armor armor) {
        if (this.armor != null) {
            System.out.println("Replaced " + this.armor.getName() + " with " + armor.getName() + "!");
        } else {
            System.out.println("Added " + armor.getName() + " to inventory!");
        }
        this.armor = armor;
    }

    public void addMoney(int money) {
        System.out.println("Added " + money + " coins to inventory!");
        this.balance += money;
    }

    public void display() {
        System.out.println("Inventory:");
        if (weapon != null) {
            System.out.println("Weapon: " + weapon.getName() + " (damage=" + weapon.getDamage() + ")");
        } else {
            System.out.println("Weapon: none");
        }
        if (armor != null) {
            System.out.println("Armor: " + armor.getName() + " (protection=" + armor.getProtection() + ", price=" + armor.getPrice() + ")");
        } else {
            System.out.println("Armor: none");
        }
        System.out.println("Money: " + balance + " coins");
    }

}
