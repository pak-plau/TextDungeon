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

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public int getExp() {
        return exp;
    }

}
