package me.guillaume.recruitment.tournament;

/**
 * Swordsman warrior with 100 hit points and a one-handed sword.
 * Can be enhanced with poison for additional damage.
 */
public class Swordsman extends Warrior {
    
    private static final int HIT_POINTS = 100;
    private static final int POISON_DAMAGE = 20;
    private static final int MAX_POISON_BLOWS = 2;
    
    private final boolean isVicious;
    private int poisonBlowsUsed = 0;
    
    public Swordsman() {
        this("Swordsman");
    }
    
    public Swordsman(String name) {
        super(name, HIT_POINTS, new OneHandedSword());
        this.isVicious = "Vicious".equals(name);
    }
    
    @Override
    protected int applySpecialAbilities(int damage) {
        if (isVicious && poisonBlowsUsed < MAX_POISON_BLOWS) {
            poisonBlowsUsed++;
            return damage + POISON_DAMAGE;
        }
        return damage;
    }
} 