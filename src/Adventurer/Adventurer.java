package Adventurer;

public class Adventurer {
    
    private String name;
    private int health, currentHealth;
    private int attack, currentAttack;
    private int exp = 20;
    private int currentExp = 0;
    private int potions, currentPotions = 3;

    public Adventurer(String name, int health, int attack) {
        this.name = name;
        this.health = this.currentHealth = health;
        this.attack = this.currentAttack = attack;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getCurrentAttack() {
        return currentAttack;
    }

    public int getExp() {
        return exp;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public int getPotions() {
        return potions;
    }

    public int getCurrentPotions() {
        return currentPotions;
    }

    public void increaseMaxHealth(int n) {
        health += n;
    }

    public void increaseMaxAttack(int n) {
        attack += n;
    }

    public void increaseExp(int n) {
        exp += n;
        if(currentExp >= exp)
            levelUp();
    }

    public void increaseMaxExp(int n) {
        exp += n;
    }

    public void increaseMaxPotions(int n) {
        potions += n;
    }

    public void levelUp() {
        increaseMaxHealth(5);
        increaseMaxAttack(5);
        increaseMaxExp(5);
        currentExp = 0;
    }

    public void usePotion() {
        currentHealth = health;
    }

}
