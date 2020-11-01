package Mobs;

public class Mob {
    
    private int health;
    private int attack;
    private int exp;

    public Mob(int health, int attack, int exp) {
        this.health = health;
        this.attack = attack;
        this. exp = exp;
    }

    private int getAttack() {
        return attack;
    }

    private int getHealth() {
        return health;
    }

    private int getExp() {
        return exp;
    }

}
