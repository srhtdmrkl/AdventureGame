public abstract class Character {
    
    private int damage;
    private int health;
    private int money;
    private int armor;
    private String characterName;
    protected String description;
    private int awareness;

    public Character(String characterName, int damage, int health, int money, int awareness) {
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.characterName = characterName;
        this.awareness = awareness;
    }

    public String getAttributes() {
        return "Character: " + characterName + "\t" +
               "Damage: " + damage + "\t" +
               "Health: " + health + "\t" +
               "Money: " + money;    }

    public String getCharacterName() {
        return characterName;
    }
    
    public int getArmor() {
        return armor;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }
    
    public String getDescription() {
        return description;
    }

    public int getAwareness() {
        return awareness;
    }

}
