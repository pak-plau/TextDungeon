package Adventurer;

public class Adventurer {
    
    private int health, currentHealth;
    private int attack, currentAttack;
    private int exp = 20;
    private int currentExp = 0;
    private int potions, currentPotions = 3;

    public Adventurer(int health, int attack) {
        this.health = this.currentHealth = health;
        this.attack = this.currentAttack = attack;
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

    public void increaseHealth(int n) {
        health += n;
    }

    public void increaseAttack(int n) {
        attack += n;
    }

    public void increaseExp(int n) {
        exp += n;
    }

    public void increasePotions(int n) {
        potions += n;
    }

    public void levelUp() {
        increaseHealth(5);
        increaseAttack(5);
        increaseExp(5);
    }

}
